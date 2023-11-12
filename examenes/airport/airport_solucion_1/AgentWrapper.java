package airport;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Registra y gestiona el inter�s de vuelos de un agente externo (AirportStatus) determinado.
 * 
 * Al agente externo le ser�n re-transmitidas todas las notificaciones clim�ticas y de eventos 
 * del aeropuerto, pero s�lo las de vuelos en los que est� interesado.  
 */
public class AgentWrapper implements AirportStatus {
	
	/**
	 * Agente externo para el cual se gestiona el inter�s en vuelos.
	 */
	private AirportStatus externalAgent;
	
	
	/**
	 * Vuelos en los cuales est� interesado externalAgent.
	 */
	private Set<String> flightNumbers;

	
	/**
	 * Crea una instancia de AgentWrapper para el agente externo recibido por par�metro. 
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
	 * Registra el inter�s de externalAgent por el vuelo flightNumber  
	 */
	public void addInterestIn(String flightNumber) {
		flightNumbers.add(flightNumber);
	}

	
	/**
	 * Remueve el inter�s de externalAgent por el vuelo flightNumber  
	 */
	public void removeInterestIn(String flightNumber) {
		flightNumbers.remove(flightNumber);
	}

	
	/**
	 * Devuelve si el externalAgent tiene alg�n inter�s en vuelos.  
	 */
	public boolean hasInterests() {
		return !flightNumbers.isEmpty();
	}
	
	
	/**
	 * Retransmisi�n incondicional de la notificaci�n de un evento.
	 */
	@Override
	public void airportStatusOK() {
		externalAgent.airportStatusOK();
	}

	
	/**
	 * Retransmisi�n incondicional de la notificaci�n de un evento.
	 */
	@Override
	public void airportClosedWeahter(WeatherEvent reason) {
		externalAgent.airportClosedWeahter(reason);
	}

	
	/**
	 * Retransmisi�n incondicional de la notificaci�n de un evento.
	 */
	@Override
	public void airportClosed(String reason) {
		externalAgent.airportClosed(reason);
	}
	
	
	/**
	 * Retransmisi�n de notificaci�n de vuelo condicionada al inter�s de externalAgent.
	 */
	@Override
	public void departFlight(String flightNumber, LocalDate time) {
		if(flightNumbers.contains(flightNumber)){
			externalAgent.departFlight(flightNumber, time);
		}
	}

	
	/**
	 * Retransmisi�n de notificaci�n de vuelo condicionada al inter�s de externalAgent.
	 */
	@Override
	public void arriveFlight(String flightNumber, LocalDate time) {
		if(flightNumbers.contains(flightNumber)){
			externalAgent.arriveFlight(flightNumber, time);
		}
	}

}
