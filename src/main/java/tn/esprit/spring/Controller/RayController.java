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

import tn.esprit.spring.entity.Ray;
import tn.esprit.spring.service.RayService;

@Scope(value = "session")
@Controller(value = "RayController") // Name of the bean in Spring IoC
@ELBeanName(value = "RayController") // Name of the bean used by JSF
//@Join(path = "/", to = "/login.jsf")
@RestController
@RequestMapping
public class RayController {
	
	public String navigate_to_showprod(long id_ray){
		
		
		String navigateTo ="null";
		this.setSelectedRayid( id_ray);
		System.err.println(this.getSelectedRayid());
		return navigateTo ="/pages/admin/showprodinray.xhtml?faces-redirect=true";
	}
	@Autowired
	RayService ray_service;
	
	private Long selectedRayid;

	public Ray newRay;
	
	@PostMapping("/addrayon")
	public void addRay(@RequestBody Ray R)
	{
		ray_service.addRay(R);
	}
	@DeleteMapping("/removeRay/{ID}")
	public void removeRay(@PathVariable("ID") Long ID)
	{
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

}
