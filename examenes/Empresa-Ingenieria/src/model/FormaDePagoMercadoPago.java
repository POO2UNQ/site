package model;

public class FormaDePagoMercadoPago implements FormaDePago{

	@Override
	public Double ajustarPrecio(Double costo) {
		
		return costo * 0.03;
	}

	@Override
	public Double getMonto(Actividad actividad) {
		
		return actividad.getCosto() - actividad.ajustarPorFormaDePago(this);
	}

}
