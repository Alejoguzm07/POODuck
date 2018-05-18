package aplicacion;

public abstract class Jugador {
	
	private int balas;
	
	
	
	/**
 	* El numero de balas vuelve a ser el maximo.
 	*/
	public void recargue() {
		balas = 3;
	}
	
	
	/**
	 * Retorna la puntuacion que lleva el jugador.
	 * @return puntaje, puntaje del jugador.
	 */
	public int getPuntaje() {
		return 0;
	}


	public int[] getBalas() {
		return null;
	}
	
	
}