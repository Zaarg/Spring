package be.vdab.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import be.vdab.entities.Filiaal;
import be.vdab.valueobjects.PostcodeReeks;

@Repository 
class FiliaalDAOImpl implements FiliaalDAO { 
	private final Map<Long, Filiaal> filialen = new ConcurrentHashMap<>(); 
	private final JdbcTemplate jdbcTemplate;
	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	FiliaalDAOImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		  this.jdbcTemplate = jdbcTemplate;
		  this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	} 
	  
	@Override
	public void create(Filiaal filiaal) {
		filiaal.setId(Collections.max(filialen.keySet()) + 1); 
		filialen.put(filiaal.getId(), filiaal);
	} 
  
	@Override
	public Filiaal read(long id) {
		return filialen.get(id);
	} 
  
	@Override
	public void update(Filiaal filiaal) {
		filialen.put(filiaal.getId(), filiaal);
	} 
  
	@Override
	public void delete(long id) {
		filialen.remove(id);
	} 
  
	@Override
	public List<Filiaal> findAll() {
		return new ArrayList<>(filialen.values());
	}
	
	@Override
	public long findAantalFilialen() {
		return filialen.size();
	}
  
	@Override
	public long findAantalWerknemers(long id) {
		return id == 1L ? 7L : 0L; 
	}
	
	@Override 
	public List<Filiaal> findByPostcodeReeks(PostcodeReeks reeks) {
	  List<Filiaal> filialen = new ArrayList<>();
	  for (Filiaal filiaal : this.filialen.values()) {
	    if (reeks.bevat(filiaal.getAdres().getPostcode())) {
	      filialen.add(filiaal);
	    }
	  }
	  return filialen;
	} 
}