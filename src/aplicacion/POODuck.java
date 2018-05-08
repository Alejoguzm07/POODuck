package aplicacion;

import java.util.*;

public class POODuck {
	
	ArrayList<Pato> patos;
	
	public POODuck() {
		patos = new ArrayList<Pato>();
		
	}
	
	public ArrayList<Pato> getPatos(){
		return patos;
	}
	
	public void agregarPatos() {
		patos.add(new Pato());
		patos.add(new Pato());
		patos.add(new Pato());
	}

	public void disparo(int x, int y,int[] posiciones) {
		for(int i = 0; i < patos.size(); i++) {
			patos.get(i).impacto(x, y);
		}
	}
}
