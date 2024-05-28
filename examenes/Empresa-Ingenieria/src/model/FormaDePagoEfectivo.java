package model;

public class FormaDePagoEfectivo implements FormaDePago{

	@Override
	public Double ajustarPrecio(Double costo) {
		
		return 0.0;
	}

	@Override
	public Double getMonto(Actividad actividad) {
		
		return actividad.getCosto();
	}

}
