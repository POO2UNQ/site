package simpleObserver;
import java.util.Observable;

/**
 * Importante: esta clase fue desarrollada a modo de ejemplo y disparador
 * para ser criticados y mejorados en la practica de Observer de la materia
 * Objetos 2 de la UNQ.
 */

public class Sensor extends Observable{
	
	private int temperaturaActual;
	
	public Sensor(){
		this.temperaturaActual = 0; // 
	}
	
	
	/**
	 * Este metodo es invocado por el controlador de hardware del sensor fisico
	 * @param nuevoValor nuevo valor de temperatura
	 */
	public void setTempratura(int nuevoValor){
		this.temperaturaActual=nuevoValor;
		this.setChanged();
		this.notifyObservers(); //Forma basica, indica que cambió solamente pero no cual es el elemento particular del cambio
		
	}
	
	public int getTemperatura(){
		return this.temperaturaActual;
	}

}
