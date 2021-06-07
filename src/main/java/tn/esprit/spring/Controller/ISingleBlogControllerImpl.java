package tn.esprit.spring.Controller;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Commentaire;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.ICommentaireService;
import tn.esprit.spring.service.ISujetService;


@Controller(value = "singleblogController")
@ELBeanName(value = "singleblogController")
@Join(path = "/single-blog", to = "single-blog.jsf")
public class ISingleBlogControllerImpl{
	@Autowired
	ISujetService iSujetService;
	
	@Autowired ICommentaireService icommentaireService;
	private Long id;
	private String description;
	private Commentaire commentaire;
	private User idUser;
	private Long userId =1L;
	
	public ISujetService getiSujetService() {
		return iSujetService;
	}

	public void setiSujetService(ISujetService iSujetService) {
		this.iSujetService = iSujetService;
	}

	public ICommentaireService getIcommentaireService() {
		return icommentaireService;
	}

	public void setIcommentaireService(ICommentaireService icommentaireService) {
		this.icommentaireService = icommentaireService;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Commentaire getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(Commentaire commentaire) {
		this.commentaire = commentaire;
	}

	public User getIdUser() {
		return idUser;
	}

	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}

	public  List<Commentaire> afficherCommentaireOfSujet(Long sujetId) {
	
		return icommentaireService.getCommentaireOfSujet(sujetId);
		}
	
	public String ajoutercommentaire(Long sujetId){
//		if (userId==null)
//		{
//			return "/login";
//		}
		String navigateTo =null;
		Commentaire com2= new Commentaire ();
		com2.setDescription(description);
		System.out.println("********"+description);
		icommentaireService.ajouterCommentaire(com2, sujetId, userId);
		   setDescription(null);
		return navigateTo ;
	}
	
	public int countNbcommentaire(Long sujetId){
		return icommentaireService.countNbcommentaire(sujetId);
	}
	
	public String removeCommentarie(Long comId,Long userId){
	    String navigateTo="null";
		icommentaireService.RemoveCommentairebyIdUser(comId, userId);
		return navigateTo;
	}
	
    public int verificationCombyId(Long comId,Long userId){
    	if (userId==null)
    		userId=(long) 0;
    	
    	return icommentaireService.verivcationCom(comId, userId);
    }

}
