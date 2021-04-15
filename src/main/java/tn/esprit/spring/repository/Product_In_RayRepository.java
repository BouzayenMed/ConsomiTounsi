package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.Product_In_Ray;

@Repository
public interface Product_In_RayRepository extends CrudRepository<Product_In_Ray, Long> {
	
	@Query(nativeQuery=true,value="select * from product_in_ray  where product_product_id = ?1")
	public Product_In_Ray find_product_Ray(@Param(value = "product_product_id") long product_product_id);
}
