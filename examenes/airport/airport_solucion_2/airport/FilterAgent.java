package airport;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilterAgent implements AirportStatus {
	
	private Set<AirportStatus> agents;
	private String flight;
	
	public FilterAgent(String flightNumber) {
		this.flight=flightNumber;
		this.agents= new HashSet<AirportStatus>();
	}
	
	

	@Override
	public void airportStatusOK() {
		// TODO Auto-generated method stub
		this.agents.forEach((a)-> {a.airportStatusOK();});

	}

	@Override
	public void airportClosedWeahter(WeatherEvent reason) {
		this.agents.forEach((a)-> {a.airportClosedWeahter(reason);});
	}

	@Override
	public void airportClosed(String reason) {
		this.agents.forEach((a)-> {a.airportClosed(reason);});

	}

	@Override
	public void departFlight(String flightNumber, LocalDate time) {
		if(flightNumber.equals(this.flight)) {
			this.agents.forEach((a)-> {a.departFlight(flightNumber, time);});
		}

	}

	@Override
	public void arriveFlight(String flightNumber, LocalDate time) {
		if(flightNumber.equals(this.flight)) {
			this.agents.forEach((a)-> {a.arriveFlight(flightNumber, time);});
		}

	}
	
	public boolean isForThisFlight(String flightNumber) {
		return this.flight.equals(flightNumber);
	}

	public void addListener(AirportStatus agent) {
		this.agents.add(agent);
	}
	
	public void removeListener(AirportStatus agent) {
		this.agents.remove(agent);
	}
}
