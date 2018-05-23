package presentacion;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.event.*;

public class SeleccionUnJugador extends Seleccion{
	
	private JButton clasico;
	private JButton CPU;		
	
	/**
	 * Abre una ventana con las opciones de juego individual.
	 * @param gui, recibe el tablero de juego.
	 * @param menuI, recibe el menu inicial.
	 */
	public SeleccionUnJugador(POODuckGUI gui, MenuInicial menuI) {
		super(gui, menuI);
	}
	
	/**
	 * Prepara los elementos necesarios para mostrar la ventana de un jugadpr.
	 */
	protected void prepareElementos() {
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
	
	/**
	 * Prepara y ajusta todos los botones a mostrar en la ventana de seleccion de un jugador.
	 */
	protected void prepararBotones() {
		clasico = new JButton("Clasico");
		CPU = new JButton("<html><p align=\"center\">CPU</p><p align=\"center\">VS</p><p align=\\\"center\\\">Jugador</p></html>");
		volver = new JButton("Volver");
		estetica();
		botones.add(clasico);
		botones.add(CPU);
		botones.add(volver);
	}
	
	/**
	 * Ajusta el tamano de los botones en pantalla.
	 */
	protected void tamano() {
		int x = this.getWidth();
		int y = this.getHeight();
		clasico.setSize(x / 3, y / 8);
		CPU.setSize(x/3, y/3 + 10);
		volver.setSize(x/3, y/8);
	}
	
	/**
	 * Ajusta la posicion de los botones en pantalla.
	 */
	protected void posicion() {
		int x = this.getWidth();
		int y = this.getHeight();
		clasico.setLocation((x - (x / 3))/6, (y - (y / 8)) / 3);
		CPU.setLocation((x - (x / 3) - x/8), (y - (y / 8)) / 5);
		volver.setLocation((x - (x / 3))/2, (y - (y / 3) - 20));
	}
	
	/**
	 * Ajusta las animaciones de los botones en pantalla.
	 */
	protected void animaciones() {				
		clasico.setBorder(null);
		CPU.setBorder(null); 
		volver.setBorder(null); 	
		clasico.setFocusable(false);	
		CPU.setFocusable(false);	 
		volver.setFocusable(false);	
	}
	
	/**
	 * Ajusta el color de fondo de los elementos en pantalla.
	 */
	protected void colorFondo() {
		clasico.setBackground(colorBoton);
		CPU.setBackground(colorBoton);
		volver.setBackground(colorBoton);
	}
	
	/**
	 * Ajusta los textos de los elementos en pantalla.
	 */
	protected void fuentes() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int y = pantalla.height;
		clasico.setForeground(colorFuente); 
		CPU.setForeground(colorFuente); 
		volver.setForeground(colorFuente);	
		clasico.setFont(new Font("Gill Sans Ultra Bold",0,y / 18)); 
		CPU.setFont(new Font("Gill Sans Ultra Bold",0,y / 20)); 
		volver.setFont(new Font("Gill Sans Ultra Bold",0,y / 16));
	}
	
	/**
	 * Asigna funcionalidades a los botones en pantalla.
	 */
	protected void prepareAcciones() {
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
	
	/**
	 * Inicia el modo de juego clasico con una cantidad de patos indicada.
	 */
	private void unJugadorUno() {
		String[] options = {"Dos Patos", "Tres Patos",};
		int seleccion = JOptionPane.showOptionDialog(null, "Seleccione el numero de patos", "Numero de patos", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if(seleccion == 0) {
			setVisible(false);
			menu.setVisible(false);
			juego.unJugador(2);
		}
		if(seleccion == 1) {
			setVisible(false);
			menu.setVisible(false);
			juego.unJugador(3);
		}
	}
	
	/**
	 * Inicia el modo de juego contra la CPU en la dificultad indicada.
	 */
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