package presentacion;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.event.*;
import java.lang.*;

public class PatoGUI extends Component{
	
	private int numImagen = 1;
	private JPanel panel;
	private int col;
	private int fila;
	private int moverFila;
	private int moverCol;
	private String ruta;
	private int radio;
	private boolean isAlive;
	private boolean impactado;
	private int velocidad;
	private int pato;
	private int tamano;
	private int tiempoImpactado;
	private int pisoY;
	private int pisoX;
	private int tamX;
	
	/**
	 * Crea un pato visible en pantalla.
	 * @param pan, recibe el tablero de juego.
	 * @param spd, recibe la velocidad del pato.
	 * @param pat, recibe el tipo de pato a ser pintado.
	 * @param tam, recibe el tamano del pato.
	 * @param tx, recibe el ancho del tablero de juego.
	 * @param ty, recibe el alto del tablero de juego.
	 * @param px, recibe la ubicacion en x del tablero de juego.
	 * @param py, recibe la ubicacion en y del tablero de juego.
	 */
	public PatoGUI(JPanel pan, int spd, int pat, int tam, int tx, int ty, int px, int py) {
		tamX = tx-tx/16;
		tamano = tam;
		panel = pan;
		pato = pat;
		Random rd = new Random();
		pisoY = py + ((ty/500)*(450));
		pisoX = px + (Math.abs(rd.nextInt())%tx);
		fila = pisoY;
		col = pisoX;
		setBounds(fila,col, tamano, tamano);
		moverFila = spd;
		moverCol = spd;
		velocidad = spd;
		derechaArriba();
		isAlive = true;
		impactado = false;
		tiempoImpactado = 15; // Contador del tiempo que durara la animacion del impacto.
	}
	
	/**
	 * Retorna la longitud en x del tamaño del ave.
	 * @return tamano, longitud x del tamano del ave.
	 */
	public int getTamano() {
		return tamano;
	}
	
	/**
	 * Retorna la posicion y del ave. 
	 * @return fila, variable con la posicion y del ave.
	 */
	public int getFila() {
		return fila;
	}
	
	/**
	 * Retorna la posicion x del ave.
	 * @return col, variable con la posicion x del ave.
	 */
	public int getCol() {
		return col;
	}
	
	/**
	 * Devuelve la direccion de la imagen del pato.
	 * @return, Una cadena con la ruta de la imagen del pato.
	 */
	public String getRuta() {
		return ruta;
	}
	
	/**
	 * retorna si el ave esta viva o muerta.
	 * @return isAlive, variable con un booleano indicando si el ave esta muerta o viva.
	 */
	public boolean estaVivo() {
		return isAlive;
	}
	
	/**
	 * retorna el numero de la imagen PGN que se desea pintar.
	 * @return, devuelve el numero de imagen que se debe pintar.
	 */
	public int getNumImagen() {
		return numImagen;
	}
	
	/**
	 * Cambia el numero de la imagen PNG para hacer la correcta animacion.
	 */
	public void cambiarImagen() {
		numImagen++;
		if(numImagen == 4) {
			numImagen = 1;
		}
	}
	
	/**
	 * Cambia la posicion del ave respecto a y, sumandole un delta moverFila.
	 */
	public void moverCol() {
		col+=moverCol;
	}
	
	/**
	 * Cambia la posicion del ave respecto a x, sumandole un delta moverCol.
	 */
	public void moverFila() {
		fila+=moverFila;
	}
	
	/**
	 * Retorna un booleano indicando si el pato esta impactado por un disparo.
	 * @return impactado, Variable con un valor booleano.
	 */
	public boolean estaImpactado() {
		return impactado;
	}
	
	/**
	 * Simula el movimiento del pato.
	 */
	public void mover() {		
		Random rd = new Random();
		fila = pisoY;
		col = pisoX;
	}
	
	/**
	 * Controla el movimiento del ave y asegura que no se salga del tablero del juego.
	 */
	public void controlarMovimiento() {
		if(fila < 3) {
			moverFila = velocidad;
		}
		if(col < 3) {
			moverCol = velocidad;
		}
		if(fila > pisoY) {
			moverFila = -velocidad;
		}
		if(col > tamX) {
			moverCol = -velocidad;
		}
		definirDireccion();
	}
	
	/**
	 * Define la direccion en que se mueve el ave.
	 */
	private void definirDireccion() {
		if(moverFila > 0 && moverCol > 0) {
			derechaAbajo();
		}
		if(moverFila > 0 && moverCol < 0) {
			izquierdaAbajo();
		}
		if(moverFila < 0 && moverCol > 0) {
			derechaArriba();
		}
		if(moverFila < 0 && moverCol < 0) {
			izquierdaArriba();
		}
	}
	
	/**
	 * Genera un contador para temporizar cuanto durara la animacion del impacto.
	 */
	public void disminuirTiempoI() {
		tiempoImpactado--;
		if(tiempoImpactado < 1) {
			impactado = false;
			isAlive = false;
		}
	}
	
	/**
	 * Empieza a hacer la animacion del pato muriendo.
	 */
	public void definirMuriendo() {
		cayendo();
		fila+=18;
	}
	
	/**
	 * Interrumpe el vuelo del pato para empezar a derribarlo
	 */
	public void derribar() {
		impactado = true;
		impactadoP();
	}
	
	/**
	 * Define la ruta direccion derecha hacia abajo del ave.
	 */
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
			ruta = "ImagenesPatoDoble/DerechaAbajo/";
		}
		if(pato == 5) {
			ruta = "ImagenesPatoBoss/DerechaAbajo/";
		}		
	}
	
	/**
	 * Define la ruta direccion derecha hacia arriba del ave. 
	 */
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
			ruta = "ImagenesPatoDoble/DerechaArriba/";
		}
		if(pato == 5) {
			ruta = "ImagenesPatoBoss/DerechaArriba/";
		}		
	}
	
	/**
	 * Define la ruta direccion izquierda hacia arriba del ave.
	 */
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
			ruta = "ImagenesPatoDoble/IzquierdaArriba/";
		}
		if(pato == 5) {
			ruta = "ImagenesPatoBoss/IzquierdaArriba/";
		}		
	}
	
	/**
	 * Define la ruta direccion izquierda hacia abajo del ave.
	 */
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
			ruta = "ImagenesPatoDoble/IzquierdaAbajo/";
		}
		if(pato == 5) {
			ruta = "ImagenesPatoBoss/IzquierdaAbajo/";
		}		
	}
	
	/**
	 * Define la ruta cayendo del ave.
	 */
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
			ruta = "ImagenesPatoDoble/Cayendo/";
		}
		if(pato == 5) {
			ruta = "ImagenesPatoBoss/Cayendo/";
		}
	}
	
	/**
	 * Define la ruta impactado del ave.
	 */
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
			ruta = "ImagenesPatoDoble/Impactado/";
		}
		if(pato == 5) {
			ruta = "ImagenesPatoBoss/Impactado/";
		}		
	}
	
	/**
	 * Informa si el ave esta en el suelo. Se usa cuando el ave muere y cae al suelo.
	 * @return flag, variable con valor booleano que indica si el ave esta en el suelo
	 */
	public boolean enSuelo() {
		boolean flag = false;
		if(fila >=  pisoY) {
			flag = true;
		}
		return flag;
	}
	
	/**
	 * desaparece el ave de la pantalla de juego luego de morir y llegar al suelo.
	 */
	public void desaparecer() {
		fila = 10000;
		col = 10000;
	}
	
	/**
	 * Le indica al pato que debe salir de la pantalla.
	 */
	public void irse() {
		moverFila = -velocidad;
		definirDireccion();
	}
	
	/**
	 * retorna un cambio de posicion en x del pato.
	 * @return, delta del movimiento en x del pato.
	 */
	public int getMoverCol() {
		return moverCol;
	}
	
	/**
	 * retorna un cambio de posicion en y del pato.
	 * @return, delta del movimiento en y del pato.
	 */
	public int getMoverFila() {
		return moverFila;
	}
}