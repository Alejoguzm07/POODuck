package aplicacion;

import java.util.ArrayList;

public class Salvavidas extends Bala{
	
	/**
	 * Crea una bala de tipo salvavidas.
	 * @param pts, arreglo con los patos que pueden ser impactados.
	 */
	public Salvavidas(ArrayList<Pato> pts) {
		super(pts);
		tipo = 3;
		efecto = 'S';
	}
	
	/**
	 * Devuelve el puntaje obtenido por una bala en un disparo.
	 */
	public int getPuntaje() {
		return puntajeObtenido;
	}
}
