package model;

import java.util.List;

public class Receta {

	private List<Ingrediente> ingredientes;

	public Receta(List<Ingrediente> listaDeIngredientes){ 
		/* Se agrega este constructor para mostrar que los objetos mockeados no 
		 * necesitan los parametros del constructor. */
		ingredientes = listaDeIngredientes;
	}
	public Integer costoTotal() {
		/* Devuelve el costo total de una receta.
		 * Deberia ser el costo de cada uno de los ingredientes.
		 */
		return 0;
	}
	public boolean esAptoCeliaco() {
		//Se deberia fijar si todos los ingreditens son apto para celiacos.

		return false;
	}

}
