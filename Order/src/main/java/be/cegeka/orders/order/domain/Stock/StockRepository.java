package be.cegeka.orders.order.domain.Stock;

import be.cegeka.orders.order.domain.items.Item;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
public class StockRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Stock> getAllStock(){
        return entityManager.createQuery("select s from Stock s", Stock.class).getResultList();
    }

    public void addStock(Item item, int quantity){
<<<<<<< HEAD
       entityManager.createQuery("insert into Stock", Stock.class).
=======
        //entityManager.createQuery("insert into Stock", Stock.class)
>>>>>>> 2defbe861fdd1236ce99aef2d523c64f99d0d061
    }

    public void updateQuantity(){

    }
    //maybe should make a method to add stock and a method to alter table column Quantity value or something?
}

