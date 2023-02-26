package it.WeeklyProject.GestioneIncendi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.WeeklyProject.GestioneIncendi.entities.CentroControllo;
import it.WeeklyProject.GestioneIncendi.entities.Comunicazione;
import it.WeeklyProject.GestioneIncendi.entities.ControlloSonda;
import it.WeeklyProject.GestioneIncendi.entities.Sonda;

@SpringBootApplication
public class GestioneIncendiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestioneIncendiApplication.class, args);
		
		Comunicazione c = new Comunicazione();

        CentroControllo cc = new CentroControllo(c);

        ControlloSonda cs = new ControlloSonda(1, cc);
        
        ControlloSonda cs1 = new ControlloSonda(2, cc);
        
        ControlloSonda cs2 = new ControlloSonda(3, cc);

        Sonda s = new Sonda(1, 44.424829,  8.932020);
        
        Sonda s1 = new Sonda(2, 44.1072811,  9.801819);
        
        Sonda s2 = new Sonda(3, 44.3052193,  8.4345189);


        // L'osservatore della sonda e` il controllo sonda cs

        s.addObserver(cs);
        s1.addObserver(cs1);
        s2.addObserver(cs2);


        s.setSmokeLevel(6);
        s1.setSmokeLevel(7);
        //questo allarme non deve partire
        s2.setSmokeLevel(2);

	}
	
	

}
