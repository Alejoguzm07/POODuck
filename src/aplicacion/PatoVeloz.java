package aplicacion;

public class PatoVeloz extends Pato{
	
	/**
	 * crea un pato de tipo veloz
	 */
	public PatoVeloz() {
		puntaje = 150;
		velocidad = 15;
	}
	
	/**
	 * crea un objeto de tipo pato
	 */
	public int getTipo() {
		return 2;
	}
	
	/**
	 * determina si el pato fue impactado.
	 * @param x, posicion x de un disparo.
	 * @param y, posicion y de un disparo.
	 * @param ef, efecto de bala disparada.
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
