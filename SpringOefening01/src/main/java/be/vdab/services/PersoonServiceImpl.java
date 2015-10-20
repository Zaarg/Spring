package be.vdab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import be.vdab.Persoon;
import be.vdab.DAO.PersoonDAO;

@Service
public class PersoonServiceImpl implements PersoonService{
	
	PersoonDAO persoonDAO;
	
	@Autowired
	public PersoonServiceImpl(@Qualifier("persoonCSV") PersoonDAO persoonDAO) {
		this.persoonDAO = persoonDAO;
	}
	
	@Override
	public List<Persoon> findAll() {
		return this.persoonDAO.findAll();
	}

}
