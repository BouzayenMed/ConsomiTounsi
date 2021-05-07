package tn.esprit.spring.Controller;



import java.util.List;


import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Category;
import tn.esprit.spring.entity.Ray;
import tn.esprit.spring.service.CategoryService;
import tn.esprit.spring.service.RayService;

@Scope(value = "session")
@Controller(value = "RayController") // Name of the bean in Spring IoC
@ELBeanName(value = "RayController") // Name of the bean used by JSF
//@Join(path = "/", to = "/showRay.jsf")
public class RayController {
	
	private String name_ray_to_add;
	private Ray selcted_ray;
	
	public String navigate_to_showprod(long id_ray){
		
		
		System.err.println(id_ray+" ------- ****");
		String navigateTo ="null";
		this.setSelectedRayid( id_ray);
		System.err.println(this.getSelectedRayid());
		navigateTo ="showprodinray.xhtml?faces-redirect=true";
		return navigateTo;
	}
	@Autowired
	RayService ray_service;
	
	public List<Ray> getraybycat(long cat_id){
		return  ray_service.getraybycat(cat_id);
	} 
	private Long selectedRayid;

	public Ray newRay;
	
	@PostMapping("/addrayon")
	public void addRay(@RequestBody Ray R)
	{
		ray_service.addRay(R);
	}
	@Autowired
	CategoryService cat_serv;
	public void addRaywithcat(String name,long id_cat)
	{
		System.err.println("how name li jenii ena 5atini -___- ");
	   Category cat;
	   cat =cat_serv.getcatbyid(id_cat);
		Ray R=new Ray(name, cat);
		R.setRayName(name);
		ray_service.addRay(R);
	}
	
	
	@DeleteMapping("/removeRay/{ID}")
	public void removeRay(@PathVariable("ID") Long ID)
	{
		System.err.println("Id   ********* ID : "+ID);
		ray_service.removeRay(ID);
	}
	@GetMapping("/showRay")
	public List<Ray> showRay(){
		return ray_service.showRay();
	}
	@RequestMapping("getraybyid")
	public Ray selectraybyid(@RequestParam("id")Long ID){
		return ray_service.selectraybyid(ID);
	}
	@PutMapping("/updateRay/{id}")
	public void update_ray(@PathVariable("id") Long id, @RequestBody Ray ray)
	{
		ray_service.updateRay(ray, id);
		
	}
	public Long getSelectedRayid() {
		return selectedRayid;
	}
	public void setSelectedRayid(Long selectedRayid) {
		this.selectedRayid = selectedRayid;
	}

	public Ray getNewRay() {
		return newRay;
	}
	public void setNewRay(Ray newRay) {
		this.newRay = newRay;
	}
	public Ray getSelcted_ray() {
		return selcted_ray;
	}
	public void setSelcted_ray(Ray selcted_ray) {
		this.selcted_ray = selcted_ray;
	}


	public String getName_ray_to_add() {
		System.err.println("Get : "+name_ray_to_add);
		return name_ray_to_add;
		
	}


	public void setName_ray_to_add(String name_ray_to_add) {
		System.err.println(" el nom li jè lil set name :"+name_ray_to_add);
		this.name_ray_to_add = name_ray_to_add;
	}

}
