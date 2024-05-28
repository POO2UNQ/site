package model;

public class Transporte implements Actividad{
	
	private Double pesoDeCarga;
	private Double precio;
	private Integer distancia;
	
	public Transporte(Double pesoDeCarga, Double precio, Integer distancia) {
		this.pesoDeCarga = pesoDeCarga;
		this.precio = precio;
		this.distancia = distancia;
	}
	
	@Override
	public Double getCosto() {
		return this.pesoDeCarga * this.precio * this.distancia;
	}

	@Override
	public Double ajustarPorFormaDePago(FormaDePago formaDePago) {
		return 0.0;
	}

}
