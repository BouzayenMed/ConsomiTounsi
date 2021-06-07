package tn.esprit.spring.Controller;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Sujet;
import tn.esprit.spring.service.ICategorieSujetService;
import tn.esprit.spring.service.IImageSujetService;
import tn.esprit.spring.service.ISujetService;
import tn.esprit.spring.service.IVoteSujetService;
import tn.esprit.spring.service.IVusService;

@Controller(value = "ControllerValidatePost")
@ELBeanName(value = "ControllerValidatePost")
@Join(path = "/validateposts", to = "validate-posts.jsf")

@Transactional
public class ValidatePost {
	@Autowired
	ISujetService iSujetService;
	@Autowired
	ICategorieSujetService icategorieSujetService;
	@Autowired
	IVoteSujetService iVoteSujetService;
	@Autowired
	IImageSujetService iImageSujetService;
	@Autowired
	IVusService iVusService;
	private Sujet sujetrec;
	
	public Sujet getSujetrec() {
		return sujetrec;
	}

	public void setSujetrec(Sujet sujetrec) {
		this.sujetrec = sujetrec;
	}

	public void accpteSujet(long sujetId){
		iSujetService.accpeterSujet(sujetId);
	}
	
	public void refuseSujet(long sujetId)
	{
		iSujetService.RefuserSujet(sujetId);
	}
    
	public List<Sujet> getAllSujetEtatWaiting(){
		return iSujetService.getAllSujetEtatWaiting();
	}
	
	String a;

	private String getCountryFromJSF(FacesContext context) {
		Map<String, String> parameters = context.getExternalContext().getRequestParameterMap();
		return parameters.get("idsujet");
	}

	public Long outcome() {
		FacesContext context = FacesContext.getCurrentInstance();
		a = getCountryFromJSF(context);
		System.out.println(a);
		return Long.parseLong(a);

	}

	public String findSujetrec() {
		 sujetrec = iSujetService.findOne(outcome());
		 String navigatTo = "/postAdmin?faces-redirect=true&idsujet=" +outcome().toString();
		 return navigatTo;
	}
	public Sujet findSujetrec1(){
		return sujetrec = iSujetService.findOne(1L);
	}
	public String accptedSujet(Long sujetId){		
		iSujetService.accpeterSujet(sujetId);
		return "/validate-posts.jsf";
		
	}
	public String refuseSujet(Long sujetId){		
		iSujetService.RefuserSujet(sujetId);
		return "/validate-posts.jsf";}
}
