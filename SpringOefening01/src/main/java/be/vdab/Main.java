package be.vdab;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
  public static void main(String[] args) { 
    List<Persoon> personen = new ArrayList<>();
    personen.add(new Persoon(1,"Bob","Bobby",0));
    personen.add(new Persoon(2,"Cob","Cobby",1));
    personen.add(new Persoon(3,"Dob","Dobby",2));
    personen.add(new Persoon(4,"Eob","Eobby",3));
    personen.add(new Persoon(5,"Fob","Fobby",4));
	try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("container.xml")) {
		PersoonViewer persoonViewer = context.getBean("persoonViewer", PersoonViewer.class); 
		persoonViewer.afbeelden(personen);
    }
  }
} 