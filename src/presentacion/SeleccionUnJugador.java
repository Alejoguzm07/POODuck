package presentacion;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.event.*;

public class SeleccionUnJugador extends JDialog{
	
	private POODuckGUI juego;
	private MenuInicial menu;
	private Container contentPane;
	private JButton clasico;
	private JButton CPU;
	private JButton volver;
	private JPanel botones;
	private Color colorFuente = Color.WHITE;
	private Color colorBoton = new Color(105,205,230);	
	private URL fondo = this.getClass().getResource("FondoSeleccion.png");
	private Image imagenFondo = new ImageIcon(fondo).getImage();
	
	public SeleccionUnJugador(POODuckGUI gui, MenuInicial menuI) {
		juego = gui;
		menu = menuI;
		contentPane = getContentPane();
		contentPane.setBackground(colorBoton);
		contentPane.setLayout(new BorderLayout());
		prepareElementos();
		prepareAcciones();
	}
	
	private void prepareElementos() {
		setTitle("UN JUGADOR");
		ajustarTamano();
		centrar();
		botones = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(imagenFondo,0,0,getWidth(),getHeight(),this);
			}
		};
		botones.setLayout(null);
		prepararBotones();
		contentPane.add(botones,BorderLayout.CENTER);
		setVisible(true);
	}
	
	private void ajustarTamano() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int x = pantalla.width;
		int y = pantalla.height;
		setSize(x /2, y /2);
	}
	
	private void centrar() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (pantalla.width - getSize().width) / 2;
		int y = (pantalla.height - getSize().height) / 2;
		setLocation(x,y);
	}
	
	private void prepararBotones() {
		clasico = new JButton("Clasico");
		CPU = new JButton("<html><p align=\"center\">CPU</p><p align=\"center\">VS</p><p align=\\\"center\\\">Jugador</p></html>");
		volver = new JButton("Volver");
		estetica();
		botones.add(clasico);
		botones.add(CPU);
		botones.add(volver);
	}
	
	private void estetica(){
		tamano();
		posicion();
		animaciones();
		colorFondo();
		fuentes();
	}
	
	private void tamano() {
		int x = this.getWidth();
		int y = this.getHeight();
		clasico.setSize(x / 3, y / 8);
		CPU.setSize(x/3, y/3 + 10);
		volver.setSize(x/3, y/8);
	}
	
	private void posicion() {
		int x = this.getWidth();
		int y = this.getHeight();
		clasico.setLocation((x - (x / 3))/6, (y - (y / 8)) / 3);
		CPU.setLocation((x - (x / 3) - x/8), (y - (y / 8)) / 5);
		volver.setLocation((x - (x / 3))/2, (y - (y / 3) - 20));
	}
	
	private void animaciones() {				
		clasico.setBorder(null);
		CPU.setBorder(null); 
		volver.setBorder(null); 	
		clasico.setFocusable(false);	
		CPU.setFocusable(false);	 
		volver.setFocusable(false);	
	}
	
	private void colorFondo() {
		clasico.setBackground(colorBoton);
		CPU.setBackground(colorBoton);
		volver.setBackground(colorBoton);
	}
	
	private void fuentes() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int y = pantalla.height;
		clasico.setForeground(colorFuente); 
		CPU.setForeground(colorFuente); 
		volver.setForeground(colorFuente);	
		clasico.setFont(new Font("Gill Sans Ultra Bold",0,y / 18)); 
		CPU.setFont(new Font("Gill Sans Ultra Bold",0,y / 20)); 
		volver.setFont(new Font("Gill Sans Ultra Bold",0,y / 16));
	}
	
	private void prepareAcciones() {
		ActionListener oyenteBotonCazadores = new ActionListener(){
			public void actionPerformed(ActionEvent we){
				unJugadorUno();
			}
		};
		ActionListener oyenteBotonPajaroCazador = new ActionListener(){
			public void actionPerformed(ActionEvent we){
				unJugadorDos();
			}
		};
		ActionListener oyenteBotonVolver = new ActionListener(){
			public void actionPerformed(ActionEvent we){
				atras();
			}
		};
		clasico.addActionListener(oyenteBotonCazadores);
		CPU.addActionListener(oyenteBotonPajaroCazador);
		volver.addActionListener(oyenteBotonVolver);
	}
	
	private void atras() {
		setVisible(false);	
	}
	
	private void unJugadorUno() {
		setVisible(false);
		menu.setVisible(false);
		juego.multijugador();
	}

	private void unJugadorDos() {
		String[] options = {"Tranquilo", "Agresivo",};
		int seleccion = JOptionPane.showOptionDialog(null, "Seleccione el nivel de dificultad", "Dificultad", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if(seleccion == 0) {
			/*setVisible(false);
			menu.setVisible(false);
			juego.unJugador();*/
		}
		if(seleccion == 1) {
			/*setVisible(false);
			menu.setVisible(false);
			juego.unJugador();*/
		}
	}
}


