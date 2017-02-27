package be.cegeka.orders.order.domain.customers;

import be.cegeka.orders.order.domain.orders.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private int id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private List<Order> orders;

    public Customer() {
        orders = new ArrayList<>();
    }

    public Customer(int id, String firstName, String lastName, String emailAddress, String address, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address = address;
        this.phoneNumber = phoneNumber;
        orders = new ArrayList<>();
    }



    public Customer(String name, String lastName, List<Order> orders) {
        this.firstName = name;
        this.lastName = lastName;
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

}
