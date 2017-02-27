package be.cegeka.orders.order.domain.customers;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Named
public class CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Customer> getAllCustomers(){
        return entityManager.createQuery("select c from Customer c" , Customer.class).getResultList();
    }


    public Customer getCustomerByID(int id) {
        TypedQuery<Customer> query =  entityManager.createQuery("select c from Customer c where CUSTOMER_ID = :id", Customer.class);
        return query.setParameter("id", id).getSingleResult();
    }



    public void addCustomer(Customer customer) {
        entityManager.persist(customer);
    }
}
