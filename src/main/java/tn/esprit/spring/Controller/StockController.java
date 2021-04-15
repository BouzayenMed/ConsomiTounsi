package tn.esprit.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.service.StockService;



@RestController
@RequestMapping("ApiStock")
public class StockController {
	@Autowired
	StockService stock_service;
	
	@RequestMapping("/addprodtostock")
	public int  addprodtostock(@RequestParam("quantity") int quantity,@RequestParam("prod_id") long prod_id){
		 
	
	System.err.println("Max quantity can be added : "+stock_service.Max_Quantity_to_add(prod_id)); 	
	return stock_service.add_Quantity_to_stock(quantity, prod_id);
	}
	
	@RequestMapping("/getprodstock")
	public Stock getProdStock(@RequestParam("prod_id")long prod_id){
		return stock_service.getProdStock( prod_id);
	}

}
