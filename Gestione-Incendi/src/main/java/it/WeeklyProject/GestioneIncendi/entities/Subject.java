package it.WeeklyProject.GestioneIncendi.entities;

import java.util.ArrayList;
import java.util.List;


public abstract class Subject {
	
	private final List<Observer> observers = new ArrayList<Observer>();

    public void notifyObservable() {
        this.getObservers().forEach(o -> o.update(this));
    }

   public List<Observer> getObservers() {
       return observers;
   }

   public void addObserver(Observer obs) {
       this.getObservers().add(obs);
   }
   
   public void removeObserver(Observer obs) {
       this.getObservers().remove(obs);
   }
}
