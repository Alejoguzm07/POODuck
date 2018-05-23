package aplicacion;

public class PatoDoble extends Pato{
	
	/**
	 * crea un pato de tipo doble
	 */
	public PatoDoble() {
		puntaje = 200;
		vida = 2;
		velocidad = 10;
	}
	
	/**
	 * indica el tipo de pato
	 * @return un entero indicando el tipo de pato
	 */
	public int getTipo() {
		return 4;
	}
	
	/**
	 * determina si el pato fue impactado.
	 * @param x, posicion x de un disparo.
	 * @param y, posicion y de un disparo.
	 * @param tipo, tipo de bala disparada.
	 * @return, devuelve el puntaje obtenido en el disparo.
	 */
	public int impacto(int x, int y, char ef) {
		return super.impacto(x, y, ef);
	}
	
	/**
	 * indica si el pato esta vivo
	 * @return devuelve un booleano indicando si el pato esta vivo
	 */
	public boolean isAlive() {
		return super.isAlive();
	}
}
