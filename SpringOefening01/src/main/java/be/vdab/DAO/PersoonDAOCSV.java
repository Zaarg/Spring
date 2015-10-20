package be.vdab.DAO;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import be.vdab.Persoon;

@Repository
@Qualifier("persoonCSVDAO")
class PersoonDAOCSV implements PersoonDAO{ //imoort from text file with comma delimiter

	File personenfile;
	
	//@Autowired
	PersoonDAOCSV (File personenfile) {
		this.personenfile = personenfile;
	}
	
	@Override
	public List<Persoon> findAll() {
		List<Persoon> personen = new ArrayList<>();
		try (Stream<String> stream = Files.lines(personenfile.toPath())) {
			stream.forEach(regel -> {
				String[] eigenschap = regel.split(",");
				try {
					personen.add(new Persoon(Integer.parseInt(eigenschap[0]),eigenschap[1],eigenschap[2],Integer.parseInt(eigenschap[3])));
				} catch (NumberFormatException x){
					
				}
			});
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
		return personen;
	}

}
