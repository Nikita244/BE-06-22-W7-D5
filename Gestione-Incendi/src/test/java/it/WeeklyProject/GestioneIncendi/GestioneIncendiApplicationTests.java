package it.WeeklyProject.GestioneIncendi;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import it.WeeklyProject.GestioneIncendi.entities.CentroControllo;
import it.WeeklyProject.GestioneIncendi.entities.ControlloSonda;
import it.WeeklyProject.GestioneIncendi.entities.Sonda;

@SpringBootTest
class GestioneIncendiApplicationTests {
	
	CentroControllo centroControllo;

	@Test
	void contextLoads() {
	}
	
	@Test
		public void testSonda() {
			ControlloSonda cts = new ControlloSonda(1, centroControllo);
			Sonda s = new Sonda(1, 44.424829,  8.932020);
			
			s.addObserver(cts);
			
			assertTrue(s.getObservers().contains(cts));
	}


	@Test
	public void testFumoUp() {

	    ControlloSonda cts1 = new ControlloSonda(1, centroControllo);
	    
	    Sonda s = new Sonda(1, 44.424829,  8.932020);
	    
	    s.addObserver(cts1);

	    Runnable runnable = new Runnable() {
	        @Override
	        public void run() {
	            s.setSmokeLevel(7);
	        }
	    };
	    
	    assertThrows(Exception.class, runnable::run);
	}
	
	@Test
	public void testFumoDown() {
	  
	    ControlloSonda cts1 = new ControlloSonda(1, centroControllo);
	    
	    Sonda s = new Sonda(1, 44.424829,  8.932020);
	    
	    s.addObserver(cts1);
	    
	    Assertions.assertDoesNotThrow(() -> {
	        s.setSmokeLevel(2);
	    });
	}
}
