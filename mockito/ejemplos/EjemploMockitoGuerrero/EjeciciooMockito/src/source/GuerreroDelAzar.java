package src.source;

public class GuerreroDelAzar implements IGuerrero{
	
	private Integer puntosDeVida;
	private Integer puntosDeAtaque;
	private IMoneda miMoneda;
	
	public GuerreroDelAzar(Integer unosPuntosDeVida, Integer unosPuntosDeAtaque, IMoneda unaMoneda) {
		puntosDeVida = unosPuntosDeVida;
		puntosDeAtaque = unosPuntosDeAtaque;
		miMoneda = unaMoneda;
	}

	@Override
	public void atacar(IGuerrero unGuerrero) {		
		if(miMoneda.esCara()){
			unGuerrero.descontarVida(this.puntosDeAtaque);
		}else{
			this.descontarVida(this.puntosDeAtaque);
		}
	}

	@Override
	public void descontarVida(Integer unosPuntosDeAtaque) {
		puntosDeVida =- unosPuntosDeAtaque; 
	}

}
