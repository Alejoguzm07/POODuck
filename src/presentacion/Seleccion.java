package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public abstract class Seleccion extends JDialog{
	
	protected POODuckGUI juego;
	protected MenuInicial menu;
	protected Container contentPane;
	protected JButton volver;
	protected JPanel botones;
	protected Color colorFuente = Color.WHITE;
	protected Color colorBoton = new Color(105,205,230);	
	private URL fondo = this.getClass().getResource("FondoSeleccion.png");
	protected Image imagenFondo = new ImageIcon(fondo).getImage();
	
	/**
	 * Abre una ventana con las opciones de seleccion.
	 * @param gui, recibe el tablero de juego.
	 * @param menuI, recibe el menu inicial.
	 */
	public Seleccion(POODuckGUI gui, MenuInicial menuI) {
		juego = gui;
		menu = menuI;
		contentPane = getContentPane();
		contentPane.setBackground(Color.BLACK);
		contentPane.setLayout(new BorderLayout());
		prepareElementos();
		prepareAcciones();
	}
	
	/**
	 * Prepara los elementos necesarios para mostrar la ventana de seleccion.
	 */
	protected abstract void prepareElementos();
	
	/**
	 * Ajusta el tamano de los elementos en la ventana de seleccion.
	 */
	protected void ajustarTamano() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int x = pantalla.width;
		int y = pantalla.height;
		setSize(x /2, y /2);
	}
	
	/**
	 * Ubica la ventana de seleccion en el centro de la pantalla.
	 */
	protected void centrar() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (pantalla.width - getSize().width) / 2;
		int y = (pantalla.height - getSize().height) / 2;
		setLocation(x,y);
	}
	
	/**
	 * Prepara y ajusta todos los botones a mostrar en la ventana de seleccion.
	 */
	protected abstract void prepararBotones();
	
	/**
	 * Ajusta la estetica de los botones al mostrar en la ventana de seleccion.
	 */
	protected void estetica(){
		tamano();
		posicion();
		animaciones();
		colorFondo();
		fuentes();
	}
	
	/**
	 * Ajusta el tamano de los botones en pantalla.
	 */
	protected abstract void tamano();
	
	/**
	 * Ajusta la posicion de los botones en pantalla.
	 */
	protected abstract void posicion();
	
	/**
	 * Ajusta las animaciones de los botones en pantalla.
	 */
	protected abstract void animaciones();
	
	/**
	 * Ajusta el color de fondo de los elementos en pantalla.
	 */
	protected abstract void colorFondo();
	
	/**
	 * Ajusta los textos de los elementos en pantalla.
	 */
	protected abstract void fuentes();

	/**
	 * Asigna funcionalidades a los botones en pantalla.
	 */
	protected abstract void prepareAcciones();
	
	/**
	 * Vuelve al menu inicial en el caso de ser indicado.
	 */
	protected void atras() {
		setVisible(false);	
	}
}
