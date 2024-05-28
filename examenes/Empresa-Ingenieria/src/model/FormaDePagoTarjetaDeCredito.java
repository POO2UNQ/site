package model;

public class FormaDePagoTarjetaDeCredito implements FormaDePago{
	
	private Integer coutas;
	
	@Override
	public Double ajustarPrecio(Double costo) {
		
		return costo * 0.04 * this.coutas;
	}

	@Override
	public Double getMonto(Actividad actividad) {
		
		return actividad.getCosto() + actividad.ajustarPorFormaDePago(this);
	}

}
