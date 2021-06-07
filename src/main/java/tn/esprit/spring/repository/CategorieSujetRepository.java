package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.spring.entity.CategorieSujet;


public interface CategorieSujetRepository  extends JpaRepository<CategorieSujet, Long> {
	@Query(value = "SELECT * FROM categorie_sujet WHERE nom_categorie LIKE ?1%", nativeQuery = true)
	public List<CategorieSujet> findCategbyName(String name);
}
