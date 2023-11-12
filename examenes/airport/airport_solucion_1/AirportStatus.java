package airport;

import java.time.LocalDate;

/**
 * Interfaz que deben implementar los Agentes Externos interesados en recibir notificaciones del Aeropuerto. 
 */
public interface AirportStatus {

		public void airportStatusOK();
		public void airportClosedWeahter(WeatherEvent reason);
		public void airportClosed(String reason);
		public void departFlight(String flightNumber, LocalDate time);
		public void arriveFlight(String flightNumber, LocalDate time);

}
