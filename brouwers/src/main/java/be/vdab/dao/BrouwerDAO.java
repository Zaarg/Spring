package be.vdab.dao;

import java.util.List;

import be.vdab.entities.Brouwer;

public interface BrouwerDAO {
	
	void create(Brouwer brouwer);
	
	Brouwer read(long id);
	
	void update(Brouwer brouwer);
	
	void delete(long id);
	
	List<Brouwer> findAll();
	
	List<Brouwer> findByNaam(String beginNaam);
		
}