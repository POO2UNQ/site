package airport;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Registra y gestiona el interés de vuelos de un agente externo (AirportStatus) determinado.
 * 
 * Al agente externo le serán re-transmitidas todas las notificaciones climáticas y de eventos 
 * del aeropuerto, pero sólo las de vuelos en los que esté interesado.  
 */
public class AgentWrapper implements AirportStatus {
	
	/**
	 * Agente externo para el cual se gestiona el interés en vuelos.
	 */
	private AirportStatus externalAgent;
	
	
	/**
	 * Vuelos en los cuales está interesado externalAgent.
	 */
	private Set<String> flightNumbers;

	
	/**
	 * Crea una instancia de AgentWrapper para el agente externo recibido por parámetro. 
	 */
	public AgentWrapper(AirportStatus externalAgent) {
		this.externalAgent = externalAgent;
		this.flightNumbers = new HashSet<String>();
	}

	
	/**
	 * Getter de externalAgent. 
	 */
	public AirportStatus getExternalAgent() {
		return externalAgent;
	}

	
	/**
	 * Setter de externalAgent. 
	 */
	public void setExternalAgent(AirportStatus externalAgent) {
		this.externalAgent = externalAgent;
	}

	
	/**
	 * Registra el interés de externalAgent por el vuelo flightNumber  
	 */
	public void addInterestIn(String flightNumber) {
		flightNumbers.add(flightNumber);
	}

	
	/**
	 * Remueve el interés de externalAgent por el vuelo flightNumber  
	 */
	public void removeInterestIn(String flightNumber) {
		flightNumbers.remove(flightNumber);
	}

	
	/**
	 * Devuelve si el externalAgent tiene algún interés en vuelos.  
	 */
	public boolean hasInterests() {
		return !flightNumbers.isEmpty();
	}
	
	
	/**
	 * Retransmisión incondicional de la notificación de un evento.
	 */
	@Override
	public void airportStatusOK() {
		externalAgent.airportStatusOK();
	}

	
	/**
	 * Retransmisión incondicional de la notificación de un evento.
	 */
	@Override
	public void airportClosedWeahter(WeatherEvent reason) {
		externalAgent.airportClosedWeahter(reason);
	}

	
	/**
	 * Retransmisión incondicional de la notificación de un evento.
	 */
	@Override
	public void airportClosed(String reason) {
		externalAgent.airportClosed(reason);
	}
	
	
	/**
	 * Retransmisión de notificación de vuelo condicionada al interés de externalAgent.
	 */
	@Override
	public void departFlight(String flightNumber, LocalDate time) {
		if(flightNumbers.contains(flightNumber)){
			externalAgent.departFlight(flightNumber, time);
		}
	}

	
	/**
	 * Retransmisión de notificación de vuelo condicionada al interés de externalAgent.
	 */
	@Override
	public void arriveFlight(String flightNumber, LocalDate time) {
		if(flightNumbers.contains(flightNumber)){
			externalAgent.arriveFlight(flightNumber, time);
		}
	}

}
