package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.customers.Customer;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ORDER_ID")
    private int id;
    @Column (name = "ORDER_DATE",columnDefinition = "DATETIME")
    private Date orderDate;

   public Order(){
    }

    public Order ( Date orderDate){
        this.orderDate = orderDate;
    }
    public int getId(){return id;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return id == order.id;
    }

    @Override
    public int hashCode() {
        return id;
    }



}
