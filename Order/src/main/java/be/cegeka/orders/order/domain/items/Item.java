package be.cegeka.orders.order.domain.items;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "Items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description",columnDefinition = "TEXT")
    private String description;

    @Column(name = "Selling_Price",columnDefinition = "DECIMAL")
    private double sellingPrice;

    @ManyToMany(cascade = ALL)
    @JoinTable(
            name = "items_on_order",
            joinColumns = {@JoinColumn(name = "ITEM_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ORDER_ID")})
    private List<Item> items = new ArrayList<>();

    public Item() {
    }

    public Item(String name, String description, double sellingPrice) {
        this.name = name;
        this.description = description;
        this.sellingPrice = sellingPrice;
    }

    public int getId() {
        return id;
    }

    //make sure there is an addItem method in ORDER
    //make sure there is a getItems method in ORDER
}
