package be.cegeka.orders.order.domain.Stock;


import be.cegeka.orders.order.domain.items.Item;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.GeneratedValue;
import java.util.List;

@Named
public class StockService {

    @Inject
    private StockRepository stockRepository;
    private Stock stock;
    private Item item;

    public List<Stock> getAllStock() {
        return stockRepository.getAllStock();
    }

    public void addStock(String name, String deription, double sellingPrice, int quantity) {

        item = new Item(name, deription, sellingPrice);
        stock = new Stock(quantity, item);
        if(stockRepository.getAllStock().contains(stock)){
            stockRepository.updateQuantity(item, quantity);
        }
        stockRepository.addStock(item, quantity);
    }

    public int getItemQuantity(Item item) {
        return stockRepository.getItemQuantity(item);

    }
}
