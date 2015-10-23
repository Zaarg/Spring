package be.vdab.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import be.vdab.entities.Brouwer;
import be.vdab.valueobjects.Adres;

@Repository 
class BrouwerDAOImpl implements BrouwerDAO { 
	
	private final Map<Long, Brouwer> brouwers = new ConcurrentHashMap<>(); 
	BrouwerDAOImpl() { 
		brouwers.put(1L, new Brouwer(1, "Stella", 1000000, new Adres("Vaartkom", "11", 3000, "Leuven")));
		brouwers.put(2L, new Brouwer(2, "Mort Subite", 100000, new Adres("Gasthuisstraat", "31", 1000, "Brussel")));
		brouwers.put(3L, new Brouwer(3, "Straffen Hendrik", 200000, new Adres("Katelijnestraat", "44", 8000, "Brugge")));
	} 
  
	@Override
	public void create(Brouwer brouwer) {
		brouwer.setBrouwerNr(Collections.max(brouwers.keySet()) + 1); 
		brouwers.put(brouwer.getBrouwerNr(), brouwer);
	} 
   
	@Override
	public List<Brouwer> findAll() {
		return new ArrayList<>(brouwers.values());
	}
	
	@Override
	public List<Brouwer> findByNaam(String beginNaam) {
		List<Brouwer> bros = new ArrayList<>();
		for (Brouwer bro:brouwers.values()) {
			if (bro.getNaam().toLowerCase().contains(beginNaam.toLowerCase())) {
				bros.add(bro);
			}
		}
		return new ArrayList<>(brouwers.values());
	}
	
}