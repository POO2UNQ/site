package complexWithListener;

import java.util.ArrayList;
import java.util.List;

public class ComplexSensor {

		
		private int temperaturaExterior;
		private int temperaturaInterior;
		private int humedad;
		private List<SensorListener> listeners;
		
		public ComplexSensor(){
			this.temperaturaExterior=0;
			this.temperaturaInterior=0;
			this.humedad=0;
			this.listeners= new ArrayList<SensorListener>();
			this.reset();
		}

		private void reset() {
			// Metodo que simular obtener los valores iniciales del
			//hardware que obtiene las temperaturas y la humedad
			
		}
		
		public void setTemperaturaExterior(int nuevoValor){
			this.temperaturaExterior=nuevoValor;
			this.notificarTemperaturaExterior();;
		}
		
		private void notificarTemperaturaExterior() {
			for (SensorListener listener : this.listeners) {
				listener.temperaturaExteriorModificada(this, this.getTemperaturaExterior());
			}
		}

		public void setTemperaturaInterior(int nuevoValor){
			this.temperaturaInterior=nuevoValor;
			this.notificarTemperaturaInterior();
		}
		
		private void notificarTemperaturaInterior() {
			for (SensorListener listener : this.listeners) {
				listener.temperaturaInteriorModificada(this, this.getTemperaturaInterior());
			}
		}
		public void setHumedad(int nuevoValor){
			this.humedad=nuevoValor;
			this.notificarHumedad();
		}
		
		private void notificarHumedad() {
			for (SensorListener listener : this.listeners) {
				listener.humedadModificada(this, this.getHumedad());
			}
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
		
}
