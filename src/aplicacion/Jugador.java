package aplicacion;

import java.util.ArrayList;

public abstract class Jugador {
	
	public int puntaje;
	
	/**
	 * Retorna la puntuacion que lleva el jugador.
	 * @return puntaje, puntaje del jugador.
	 */
	public int getPuntaje() {
		return puntaje;
	}

	/**
	 * Devuelve las balas del jugador.
	 * @return, arreglo con las tres balas del jugador.
	 */
	public abstract Bala[] getBalas();
	
	/**
	 * Realiza un disparo en las posiciones indicadas.
	 * @param px, posicion x del disparo.
	 * @param py, posicion y del disparo.
	 * @return, retorna un booleano indicando si hubo un impacto a un pato.
	 */
	public abstract boolean disparar(int px, int py);

	/**
	 * Recarga las balas de un jugador.
	 * @param patos, un arreglo con los patos a ser impactados
	 */
	public abstract void recargar(ArrayList<Pato> patos);

	/**
	 * adiciona una bala especial cuando se derrota un pato.
	 */
	public abstract void adicioneBala();
}