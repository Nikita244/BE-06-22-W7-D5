package it.WeeklyProject.GestioneIncendi.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sonda extends Subject{
	
	private final int limite = 5;

    private int id;
    private double lon;
    private double lat;
    private int smokeLevel = 0;

    public Sonda(int id, double x, double y) {

        this.id = id;
        this.lat = x;
        this.lon = y;
    }

    public void setSmokeLevel(int smokeLevel) {
        this.smokeLevel = smokeLevel;

        if(smokeLevel > limite ) {
            super.notifyObservable();
        }
    }

}
