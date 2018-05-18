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
			izquierdaArriba();
		}
		if(direccion == 2) {
			derechaArriba();
		}
		if(direccion == 3) {
			derechaAbajo();
		}
		if(direccion == 4) {
			derechaAbajo(;
		}
		if(direccion == 6) {
			izquierdaAbajo();
		}
		if(direccion == 7) {
			izquierdaAbajo();
		}
		numImagen++;
		if(numImagen > 4) {
			numImagen = 1;
		}
		panel.repaint();
	}
	
	private void derechaAbajo() {
		if(pato == 1) {
			ruta = "ImagenesPatoNormal/DerechaAbajo/";
		}
		if(pato == 2) {
			ruta = "ImagenesPatoVeloz/DerechaAbajo/";
		}
		if(pato == 3) {
			ruta = "ImagenesPatoBlindado/DerechaAbajo/";
		}
		if(pato == 4) {
			ruta = "ImagenesPatoBoss/DerechaAbajo/";
		}
	}
	private void derechaArriba() {
		if(pato == 1) {
			ruta = "ImagenesPatoNormal/DerechaArriba/";
		}
		if(pato == 2) {
			ruta = "ImagenesPatoVeloz/DerechaArriba/";
		}
		if(pato == 3) {
			ruta = "ImagenesPatoBlindado/DerechaArriba/";
		}
		if(pato == 4) {
			ruta = "ImagenesPatoBoss/DerechaArriba/";
		}		
	}
	
	private void izquierdaArriba() {
		if(pato == 1) {
			ruta = "ImagenesPatoNormal/IzquierdaArriba/";
		}
		if(pato == 2) {
			ruta = "ImagenesPatoVeloz/IzquierdaArriba/";
		}
		if(pato == 3) {
			ruta = "ImagenesPatoBlindado/IzquierdaArriba/";
		}
		if(pato == 4) {
			ruta = "ImagenesPatoBoss/IzquierdaArriba/";
		}		
	}
	
	private void izquierdaAbajo() {
		if(pato == 1) {
			ruta = "ImagenesPatoNormal/IzquierdaAbajo/";
		}
		if(pato == 2) {
			ruta = "ImagenesPatoVeloz/IzquierdaAbajo/";
		}
		if(pato == 3) {
			ruta = "ImagenesPatoBlindado/IzquierdaAbajo/";
		}
		if(pato == 4) {
			ruta = "ImagenesPatoBoss/IzquierdaAbajo/";
		}		
	}
	
	private void cayendo() {
		if(pato == 1) {
			ruta = "ImagenesPatoNormal/Cayendo/";
		}
		if(pato == 2) {
			ruta = "ImagenesPatoVeloz/Cayendo/";
		}
		if(pato == 3) {
			ruta = "ImagenesPatoBlindado/Cayendo/";
		}
		if(pato == 4) {
			ruta = "ImagenesPatoBoss/Cayendo/";
		}		
	}
	
	private void impactadoP() {
		if(pato == 1) {
			ruta = "ImagenesPatoNormal/Impactado/";
		}
		if(pato == 2) {
			ruta = "ImagenesPatoVeloz/Impactado/";
		}
		if(pato == 3) {
			ruta = "ImagenesPatoBlindado/Impactado/";
		}
		if(pato == 4) {
			ruta = "ImagenesPatoBoss/Impactado/";
		}	
	
}
