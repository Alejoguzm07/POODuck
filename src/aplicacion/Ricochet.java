package aplicacion;

import java.util.ArrayList;

public class Ricochet extends Bala{
	
	/**
	 * Crea una bala de tipo Ricochet.
	 * @param pts, recibe un areglo de patos a ser impactados.
	 */
	public Ricochet(ArrayList<Pato> pts) {
		super(pts);
		tipo = 2;
		efecto = 'R';
	}
}
