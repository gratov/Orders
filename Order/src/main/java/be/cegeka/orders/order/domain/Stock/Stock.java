package be.cegeka.orders.order.domain.Stock;

import be.cegeka.orders.order.domain.items.Item;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "Stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STOCK_ID")
    private int id;

    @Column(name = "QUANTITY")
    private int quantity;

    @OneToOne(cascade = ALL)
    @JoinColumn(name = "ITEM_ID", nullable = false)
    private Item item;

    public Stock() {
    }

    public Stock(int quantity, Item item) {
        this.quantity = quantity;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void addItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

}
