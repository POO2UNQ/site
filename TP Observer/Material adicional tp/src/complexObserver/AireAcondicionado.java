package complexObserver;

/**
 * Importante: esta clase fue desarrollada a modo de ejemplo y disparador
 * para ser criticados y mejorados en la practica de Observer de la materia
 * Objetos 2 de la UNQ.
 */

import java.util.Observable;
import java.util.Observer;

public class AireAcondicionado implements Observer{
	
	private ComplexSensor miSensor;
	
	
	public AireAcondicionado(ComplexSensor miSensor){
		this.miSensor=miSensor;
		this.miSensor.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		String aspecto = (String) arg;
		if(aspecto.equalsIgnoreCase("TemperaturaInterior")){
			this.verificarContexto(this.miSensor.getTemperaturaInterior());
		}
	}

	private void verificarContexto(int temperaturaInterior) {
		if(temperaturaInterior>25){
			//encender motor aire acondicionado 15 segundos
		}
		
	}

}
