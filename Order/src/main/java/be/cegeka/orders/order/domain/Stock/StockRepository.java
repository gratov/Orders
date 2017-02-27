package be.cegeka.orders.order.domain.Stock;

import be.cegeka.orders.order.domain.items.Item;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Named
public class StockRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Stock> getAllStock(){
        return entityManager.createQuery("select s from Stock s", Stock.class).getResultList();
    }

    public void addStock(Stock stock){
        entityManager.persist(stock);
        entityManager.flush();
    }

    public void updateQuantity(Item item, int quantityToAdd){
        Stock stock = getStockItem(item);
        stock.addQuantity(quantityToAdd);
        entityManager.persist(stock);
        entityManager.flush();
    }

    public Stock getStockItem(Item item) {
        TypedQuery<Stock> query = entityManager.createQuery("select quantity from Stock s where ITEM_ID = :id",Stock.class);
        return query.setParameter("id", item.getId()).getSingleResult();
    }

    public int getItemQuantity (Item item){
        Stock stock =  getStockItem(item);
        return stock.getQuantity();
    }

}

