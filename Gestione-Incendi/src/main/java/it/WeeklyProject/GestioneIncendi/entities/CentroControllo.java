package it.WeeklyProject.GestioneIncendi.entities;

public class CentroControllo {
	
	public CentroControllo(Comunicazione comunicazione) {

        this.comunicazione = comunicazione;
    }
	
    private Comunicazione comunicazione;
    
    public void rilevaIncendio(Sonda s) {
        comunicazione.allarme(s.getId(), s.getLat(), s.getLon(), s.getSmokeLevel());
    }
}
