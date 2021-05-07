package tn.esprit.spring.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.Ads;




public interface AdsRepository<A> extends JpaRepository<Ads, Long>{
	




}
