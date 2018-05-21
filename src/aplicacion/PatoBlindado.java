package aplicacion;

public class PatoBlindado extends Pato{
	
	public PatoBlindado() {
		puntaje = 250;
		velocidad = 8;
	}
	
	public int getTipo() {
		return 3;
	}
	
	public boolean isAlive() {
		return super.isAlive();
	}
	
	public int impacto(int x, int y, int tipo) {
		int pun = 0;
		if(vivo) {
			int radio = tamano / 2;
			if(tipo == 2) {
				radio = 5 * 55;
			}
			int distCabeza = (int) Math.hypot(cabezaX - x, cabezaY - y);
			if(distCabeza <= radio / 2) {
				vida--;
				if(muerto()) {
					pun = puntaje;
				}
			}
		}
		return pun;		
	}
}
