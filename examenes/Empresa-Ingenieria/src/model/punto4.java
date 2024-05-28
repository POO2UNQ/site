package model;

import java.util.ArrayList;
import java.util.List;

public class punto4 {
	
	
	public void ejecutar() {
		Proyecto proyecto = new Proyecto(new ArrayList<Actividad>());
		Proyecto otroProyecto = new Proyecto(new ArrayList<Actividad>());
		
		List<Operario> operarios = new ArrayList<Operario>();
		List<Material> materiales = new ArrayList<Material>();
		
		Operario operario = new Operario(50, 5.0, 10);
		Material ladrillo = new Material(400, 4.0);
		
		operarios.add(operario);
		materiales.add(ladrillo);
		
		Obra obra = new Obra(operarios, materiales);
		
		proyecto.agregarActividad(obra);
		proyecto.agregarActividad(otroProyecto);
		FormaDePago formaDePago = new FormaDePagoMercadoPago();
		Empresa empresa = new Empresa("Apsis Ingeniria SA", "30-123456-0", proyecto, formaDePago);
	}

}
