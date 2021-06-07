package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.spring.entity.ImageSujet;


public interface ImageSujetRepository extends JpaRepository<ImageSujet, Long>  {
	
	@Query(value = "SELECT * FROM image_sujet WHERE id_sujet=?1", nativeQuery = true)
	public ImageSujet findImageSujet(Long idSujet);

}
