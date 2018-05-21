package aplicacion;

import java.util.*;

public class Cazador extends Jugador{
	
	private int numBala;
	private Bala[] balas;
	private ArrayList<Pato> patos;
	
	public Cazador(ArrayList<Pato> pts) {
		recargar(pts);
		puntaje = 0;
	}

	public void recargar(ArrayList<Pato> patos) {
		this.patos = patos;
		numBala = 2;
		balas = new Bala[3];
		balas[0] = new Bala(patos);
		balas[1] = new Bala(patos);
		balas[2] = new Bala(patos);		
	}

	public Bala[] getBalas() {
		return balas;
	}
	
	private int buscarBala() {
		int num = 0;
		while(balas[num].getTipo() == 0) {
			num++;
		}
		return num;
	}

	public boolean disparar(int px, int py) {
		boolean impacto = false;
		if(numBala > -1) {
			int posBala = buscarBala();
			balas[posBala].disparar(px,py);
			int p = balas[posBala].getPuntaje();
			if(p > 0) {
				puntaje += p;
				impacto = true;
			}
			numBala--;
		}
		return impacto;
	}

	public void adicioneBala() {
		for(int i = 0; i < 3; i++) {
			if(balas[i].getTipo() == 0) {
				Random md = new Random();
				int num = Math.abs(md.nextInt())%10;
				if(num == 1) {
					balas[i] = new Bala(patos);
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

}
