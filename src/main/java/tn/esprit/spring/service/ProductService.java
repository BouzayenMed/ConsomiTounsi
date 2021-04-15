package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Product;

import tn.esprit.spring.repository.IProductRepository;

@Service
public class ProductService {
	
	@Autowired
	IProductRepository product_rep;
	
	
	public void AddProduct(Product produit){
		
		product_rep.save(produit);
	}
	
	@Query("select * from product  where ray_ray_id = ?1")
	public List<Product> find_products_ByRayId(@Param(value = "ray_ray_id") Long ray_id){
		
		return product_rep.find_products_ByRayId(ray_id);
		
		
	}
	
	
	

	

}
