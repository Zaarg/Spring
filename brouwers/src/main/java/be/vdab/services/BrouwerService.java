package be.vdab.services;

import java.util.List;

import be.vdab.entities.Brouwer;

public interface BrouwerService {
  
	void create(Brouwer brouwer);
	void read(long id);
	void update(Brouwer Brouwer);
	void delete(long id);
	
	List<Brouwer> findAll();
	
	List<Brouwer> findByNaam(String beginNaam);
  
} 