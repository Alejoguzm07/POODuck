package aplicacion;

import java.util.ArrayList;

public class Pajaro extends Jugador implements Impactable{
	
	private int vida;
	private int cuerpoX;
	private int cuerpoY;
	private int tamano;
	private int cabezaX;
	private int cabezaY;
	private boolean vivo;
	
	public Pajaro() {
		vida = 5;
		tamano = 120;
		vivo = true;
	}
	
	public Bala[] getBalas() {
		return null;
	}

	public boolean disparar(int px, int py) {
		return false;
	}

	public void recargar(ArrayList<Pato> patos) {	
	}

	public void adicioneBala() {
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
	 * @param tipo, tipo de bala disparada.
	 * @return, devuelve el puntaje obtenido en el disparo.
	 */
	public int impacto(int x, int y, char ef) {
		int pun = 0;
		if(vivo) {
			int radio = tamano / 2;
			if(ef == 'r') {
				radio = 5 * 100;
			}
			int distCabeza = (int) Math.hypot(cabezaX - x, cabezaY - y);
			int distCuerpo = (int) Math.hypot(cuerpoX - x, cuerpoY - y);
			if(distCabeza <= radio / 2 || distCuerpo <= radio) {
				vida--;
				if(muerto()) {
					pun = puntaje;
				}
			}
			System.out.println(pun);
		}
		return pun;		
	}

	/**
	 * revisa el estado de la vida de un pato
	 * @return devuelve un booleano que indica si el pato esta muerto
	 */
	protected boolean muerto() {
		if(vida == 0) {
			vivo = false;
			return true;
		}
		return false;
	}
	
	public boolean isAlive() {
		return vivo;
	}

	@Override
	public boolean dispararAve(Pajaro jugador, int posDisparoX, int posDisparoY) {
		return false;
	}
}
