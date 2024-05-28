package model;

public class Empresa {
	
	private Actividad actividadActual;
	private FormaDePago formaDePago;
	private String nombre;
	private String cuit;
	
	public Empresa(String nombre, String cuit, Proyecto actividad, FormaDePago formaDePago) {
		this.nombre = nombre;
		this.cuit = cuit;
		this.actividadActual = actividad;
		this.formaDePago = formaDePago;
	}

	public Double getCosto() {
		return formaDePago.getMonto(this.actividadActual);
	}

}
