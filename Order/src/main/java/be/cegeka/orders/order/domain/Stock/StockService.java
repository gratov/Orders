package be.cegeka.orders.order.domain.Stock;


import be.cegeka.orders.order.domain.items.Item;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class StockService {

    @Inject
    private StockRepository stockRepository;
    private Stock stock;
    private Item item;

    //My Idea
    /*
    public int getQuantity(){

        int quantity;
        if (stockRepository.getAllStock().contains(null)){
           return quantity = 0;
        }
        return quantity = stock.getQuantity();
    }

    public void addItemIncreasesQuantity(int quantity){

        stock.addItem(item);
            quantity++;
        }
    */
    public List<Stock> getAllStock() {
        return stockRepository.getAllStock();
    }

    public void addStock(Item item, int quantity) {
        stockRepository.addStock();
    }

    public void updateQuantity(Item item, int quantity) {
    }


}
