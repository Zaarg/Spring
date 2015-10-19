package be.vdab;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
  public static void main(String[] args) { 
    try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("container.xml")) {
    	System.out.println(context.getBean("classA", ClassA.class).getBoodschap()); //standaard manier van bean opvragen
    	System.out.println(context.getBean("classB", ClassB.class).getBoodschap());
    	System.out.println(context.getBean(ClassA.class).getBoodschap()+" 1 class only");		//als slechts 1 bean bestaat volstaat dit commando
    	System.out.println(context.getBean(InterfaceB.class).getBoodschap()+" 1 interfaced class only"); 	//slechts 1 bean die de interface implenteert, opvragen via interace mogelijk
    }
  }
} 