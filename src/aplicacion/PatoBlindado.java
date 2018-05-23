package aplicacion;

public class PatoBlindado extends Pato{
	
	/**
	 * crea un pato blindado
	 */
	public PatoBlindado() {
		puntaje = 250;
		velocidad = 8;
	}
	
	/**
	 * indica el tipo de pato.
	 * @return un entero indicando el tipo de pato.
	 */
	public int getTipo() {
		return 3;
	}
	
	/**
	 * indica si el pato esta vivo
	 * @return devuelve un booleano indicando si el pato esta vivo
	 */
	public boolean isAlive() {
		return super.isAlive();
	}
	
	/**
	 * determina si el pato fue impactado en la cabeza.
	 * @param x, posicion x de un disparo.
	 * @param y, posicion y de un disparo.
	 * @param tipo, tipo de bala disparada.
	 * @return, devuelve el puntaje obtenido en el disparo.
	 */
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
