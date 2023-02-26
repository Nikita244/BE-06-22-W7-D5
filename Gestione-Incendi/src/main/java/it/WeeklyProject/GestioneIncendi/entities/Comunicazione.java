package it.WeeklyProject.GestioneIncendi.entities;

public class Comunicazione {

	public void allarme(int id, double x, double y, int smokeLevel) {
        
		System.out.println(" ");
		
		System.out.println(String.format("\uD83D\uDD25 E' stato rilevato un incendio dalla sonda %d presso le seguenti coordinate: %f %f e livello di fumo %d.", id, x, y, smokeLevel));

        System.out.println(String.format("Notifica inviata al personale preposto all'intervento con URL: http://host/alarm?idsonda=%d&lat=%f&lon=%f&smokelevel=%d.", id, x, y, smokeLevel));

    }
}
