package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Product_In_Ray;

import tn.esprit.spring.repository.Product_In_RayRepository;

@Service
public class Product_In_RayService {

	@Autowired
	Product_In_RayRepository product_in_ray;

	public Product_In_Ray getProdRay(long prod_id){
		return product_in_ray.find_product_Ray(prod_id);
	}

	public int getCurrent_quantity(long prod_id){

		return product_in_ray.find_product_Ray(prod_id).getCurent_quantity()		;

	}

	public int Max_Quantity_to_add(long prod_id){
		//System.err.println("In Max");
		System.err.println("Curent : "+this.getCurrent_quantity(prod_id));
		System.err.println("Max :"+product_in_ray.find_product_Ray(prod_id).getMax_quantity());
		//System.err.println(product_in_ray.find_product_Ray(prod_id).getMax_quantity() - this.getCurrent_quantity(prod_id));
		
		int x = (product_in_ray.find_product_Ray(prod_id).getMax_quantity() )-( this.getCurrent_quantity(prod_id));
		System.err.println("X = "+x);
		return x;
		



	}
	@Autowired
	StockService prod_stock;

	//returns -1 if total quantity > quantity max| total quantity
	public int add_Quantity_to_ray(int quantity , long prod_id){
		System.err.println("In add_Quantity_to_ray ");
		System.err.println("Curent qnt stock "+prod_stock.getCurrent_quantity(prod_id));
		System.err.println("Max qnty can add "+(Max_Quantity_to_add(prod_id)));
		if(prod_stock.getCurrent_quantity(prod_id)>=quantity
				&&
				Max_Quantity_to_add( prod_id)>=quantity){
			System.err.println("In IFFs ");
			Product_In_Ray s = product_in_ray.find_product_Ray(prod_id);
			s.setCurent_quantity
			(this.getCurrent_quantity(prod_id)+quantity);
			System.err.println("Product quantity in ray "+s.getCurent_quantity());
			prod_stock.remove_quantity(prod_id, quantity);
			product_in_ray.save(s);
			return product_in_ray.find_product_Ray(prod_id).getCurent_quantity();
		}
		else
			return -1	;

	}

}
