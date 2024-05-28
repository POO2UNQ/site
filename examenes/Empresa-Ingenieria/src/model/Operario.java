package model;

public class Operario {
	
	private Integer horasTrabajadas;
	private Double valorPorHora;
	private Integer aniosDeAntiguedad;
	

	public Operario(Integer horasTrabajadas, Double valorPorHora, Integer aniosDeAntiguedad) {
		super();
		this.horasTrabajadas = horasTrabajadas;
		this.valorPorHora = valorPorHora;
		this.aniosDeAntiguedad = aniosDeAntiguedad;
	}

	public Double getSueldo() {
		return this.horasTrabajadas * this.valorPorHora * this.procentajeExtraPorAntiguedad();
	}

	private Double procentajeExtraPorAntiguedad() {
		
		return (aniosDeAntiguedad > 5) ? 1.1 : 1.0;
	}

}
