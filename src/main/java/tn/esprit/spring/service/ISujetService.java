package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Sujet;
import tn.esprit.spring.entity.User;

public interface ISujetService {

	public int ajouterSujet (Sujet c,Long categId,Long userId);
	public void accpeterSujet (Long sujetId);
	public void RefuserSujet (Long sujetId);
	public List<Sujet> getAllSujets();
	public List<Sujet> getAllSujetEtatWaiting();
	public int deleteSujetById(Long sujetId);
	public List<Sujet> findSujetbyName(String name);
	public Sujet findOne(Long id);
	public int modifierDescription(String desc, Long sujetId,Long userId);
	public void affecterSujetACategS(Long sujId, Long categId);
	public List<Sujet> getAllSujetNamesByCategorie(Long categId);
	public List<Sujet> findSujetbyUser(Long userid);
	public String findNamebySujet (Long sujetid);
	public User client_gangnant(int nbpoint);
//	public Product produit_gangnant(int nbpoint) throws MessagingException;
	public void sendmail();
	
}
