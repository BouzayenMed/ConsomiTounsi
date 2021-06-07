package tn.esprit.spring.Controller;

import java.util.List;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.CategorieSujet;
import tn.esprit.spring.service.ICategorieSujetService;


@Controller(value = "ControllerCategorieSujet")
@ELBeanName(value = "ControllerCategorieSujet")
public class ControllerCategorieSujet {

	@Autowired
	ICategorieSujetService iCategorieService;
	
	CategorieSujet categorieSujet;
	
	public List<CategorieSujet> findNameCategoris(){
		return iCategorieService.getAllCategorieSujets();
	}
    public int getNbcategeorieSujet(Long CatregId){
     	return	iCategorieService.countSujetbycatId(CatregId);
    }
  
}
