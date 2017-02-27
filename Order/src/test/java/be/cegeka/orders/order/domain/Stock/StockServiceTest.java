package be.cegeka.orders.order.domain.Stock;

import be.cegeka.orders.order.domain.items.Item;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StockServiceTest {

    private StockService stockQuantity;
    private Item item, item1;
    private Stock stock;
    private int quantity;


    @Before
    public void setUpDatabase() {
        stockQuantity = new StockService();
        item = new Item("smurf", "blue", 2.0);
        item1 = new Item("colaRola", "silver balls", 3.0);
        quantity = 0;
        stock = new Stock(quantity, item);
    }

//    @Test
//    public void getAllStock_returnsAllStock() throws Exception {
//
//        stock.addItem(item);
//        int expected = 1;
//
//        assertThat(stockQuantity.getItemQuantity(quantity)).isEqualTo(expected);
//    }
}
