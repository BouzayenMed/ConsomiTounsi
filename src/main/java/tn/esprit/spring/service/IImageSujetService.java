package tn.esprit.spring.service;

import tn.esprit.spring.entity.ImageSujet;

public interface IImageSujetService {
	public ImageSujet ajouterImage(ImageSujet image) ;
	public ImageSujet findImageSujet(Long idSujet);
}
