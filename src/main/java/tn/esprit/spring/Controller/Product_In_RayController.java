package tn.esprit.spring.Controller;

import java.util.List;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.Product_In_Ray;
import tn.esprit.spring.service.ProductService;
import tn.esprit.spring.service.Product_In_RayService;

@Scope(value = "session")
@Controller(value = "ProdinRayController") // Name of the bean in Spring IoC
@ELBeanName(value = "ProdinRayController") 
public class Product_In_RayController {

	private int qnt_to_add;
	private int maxcnt;
	private int mincnt;
	private long id_prod_to_add;
	Product prod_to_add = null;
	@Autowired
	ProductService prod_serv;



	@Autowired
	Product_In_RayService prod_ray;

	@GetMapping("show_product_in_ray_by_RayId")
	public List<Product_In_Ray> find_product_Ray_byRayId(@RequestParam("ray_id") long ray_id){
		return  prod_ray.find_product_Ray_byRayId(ray_id);
	}

	@GetMapping("show_product_in_ray_by_ProdId")
	public Product_In_Ray show_prod_in_ray_by_Prod_ID(@RequestParam("prod_id")long prod_id){
		return prod_ray.getProd_In_Ray_By_ProdID(prod_id);
	}
	@DeleteMapping
	public void delete_prod_in_ray_(@RequestParam("prod_id")long prod_id){
		prod_ray.remove_product_from_ray_ByProdID(prod_id);
	}


	@RequestMapping(value="/new_prod_in_ray",method = RequestMethod.POST)
	public void new_prod_to_rat(@RequestParam("min_quantity") int min_quantity,
			@RequestParam("max_quantity") int max_quantity,@RequestBody long id_product){

		//nest7a9 getprodbyID bech manab9ach nsetii f prod kemel
		//if(prod_ray.getProdRay(product.getProduct_Id())==null)

		if(id_prod_to_add!=0)  this.prod_to_add = prod_serv.getProd_byid(id_prod_to_add);
		prod_ray.add_new_product_in_ray(min_quantity, 0, max_quantity, prod_to_add);
		//else
		//System.err.println("Product exists in the rays");
	}
	@RequestMapping("/add_Quantity_to_ray")
	public void add_Quantity_to_ray(@RequestParam("quantity") int quantity,@RequestParam("prod_id") long prod_id){
		System.err.println(quantity);
		System.err.println(prod_id);
		prod_ray.add_Quantity_to_ray(quantity, prod_id);
	}
	@RequestMapping("/remove_Quantity_from_ray")
	public void remove_Quantity_from_ray(@RequestParam("quantity") int quantity,@RequestParam("prod_id") long prod_id){
		prod_ray.remove_Quantity_from_ray(quantity, prod_id);
		

	}

	public int getMaxcnt() {
		return maxcnt;
	}

	public void setMaxcnt(int maxcnt) {
		this.maxcnt = maxcnt;
	}

	public int getMincnt() {
		return mincnt;
	}

	public void setMincnt(int mincnt) {
		this.mincnt = mincnt;
	}


	public long getId_prod_to_add() {
		return id_prod_to_add;
	}

	public void setId_prod_to_add(long id_prod_to_add) {
		this.id_prod_to_add = id_prod_to_add;
	}

	public Product getProd_to_add() {
		return prod_to_add;
	}

	public void setProd_to_add(Product prod_to_add) {
		this.prod_to_add = prod_to_add;
	}

	public int getQnt_to_add() {
		return qnt_to_add;
	}

	public void setQnt_to_add(int qnt_to_add) {
		System.err.println(" *********** " + qnt_to_add);
		this.qnt_to_add = qnt_to_add;
	}





}
