package be.cegeka.orders.order.domain.customers;

import be.cegeka.orders.order.OrderApplication;
import be.cegeka.orders.order.domain.orders.Order;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = OrderApplication.class)
@Transactional
public class CustomerRepositoryTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private CustomerRepository customerRepository;
    private Customer seppe, johan;
    Order order1;

    @Before
    public void setupDatabase() {
        seppe = new Customer("Seppe", "Gielen","seppe.gielen@cegeka.com","Leuven","012345678");
        johan = new Customer("Johan", "Vdw","johan.vdw@hotmail.com","Antwerpen","4567897");
        order1 = new Order();
        seppe.addOrder(order1);
        entityManager.persist(seppe);
        entityManager.persist(johan);
    }

    @Test
    public void getAllShouldReturnAll() throws Exception {
        assertThat(customerRepository.getAllCustomers()).contains(seppe, johan);
    }

    @Test
    public void getCostumerByID_ReturnsCostumer() throws Exception{
        assertThat(customerRepository.getCustomerByID(seppe.getId())).isEqualTo(seppe);
    }
    @Test
    public void getCustomerByID_ShouldReturnCustomerAndOrderDetails() throws Exception {
        assertThat(customerRepository.getCustomerByID(seppe.getId()).getOrders()).contains(order1);
    }
    @Test
    public void AddCustomer_ShouldAddCustomer() throws Exception {
        Customer kevin = new Customer("kevin","smet","smetkevin@yahoo.com","willebroek","1234567");
        customerRepository.addCustomer(kevin);
        entityManager.find(Customer.class, kevin.getId());
        assertThat(entityManager.find(Customer.class, kevin.getId())).isNotNull();

    }
    @After
    public void cleanDatabase(){
        entityManager.clear();
    }
}
