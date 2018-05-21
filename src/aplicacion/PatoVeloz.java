package aplicacion;

public class PatoVeloz extends Pato{
	public PatoVeloz() {
		puntaje = 150;
		velocidad = 15;
	}
	
	public int getTipo() {
		return 2;
	}
	
	public int impacto(int x, int y, int tipo) {
		return super.impacto(x, y, tipo);
	}
	
	public boolean isAlive() {
		return super.isAlive();
	}
}
