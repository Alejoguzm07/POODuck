package presentacion;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.event.*;

public class SeleccionMultijugador extends Seleccion {	
	
	private JButton cazadores;
	private JButton pajaroCazador;

	/**
	 * Abre una ventana con las opciones de multijugador.
	 * @param gui, recibe el tablero de juego.
	 * @param menuI, recibe el menu inicial.
	 */
	public SeleccionMultijugador(POODuckGUI gui, MenuInicial menuI) {
		super(gui, menuI);
	}
	
	/**
	 * Prepara los elementos necesarios para mostrar la ventana de Multijugador.
	 */
	protected void prepareElementos() {
		setTitle("MULTIJUGADOR");
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
	 * Prepara y ajusta todos los botones a mostrar en la ventana de seleccion de multijugador.
	 */
	protected void prepararBotones() {
		cazadores = new JButton("<html><p align=\\\"center\\\">Cazador</p><p align=\"center\">VS</p><p align=\\\"center\\\">Cazador</p></html>");
		pajaroCazador = new JButton("<html><p align=\"center\">Pato</p><p align=\"center\">VS</p><p align=\\\"center\\\">Cazador</p></html>");
		volver = new JButton("Volver");
		estetica();
		botones.add(cazadores);
		botones.add(pajaroCazador);
		botones.add(volver);
	}	
	
	/**
	 * Ajusta el tamano de los botones en pantalla.
	 */
	protected void tamano() {
		int x = this.getWidth();
		int y = this.getHeight();
		cazadores.setSize(x/3, y/3 + 10);
		pajaroCazador.setSize(x/3, y/3 + 10);
		volver.setSize(x/3, y/8);
	}
	
	/**
	 * Ajusta la posicion de los botones en pantalla.
	 */
	protected void posicion() {
		int x = this.getWidth();
		int y = this.getHeight();
		cazadores.setLocation((x - (x / 3))/10, (y - (y / 8)) / 5);
		pajaroCazador.setLocation((x - (x / 3) - x/8), (y - (y / 8)) / 5);
		volver.setLocation((x - (x / 3))/2, (y - (y / 3) - 20));
	}
	
	/**
	 * Ajusta las animaciones de los botones en pantalla.
	 */
	protected void animaciones() {						
		cazadores.setBorder(null);
		pajaroCazador.setBorder(null); 
		volver.setBorder(null); 	
		cazadores.setFocusable(false);	
		pajaroCazador.setFocusable(false);	 
		volver.setFocusable(false);	
	}
	
	/**
	 * Ajusta el color de fondo de los elementos en pantalla.
	 */
	protected void colorFondo() {
		cazadores.setBackground(colorBoton);
		pajaroCazador.setBackground(colorBoton);
		volver.setBackground(colorBoton);	
	}
	
	/**
	 * Ajusta los textos de los elementos en pantalla.
	 */
	protected void fuentes() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int y = pantalla.height;
		cazadores.setForeground(colorFuente); 
		pajaroCazador.setForeground(colorFuente); 
		volver.setForeground(colorFuente);	
		cazadores.setFont(new Font("Gill Sans Ultra Bold",0,y / 20)); 
		pajaroCazador.setFont(new Font("Gill Sans Ultra Bold",0,y / 20)); 
		volver.setFont(new Font("Gill Sans Ultra Bold",0,y / 16));
	}
	
	/**
	 * Asigna funcionalidades a los botones en pantalla.
	 */
	protected void prepareAcciones() {
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
	
	private void multijugadorUno() {
		/*setVisible(false);
		menu.setVisible(false);
		juego.multijugador('V');*/
	}

	private void multijugadorDos() {
		setVisible(false);
		menu.setVisible(false);
		juego.multijugador('V');
	}
}
