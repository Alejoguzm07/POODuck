package presentacion;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.event.*;

import java.lang.*;

public class ControladorAnimacion extends Component{
	
	private ArrayList<PatoGUI> patos;
	private JPanel panel;
	private ArrayList<BalaGUI> balas;
	private int h;
	private int w;
	private int posX;
	private int posY;
	private Integer ronda;
	private ArrayList<Integer> puntajes;
	private boolean tandaFinalizada;
	
	/**
	 * Componente que pinta todos los elementos en el tablero de juego.
	 * @param pan, tablero de juego.
	 * @param tx, ancho del tablero de juego.
	 * @param ty, alto del tablero de juego.
	 * @param px, posicion en x del tablero de juego.
	 * @param py, posicion en y del tablero de juego.
	 */
	public ControladorAnimacion(JPanel pan, int tx, int ty, int px, int py) {
		patos = new ArrayList<PatoGUI>();
		panel = pan;
		balas = new ArrayList<BalaGUI>();
		puntajes = new ArrayList<Integer>();
		h = ty;
		w = tx;
		posX = px;
		posY = py;
		ronda = 0;
		tandaFinalizada = false;
	}
	
	/**
	 * Adiciona los patosGUI que recibde de POODuckGUI a un arraylist.
	 * @param patosGUI, arreglo de patos a ser pintados.
	 */
	public void adicionarPatos(ArrayList<PatoGUI> patosGUI) {
		patos = patosGUI;
	}
	
	/**
	 * Adiciona las balasGUI que recibe de POODuckGUI a un arrayList.
	 * @param balasGUI, arreglo de balas a ser pintadas.
	 */
	public void adicionarBalas(ArrayList<BalaGUI> balasGUI) {
		balas = balasGUI;
	}
	
	/**
	 * Actualiza los puntajes de los jugadores.
	 * @param pun, arreglo de puntajes.
	 */
	public void ajustarPuntajes(ArrayList<Integer> pun) {
		puntajes = pun;
	}
	
	/**
	 * Actualiza la ronda de juego.
	 * @param ron, numero de la ronda actual.
	 */
	public void ronda(int ron) {
		ronda = ron;
	}
	
	/**
	 * Indica que finalizo una tanda.
	 */
	public void finalizarTanda() {
		tandaFinalizada = true;
	}
	
	/**
	 * Indica que inicio una tanda.
	 */
	public void iniciarTanda() {
		tandaFinalizada = false;
	}
	
	/**
	 * Empieza la ejecucion del hilo.
	 */
	public void empezarHilo() {
		hiloVolar.start();
	}
	
	/**
	 * El hilo de ejecucion que controla todos los patos en pantalla.
	 */
	public Thread hiloVolar = new Thread(){
		@Override
		/**
		 * Genera las animaciones de los patos segun su estado actual.
		 */
		public void run() {
			try {
				while(true) {
					for(int i = 0; i < patos.size(); i++) {
						if(!tandaFinalizada || (patos.get(i).estaImpactado() || !patos.get(i).estaVivo())) {
							if(patos.get(i).estaVivo() && !(patos.get(i).estaImpactado())) {
								patos.get(i).cambiarImagen();
								patos.get(i).controlarMovimiento();
								patos.get(i).moverFila();
								patos.get(i).moverCol();
							}
							if(patos.get(i).estaImpactado()) {
								patos.get(i).disminuirTiempoI();
							}
							if(!patos.get(i).estaVivo() && !patos.get(i).enSuelo()) {
								patos.get(i).cambiarImagen();
								patos.get(i).definirMuriendo();
							}
							if(!patos.get(i).estaVivo() && patos.get(i).enSuelo()) {
								patos.get(i).desaparecer();
							}
						}
						else {
							if(patos.get(i).estaVivo()) {
								patos.get(i).irse();
								patos.get(i).moverFila();
								patos.get(i).cambiarImagen();
							}
						}
					}
					hiloVolar.sleep(100);
					repaint();
				}
			}catch (InterruptedException ex) {
				System.out.println(ex.getMessage());
			}
		}
	};
	
	/**
	 * Hace visible los elementos en el tablero.
	 */
	public void paint(Graphics g) {
		for(int i = 0; i < patos.size(); i++) {
			PatoGUI p = patos.get(i);
			ImageIcon imagenPatos = new ImageIcon(new ImageIcon(getClass().getResource(p.getRuta()+p.getNumImagen()+".png")).getImage());
			g.drawImage(imagenPatos.getImage(), p.getCol(), p.getFila(), p.getTamano(), p.getTamano(), null);
		}
		for(int i = 0; i < balas.size(); i++) {
			BalaGUI b = balas.get(i);
			ImageIcon imagenBalas = new ImageIcon(new ImageIcon(getClass().getResource(b.getRuta())).getImage());
			g.drawImage(imagenBalas.getImage(), (posX+w/48)+((i+1)* w*3/100), posY+((h/500)*830), w*3/100, h*6/100, null);
		}
		g.setColor(Color.WHITE);
		g.setFont(new Font("Gill Sans Ultra Bold",0, h / 30));
		g.drawString("R = "+ ronda.toString(), (posX+w/15), posY+((h/500)*785));
		g.setFont(new Font("Gill Sans Ultra Bold",0, h / 15));
		for(int i = 0; i < puntajes.size(); i++) {
			g.drawString(puntajes.get(i).toString(), (posX+(w/10)*7), posY+((h/500)*880));
		}
		
	}
}