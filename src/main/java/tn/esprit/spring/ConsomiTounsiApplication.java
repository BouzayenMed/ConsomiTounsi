package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tn.esprit.spring.Controller.ProductController;
import tn.esprit.spring.Controller.RayController;
import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.Ray;

@SpringBootApplication
public class ConsomiTounsiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsomiTounsiApplication.class, args);
		
		
	}

}
