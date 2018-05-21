package aplicacion;

public class PatoDoble extends Pato{
	public PatoDoble() {
		puntaje = 200;
		vida = 2;
		velocidad = 10;
	}
	
	public int getTipo() {
		return 4;
	}
	
	public int impacto(int x, int y, int tipo) {
		return super.impacto(x, y, tipo);
	}
	
	public boolean isAlive() {
		return super.isAlive();
	}
}
