package presentacion;

import java.util.*;
import java.util.Timer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import aplicacion.POODuck;
import java.lang.*;
import javax.swing.event.*;

public class POODuckGUI extends JFrame{	
	
	private Container contentPane;
	private URL fondo = this.getClass().getResource("FondoOriginal.png");
	private Image imagenFondo = new ImageIcon(fondo).getImage();
	private MenuInicial menu;
	private Cursor mira;	
	private ImageIcon imagenMira = new ImageIcon(getClass().getResource("Mira.png"));
	private Toolkit Tk = Toolkit.getDefaultToolkit();
	private JPanel tablero;
	private MouseAdapter disparadorMouse;
	private ArrayList<PatoGUI> patosGUI;
	private ArrayList<BalaGUI> balasGUI;
	private PajaroGUI aveJugador;
	private POODuck juego;
	private int nump;
	private ControladorAnimacion hilo;
	private int posX;
	private int posY;
	private int tamX;
	private int tamY;
	private Timer partidas;
	private boolean modoPato = false;
	
	/**
	 * Instancia un objeto de tipo POODuckGUI.
	 */
	public POODuckGUI(){
		prepareElementos();
		prepareAcciones();	
	}	
	
	public static void main(String[] args) {
		POODuckGUI gui = new POODuckGUI();				
	}
	
	/**
	 * Inicia el menu de juego.
	 */
	private void prepareElementos(){
		contentPane = getContentPane();		
		setTitle("POODuck");
		setResizable(false);
		menu = new MenuInicial(this);		
	}
	
	/**
	 * Reinicia la cantidad de patos al empezar una ronda.
	 */
	private void preparePatosClasico() {
		patosGUI = new ArrayList<PatoGUI>();
		juego.inicieRonda(nump);
		for(int i = 0; i < nump; i++) {
			patosGUI.add(new PatoGUI(tablero, juego.getVelocidad(i), juego.getTipo(i), juego.getTamano(i), tamX, tamY, posX, posY));
		}
		hilo.adicionarPatos(patosGUI);
	}
	
	/**
	 * Reinicia las balas de un jugador especifico.
	 * @param jug, recibe el jugador al cual se le reinician las balas.
	 */
	private void prepareBalas(int jug) {
		balasGUI = new ArrayList<BalaGUI>();
		for(int i = 0; i < jug; i++) {
			int [] tipos = juego.getBalas(i);
			for(int j = 0; j < 3; j++) {
				balasGUI.add(new BalaGUI(tablero, tipos[j]));
				balasGUI.get(j).definirRuta();
			}
		}
		hilo.adicionarBalas(balasGUI);
	}
	
	/**
	 * Le indica a aplicacion que un jugador especifico realizo un disparo.
	 * @param posDisparoX, posicion x del disparo.
	 * @param posDisparoY, posicion y del disparo.
	 * @param jug, jugador que realizo el disparo.
	 */
	private void derrotePato(int posDisparoX, int posDisparoY, int jug) {
		if(modoPato) {
			juego.ubicarAve(aveJugador.getPosX(), aveJugador.getPosY(), aveJugador.getMoverCol(), aveJugador.getMoverfila());
			for(int i = 0; i < nump; i++) {
				juego.ubicar(i, patosGUI.get(i).getCol(), patosGUI.get(i).getFila(), patosGUI.get(i).getMoverCol(), patosGUI.get(i).getMoverFila());
			}
			juego.impactoConPato(jug,posDisparoX, posDisparoY);
			boolean bp = juego.estaVivoAve();
			if(!bp) {
				aveJugador.derribar();
			}	
			for(int i = 0; i < nump; i++) {
				boolean b = juego.estaVivo(i);
				if(!b) {
					patosGUI.get(i).derribar();
				}
			}
		}
		else {
			for(int i = 0; i < nump; i++) {
				juego.ubicar(i, patosGUI.get(i).getCol(), patosGUI.get(i).getFila(), patosGUI.get(i).getMoverCol(), patosGUI.get(i).getMoverFila());
			}
			juego.impacto(jug,posDisparoX, posDisparoY);
			for(int i = 0; i < nump; i++) {
				boolean b = juego.estaVivo(i);
				if(!b) {
					patosGUI.get(i).derribar();
				}
			}
		}
	}
	
	private void derroteAve(int posDisparoX, int posDisparoY, int jug) {
		
	}
	
	/**
	 * Inicia el juego en modo un jugador clasico.
	 * @param n, numero de patos por tanda.
	 */
	public void unJugador(int n){
		modoPato = false;
		this.mira = Tk.createCustomCursor(imagenMira.getImage(), new Point(1,1), "Mira.png");
		this.setCursor(mira);
		juego = new POODuck();
		nump = n;
		ajustarTamano();
		centrar();
		tablero = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(imagenFondo,getX(),getY(),this.getWidth(),this.getHeight(),this);
			}
		};
		GridLayout layoutTablero = new GridLayout(1,1);
        tablero.setLayout(layoutTablero);
        hilo = new ControladorAnimacion(tablero, tamX, tamY, posX, posY);
        juego.iniciarJuego('C');
		contentPane.add(tablero);
		tablero.add(hilo);
		hilo.empezarHilo();
		setVisible(true);
		ejecutarRondas();
	}
	
	public void multijugador(char modo){
		modoPato = true;
		this.mira = Tk.createCustomCursor(imagenMira.getImage(), new Point(1,1), "Mira.png");
		this.setCursor(mira);
		juego = new POODuck();
		nump = 3;
		ajustarTamano();
		centrar();
		tablero = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(imagenFondo,getX(),getY(),this.getWidth(),this.getHeight(),this);
			}
		};
		GridLayout layoutTablero = new GridLayout(1,1);
        tablero.setLayout(layoutTablero);
        hilo = new ControladorAnimacion(tablero, tamX, tamY, posX, posY);
        juego.iniciarJuego('V');
		contentPane.add(tablero);
		tablero.add(hilo);
		hilo.empezarHilo();
		aveJugador = new PajaroGUI();
		hilo.asignarJugadorAve(aveJugador);
		setVisible(true);
		ejecutarRondasAve();
	}
	
	private void ejecutarRondasAve() {
		partidas = new Timer();
		TimerTask finTanda = new TimerTask() {
			public void run() {
				hilo.finalizarTanda();
			}
		};
		TimerTask tarea = new TimerTask() {
			@Override
			public void run() {
				hilo.iniciarTanda();
				if(juego.getRonda() == 12 || aveJugador.estaImpactado()) {
					partidas.cancel();
					salgaInmediato();
				}
				preparePatosClasico();
				ajustarRonda();
				prepareBalas(1);
				ajustePuntaje(1);
			}
		};
		partidas.schedule(tarea, 0, 10000);
		partidas.schedule(finTanda, 7000, 10000);
	}

	/**
	 * Prepara las reacciones hacia las acciones en pantalla de los jugadores.
	 */
	private void prepareAcciones(){
		WindowAdapter oyenteCerrarVentana = new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				salga();
			}
		};		
		addWindowListener(oyenteCerrarVentana);
		
		disparadorMouse = new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				derrotePato(arg0.getX(),arg0.getY(),0);
				prepareBalas(1);
				ajustePuntaje(1);
				derroteAve(arg0.getX(),arg0.getY(),0);
			}
		};
		addMouseListener(disparadorMouse);
		
		KeyAdapter oyenteTeclado = new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				controlarTeclado(ke);
			}
			public void keyReleased(KeyEvent ke) {
				dejarDeOprimirTeclado(ke);
			}
		};
		addKeyListener(oyenteTeclado);
	}
	
	private void controlarTeclado(KeyEvent e) {
		if(modoPato) {
			int boton = e.getKeyCode();
			if(boton == 37) {
				aveJugador.asignarIzquierda();
			}
			if(boton == 38) {
				aveJugador.asignarArriba();
			}
			if(boton == 39) {
				aveJugador.asignarDerecha();
			}
			if(boton == 40) {
				aveJugador.asignarAbajo();
			}
		}
	}
	
	private void dejarDeOprimirTeclado(KeyEvent e) {
		if(modoPato) {
			int boton = e.getKeyCode();
			if(boton == 37) {
				aveJugador.desAsignarIzquierda();
			}
			if(boton == 38) {
				aveJugador.desAsignarArriba();
			}
			if(boton == 39) {
				aveJugador.desAsignarDerecha();
			}
			if(boton == 40) {
				aveJugador.desAsignarAbajo();
			}
		}
	}
	
	
	/**
	 * Actualiza los puntajes de los jugadores.
	 * @param jug, numero de jugadores.
	 */
	private void ajustePuntaje(int jug) {
		ArrayList<Integer> puntajes = new ArrayList<Integer>();
		for(int i = 0; i < jug; i++) {
			puntajes.add(juego.getPuntaje(i));
		}
		hilo.ajustarPuntajes(puntajes);
	}
	
	/**
	 * Actualiza la ronda de juego actual.
	 */
	private void ajustarRonda() {
		hilo.ronda(juego.getRonda());
	}
	
	/**
	 * Ejecuta la accion de salir al oprimir la x de la pantalla.
	 */
	private void salga(){
		int respuesta = JOptionPane.showConfirmDialog(this,"Are you sure?","Exit",JOptionPane.YES_NO_OPTION);
		if(respuesta == JOptionPane.YES_OPTION){
			setVisible(false);
			contentPane.removeAll();
			juego = null;
			menu.setVisible(true);
			partidas.cancel();
		}
		else{
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		}
	}
	
	/**
	 * Ajusta el tamano de la pantalla de juego.
	 */
	private void ajustarTamano() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		tamX = pantalla.width * 92/100;
		tamY = pantalla.height * 46/50;
		setSize(tamX, tamY);
	}
	
	/**
	 * Ubica la ventana de juego en el centro de la pantalla.
	 */
	private void centrar() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		posX = (pantalla.width - getSize().width) / 2;
		posY = (pantalla.height - getSize().height) / 2 - pantalla.height*1/30;
		setLocation(posX, posY);
	}
	
	/**
	 * Controla el tiempo de las rondas y prepara las diferentes acciones en cada una.
	 */
	private void ejecutarRondas() {
		partidas = new Timer();
		TimerTask finTanda = new TimerTask() {
			public void run() {
				hilo.finalizarTanda();
			}
		};
		TimerTask tarea = new TimerTask() {
			@Override
			public void run() {
				hilo.iniciarTanda();
				if(!juego.gano() && juego.getFinalizado()) {
					partidas.cancel();
					salgaInmediato();
				}
				preparePatosClasico();
				ajustarRonda();
				prepareBalas(1);
				ajustePuntaje(1);
			}
		};
		partidas.schedule(tarea, 0, 10000);
		partidas.schedule(finTanda, 7000, 10000);
	}
	
	/**
	 * Regresa al menu inicial cuando se pierda una ronda.
	 */
	private void salgaInmediato() {
		setVisible(false);
		contentPane.removeAll();
		juego = null;
		menu.setVisible(true);
		partidas.cancel();
	}
}