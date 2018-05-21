package presentacion;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.event.*;


public class MenuInicial extends JDialog{
	
	private Container contentPane;
	private Dimension pantalla;
	private JPanel botones;
	private JButton unJugador;
	private JButton multiJugador;
	private JButton instrucciones;
	private JButton salir;
	private POODuckGUI juego;
	private SeleccionMultijugador opcionDosJugadores;
	private SeleccionUnJugador opcionUnJugador;
	private Color colorFuente = Color.WHITE;
	private Color colorBoton = new Color(105,205,230);	
	private URL fondo = this.getClass().getResource("FondoMenu.png");
	private Image imagenFondo = new ImageIcon(fondo).getImage();
	
	/**
	 * Inicia la ventana de menu inicial.
	 * @param gui, recibe el tablero de juego.
	 */
	public MenuInicial(POODuckGUI gui){
		juego = gui;
		contentPane = getContentPane();
		pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		prepareElementos();
		prepareAcciones();
	}
	
	/**
	 * Prepara los elementos necesarios para mostrar los elementos del menu.
	 */
	private void prepareElementos(){		
		setTitle("MENU PRINCIPAL");
		setVisible(true);
		contentPane.setLayout(new BorderLayout());
		prepareBotones();
	}
	
	/**
	 * Prepara y ajusta todos los botones a mostrar en el menu inicial.
	 */
	private void prepareBotones(){
		botones = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(imagenFondo,0,0,getWidth(),getHeight(),this);
			}
		};
		botones.setLayout(null);
		unJugador = new JButton("Un Jugador");		
		multiJugador = new JButton("Multijugador");		
		instrucciones = new JButton("Como Jugar");				
		salir = new JButton("Salir");
		ajustarTamano();
		ajustarTamanoBotones();
		centrar();
		estetica();
		botones.add(unJugador);
		botones.add(multiJugador);
		botones.add(instrucciones);
		botones.add(salir);
		contentPane.add(botones,BorderLayout.CENTER);
	}
	
	/**
	 * Ajusta la estetica del menu inicial.
	 */
	private void estetica(){		
		animaciones();
		colorFondo();
		fuentes();
	}
	
	/**
	 * Ajusta las animaciones de los botones en el menu inicial.
	 */
	private void animaciones() {				
		unJugador.setBorder(null);
		multiJugador.setBorder(null); 
		instrucciones.setBorder(null); 
		salir.setBorder(null);		
		unJugador.setFocusable(false);	
		multiJugador.setFocusable(false);	 
		instrucciones.setFocusable(false);	
		salir.setFocusable(false);
	}
	
	/**
	 * Ajusta el color de los elementos en el menu.
	 */
	private void colorFondo() {
		unJugador.setBackground(colorBoton);
		multiJugador.setBackground(colorBoton);
		instrucciones.setBackground(colorBoton);
		salir.setBackground(colorBoton);
	}
	
	/**
	 * Ajusta los textos en el menu inicial.
	 */
	private void fuentes() {
		int y = pantalla.height;
		Font fuente = new Font("Gill Sans Ultra Bold",0,y / 20);
		unJugador.setForeground(colorFuente); 
		multiJugador.setForeground(colorFuente); 
		instrucciones.setForeground(colorFuente); 
		salir.setForeground(colorFuente);		
		unJugador.setFont(fuente); 
		multiJugador.setFont(fuente); 
		instrucciones.setFont(fuente); 
		salir.setFont(fuente);
	}
	
	/**
	 * Asigna las diferentes funcionalidades a los botones del menu.
	 */
	private void prepareAcciones(){
		WindowAdapter oyenteCerrarVentana = new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				salga();
			}
		};
		ActionListener oyenteBotonSalir = new ActionListener(){
			public void actionPerformed(ActionEvent we){
				salga();
			}
		};
		ActionListener oyenteBotonUnJugador = new ActionListener(){
			public void actionPerformed(ActionEvent we){
				juegoUno();
			}
		};
		ActionListener oyenteBotonMultijugador = new ActionListener(){
			public void actionPerformed(ActionEvent we){
				juegoDos();
			}
		};
		addWindowListener(oyenteCerrarVentana);
		salir.addActionListener(oyenteBotonSalir);
		unJugador.addActionListener(oyenteBotonUnJugador);
		multiJugador.addActionListener(oyenteBotonMultijugador);
	}
	
	/**
	 * Cierra el juego en caso de que el usuario le indique.
	 */
	private void salga(){
		int respuesta = JOptionPane.showConfirmDialog(this,"Are you sure?","Exit",JOptionPane.YES_NO_OPTION);
		if(respuesta == JOptionPane.YES_OPTION){
			System.exit(0);
		}
		else{
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		}
	}
	
	/**
	 * Ajusta el tamano de la ventana del menu inicial.
	 */
	private void ajustarTamano() {
		int x = pantalla.width;
		int y = pantalla.height;
		setSize(x * 61/100, y * 41/50);
	}
	
	/**
	 * Ajusta el tamano y la ubicacion de los botones en el menu.
	 */
	private void ajustarTamanoBotones() {
		int x = this.getWidth();
		int y = this.getHeight();
		int yU = (y - (y / 9)) / 3;
		int yM = yU + y / 12 + y / 18;
		int yC = yM + y / 12 + y / 18;
		int yS = yC + y / 12 + y / 18;
		unJugador.setSize(x / 3 + 90, y / 11);		
		multiJugador.setSize(x / 3 + 120, y / 11);
		instrucciones.setSize(x / 3 + 90, y / 11);		
		salir.setSize(x / 4, y / 11);
		unJugador.setLocation((x - (x / 3 + 90))/2, yU);
		multiJugador.setLocation((x - (x / 3 + 120))/2,yM);
		instrucciones.setLocation((x - (x / 3 + 90))/2,yC);
		salir.setLocation((x - (x / 4))/2,yS);
	}
	
	/**
	 * Ubica la ventana de menu inicial en el centro de la pantalla.
	 */
	private void centrar() {
		int xpos = (pantalla.width - getSize().width) / 2;
		int ypos = (pantalla.height - getSize().height) / 2;
		setLocation(xpos,ypos);		
	}
	
	/**
	 * Abre una ventana con las opciones de juego individual.
	 */
	private void juegoUno(){
		opcionUnJugador = new SeleccionUnJugador(juego, this);
	}
	
	/**
	 * Abre una ventana con las opciones de multijugador.
	 */
	private void juegoDos(){
		opcionDosJugadores = new SeleccionMultijugador(juego, this);
	}

}
