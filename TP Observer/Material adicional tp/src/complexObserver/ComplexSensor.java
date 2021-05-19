package complexObserver;

/**
 * Importante: esta clase fue desarrollada a modo de ejemplo y disparador
 * para ser criticados y mejorados en la practica de Observer de la materia
 * Objetos 2 de la UNQ.
 */

import java.util.Observable;

public class ComplexSensor extends Observable{
	
	private int temperaturaExterior;
	private int temperaturaInterior;
	private int humedad;
	
	public ComplexSensor(){
		this.temperaturaExterior=0;
		this.temperaturaInterior=0;
		this.humedad=0;
		this.reset();
	}

	private void reset() {
		// Metodo que simular obtener los valores iniciales del
		//hardware que obtiene las temperaturas y la humedad
		
	}
	
	public void setTemperaturaExterior(int nuevoValor){
		this.temperaturaExterior=nuevoValor;
		this.notificar("TemperaturaExterior");
	}
	
	public void setTemperaturaInterior(int nuevoValor){
		this.temperaturaInterior=nuevoValor;
		this.notificar("TemperaturaInterior");
	}
	
	public void setHumedad(int nuevoValor){
		this.humedad=nuevoValor;
		this.notificar("Humedad");
	}

	public int getTemperaturaExterior() {
		return temperaturaExterior;
	}

	public int getTemperaturaInterior() {
		return temperaturaInterior;
	}

	public int getHumedad() {
		return humedad;
	}
	
	private void notificar(String aspecto){
		this.setChanged();
		this.notifyObservers(aspecto);
	}

	
	
}
