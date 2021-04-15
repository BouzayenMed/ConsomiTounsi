package tn.esprit.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Ray;
import tn.esprit.spring.service.StockService;



@RestController
@RequestMapping("ApiStock")
public class StockController {
	@Autowired
	StockService stock_service;
	
	@RequestMapping("/addprodtostock")
	public void addprodtostock(@RequestParam("quantity") int quantity,@RequestParam("prod_id") long prod_id){
		 
	System.err.println("Returned value from addd prod "+stock_service.add_Quantity_to_stock(quantity, prod_id)); 
	System.err.println("Max quantity can be added : "+stock_service.Max_Quantity_to_add(prod_id)); 	
	}

}
