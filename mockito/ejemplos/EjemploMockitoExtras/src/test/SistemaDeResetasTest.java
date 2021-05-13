package test;
/*
 *	#########  		Programación con objetos 2			#########
 *	#########		Universidad Nacional de Quilmes		#########
 * 	
 * 			Mockito
 *			Material de ejemplo simple sobre Tests Doubles.
 *			La idea es mostrar ejemplos de codigo simple y 
 *			de varios casos utilizando el framework Mockito.
 * 
 * 	#########				IMPORTANTE					#########			
 * 			Dependencias: 
 * 					- JUNIT4.
 * 					- MOCKITO 2.0.2
 * 
 *			El proyecto no cuenta con dependencias porque durante
 *			la materia no se explica el tema, ni se explica en
 *			materias anteriores.  
 * 			Se correjiran las dependencias cuando sea necesario
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import model.ExportadorPDF;
import model.Receta;
import model.SistemaDeRecetas;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SistemaDeResetasTest {

	SistemaDeRecetas sistemaRecetas;
	Receta recetaAptaCeliaco;
	Receta receta;
	Receta dummyReceta;

	
	@Before
	public void setUp() throws Exception {
		
		// Los Dummy se instancian igual que los mocks y mientras no se les defina un comportamiento seguiran siendo dummy.
		dummyReceta = mock(Receta.class);
		recetaAptaCeliaco = mock(Receta.class);
		receta = mock(Receta.class);
		
		sistemaRecetas = new SistemaDeRecetas();
	
	}

	@Test
	public void testCantidadDeRecetasPublicadas() {
		
		List<Receta> spyListaDeRecetas = spy(new ArrayList<Receta>());	
		SistemaDeRecetas sistemaR = new SistemaDeRecetas(spyListaDeRecetas);
				
		sistemaR.publicar(dummyReceta);
		sistemaR.publicar(recetaAptaCeliaco);
		
		// Con el spy verifico que el se le mando correctamente el mensaje add a la collecion dentro del mensaje publicar.
		assertEquals(sistemaR.cantidadDeRecetasPublicadas(), 2, 0);
		
		// Ademas se verifica que el envio de mensajes se haga en orden esperado.	 
		InOrder orden = inOrder(spyListaDeRecetas);			
		orden.verify(spyListaDeRecetas).add(dummyReceta);
		orden.verify(spyListaDeRecetas).add(recetaAptaCeliaco);
				
		// Verifico con el spy que se le mando el mensaje size a la colleccion para obtener la cantidad de recetas publicadas.
		verify(spyListaDeRecetas).size();
		
	}
	
	@Test
	public void testRecetaMasEconomica() {
		
		sistemaRecetas.publicar(recetaAptaCeliaco);
		sistemaRecetas.publicar(receta);
		
		when(recetaAptaCeliaco.costoTotal()).thenReturn(30);
		when(receta.costoTotal()).thenReturn(15);
		
		assertEquals(sistemaRecetas.recetaMasEconomica(), receta);
		
		// verifico que al menos una vez le preguntaron el costo total a las recetas
		verify(receta, atLeast(1)).costoTotal();	
		verify(recetaAptaCeliaco, atLeast(1)).costoTotal();	
	}
	
	@Test
	public void testRecetasAptasParaCeliacos() {
		
		sistemaRecetas.publicar(recetaAptaCeliaco);
		sistemaRecetas.publicar(receta);
		
		when(recetaAptaCeliaco.esAptoCeliaco()).thenReturn(true);
		when(receta.esAptoCeliaco()).thenReturn(false);
		
		assertEquals(sistemaRecetas.recetasAptoCeliacos().size(), 1);
	}
	
	@Test
	public void testRecetaMasEconomicaAptaParaCeliacos() {
		
		sistemaRecetas.publicar(recetaAptaCeliaco);
		sistemaRecetas.publicar(receta);
		
		when(recetaAptaCeliaco.esAptoCeliaco()).thenReturn(true);
		when(receta.esAptoCeliaco()).thenReturn(false);
		
		when(recetaAptaCeliaco.costoTotal()).thenReturn(30);
		when(receta.costoTotal()).thenReturn(15);
		
		assertEquals(sistemaRecetas.recetaAptoCeliacoMasEconomica(), recetaAptaCeliaco);
		
		/*  Verifico que a la receta que no es apta para celiaco nunca le pida el costo total
		 *	Porque no es necesario saberlo
		 */
		verify(receta, never()).costoTotal();
	}
	
	@Test
	public void testRecetaDelDia() {
		
		Random random = mock(Random.class);
		
		when(random.nextInt(anyInt())).thenReturn(1);
		sistemaRecetas.publicar(recetaAptaCeliaco);
		sistemaRecetas.publicar(receta);

		assertEquals(sistemaRecetas.recetaDelDia(random), receta);
		
		// Verifico que no hay interaccion con las recetas al momento de decidir cual es la receta del dia.
		verifyZeroInteractions(recetaAptaCeliaco);
		verifyZeroInteractions(receta);
	}
	
	@Test
	public void testExportarResumen() {

		ExportadorPDF exportador = mock(ExportadorPDF.class);

		sistemaRecetas.publicar(recetaAptaCeliaco);
		sistemaRecetas.publicar(receta);

		sistemaRecetas.exportarMenuUsando(exportador);
		
		/* Como la exportacion no devulve nada, para verificar que se mandaron los mensajes correctos 
		 * agregando la verificacion de que al exportador se le mandan el mensaje exportar con cualquier receta
		 */
		verify(exportador).exportar(any(Receta.class));
	}
	
	

}
