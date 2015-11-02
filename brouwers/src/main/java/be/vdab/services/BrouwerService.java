package be.vdab.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import be.vdab.entities.Brouwer;

public interface BrouwerService {
  
	void create(Brouwer brouwer);
	void read(long id);
	void update(Brouwer Brouwer);
	void delete(long id);
	
	Page<Brouwer> findAll(Pageable pageable);
	
	List<Brouwer> findByNaam(String beginNaam);
  
} 