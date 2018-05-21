package aplicacion;

public class PatoBoss extends Pato{

	public PatoBoss() {
		puntaje = 500;
		velocidad = 25;
		vida = 3;
		tamano = 110;
	}
	
	public int getTipo() {
		return 5;
	}
	
	public int impacto(int x, int y,int tipo) {
		return super.impacto(x, y, tipo);
	}
	
	public boolean isAlive() {
		return super.isAlive();
	}
	
}
