package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.CategorieSujet;



public interface ICategorieSujetService {

	public int ajouterCategorieSujet (CategorieSujet c);
	public List<CategorieSujet> getAllCategorieSujets();
	public void deleteCategorieSujetById(long CategId);
	public List<CategorieSujet> findCategbyName(String name);
	public CategorieSujet findOne(Long id);
	public void modifierNom(String name, long CategId);
	public int countSujetbycatId(Long CategId);
}
