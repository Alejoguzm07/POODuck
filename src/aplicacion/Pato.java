package aplicacion;

import java.util.Random;

public class Pato implements Impactable{
	private int vida;
	private int puntaje;
	private boolean vivo;
	private int delta;
	private int cuerpoX;
	private int cuerpoY;
	private int cabezaX;
	private int cabezaY;
	private int cambioPosicion;
	private final int[] direcciones = {1,7,6,2,3,4};
	private int direccion;
	private int ancho;
	private int alto;
	
	public Pato() {
		vida = 1;
		puntaje = 100;
		vivo = true;
		delta = 10;
		cambioPosicion = 0;
		direccion = 2;
	}
	
	public String getTipo() {
		return "Recursos/ImagenesPatoNormal";
	}
	
	public int getDelta() {
		return delta;
	}
	
	public int[] getCuerpo() {
		int[] cpo = new int[2];
		cpo[0] = cuerpoX;
		cpo[1] = cuerpoY;
		return cpo;
	}
	
	public int[] getCabeza() {
		int[] cbz = new int[2];
		cbz[0] = cabezaX;
		cbz[1] = cabezaY;
		return cbz;
	}
	
	public boolean isAlive() {
		return vivo;
	}
	
	public void ubicar(int[] posiciones) {
		cuerpoX = posiciones[0];
		cuerpoY = posiciones[1];
		cabezaX = posiciones[2];
		cabezaY = posiciones[3];
	}

	public void impacto(int x, int y) {
		int distCabeza = (int) Math.hypot(cabezaX - x, cabezaY - y);
		int distCuerpo = (int) Math.hypot(cuerpoX - x, cuerpoY - y);
		if(distCabeza <= 10 || distCuerpo <= 40) {
			vida--;
			muerto();
		}
	}

	private void muerto() {
		if(vida == 0) {
			vivo = false;
			direccion = 5;
		}		
	}

	public void vayase() {
		
	}
	
	public void mover() {
		if(direccion == 5) {
			desplomar();
		}
		else {
			cambioPosicion++;
			if(cambioPosicion == 30 || cabezaX > 1000 || cabezaX < 0 || cabezaY < 0 || cuerpoY > 12 ) {
				cambiarDireccion();
			}
			cambiarPosicion();
		}
	}
	
	private void desplomar() {
		if(cuerpoY <= 12) {
			cabezaY -= delta;
			cuerpoY -= delta;
		}
	}

	private void cambiarPosicion() {
		switch ( direccion ) {
			case 1:
				cabezaX -= delta;
				cabezaY += delta;
				cuerpoX -= delta;
				cuerpoY += delta;
			case 2:
				cabezaX += delta;
				cabezaY += delta;
				cuerpoX += delta;
				cuerpoY += delta;
			case 3:
				cabezaX += delta;
				cuerpoX += delta;
			case 4: 
				cabezaX += delta;
				cuerpoX += delta;
				cabezaY -= delta;
				cuerpoY -= delta;
			case 6: 
				cabezaX -= delta;
				cuerpoX -= delta;
				cabezaY -= delta;
				cuerpoY -= delta;
			case 7:
				cabezaX -= delta;
				cuerpoX -= delta;
		}
	}

	private void cambiarDireccion() {
		Random rnd = new Random();
		int num = rnd.nextInt()%6;
		if(direcciones[num] != direccion) {
			direccion = direcciones[num];
			switch ( direccion ) {
				case 1: 
				case 2: 
				case 3: 
				case 4: 
				case 6: 
				case 7: 
			}
		}
	}
	
	public int getDireccion() {
		return direccion;
	}
}
