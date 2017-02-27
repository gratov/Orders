package be.cegeka.orders.order.domain.Controllers;

import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.customers.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by jensde on 27/02/2017.
 */
@Controller

@RequestMapping("/customer")
public class CustomerController {
    @Inject
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    void addCustomer(@RequestParam(value = "firstName", required = true) String firstName,
                     @RequestParam(value = "lastName", required = true) String lastName,
                     @RequestParam(value = "emailAddress", required = true) String emailAddress,
                     @RequestParam(value = "address", required = true) String address,
                     @RequestParam(value = "phoneNumber", required = true) String phoneNumber){
        customerService.addCustomer(firstName, lastName, emailAddress, address, phoneNumber);
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
}
