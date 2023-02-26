package it.WeeklyProject.GestioneIncendi.entities;

public class ControlloSonda implements Observer{
	
	private int id;

    private CentroControllo centroControllo;

    public ControlloSonda(int id, CentroControllo centroControllo) {
        this.id = id;
        this.centroControllo = centroControllo;
    }

    @Override
    public void update(Subject obj) {
        Sonda s = (Sonda)obj;
        centroControllo.rilevaIncendio(s);
    }
}
