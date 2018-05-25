package presentacion;

public class PajaroGUI {
	
	private boolean dirArriba;
	private boolean dirAbajo;
	private boolean dirDerecha;
	private boolean dirIzquierda;
	private int moverX;
	private int moverY;
	private int vel;
	private int posX;
	private int posY;
	private String ruta;
	private int numImagen;
	private boolean isAlive;
	private boolean impactado;
	
	public PajaroGUI() {
		dirArriba = false;
		dirAbajo = false;
		dirDerecha = false;
		dirIzquierda = false;
		vel = 500;
		posX = 100;
		posY = 100;
		moverX = vel;
		moverY = vel;
		numImagen = 1;
		isAlive = true;
		impactado = false;
		derechaAbajo();
	}
	
	public boolean estaVivo() {
		return isAlive;
	}
	
	public boolean estaImpactado() {
		return impactado;
	}
	
	public void cambiarNum() {
		if(numImagen == 4) {
			numImagen = 0;
		}
		numImagen++;
	}
	
	public void moverX() {
		if(dirIzquierda) {
			moverX = vel*-1;
			posX += vel*-1;
		}
		if(dirDerecha){
			moverX= vel;
			posX += vel;
		}
	}
	
	public void moverY() {
		if(dirArriba) {
			moverY = vel*-1;
			posY += vel*-1;
		}
		if(dirAbajo){
			moverY = vel;
			posY += vel;
		}
	}
	
	public void asignarArriba() {
		dirArriba = true;
		dirAbajo = false;
	}
	
	public void asignarAbajo() {
		dirAbajo = true;
		dirArriba = false;
 	}
	
	public void asignarDerecha() {
		dirDerecha = true;
		dirIzquierda = false;
	}
	
	public void asignarIzquierda() {
		dirIzquierda = true;
		dirDerecha = false;
	}
	
	public void definirDireccion() {
		if(dirArriba) {
			if(dirDerecha) {
				derechaArriba();
			}
			else {
				izquierdaArriba();
			}
		}
		if(dirAbajo) {
			if(dirIzquierda) {
				izquierdaAbajo();
			}
			else {
				derechaAbajo();
			}
		}
		if(!dirAbajo && !dirArriba) {
			if(dirDerecha){				
				derechaAbajo();
			}
			if(dirIzquierda) {
				izquierdaAbajo();
			}
			else {
				derechaAbajo();
			}
		}
	}

	public boolean getArriba() {
		return dirArriba;
	}
	
	public boolean getAbajo() {
		return dirAbajo;
	}
	
	public boolean getDerecha() {
		return dirDerecha;
	}
	
	public boolean getIzquierda() {
		return dirIzquierda;
	}
	public String getRuta() {
		return ruta;
	}

	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	/**
	 * Define la ruta direccion derecha hacia abajo del ave.
	 */
	private void derechaAbajo() {
		ruta = "ImagenesPatoBoss/DerechaAbajo/"+numImagen+".png";		
	}
	
	/**
	 * Define la ruta direccion derecha hacia arriba del ave. 
	 */
	private void derechaArriba() {
		ruta = "ImagenesPatoBoss/DerechaArriba/"+numImagen+".png";		
	}
	
	/**
	 * Define la ruta direccion izquierda hacia arriba del ave.
	 */
	private void izquierdaArriba() {
		ruta = "ImagenesPatoBoss/IzquierdaArriba/"+numImagen+".png";	
	}
	
	/**
	 * Define la ruta direccion izquierda hacia abajo del ave.
	 */
	private void izquierdaAbajo() {
		ruta = "ImagenesPatoBoss/IzquierdaAbajo/"+numImagen+".png";		
	}
	
	/**
	 * Define la ruta cayendo del ave.
	 */
	private void cayendo() {
		ruta = "ImagenesPatoBoss/Cayendo/";
	}
	
	/**
	 * Define la ruta impactado del ave.
	 */
	private void impactadoP() {
		ruta = "ImagenesPatoBoss/Impactado/"+numImagen+".png";	
	}

	public void desAsignarIzquierda() {
		dirIzquierda = false;
	}

	public void desAsignarArriba() {
		dirArriba = false;
	}

	public void desAsignarDerecha() {
		dirDerecha = false;
	}

	public void desAsignarAbajo() {
		dirAbajo = false;
	}

	public int getMoverCol() {
		return moverX;
	}

	public int getMoverfila() {
		return moverY;
	}

	public void derribar() {
		impactado = true;
		impactadoP();
		isAlive = false;
	}
}