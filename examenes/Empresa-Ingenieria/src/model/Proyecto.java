package model;

import java.util.List;

public class Proyecto implements Actividad{
	
	private List<Actividad> actividades;
	
	public Proyecto( List<Actividad> actividades) {
		this.actividades = actividades;
		
	}
	
	public void agregarActividad(Actividad actividad) {
		this.actividades.add(actividad);
	}

	@Override
	public Double getCosto() {
		
		return this.actividades.stream().mapToDouble(actividad -> actividad.getCosto()).sum() * 1.2;
	}

	@Override
	public Double ajustarPorFormaDePago(FormaDePago formaDePago) {
		
		return this.actividades.stream().mapToDouble(actividad -> actividad.ajustarPorFormaDePago(formaDePago)).sum();
	}
	

}
