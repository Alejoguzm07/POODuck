package presentacion;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.event.*;
import java.lang.*;

public class BalaGUI {
	
	private JPanel panel;
	private int tipo;
	private int tamano;
	private String ruta;
	
	/**
	 * Crea una bala visible en pantalla.
	 * @param pan, recibe el tablero de juego.
	 * @param bala, recibe el tipo de bala.
	 */
	public BalaGUI(JPanel pan, int bala) {
		panel = pan;
		tipo = bala;
	}
	
	/**
	 * Define la imagen de la bala a ser pintada.
	 */
	public void definirRuta() {
		if(tipo == 1) {
			ruta = "ImagenesBalas/Normal.png";
		}
		if(tipo == 2) {
			ruta = "ImagenesBalas/Ricochet.png";
		}
		if(tipo == 3) {
			ruta = "ImagenesBalas/Salvavidas.png";
		}
		if(tipo == 4) {
			ruta = "ImagenesBalas/DoblePuntaje.png";
		}
		if(tipo == 0) {
			ruta = "ImagenesBalas/Descargada.png";
		}
	}

	/**
	 * Devuelve la ruta de la imagen de la bala.
	 * @return, Cadena con la ruta de la imagen de la bala.
	 */
	public String getRuta() {
		return ruta;
	}
}
