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
	
	public MenuInicial(POODuckGUI gui){
		juego = gui;
		contentPane = getContentPane();
		pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		prepareElementos();
		prepareAcciones();
	}
	
	private void prepareElementos(){		
		setTitle("MENU PRINCIPAL");
		setVisible(true);
		contentPane.setLayout(new BorderLayout());
		prepareBotones();
	}
	
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
	
	private void estetica(){		
		animaciones();
		colorFondo();
		fuentes();
	}
	
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
	
	private void colorFondo() {
		unJugador.setBackground(colorBoton);
		multiJugador.setBackground(colorBoton);
		instrucciones.setBackground(colorBoton);
		salir.setBackground(colorBoton);
	}
	
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
	
	private void salga(){
		int respuesta = JOptionPane.showConfirmDialog(this,"Are you sure?","Exit",JOptionPane.YES_NO_OPTION);
		if(respuesta == JOptionPane.YES_OPTION){
			System.exit(0);
		}
		else{
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		}
	}
	
	private void ajustarTamano() {
		int x = pantalla.width;
		int y = pantalla.height;
		setSize(x * 61/100, y * 41/50);
	}
	
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
	
	private void centrar() {
		int xpos = (pantalla.width - getSize().width) / 2;
		int ypos = (pantalla.height - getSize().height) / 2;
		setLocation(xpos,ypos);		
	}
	
	private void juegoUno(){
		opcionUnJugador = new SeleccionUnJugador(juego, this);
	}
	
	private void juegoDos(){
		opcionDosJugadores = new SeleccionMultijugador(juego, this);
	}

}
