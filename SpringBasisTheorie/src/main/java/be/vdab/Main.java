package be.vdab;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
  public static void main(String[] args) { 
    try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("container.xml")) {
    	ClassA objectA = context.getBean(ClassA.class);
    	System.out.println(objectA.getKoersenURL());
    	System.out.println(objectA.getDefaultTaalEnLand().getDisplayName());
    	System.out.println("Bestand bestaat: " + objectA.getImportData().exists());
    	System.out.println(objectA.getDefaultBladRichting());     
    }
  }
} 