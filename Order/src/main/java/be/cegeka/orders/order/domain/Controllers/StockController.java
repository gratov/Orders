package be.cegeka.orders.order.domain.Controllers;

import be.cegeka.orders.order.domain.Stock.Stock;
import be.cegeka.orders.order.domain.Stock.StockService;
import be.cegeka.orders.order.domain.items.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.ws.rs.POST;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/stock")
public class StockController {


    @Inject
private StockService stockService;

    @ResponseBody
    @RequestMapping(method = GET)
    public List<Stock> getAllStock(){
        return stockService.getAllStock();      //method empty at the moment
    }

    @ResponseBody
    @RequestMapping(method = POST)
    public void addStock(@RequestParam(value = "Item") Item item,
                         @RequestParam(value = "Quantity") int quantity){
        stockService.addStock(item, quantity);
    }

    @ResponseBody
    @RequestMapping(path = "/updatequantity", method = POST)
    public void updateQuantity(@RequestParam(value = "Item") Item item,
                              @RequestParam(value = "Quantity") int quantity){
        stockService.updateQuantity(item, quantity);
    }
}
