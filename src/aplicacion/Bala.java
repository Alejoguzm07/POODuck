package aplicacion;

import java.util.*;

public class Bala {
	
	protected int tipo;
	protected int puntajeObtenido;
	protected ArrayList<Pato>patos;
	protected char efecto;
	
	/**
	 * Crea una bala de tipo Normal.
	 * @param pts, recibe el arreglo de patos que pueden ser impactados.
	 */
	public Bala(ArrayList<Pato> pts) {
		tipo = 1;
		patos = pts;
		puntajeObtenido = 0;
		efecto = 'N';
	}
	
	/**
	 * Indica el tipo de bala.
	 * @return, entero que indica el tipo de bala.
	 */
	public int getTipo() {
		return tipo;
	}
	
	/**
	 * Ejecuta un disparo en las coordenadas indicadas.
	 * @param px, posicion x del disparo.
	 * @param py, posicion y del disparo.
	 */
	public void disparar(int px, int py) {
		if(tipo != 0) {
			for(int i = 0; i < patos.size(); i++) {
				puntajeObtenido += patos.get(i).impacto(px, py,efecto);
			}
			tipo = 0;
		}
	}
	
	/**
	 * Devuelve el puntaje obtenido tras realizar un disparo.
	 * @return, Entero con el puntaje obtenido.
	 */
	public int getPuntaje() {
		int pun = puntajeObtenido;
		puntajeObtenido = 0;
		return pun;
	}
	
	/**
	 * le otorga habilidades a una bala
	 * @param fx, caracter que identifica un efecto
	 */
	public void agregarEfecto(char fx) {
		efecto = fx;
	}

	/**
	 * indica la habilidad de la bala
	 * @return un caracer que representa la habilidad de la bala
	 */
	public char getEfecto() {
		return efecto;
	}
}
