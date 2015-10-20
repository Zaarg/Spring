package be.vdab.DAO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import be.vdab.Persoon;

public class PersoonDAOMeerdereRegels implements PersoonDAO{ //imoort from text file with ENTER delimiter
	
	File personenfile;
	
	public PersoonDAOMeerdereRegels (File personenfile) {
		this.personenfile = personenfile;
	}
	
	@Override
	public List<Persoon> findAll() {
		List<Persoon> personen = new ArrayList<>();
		try (Scanner txtScanner = new Scanner(personenfile)) {
			while (txtScanner.hasNextLine()) {
                String nr = txtScanner.nextLine();
                String voornaam = txtScanner.nextLine();
                String familienaam = txtScanner.nextLine();
                String kinderen = txtScanner.nextLine();
                try {
					personen.add(new Persoon(Integer.parseInt(nr),voornaam,familienaam,Integer.parseInt(kinderen)));
				} catch (NumberFormatException x){					
				}
            }
		} catch (Exception ex) {
			ex.printStackTrace();
		    return null;
		}      
		return personen;
	}

}
