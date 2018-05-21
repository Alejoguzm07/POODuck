package aplicacion;

import java.util.ArrayList;

public class DoblePuntaje extends Bala{
	
	/**
	 * Crea una bala de tipo DoblePuntaje.
	 * @param pts, recibe un areglo de patos a ser impactados.
	 */
	public DoblePuntaje(ArrayList<Pato> pts) {
		super(pts);
		tipo = 4;
	}

	/**
	 * Devuelve el doble del puntaje obtenido con el disparo.
	 * @return, un entero con el puntaje ganado en el disparo.
	 */
	public int getPuntaje() {
		int pun = puntajeObtenido;
		puntajeObtenido = 0;
		return pun * 2;
	}
	
}
