package aplicacion;

import java.util.*;

public class POODuck {
	
	private ArrayList<Pato> patos;
	private int rondas;
	private int tandas;
	private Jugador jugadorUno;
	private Timer tiempoTanda;
	private final char[] dificultad = {'N', 'V', 'D', 'b', 'B'};
	
	public POODuck() {
		patos = new ArrayList<Pato>();
		rondas = 0;
		tandas = 0;
		tiempoTanda = new Timer();
		
	}	
	
	/**
	 * inicia una ronda de juego.
	 * @param numPatos, numero de patos en cada tanda.
	 */
	public void inicieRonda(int numPatos) {
		rondas++;
		tandas = 0;
		TimerTask tarea = new TimerTask() {
			@Override
			public void run() {
				tandas++;
				if((numPatos == 2 && tandas > 5) || (numPatos == 3 && tandas > 3)) {
					tiempoTanda.cancel();
				}
				desaparecerPatos();
				inicieTanda(numPatos);
			}
			
		};
		tiempoTanda.schedule(tarea, 0, 15000);		
	}
	
	/**
	 * Le indica a todos los patos desparecer del tablero.
	 */
	private void desaparecerPatos() {
		for(Pato p: patos) {
			p.vayase();
		}
	}
	
	/**
	 * inicia una nueva tanda.
	 * @param numPatos, numero de patos en cada tanda.
	 */
	private void inicieTanda(int numPatos) {
		//jugadorUno.recargue();
		crearPatos(numPatos);
	}
	
	/**
	 * Determina segun el numero de rondas que patos deberian aparecer.
	 * @param numPatos, numero de patos en cada tanda.
	 */
	private void crearPatos(int numPatos) {
		patos.clear();
		Random rnd = new Random();		
		char tipo = 'N';
		for(int i = 0; i < numPatos; i++) {
			int pos = rnd.nextInt();
			if(pos < 0) {
				pos = pos * -1;
			}
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
		System.out.println(patos.size());;
	}
	
	/**
	 * Indica el puntaje del jugador especificado.
	 * @param numJugador, indica el jugador del cual se quiere conocer el puntaje.
	 * @return El puntaje del jugador.
	 */
	public int getPuntaje(int numJugador) {
		return jugadorUno.getPuntaje();
	}
	
	/**
	 * Indica el numero de balas que tiene el jugador especificado.
	 * @param numJugador; jugador del cual se quiere conocer las balas.
	 * @return Las balas y su tipo.
	 */
	public int[] getBalas(int numJugador) {
		return jugadorUno.getBalas();
	}
	
	/**
	 * Indica la ronda que se esta jugando actualmente.
	 * @return, la randoa actual.
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
	
	public int getDireccion(int numPato) {
		return patos.get(numPato).getDireccion();
	}
	
	public int[] getPosicion(int numPato) {
		return patos.get(numPato).getCuerpo();
	}
}
