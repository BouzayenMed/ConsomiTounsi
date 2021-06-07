package tn.esprit.spring.Controller;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import tn.esprit.spring.entity.CategorieSujet;
import tn.esprit.spring.entity.Sujet;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.FileStorageServiceImpl;
import tn.esprit.spring.service.ICategorieSujetService;
import tn.esprit.spring.service.IImageSujetService;
import tn.esprit.spring.service.ISujetService;
import tn.esprit.spring.service.IVoteSujetService;
@Controller(value = "ControllerMyposts")
@ELBeanName(value = "ControllerMyposts")
@Join(path = "/myposts", to = "myPosts.jsf")
@SessionScope
@ViewScoped
public class MypostsController {
	@Autowired
	ISujetService iSujetService;
	@Autowired
	 ICategorieSujetService  icategorieSujetService;
	@Autowired 
	IVoteSujetService iVoteSujetService;
	@Autowired
	IImageSujetService iImageSujetService;
	 @Autowired
	  FileStorageServiceImpl fileStorageServiceImpl;
		
	 
	 private RepeatPaginator paginatorRec;
	 
		public RepeatPaginator getPaginatorRec() {
			return paginatorRec;
		}
		public void setPaginatorRec(RepeatPaginator paginatorRec) {
			this.paginatorRec = paginatorRec;
		}
		
		User idUser;
		CategorieSujet idCategorieSujet;
		
		/*******show Sujet By User******/
		
		public List<Sujet>getSujetByUser(Long userId){
			if (userId==null)
				userId=(long)0;
			return iSujetService.findSujetbyUser(1L);	
			
		}
		private String getCountryFromJSF(FacesContext context) {
	        Map<String, String> parameters = context.getExternalContext().getRequestParameterMap();
	        return parameters.get("userId");
	    }
		 public Long outcome() {
			   String a;
		        FacesContext context = FacesContext.getCurrentInstance();
		        a = getCountryFromJSF(context);
		        System.out.println(a);
		        return Long.parseLong(a);
		        
		    }

		@PostConstruct
		@Scheduled(cron="*/10 * * * * *")
		public void init(){
		//System.out.println(LoginController.userDetails.getId());
			paginatorRec=new RepeatPaginator(getSujetByUser(1L));
		}

}
