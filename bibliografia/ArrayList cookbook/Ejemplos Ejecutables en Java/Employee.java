package unq.collections;

/**
 * Clase que define un empleado básico de una empresa.
 * @author dcano
 *
 */
public class Employee {

	/**
	 * Nombre del Empleado.
	 */
	private String name;

	/**
	 * Apellido del Empleado.
	 */
	private String surname;	

	/**
	 * Sueldo Basico del Empleado.
	 */
	private Double basicIncome;

	
	/**
	 * Constructor. Crea una instancia de empleado a partir de los 
	 * parámetros recibidos.
	 * 
	 * @param name Nombre del empleado.
	 * @param surname Apellido del empleado.
	 * @param basicIncome Sueldo basico empleado.
	 */
	public Employee(String name, String surname, Double basicIncome) {
		this.setName(name);
		this.setSurname(surname);
		this.setBasicIncome(basicIncome);
	}

	/**
	 *  Calculo del sueldo neto del empleado. Se le descuenta el 15 porciento por aportes jubilatorios.
	 */
	public Double getFinalIncome(){
		return this.getBasicIncome()*0.85;
	}
	
	/**
	 * Incrementa el sueldo basico en el porcentaje indicado por parametro.
	 * 
	 * @param percentage Porcentaje a incrementar el sueldo basico.
	 */
	public void increaseIncome(Double percentage){
		this.setBasicIncome(this.getBasicIncome()*(1+(percentage/100)));
	}
	
	
	
	/** Getters y Setters */
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Double getBasicIncome() {
		return basicIncome;
	}

	public void setBasicIncome(Double basicIncome) {
		this.basicIncome = basicIncome;
	}	

}
