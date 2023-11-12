package airport;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Airport {
	
	private Set<AirportStatus> agents;
	private Set<FilterAgent> filterAgents;
	
	public Airport() {
		this.agents=new HashSet<AirportStatus>();
	}
	
	public void addListener(AirportStatus airportStatus) {
		this.agents.add(airportStatus);
	}
	
	public void removeListener(AirportStatus airportStatus) {
		this.agents.remove(airportStatus);
	}
	
	public void removeListener(AirportStatus agent, String flightNumber) {
		this.getFilterAgent(flightNumber).removeListener(agent);
	}
	
	public void addListenerToFly(String flightNumber, AirportStatus agent) {
		this.agents.remove(agent);
		FilterAgent correct = this.getFilterAgent(flightNumber);
		correct.addListener(agent);
		
	}
	
	public FilterAgent getFilterAgent(String flighNumber) {
		FilterAgent fa = this.filterAgents.stream().filter(a -> a.isForThisFlight(flighNumber)).findFirst().orElse(new FilterAgent(flighNumber));
		this.filterAgents.add(fa);
		return fa;
	}
	
	public void newFlightDeparture(String flightNumber) {
		this.getAgents().forEach(a -> a.departFlight(flightNumber, LocalDate.now()));
		
	}
	
	//Similar para el resto de las notificaciones.
	
	private Set<AirportStatus> getAgents(){
		Set<AirportStatus> all = new HashSet<AirportStatus>();
		all.addAll(this.agents);
		all.addAll(this.filterAgents);
		return all;
	}
	

}
