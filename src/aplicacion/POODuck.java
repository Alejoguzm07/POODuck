package aplicacion;

import java.util.*;

public class POODuck {
	
	private ArrayList<Pato> patos;
	private int rondas;
	private int tandas;
	private ArrayList<Jugador> jugadores;
	private Timer tiempoTanda;
	private int numBala;
	private final char[] dificultad = {'N', 'V', 'D', 'b', 'B'};
	private char modo;
	private int patosMuertos;
	private boolean finalizado;
	
	public POODuck() {
		patos = new ArrayList<Pato>();
		rondas = 1;
		tandas = 0;
		patosMuertos = 0;
		finalizado = false;
		tiempoTanda = new Timer();		
	}
	
	public void iniciarJuego(char md) {
		modo = md;
		jugadores = new ArrayList<Jugador>();
		if(modo == 'C') {
			jugadores.add(new Cazador(patos));
		}
		if(modo == 'V') {
			jugadores.add(new Cazador(patos));
			jugadores.add(new Pajaro());
		}
		if(modo == 'c') {
			jugadores.add(new Cazador(patos));
			jugadores.add(new Cazador(patos));
		}	
	}
	
	/**
	 * inicia una ronda de juego.
	 * @param numPatos, numero de patos en cada tanda.
	 */
	public void inicieRonda(int numPatos) {
		if(gano() && finalizado) {
			rondas++;
			tandas = 0;
			patosMuertos = 0;
			finalizado = false;
		}
		if(gano()) {
			inicieTanda(numPatos);
		}
	}
	
	public boolean getFinalizado() {
		return finalizado;
	}
	
	public boolean gano() {
		boolean flag = true;
		if(finalizado) {
			if((rondas > 0 && rondas <= 8) && (patosMuertos < 4)) {
				flag = false;
			}
			if((rondas > 8 && rondas <= 15) && (patosMuertos < 8)) {
				flag = false;
			}
			if(rondas > 15  && (patosMuertos < 9)) {
				flag = false;
			}
		}
		return flag;
	}
	
	/**
	 * inicia una nueva tanda.
	 * @param numPatos, numero de patos en cada tanda.
	 */
	private void inicieTanda(int numPatos) {
		tandas++;
		crearPatos(numPatos);
		for(int i = 0; i < jugadores.size(); i++) {
			jugadores.get(i).recargar(patos);
		}
		if(numPatos == 2) {
			if(tandas == 5) {
				finalizado = true;
			}
		}
		else {
			if(tandas == 3) {
				finalizado = true;
			}
		}
	}
	
	/**
	 * Determina segun el numero de rondas que patos deberian aparecer.
	 * @param numPatos, numero de patos en cada tanda.
	 */
	private void crearPatos(int numPatos) {
		patos = new ArrayList<Pato>();
		Random rnd = new Random();		
		char tipo = 'N';
		int pos;
		for(int i = 0; i < numPatos; i++) {
			pos = Math.abs(rnd.nextInt());
			if(rondas > 1 && rondas < 5) {
				tipo = dificultad[pos%2];
			}
			if(rondas >= 5 && rondas < 7) {
				tipo = dificultad[pos%3];
			}
			if(rondas >= 7 && rondas < 10) {
				tipo = dificultad[pos%4];
			}
			if(rondas >= 10) {
				tipo = dificultad[pos%5];
			}
			adicionarPato(tipo);
		}
	}
	
	/**
	 * Adiciona el pato segun el tipo indicado.
	 * @param tipo, Indica que pato adicionar.
	 */
	private void adicionarPato(char tipo) {
		if(tipo == 'N') {
			patos.add(new Pato());
		}
		if(tipo == 'V') {
			patos.add(new PatoVeloz());
		}
		if(tipo == 'D') {
			patos.add(new PatoDoble());
		}
		if(tipo == 'b') {
			patos.add(new PatoBlindado());
		}
		if(tipo == 'B') {
			patos.add(new PatoBoss());
		}		
	}
	
	/**
	 * Indica el puntaje del jugador especificado.
	 * @param numJugador, indica el jugador del cual se quiere conocer el puntaje.
	 * @return El puntaje del jugador.
	 */
	public int getPuntaje(int numJugador) {
		return jugadores.get(numJugador).getPuntaje();
	}
	
	/**
	 * Indica el numero de balas que tiene el jugador especificado.
	 * @param numJugador; jugador del cual se quiere conocer las balas.
	 * @return Las balas y su tipo.
	 */
	public int[] getBalas(int jug) {
		int[] b = new int[3];
		Bala[] bl = jugadores.get(jug).getBalas();
		for(int i = 0; i < 3; i++) {
			b[i] = bl[i].getTipo();
		}
		return b;
	}
	
	/**
	 * Indica la ronda que se esta jugando actualmente.
	 * @return, la ronda actual.
	 */
	public int getRonda() {
		return rondas;
	}
	
	public boolean isAlive(int numPato) {
		return patos.get(numPato).isAlive();
	}
	
	public int getTipo(int numPato) {
		return patos.get(numPato).getTipo();
	}
	
	public int getVelocidad(int numPato) {
		return patos.get(numPato).getVelocidad();
	}
	
	public int[] getPosicion(int numPato) {
		return patos.get(numPato).getCuerpo();
	}

	public void impacto(int jug, int posDisparoX, int posDisparoY ) {
		boolean i = jugadores.get(jug).disparar(posDisparoX, posDisparoY);
		if(i) {
			patosMuertos++;
			jugadores.get(jug).adicioneBala();
		}
	}
	
	public boolean estaVivo(int pato) {
		return patos.get(pato).isAlive();		
	}
	
	public void ubicar(int pato, int col, int fila, int moverX, int moverY) {
		int[] posiciones = {col,fila,moverX,moverY};
		patos.get(pato).ubicar(posiciones);
	}

	public int getTamano(int i) {
		return patos.get(i).getTamano();
	}
}
