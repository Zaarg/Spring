package be.vdab.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Brouwer;

public interface BrouwerDAO extends JpaRepository<Brouwer, Long>{
	
	List<Brouwer> findByNaamStartingWith(String begin);
	
	/*void create(Brouwer brouwer);
	
	Brouwer read(long id);
	
	void update(Brouwer brouwer);
	
	void delete(long id);
	
	List<Brouwer> findAll();
	
	List<Brouwer> findByNaam(String beginNaam);*/
		
}