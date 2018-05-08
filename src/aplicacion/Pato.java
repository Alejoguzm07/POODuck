package aplicacion;

public class Pato {
	private int vida;
	private int puntaje;
	private boolean vivo;
	private int velocidad;
	private int cuerpoX;
	private int cuerpoY;
	private int cabezaX;
	private int cabezaY;
	
	public Pato() {
		vida = 1;
		puntaje = 100;
		vivo = true;
		velocidad = 150;		
	}
	
	public String getTipo() {
		return "Recursos/ImagenesPatoNormal";
	}
	
	public int getVelocidad() {
		return velocidad;
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
	
	private boolean isAlive() {
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
		}		
	}
	
}
