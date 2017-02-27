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
        if(stockRepository.checkIfStockIsPresent(stock)){
            stockRepository.updateQuantity(item, quantity);
        }else {
            stockRepository.addStock(stock);
        }
    }

    public int getStockQuantity(Item item) {
        return stockRepository.getStockQuantity(item);
    }

    public void updateQuantity(Item item, int quantity) {
        stockRepository.updateQuantity(item,quantity);
    }

}
