package tn.esprit.spring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Ray;
import tn.esprit.spring.repository.IRayRepository;


@Service
public class RayService {

	@Autowired
	IRayRepository ray_rep;

	public void addRay(Ray R){
		ray_rep.save(R);
	}
	public void removeRay(Long ID){
		ray_rep.deleteById(ID);
	}
	public Ray selectraybyid(Long ID){
		return ray_rep.findById(ID).get();
	}

	public List<Ray> showRay(){
		return ray_rep.findAll();
	}
	public void updateRay(Ray ray,Long id)
	{
		ray_rep.findById(id).map(i->{
			if (ray.getRayName()!=null) {
				i.setRayName(ray.getRayName());

			}
			if (ray.getCategory()!=null) {
				i.setCategory(ray.getCategory());
			}
			ray_rep.save(i);
			return i;
		});
	}



}
