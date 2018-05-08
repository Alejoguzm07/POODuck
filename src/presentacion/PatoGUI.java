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
	
	static int numImagen = 1;
	static JPanel panel;
	static int posCuerpoX;
	static int posCuerpoY;
	private static int moverFila;
	private static int moverCol;
	private static String ruta;
	private static int speed;
	private static boolean isAlive;
	private static boolean impactado;
	
	public PatoGUI(JPanel panel) {
		this.setVisible(true);
		this.panel = panel;
		setBounds(0,0,55,55);
		posCuerpoY = 600;
		posCuerpoX = 300;
		moverFila = 15;
		moverCol = 15;
		isAlive = true;
		impactado = true;
	}
	
	public void paint(Graphics g) {
		ImageIcon imagenPatos = new ImageIcon(new ImageIcon(getClass().getResource(ruta+numImagen+".png")).getImage());
		g.drawImage(imagenPatos.getImage(), posCuerpoX, posCuerpoY, 55, 55, this);
	}
	
	public void iniciar(String tipo, int velocidad) {
		ruta = tipo;
		speed = velocidad;
		mover();
	}
	
	public int getFila() {
		return posCuerpoY;
	}
	
	public int getCol() {
		return posCuerpoX;
	}
	
	public static Thread hiloVolar = new Thread(){
		@Override
		public void run() {
			try {
				while(isAlive) {
					numImagen++;
					if(numImagen == 4) {
						numImagen = 1;
					}
					panel.repaint();
					hiloVolar.sleep(speed);
					controlarMovimiento();
					posCuerpoX += moverCol;
					posCuerpoY += moverFila;
				}
				impactado = true;
				while(impactado) {
					numImagen=1;
					definirImpacto();
					panel.repaint();
					hiloVolar.sleep(150);
				}
				while(posCuerpoY <= panel.getHeight() - 10) {
					numImagen++;
					ruta = "ImagenesPatoDoble/Cayendo/";
					if(numImagen == 4) {
						numImagen = 1;
					}
					panel.repaint();
					hiloVolar.sleep(60);
					posCuerpoY += 10;
				}
				hiloVolar.sleep(5000);
				posCuerpoY += 2000;
				posCuerpoX += 2000;
				panel.repaint();
			}catch (InterruptedException ex) {
				System.out.println(ex.getMessage());
			}
		}
	};
	
	public static void mover() {
		if(!hiloVolar.isAlive()) {
			hiloVolar.start();
		}
	}
	
	private static void controlarMovimiento() {
		if(posCuerpoY < 3) {
			moverFila = 10;
		}
		if(posCuerpoX < 3) {
			moverCol = 10;
		}
		if(posCuerpoY > 430) {
			moverFila = -10;
		}
		if(posCuerpoX > 1200) {
			moverCol = -10;
		}
		definirDireccion();
	}
	
	private static void definirDireccion() {
		if(moverFila > 0 && moverCol > 0) {
			ruta = "ImagenesPatoDoble/DerechaAbajo/";
		}
		if(moverFila > 0 && moverCol < 0) {
			ruta = "ImagenesPatoDoble/IzquierdaAbajo/";
		}
		if(moverFila < 0 && moverCol > 0) {
			ruta = "ImagenesPatoDoble/DerechaArriba/";
		}
		if(moverFila < 0 && moverCol < 0) {
			ruta = "ImagenesPatoDoble/IzquierdaArriba/";
		}
	}
	
	private static void definirImpacto() {
		ruta = "ImagenesPatoDoble/Impactado/";
		impactado = false;
	}
	
	public void derribar() {
		isAlive = false;
	}
}