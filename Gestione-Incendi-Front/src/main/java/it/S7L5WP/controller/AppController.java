package it.S7L5WP.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/crea")
	public String crea() {
	    return "crea";
	}
	
	@GetMapping("/404")
	public String ErroreNotFound() {
	    return "404";
	}
	
	@GetMapping("/sonde")
	public String sonde() {
		return "sonde";
	}
	
	@GetMapping("/allarme1/genova_centro")
	public String allarme1() {
		return "allarme1";
	}
	
	@GetMapping("/allarme2/la_spezia")
	public String allarme2() {
		return "allarme2";
	}
	
	@GetMapping("/allarme6/genova_areoporto")
	public String allarme6() {
		return "allarme6";
	}
	
	
	
	
	

	
}
