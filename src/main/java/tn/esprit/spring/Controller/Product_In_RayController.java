package tn.esprit.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.service.Product_In_RayService;

@RestController
@RequestMapping("Apiprod_ray")
public class Product_In_RayController {

	
	@Autowired
	Product_In_RayService prod_ray;
	
	@GetMapping("/addprodtoray")
	public void add_prod_to_ray(@RequestParam("quantity") int quantity,@RequestParam("prod_id") long prod_id){
		prod_ray.add_Quantity_to_ray(quantity, prod_id);
	}
}
