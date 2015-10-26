package be.vdab.dao;

import java.util.List;

import be.vdab.entities.Filiaal;
import be.vdab.valueobjects.PostcodeReeks;

public interface FiliaalDAO {
	void create(Filiaal filiaal);
	Filiaal read(long id);
	void update(Filiaal filiaal);
	void delete(long id);
	List<Filiaal> findAll();
	long findAantalFilialen();
	long findAantalWerknemers(long id); // het aantal werknemers van een filiaal:
	List<Filiaal> findByPostcodeReeks(PostcodeReeks reeks); 
	
}