package be.vdab.services;

import java.util.List;

import be.vdab.Persoon;
import be.vdab.DAO.PersoonDAO;

public class PersoonServiceImpl implements PersoonService{
	
	PersoonDAO persoonDAO;
	
	public PersoonServiceImpl(PersoonDAO persoonDAO) {
		this.persoonDAO = persoonDAO;
	}
	
	@Override
	public List<Persoon> findAll() {
		return this.persoonDAO.findAll();
	}

}
