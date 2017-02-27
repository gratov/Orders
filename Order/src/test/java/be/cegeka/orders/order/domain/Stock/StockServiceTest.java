package be.cegeka.orders.order.domain.Stock;

import be.cegeka.orders.order.domain.items.Item;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class StockServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockService stockService;

    private Item item, item1;
    private Stock stock, stock1;

    @Before
    public void setUpDatabase() {
        item = new Item("smurf", "blue", 2.0);
        item1 = new Item("colaRola", "silver balls", 3.0);
        stock = new Stock(10, item);
        stock1 = new Stock(5, item1);
    }

    @Test
    public void getAllStock() throws Exception {

    }

    @Test
    public void addStock_AddsNewStock() throws Exception {
        Item item = new Item("colaBottles","minicolas",1.0);
        Stock stock = new Stock(10,item);
        stockService.addStock("colaBottles", "minicolas", 1.0, 10);
        verify(stockRepository).addStock(any());
    }

    @Test
    public void addStock_UpdatesExistingStock() throws Exception {
        Item item = new Item("colaBottles","minicolas",1.0);
        Stock stock = new Stock(10,item);
        ArrayList<Stock> list = new ArrayList<>();
        list.add(stock);
        when(stockRepository.checkIfStockIsPresent(any())).thenReturn(true);
        stockService.addStock("colaBottles", "minicolas", 1.0, 10);
        verify(stockRepository).updateQuantity(any(),anyInt());
    }


    @Test
    public void getItemQuantity() throws Exception {
        when(stockRepository.getStockQuantity(item)).thenReturn(10);
        Assertions.assertThat(stockService.getStockQuantity(item)).isEqualTo(10);
    }

    @Test
    public void updateQuantity() throws Exception {
        stockService.updateQuantity(item, 10);
        verify(stockRepository).updateQuantity(any(), anyInt());
    }

}
