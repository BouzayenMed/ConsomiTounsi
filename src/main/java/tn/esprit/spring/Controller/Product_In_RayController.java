package tn.esprit.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Product;
import tn.esprit.spring.service.Product_In_RayService;

@RestController
@RequestMapping("Apiprod_ray")
public class Product_In_RayController {

	
	@Autowired
	Product_In_RayService prod_ray;
	@RequestMapping(value="/new_prod_in_ray",method = RequestMethod.POST)
	public void new_prod_to_rat(@RequestParam("min_quantity") int min_quantity,
			@RequestParam("max_quantity") int max_quantity,@RequestBody Product product){
		
		//nest7a9 getprodbyID bech manab9ach nsetii f prod kemel
		//if(prod_ray.getProdRay(product.getProduct_Id())==null)
		prod_ray.add_new_product_in_ray(min_quantity, 0, max_quantity, product);
		//else
			//System.err.println("Product exists in the rays");
	}
	@GetMapping("/addprodtoray")
	public void add_prod_to_ray(@RequestParam("quantity") int quantity,@RequestParam("prod_id") long prod_id){
		prod_ray.add_Quantity_to_ray(quantity, prod_id);
	}
}
