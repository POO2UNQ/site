package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SistemaDeRecetas {

	private List<Receta> recetasPublicadas;

	public SistemaDeRecetas(){
		recetasPublicadas = new ArrayList<Receta>();

	}
	
	public SistemaDeRecetas(List<Receta> recetas){
		recetasPublicadas = recetas;

	}
		
	public void publicar(Receta receta){
		recetasPublicadas.add(receta);
		
	}
	
	public Integer cantidadDeRecetasPublicadas(){
		return recetasPublicadas.size();
	}

	public Receta recetaMasEconomica() {
		return buscarRecetaMasEconomica(this.recetasPublicadas);
	}
	
	public List<Receta> recetasAptoCeliacos(){
		List<Receta> recetasAptas = new ArrayList<Receta>();
		for(Receta receta : this.recetasPublicadas){
			if(receta.esAptoCeliaco()){
				recetasAptas.add(receta);
			}
		}
		
		return recetasAptas;
	}

	public Receta recetaAptoCeliacoMasEconomica(){
		return this.buscarRecetaMasEconomica(this.recetasAptoCeliacos());
	}
	
	
	private Receta buscarRecetaMasEconomica(List<Receta> recetas) {
		Receta recetaMasEconomica = recetas.get(0);
		for (Receta receta : recetas) {
			if(recetaMasEconomica.costoTotal() > receta.costoTotal()){
				recetaMasEconomica = receta;
			}
		}
		return recetaMasEconomica;
	}

	public Receta recetaDelDia(Random random) {
		
		return this.recetasPublicadas.get(random.nextInt(this.recetasPublicadas.size()));
	}

	public void exportarMenuUsando(ExportadorPDF exportador) {
		// El menu se exporta informando la receta mas economica.
		exportador.exportar(this.buscarRecetaMasEconomica(this.recetasPublicadas));
		
	}

}
