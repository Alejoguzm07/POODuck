package presentacion;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.event.*;
import aplicacion.Pato;
import java.lang.*;

public class PatoGUI extends Component{
	
	private int numImagen = 1;
	private JPanel panel;
	private final String rutaCayendo = "/Cayendo/";
	private final String rutaDerechaAbajo = "/DerechaAbajo/";
	private final String rutaDerechaArriba = "/DerechaArriba/";
	private final String rutaIzquierdaAbajo = "/IzquierdaAbajo/";
	private final String rutaIzquierdaArriba = "/IzquierdaArriba/";
	private final String rutaImpactado = "/Impactado/";
	static int posCuerpoY;
	static int posCuerpoX;
	private String ruta;
	private String pato;
	private int direccion;
	
	public PatoGUI(JPanel panel, int[] pos, String tipo) {
		this.setVisible(true);
		this.panel = panel;
		panel.add(this);
		setBounds(0,0,55,55);
		posCuerpoX = pos[0];
		posCuerpoY = pos[1];
		pato = tipo;
		direccion = 1;
		ruta = tipo + rutaDerechaArriba;
	}
	
	public void paint(Graphics g) {
		ImageIcon imagenPatos = new ImageIcon(new ImageIcon(getClass().getResource(ruta+numImagen+".png")).getImage());
		g.drawImage(imagenPatos.getImage(), posCuerpoX, posCuerpoY, 55, 55, this);
	}	
	
	public void actualizar(int[] pos, int dir, boolean isAlive) {
		posCuerpoX = pos[0];
		posCuerpoY = pos[1];
		direccion = dir;
		pintar();
		repaint();
	}
	
	private void pintar() {
		if(direccion == 1) {
			ruta = pato + rutaIzquierdaArriba;
		}
		if(direccion == 2) {
			ruta = pato + rutaDerechaArriba;
		}
		if(direccion == 3) {
			ruta = pato + rutaDerechaAbajo;
		}
		if(direccion == 4) {
			ruta = pato + rutaDerechaAbajo;
		}
		if(direccion == 6) {
			ruta = pato + rutaIzquierdaAbajo;
		}
		if(direccion == 7) {
			ruta = pato + rutaIzquierdaAbajo;
		}
		numImagen++;
		if(numImagen > 4) {
			numImagen = 1;
		}
		panel.repaint();
	}
	
}