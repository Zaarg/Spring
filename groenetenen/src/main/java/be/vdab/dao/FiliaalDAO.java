package be.vdab.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Filiaal;
import be.vdab.valueobjects.PostcodeReeks;

public interface FiliaalDAO extends JpaRepository<Filiaal, Long>{   
	
	List<Filiaal> findByAdresPostcodeBetweenOrderByNaam(int van, int tot);  
	List<Filiaal> findByWaardeGebouwNot(BigDecimal waarde);

	
	/*void create(Filiaal filiaal);
	Filiaal read(long id);
	void update(Filiaal filiaal);
	void delete(long id);
	List<Filiaal> findAll();
	long findAantalFilialen();
	//long findAantalWerknemers(long id); // het aantal werknemers van een filiaal:
	List<Filiaal> findByPostcodeReeks(PostcodeReeks reeks); */
	
}