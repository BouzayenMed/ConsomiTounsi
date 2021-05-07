package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Ads;
import tn.esprit.spring.repository.AdsRepository;


@Service
public class AdsService {
	@Autowired
	AdsRepository<Ads> AdsRepository;
	
	

	@Transactional
	public List<Ads> getAllAds() {
		return (List<Ads>) AdsRepository.findAll();
	}

	@Transactional
	public boolean addAds(Ads ads) {
		return AdsRepository.save(ads) != null;
	}

	@Transactional
	public boolean updateAds(Ads ads) {
		return AdsRepository.save(ads) != null;
	}

	@Transactional
	public boolean deleteAds(Long Adsid) {
		AdsRepository.deleteById(Adsid);
		return !AdsRepository.existsById(Adsid);

	}
	
	@Transactional
	public boolean AcceptAds(Ads ads) throws Exception {
		Optional<Ads> Optionalproduct = AdsRepository.findById(ads.getId());
		Optionalproduct.orElseThrow(() -> new Exception("Ads not found"));
		Ads A=new Ads();
		A=Optionalproduct.get();
		A.setStatus("Accepted");
		return AdsRepository.save(A) != null;
	}
	

	@Transactional
	public boolean DeclineAds(Ads ads) throws Exception {
		Optional<Ads> Optionalproduct = AdsRepository.findById(ads.getId());
		Optionalproduct.orElseThrow(() -> new Exception("Ads not found"));
		Ads A=new Ads();
		A=Optionalproduct.get();
		A.setStatus("Declined");
		return AdsRepository.save(A) != null;
	}
	

	
	
	 public List<Ads> listAll() {
	        return AdsRepository.findAll(Sort.by("id").ascending());
	    }
	 
	
		
	
}
