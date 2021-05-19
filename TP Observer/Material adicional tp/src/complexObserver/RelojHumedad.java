package complexObserver;

import java.util.Observable;
import java.util.Observer;

/**
 * Importante: esta clase fue desarrollada a modo de ejemplo y disparador
 * para ser criticados y mejorados en la practica de Observer de la materia
 * Objetos 2 de la UNQ.
 */

public class RelojHumedad implements Observer{
	
	private ComplexSensor miSensor;
	private int humedadActual;
	
	
	public RelojHumedad(ComplexSensor miSensor){
		this.miSensor=miSensor;
		this.miSensor.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		String aspecto = (String) arg;
		if(arg.equals("Humedad")){
			this.humedadActual=this.miSensor.getHumedad();
		}
		
	}

}
