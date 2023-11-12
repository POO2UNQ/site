package airport;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Airport {
	
	
	/**
	 * Agentes externos interesados en todos los eventos y notificaciones en general.
	 */
	private Set<AirportStatus> generalAgents;
	
	
	/**
	 * Agentes externos interesados en vuelos particulares.
	 * Son AgentWrappers (o sea, abstrayéndonos: agentes externos con inteligencia de gestión de intereses).
	 */
	private Set<AgentWrapper> flightAgents;
	
	
	/**
	 * Crea una instancia de Airport. 
	 */
	public Airport() {
		this.generalAgents = new HashSet<AirportStatus>();
		this.flightAgents = new HashSet<AgentWrapper>();		
	}
	

	/**
	 * Devuelve una lista con TODOS los agentes externos, independientemente de sus intereses.
	 */
	private Set<AirportStatus> getAgents(){
		Set<AirportStatus> all = new HashSet<AirportStatus>();
		all.addAll(this.generalAgents);
		all.addAll(this.flightAgents);
		return all;
	}

	
	/**
	 * Agrega a un agente externo como listener general (interesado en todos los eventos).
	 */
	public void addListener(AirportStatus agenteExterno) {
		generalAgents.add(agenteExterno);
	}

	
	/**
	 * Remueve a un agente externo como listener general (interesado en todos los eventos).
	 */
	public void removeListener(AirportStatus agenteExterno) {
		generalAgents.remove(agenteExterno);
	}
	

	/**
	 * Agrega a un agente externo como listener de un vuelo.
	 */
	public void addListener(String flightNumber, AirportStatus agent) {
		//Busco el wrapper del agente recibido. Si no lo tiene, lo creo.
		AgentWrapper agentWrapper;
		agentWrapper = flightAgents.stream().filter(fa -> fa.getExternalAgent() == agent).findFirst().orElse(new AgentWrapper(agent));

		//Agrego el wrapper al conjunto de flightAgents (sólo por si es nuevo; caso contrario, es inocuo por ser un set). 
		flightAgents.add(agentWrapper);
		
		//Registro en el wrapper el interés por el vuelo.
		agentWrapper.addInterestIn(flightNumber);				

		//Remuevo al agente del conjunto de interesados generales, ya que ahora es un interesado en vuelos.
		generalAgents.remove(agent);
	}

	
	/**
	 * Remueve a un agente externo como listener de un vuelo.
	 * Precondición: el agente actualmente tiene interés en ese vuelo.
	 */
	public void removeListener(AirportStatus agent, String flightNumber) {
		//Busco el wrapper del agente recibido.
		AgentWrapper agentWrapper = flightAgents.stream().filter(fa -> fa.getExternalAgent() == agent).findFirst().get();
		
		//Remuevo de ese wrapper el interés por el vuelo .
		agentWrapper.removeInterestIn(flightNumber);
		
		//Si ya no tiene intereses en vuelos, elimino el wrapper.
		if(!agentWrapper.hasInterests()) {
			flightAgents.remove(agentWrapper);
		}
	}

	
	/**
	 * El aeropuerto anuncia la salida de un vuelo.
	 * 
	 * Tip: Notar que, abstrayéndonos, un AgentWrapper es un agente externo con inteligencia 
	 * de gestión de intereses, y el aeropuerto los trata homgéneamente junto a los agentes 
	 * externos comunes (shhh... aquí el aeropuerto no se da cuenta!).   
	 */
	public void newFlightDeparture(String flightNumber) {
		this.getAgents().forEach(a -> a.departFlight(flightNumber, LocalDate.now()));
		
	}
	
	
	//Similar para el resto de las notificaciones.

}
