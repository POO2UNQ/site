package model;

public interface FormaDePago {
	
	public Double ajustarPrecio(Double costo);

	public Double getMonto(Actividad actividad);

}
