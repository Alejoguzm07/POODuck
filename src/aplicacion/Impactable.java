package aplicacion;

public interface Impactable {
	
	/**
	 * Le otorga a un objeto la habilidad de ser impactado.
	 * @param x, posicion x de un disparo.
	 * @param y, posicion y de un disparo.
	 * @param tipo, tipo de bala disparada.
	 * @return, devuelve el puntaje obtenido en el disparo.
	 */
	public int impacto(int x, int y, int tipo);
}
