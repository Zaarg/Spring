package be.vdab.DAO;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream; 

import be.vdab.Persoon;

public class PersoonDAOCSV implements PersoonDAO{ //imoort from text file with comma delimiter

	Path personenfile;
	
	public PersoonDAOCSV (Path personenfile) {
		this.personenfile = personenfile;
	}
	
	@Override
	public List<Persoon> findAll() {
		List<Persoon> personen = new ArrayList<>();
		try (Stream<String> stream = Files.lines(personenfile)) {
			stream.forEach(regel -> {
				String[] eigenschap = regel.split(",");
				personen.add(new Persoon(Integer.parseInt(eigenschap[0]),eigenschap[1],eigenschap[2],Integer.parseInt(eigenschap[3])));
			});
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
		return personen;
	}

}
