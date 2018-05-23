package aplicacion;

import java.util.Random;

public class Pato implements Impactable{
	protected int vida;
	protected int puntaje;
	protected boolean vivo;
	protected int cuerpoX;
	protected int cuerpoY;
	protected int cabezaX;
	protected int cabezaY;
	protected int velocidad;
	protected int tamano;
	
	/**
	 * crea un objeto de tipo pato
	 */
	public Pato() {
		vida = 1;
		puntaje = 100;
		vivo = true;
		velocidad = 10;
		tamano = 55;
	}
	
	/**
	 * indica el tipo de pato
	 * @return un entero indicando el tipo de pato
	 */
	public int getTipo() {
		return 1;
	}
	
	/**
	 * deviuelve la velocidad del pato
	 * @return un entero indicando la velocidad del pato
	 */
	public int getVelocidad() {
		return velocidad;
	}
	
	/**
	 * indica la posicion en la que esta ubicado el cuerpo del pato
	 * @return un arreglo con las coordenadas X y Y del cuerpo del pato
	 */
	public int[] getCuerpo() {
		int[] cpo = new int[2];
		cpo[0] = cuerpoX;
		cpo[1] = cuerpoY;
		return cpo;
	}
	
	/**
	 * indica la posicion en la que esta ubicada la cabeza del pato
	 * @return un arreglo con las coordenadas X y Y de la cabeza del pato
	 */
	public int[] getCabeza() {
		int[] cbz = new int[2];
		cbz[0] = cabezaX;
		cbz[1] = cabezaY;
		return cbz;
	}
	
	/**
	 * indica si el pato esta vivo
	 * @return devuelve un booleano indicando si el pato esta vivo
	 */
	public boolean isAlive() {
		return vivo;
	}
	
	/**
	 * ubica al pato segun sus posiciones en pantalla
	 * @param posiciones, un arreglo con las posiciones del pato en pantalla y la direccion en la que vuela
	 */
	public void ubicar(int[] posiciones) {
		cuerpoX = posiciones[0] + (tamano/2);
		cuerpoY = posiciones[1] + (tamano/2);
		int moverX = posiciones[2];
		int moverY = posiciones[3];
		if(moverX >= 0 && moverY < 0) {
			cabezaX = (posiciones[0] + tamano) - (4*(tamano/10));
			cabezaY = posiciones[1] + (4*(tamano/10));
		}
		if(moverX >= 0 && moverY >= 0) {
			cabezaX = (posiciones[0] + tamano) - (4*(tamano/10));
			cabezaY = posiciones[1] + (tamano/2);
		}
		if(moverX < 0 && moverY < 0) {
			cabezaX = posiciones[0] + (3*(tamano/10));
			cabezaY = posiciones[1] + (4*(tamano/10));
		}
		if(moverX < 0 && moverY >= 0) {
			cabezaX = posiciones[0] + (tamano/6);
			cabezaY = posiciones[1] + (tamano/2);
		}
		
	}
	
	/**
	 * determina si el pato fue impactado.
	 * @param x, posicion x de un disparo.
	 * @param y, posicion y de un disparo.
	 * @param ef, efecto de bala disparada.
	 * @return, devuelve el puntaje obtenido en el disparo.
	 */
	public int impacto(int x, int y, char ef) {
		int pun = 0;
		if(vivo) {
			int radio = tamano / 2;
			if(ef == 'r') {
				radio = 5 * 55;
			}
			int distCabeza = (int) Math.hypot(cabezaX - x, cabezaY - y);
			int distCuerpo = (int) Math.hypot(cuerpoX - x, cuerpoY - y);
			if(distCabeza <= radio / 2 || distCuerpo <= radio) {
				vida--;
				if(muerto()) {
					pun = puntaje;
				}
			}
		}
		return pun;		
	}
	
	/**
	 * revisa el estado de la vida de un pato
	 * @return devuelve un booleano que indica si el pat esta muerto
	 */
	protected boolean muerto() {
		if(vida == 0) {
			vivo = false;
			return true;
		}
		return false;
	}
	
	/**
	 * indica el tamano del pato
	 * @return un entero indicando el tamano del pato
	 */
	public int getTamano() {
		return tamano;
	}
}
