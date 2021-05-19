package simpleObserver;
import java.util.Observable;
import java.util.Observer;

/**
 * Importante: esta clase fue desarrollada a modo de ejemplo y disparador
 * para ser criticados y mejorados en la practica de Observer de la materia
 * Objetos 2 de la UNQ.
 */

public class LlamadorBomberos implements Observer{
	
	public Sensor miSensor;
	
	public LlamadorBomberos(Sensor sensor){
		this.miSensor=sensor;
		this.miSensor.addObserver(this); //Se agrega como observador
	}

	@Override
	public void update(Observable o, Object arg) {
		//sabe que recibe solamente este mensaje cuando cambio la temperatura, 
		//Y la recibe solamente del sensor con el que fue iniciado.
		
		this.verificarSituacion(this.miSensor.getTemperatura());
		
	}

	private void verificarSituacion(int temperatura) {
		if(temperatura > 60){
			//Llamar a los bomberos
		}
		
	}
	
	

}
