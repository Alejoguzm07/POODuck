package aplicacion;

import java.util.*;

public class Cazador extends Jugador{
	
	private int numBala;
	private Bala[] balas;
	private ArrayList<Pato> patos;
	
	/**
	 * crea un jugador de tipo cazador.
	 * @param pts, arreglo con los patos del tablero.
	 */
	public Cazador(ArrayList<Pato> pts) {
		recargar(pts);
		puntaje = 0;
	}
	
	/**
	 * Recarga las balas del cazador.
	 * @param patos, un arreglo con los patos a ser impactados.
	 */
	public void recargar(ArrayList<Pato> patos) {
		this.patos = patos;
		numBala = 2;
		balas = new Bala[3];
		balas[0] = new Bala(patos);
		balas[1] = new Bala(patos);
		balas[2] = new Bala(patos);		
	}
	
	/**
	 * devuelve las balas del cazador.
	 * @return, un arreglo de balas.
	 */
	public Bala[] getBalas() {
		return balas;
	}
	
	/**
	 * busca la primera bala que se pueda disparar
	 * @return num, entero con el numero de bala disparada
	 */
	private int buscarBala() {
		int num = 0;
		while(balas[num].getTipo() == 0) {
			num++;
		}
		return num;
	}
	
	/**
	 * realiza un disparo con la primera bala disponible.
	 * @param px, coordenada x del disparo.
	 * @param py, coordenada y del disparo.
	 * @return un booleano que indica si hubo un impacto.
	 */
	public boolean disparar(int px, int py) {
		boolean impacto = false;
		if(numBala > -1) {
			int posBala = buscarBala();
			balas[posBala].disparar(px,py);
			int p = balas[posBala].getPuntaje();
			if(p > 0) {
				if(balas[posBala].getEfecto() == 'R') {
					incluyaBala('r', 3);
				}
				puntaje += p;
				impacto = true;
			}
			else {
				if(balas[posBala].getEfecto() == 'S') {
					incluyaBala('N', 1);
				}
			}
			numBala--;
		}
		return impacto;
	}
	
	/**
	 * adiciona una bala especial cuando se derrota un pato.
	 */
	public void adicioneBala() {
		for(int i = 0; i < 3; i++) {
			if(balas[i].getTipo() == 0) {
				Random md = new Random();
				int num = Math.abs(md.nextInt())%10;
				if(num == 1) {
					numBala++;
				}
				if(num == 2) {
					balas[i] = new Ricochet(patos);
					numBala++;
				}
				if(num == 3) {
					balas[i] = new Salvavidas(patos);
					numBala++;
				}
				if(num == 4) {
					balas[i] = new DoblePuntaje(patos);
					numBala++;
				}
			}
		}
	}
	
	public void incluyaBala(char fx, int num) {
		for(int i = 0; i < num; i++) {
			Bala b = new Bala(patos);
			b.agregarEfecto(fx);
			balas[i] = b;
		}
	}

}
