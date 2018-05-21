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
	
	public Pato() {
		vida = 1;
		puntaje = 100;
		vivo = true;
		velocidad = 10;
		tamano = 55;
	}
	
	public int getTipo() {
		return 1;
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	
	public int[] getCuerpo() {
		int[] cpo = new int[2];
		cpo[0] = cuerpoX;
		cpo[1] = cuerpoY;
		return cpo;
	}
	
	public int[] getCabeza() {
		int[] cbz = new int[2];
		cbz[0] = cabezaX;
		cbz[1] = cabezaY;
		return cbz;
	}
	
	public boolean isAlive() {
		return vivo;
	}
	
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

	public int impacto(int x, int y, int tipo) {
		int pun = 0;
		if(vivo) {
			int radio = tamano / 2;
			if(tipo == 2) {
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

	protected boolean muerto() {
		if(vida == 0) {
			vivo = false;
			return true;
		}
		return false;
	}
	
	public int getTamano() {
		return tamano;
	}
}
