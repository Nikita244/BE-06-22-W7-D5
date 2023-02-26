package it.S7L5WP.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.S7L5WP.models.Sonda;
import it.S7L5WP.services.SondaService;

@RestController
@RequestMapping("/alarm")
public class SondaController {
	
	@Autowired
	SondaService serv;
	
	//tutte le sonde: localhost:8080/alarm
	//sonda by id: http://localhost:8080/alarm?idsonda=1
	
	
	//chiamata al centro di controllo: 
	//http://localhost:8080/alarm?idsonda=1&lat=44.424829&lon=8.93202&smokelevel=7
	//http://localhost:8080/alarm?idsonda=2&lat=44.1072811&lon=9.801819&smokelevel=6
	//http://localhost:8080/alarm?idsonda=6&lat=44.410672&lon=8.8186774&smokelevel=8
	
	
	// Get by id / all / parametri ----------------------------------------
	@GetMapping("")
	public ResponseEntity<Object> getSondaMultiTask(
	            @RequestParam(required=false) Integer idsonda,
	            @RequestParam(required=false) Double lat, 
	            @RequestParam(required=false) Double lon, 
	            @RequestParam(required=false) Integer smokelevel) {
		
	    
	    // Se non ci sono parametri, restituisci la lista completa
	    if (idsonda == null && lat == null && lon == null && smokelevel == null) {
	        List<Sonda> sondaList = serv.getAll();
	        return new ResponseEntity<>(sondaList, HttpStatus.OK);
	    } 
	    
	    // Se viene fornito solo Id, cerca l'oggetto Sonda corrispondente
	    else if (lat == null && lon == null && smokelevel == null) {
	        Optional<Sonda> sondaObj = serv.getById(idsonda);
	        if (!sondaObj.isPresent()) {
	            return new ResponseEntity<>("Sonda non trovata per l'id specificato", HttpStatus.NOT_FOUND);
	        }
	        Sonda sonda = sondaObj.get();
	        return new ResponseEntity<>(sonda, HttpStatus.OK);
	    } 
	     
	    // Altrimenti, filtra l'oggetto Sonda corrispondente utilizzando tutti i parametri forniti
	    else {
	        Optional<Sonda> sondaObj = serv.getById(idsonda);
	        if (!sondaObj.isPresent()) {
	            return new ResponseEntity<>("Sonda non trovata per l'id specificato", HttpStatus.NOT_FOUND);
	        }
	        Sonda sonda = sondaObj.get();
	        if (sonda.getLatitudine() == lat && sonda.getLongitudine() == lon && sonda.getLivelloFumo() == smokelevel) {
	            return new ResponseEntity<>(sonda, HttpStatus.OK);
	        }
	        else {
	            return new ResponseEntity<>("Sonda non trovata per i parametri specificati", HttpStatus.NOT_FOUND);
	        }
	        
	    }
	}
	
	// Get by id ----------------------------------------
    @GetMapping("/sonde/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id) {
        Optional<Sonda> sondaObj = serv.getById(id);
        ResponseEntity<Object> check = checkExists(sondaObj);
        if( check != null ) return check;

        return new ResponseEntity<>(sondaObj.get(), HttpStatus.OK);
    }

    //---------------------------------------------------------------------//
    private ResponseEntity<Object> checkExists(Optional<Sonda> obj) {
        if( !obj.isPresent() ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return null;
    }
}
