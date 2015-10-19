package be.vdab.DAO;

import java.io.File;
import java.util.List;
import be.vdab.Persoon;

public class PersoonDAOMeerdereRegels implements PersoonDAO{ //imoort from text file with ENTER delimiter
	
	File personenfile;
	
	public PersoonDAOMeerdereRegels (File personenfile) {
		this.personenfile = personenfile;
	}
	
	@Override
	public List<Persoon> findAll() {
		
		return null;
	}

}
