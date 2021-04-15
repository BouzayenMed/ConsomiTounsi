package tn.esprit.spring.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Ray;
import tn.esprit.spring.service.RayService;

@RestController
@RequestMapping("ApiRay")
public class RayController {
	@Autowired
	RayService ray_service;

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
	
	@PutMapping("/updateRay/{id}")
	public void update_ray(@PathVariable("id") Long id, @RequestBody Ray ray)
	{
		ray_service.updateRay(ray, id);
		
	}

}
