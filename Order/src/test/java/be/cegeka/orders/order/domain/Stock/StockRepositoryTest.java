package be.cegeka.orders.order.domain.Stock;

import be.cegeka.orders.order.OrderApplication;
import be.cegeka.orders.order.domain.items.Item;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = OrderApplication.class)
@Transactional
public class StockRepositoryTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private StockRepository stockRepository;

    private List<Stock> stockItems;
    private Item item, item1;
    private Stock stock, stock1;


    @Before
    public void setUpDatabase(){
        item = new Item("smurf", "blue", 2.0);
        item1 = new Item("colaRola", "silver balls", 3.0);
        stock = new Stock(10, item);
        stock1 = new Stock(5, item1);
    }

    @Test
    public void getAllStock_returnsAllStock() throws Exception{

        stock.setItem(item);
        stock1.setItem(item1);
        entityManager.persist(stock);
        entityManager.persist(stock1);
        assertThat(stockRepository.getAllStock()).contains(stock, stock1);
    }

    @Test
    public void addStock_addsStockToDatabase(){
        stockRepository.addStock(stock);
        assertThat(stockRepository.getAllStock()).contains(stock);

    }

    @Test
    public void updateQuantity_updatesQuantity(){
        stockRepository.addStock(stock);
        stockRepository.updateQuantity(item,10);
        assertThat(stockRepository.getStockByItem(item).getQuantity()).isEqualTo(20);

    }

    @Test
    public void getStockQuantity_returnsStockQuantity(){
        stockRepository.addStock(stock);
        assertThat(stockRepository.getStockQuantity(item)).isEqualTo(10);
    }

}