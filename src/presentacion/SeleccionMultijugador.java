package presentacion;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.event.*;

public class SeleccionMultijugador extends JDialog {
	
	private POODuckGUI juego;
	private MenuInicial menu;
	private Container contentPane;
	private JButton cazadores;
	private JButton pajaroCazador;
	private JButton volver;
	private JPanel botones;
	private Color colorFuente = Color.WHITE;
	private Color colorBoton = new Color(105,205,230);	
	private URL fondo = this.getClass().getResource("FondoSeleccion.png");
	private Image imagenFondo = new ImageIcon(fondo).getImage();

	public SeleccionMultijugador(POODuckGUI gui, MenuInicial menuI) {
		juego = gui;
		menu = menuI;
		contentPane = getContentPane();
		contentPane.setBackground(Color.BLACK);
		contentPane.setLayout(new BorderLayout());
		prepareElementos();
		prepareAcciones();
	}
	
	private void prepareElementos() {
		setTitle("MULTIJUGADOR");
		setResizable(false);
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
		cazadores = new JButton("<html><p align=\\\"center\\\">Cazador</p><p align=\"center\">VS</p><p align=\\\"center\\\">Cazador</p></html>");
		pajaroCazador = new JButton("<html><p align=\"center\">Pato</p><p align=\"center\">VS</p><p align=\\\"center\\\">Cazador</p></html>");
		volver = new JButton("Volver");
		estetica();
		botones.add(cazadores);
		botones.add(pajaroCazador);
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
		cazadores.setSize(x/3, y/3 + 10);
		pajaroCazador.setSize(x/3, y/3 + 10);
		volver.setSize(x/3, y/8);
	}
	
	private void posicion() {
		int x = this.getWidth();
		int y = this.getHeight();
		cazadores.setLocation((x - (x / 3))/10, (y - (y / 8)) / 5);
		pajaroCazador.setLocation((x - (x / 3) - x/8), (y - (y / 8)) / 5);
		volver.setLocation((x - (x / 3))/2, (y - (y / 3) - 20));
	}
	
	private void animaciones() {						
		cazadores.setBorder(null);
		pajaroCazador.setBorder(null); 
		volver.setBorder(null); 	
		cazadores.setFocusable(false);	
		pajaroCazador.setFocusable(false);	 
		volver.setFocusable(false);	
	}
	
	private void colorFondo() {
		cazadores.setBackground(colorBoton);
		pajaroCazador.setBackground(colorBoton);
		volver.setBackground(colorBoton);	
	}
	
	private void fuentes() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int y = pantalla.height;
		cazadores.setForeground(colorFuente); 
		pajaroCazador.setForeground(colorFuente); 
		volver.setForeground(colorFuente);	
		cazadores.setFont(new Font("Gill Sans Ultra Bold",0,y / 20)); 
		pajaroCazador.setFont(new Font("Gill Sans Ultra Bold",0,y / 20)); 
		volver.setFont(new Font("Gill Sans Ultra Bold",0,y / 16));
	}
	
	private void prepareAcciones() {
		ActionListener oyenteBotonCazadores = new ActionListener(){
			public void actionPerformed(ActionEvent we){
				multijugadorUno();
			}
		};
		ActionListener oyenteBotonPajaroCazador = new ActionListener(){
			public void actionPerformed(ActionEvent we){
				multijugadorDos();
			}
		};
		ActionListener oyenteBotonVolver = new ActionListener(){
			public void actionPerformed(ActionEvent we){
				atras();
			}
		};
		cazadores.addActionListener(oyenteBotonCazadores);
		pajaroCazador.addActionListener(oyenteBotonPajaroCazador);
		volver.addActionListener(oyenteBotonVolver);
	}
	
	private void atras() {
		setVisible(false);		
	}
	
	private void multijugadorUno() {
		/*setVisible(false);
		menu.setVisible(false);
		juego.unJugador();*/
	}

	private void multijugadorDos() {
		/*setVisible(false);
		menu.setVisible(false);
		juego.unJugador();*/
	}
}
