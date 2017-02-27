package be.cegeka.orders.order.domain.customers;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by jensde on 27/02/2017.
 */
@Named
public class CustomerService {
    @Inject
    private CustomerRepository customerRepository;


    public void addCustomer(String firstName, String lastName, String emailAddress, String address, String phoneNumber) {
        customerRepository.addCustomer(new Customer(firstName, lastName, emailAddress, address, phoneNumber));
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

}

