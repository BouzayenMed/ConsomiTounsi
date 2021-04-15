package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Product;
import tn.esprit.spring.service.ProductService;


@RestController
@RequestMapping("ApiProduct")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/showProductInRay/{id}")
	public List<Product> get_Products_in_Ray(@PathVariable("id") Long ray_Id){
		
		
		return productService.find_products_ByRayId(ray_Id);
		
	}
}
