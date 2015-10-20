package be.vdab;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import be.vdab.DAO.CreateDAOBeans;
import be.vdab.presentation.CreatePresentationBeans;
import be.vdab.presentation.PersoonViewer;
import be.vdab.services.CreateServiceBeans;

public class Main {
  public static void main(String[] args) { 
    /*List<Persoon> personen = new ArrayList<>();
    personen.add(new Persoon(1,"Bob","Bobby",0));
    personen.add(new Persoon(2,"Cob","Cobby",1));
    personen.add(new Persoon(3,"Dob","Dobby",2));
    personen.add(new Persoon(4,"Eob","Eobby",3));
    personen.add(new Persoon(5,"Fob","Fobby",4));*/
	try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CreateDAOBeans.class,CreateServiceBeans.class,CreatePresentationBeans.class)) {
		PersoonViewer persoonViewer = context.getBean(PersoonViewer.class); 
		persoonViewer.afbeelden();
    }
  }
} 