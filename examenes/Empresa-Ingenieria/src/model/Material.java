package model;

public class Material {
	
	private Integer cantidad;
	private Double precio;
	

	public Material(Integer cantidad, Double precio) {
		this.cantidad = cantidad;
		this.precio = precio;
	}


	public Double getCosto(){
		return this.cantidad * this.precio;
	}

}
