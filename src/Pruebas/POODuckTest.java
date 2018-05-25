package Pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import aplicacion.*;

class POODuckTest {

	@Test
	public void unPatoNormalDeberiaMorirConUnDisparoEnElCuerpo() {
		ArrayList<Pato> patos = new ArrayList<Pato>();
		Pato p = new Pato();
		patos.add(p);
		Bala b = new Bala(patos);
		int[] posiciones = {30,40,-10,10};
		p.ubicar(posiciones);
		b.disparar(57,67);
		assertFalse(p.isAlive());
	}
	
	@Test
	public void unPatoNormalDeberiaMorirConUnDisparoEnLaCabeza() {
		ArrayList<Pato> patos = new ArrayList<Pato>();
		Pato p = new Pato();
		patos.add(p);
		Bala b = new Bala(patos);
		int[] posiciones = {30,40,-10,10};
		p.ubicar(posiciones);
		b.disparar(39, 67);
		assertFalse(p.isAlive());
	}
	
	@Test
	public void unPatoNormalNoDeberiaMorirConUnDisparoQueFallo() {
		ArrayList<Pato> patos = new ArrayList<Pato>();
		Pato p = new Pato();
		patos.add(p);
		Bala b = new Bala(patos);
		int[] posiciones = {30,40,-10,10};
		p.ubicar(posiciones);
		b.disparar(57 + 28, 67);
		assertTrue(p.isAlive());
	}
	
	@Test
	public void unPatoVelozDeberiaMorirConUnDisparoEnElCuerpo() {
		ArrayList<Pato> patos = new ArrayList<Pato>();
		PatoVeloz p = new PatoVeloz();
		patos.add(p);
		Bala b = new Bala(patos);
		int[] posiciones = {30,40,-10,10};
		p.ubicar(posiciones);
		b.disparar(57,67);
		assertFalse(p.isAlive());
	}
	
	@Test
	public void unPatoVelozDeberiaMorirConUnDisparoEnLaCabeza() {
		ArrayList<Pato> patos = new ArrayList<Pato>();
		PatoVeloz p = new PatoVeloz();
		patos.add(p);
		Bala b = new Bala(patos);
		int[] posiciones = {30,40,-10,10};
		p.ubicar(posiciones);
		b.disparar(39, 67);
		assertFalse(p.isAlive());
	}
	
	@Test
	public void unPatoVelozNoDeberiaMorirConUnDisparoQueFallo() {
		ArrayList<Pato> patos = new ArrayList<Pato>();
		PatoVeloz p = new PatoVeloz();
		patos.add(p);
		Bala b = new Bala(patos);
		int[] posiciones = {30,40,-10,10};
		p.ubicar(posiciones);
		b.disparar(57 + 28, 67);
		assertTrue(p.isAlive());
	}
	
	@Test
	public void unPatoBlindadoDeberiaMorirConUnDisparoEnLaCabeza() {
		ArrayList<Pato> patos = new ArrayList<Pato>();
		PatoBlindado p = new PatoBlindado();
		patos.add(p);
		Bala b = new Bala(patos);
		int[] posiciones = {30,40,-10,10};
		p.ubicar(posiciones);
		b.disparar(39, 67);
		assertFalse(p.isAlive());
	}
	
	@Test
	public void unPatoBlindadoNoDeberiaMorirConUnDisparoEnElCuerpo() {
		ArrayList<Pato> patos = new ArrayList<Pato>();
		PatoBlindado p = new PatoBlindado();
		patos.add(p);
		Bala b = new Bala(patos);
		int[] posiciones = {30,40,-10,10};
		p.ubicar(posiciones);
		b.disparar(57,67);
		assertTrue(p.isAlive());
	}
	
	@Test
	public void unPatoDobleDeberiaMorirConDosDisparos() {
		ArrayList<Pato> patos = new ArrayList<Pato>();
		Pato p = new PatoDoble();
		patos.add(p);
		Bala b = new Bala(patos);
		int[] posiciones = {30,40,-10,10};
		p.ubicar(posiciones);
		b.disparar(57,67);
		Bala c = new Bala(patos);		
		c.disparar(57,67);
		assertFalse(p.isAlive());
	}
	
	@Test
	public void unPatoDobleNoDeberiaMorirConUnDisparo() {
		ArrayList<Pato> patos = new ArrayList<Pato>();
		Pato p = new PatoDoble();
		patos.add(p);
		Bala b = new Bala(patos);
		int[] posiciones = {30,40,-10,10};
		p.ubicar(posiciones);
		b.disparar(57,67);
		assertTrue(p.isAlive());
	}
	
	@Test
	public void unPatoBossDeberiaMorirConTresDisparos() {
		ArrayList<Pato> patos = new ArrayList<Pato>();
		Pato p = new PatoBoss();
		patos.add(p);
		Bala b = new Bala(patos);
		int[] posiciones = {30,40,-10,10};
		p.ubicar(posiciones);
		b.disparar(57,67);
		Bala c = new Bala(patos);		
		c.disparar(57,67);
		Bala d = new Bala(patos);		
		d.disparar(57,67);
		assertFalse(p.isAlive());
	}
	
	@Test
	public void unPatoBossNoDeberiaMorirConMenosDeTresDisparos() {
		//dos disparos
		ArrayList<Pato> patos = new ArrayList<Pato>();
		Pato p = new PatoBoss();
		patos.add(p);
		Bala b = new Bala(patos);
		int[] posiciones = {30,40,-10,10};
		p.ubicar(posiciones);
		b.disparar(57,67);
		Bala c = new Bala(patos);		
		c.disparar(57,67);
		assertTrue(p.isAlive());
		//un disparo
		ArrayList<Pato> patos2 = new ArrayList<Pato>();
		Pato p2 = new PatoBoss();
		patos2.add(p2);
		Bala b2 = new Bala(patos2);
		int[] posiciones2 = {30,40,-10,10};
		p2.ubicar(posiciones2);
		b2.disparar(57,67);
		assertTrue(p.isAlive());
	}
	
	@Test
	public void unPatoNormalDeberiaDarCiertoPuntaje() {
		ArrayList<Pato> patos = new ArrayList<Pato>();
		Pato p = new Pato();
		patos.add(p);
		Bala b = new Bala(patos);
		int[] posiciones = {30,40,-10,10};
		p.ubicar(posiciones);
		b.disparar(57,67);
		assertEquals(100, b.getPuntaje());
	}
	
	@Test
	public void unPatoRapidoDeberiaDarCiertoPuntaje() {
		ArrayList<Pato> patos = new ArrayList<Pato>();
		Pato p = new PatoVeloz();
		patos.add(p);
		Bala b = new Bala(patos);
		int[] posiciones = {30,40,-10,10};
		p.ubicar(posiciones);
		b.disparar(57,67);
		assertEquals(150, b.getPuntaje());
	}
	
	@Test
	public void unPatoBlindadoDeberiaDarCiertoPuntaje() {
		ArrayList<Pato> patos = new ArrayList<Pato>();
		Pato p = new PatoBlindado();
		patos.add(p);
		Bala b = new Bala(patos);
		int[] posiciones = {30,40,-10,10};
		p.ubicar(posiciones);
		b.disparar(39, 67);
		assertEquals(250, b.getPuntaje());
	}
	
	@Test
	public void unPatoDobleDeberiaDarCiertoPuntaje() {
		ArrayList<Pato> patos = new ArrayList<Pato>();
		Pato p = new PatoDoble();
		patos.add(p);
		Bala b = new Bala(patos);
		Bala c = new Bala(patos);
		int[] posiciones = {30,40,-10,10};
		p.ubicar(posiciones);
		b.disparar(57, 67);
		c.disparar(57, 67);
		assertEquals(200, c.getPuntaje());
	}
	
	@Test
	public void unPatoBossDeberiaDarCiertoPuntaje() {
		ArrayList<Pato> patos = new ArrayList<Pato>();
		Pato p = new PatoBoss();
		patos.add(p);
		Bala b = new Bala(patos);
		Bala c = new Bala(patos);
		Bala d = new Bala(patos);
		int[] posiciones = {30,40,-10,10};
		p.ubicar(posiciones);
		b.disparar(57, 67);
		c.disparar(57, 67);
		d.disparar(57, 67);
		assertEquals(500, d.getPuntaje());
	}
	
	@Test
	public void unPatoNormalDeberiaDarCiertoPuntajeConBalaDoble() {
		ArrayList<Pato> patos = new ArrayList<Pato>();
		Pato p = new Pato();
		patos.add(p);
		DoblePuntaje b = new DoblePuntaje(patos);
		int[] posiciones = {30,40,-10,10};
		p.ubicar(posiciones);
		b.disparar(57,67);
		assertEquals(200, b.getPuntaje());
	}
	
	@Test
	public void unPatoRapidoDeberiaDarCiertoPuntajeConBalaDoble() {
		ArrayList<Pato> patos = new ArrayList<Pato>();
		Pato p = new PatoVeloz();
		patos.add(p);
		DoblePuntaje b = new DoblePuntaje(patos);
		int[] posiciones = {30,40,-10,10};
		p.ubicar(posiciones);
		b.disparar(57,67);
		assertEquals(300, b.getPuntaje());
	}
	
	@Test
	public void unPatoBlindadoDeberiaDarCiertoPuntajeConBalaDoble() {
		ArrayList<Pato> patos = new ArrayList<Pato>();
		Pato p = new PatoBlindado();
		patos.add(p);
		DoblePuntaje b = new DoblePuntaje(patos);
		int[] posiciones = {30,40,-10,10};
		p.ubicar(posiciones);
		b.disparar(39, 67);
		assertEquals(500, b.getPuntaje());
	}
	
	@Test
	public void unPatoDobleDeberiaDarCiertoPuntajeConBalaDoble() {
		ArrayList<Pato> patos = new ArrayList<Pato>();
		Pato p = new PatoDoble();
		patos.add(p);
		Bala b = new Bala(patos);
		DoblePuntaje c = new DoblePuntaje(patos);
		int[] posiciones = {30,40,-10,10};
		p.ubicar(posiciones);
		b.disparar(57, 67);
		c.disparar(57, 67);
		assertEquals(400, c.getPuntaje());
	}

	@Test
	public void unPatoBossDeberiaDarCiertoPuntajeConBalaDoble() {
		ArrayList<Pato> patos = new ArrayList<Pato>();
		Pato p = new PatoBoss();
		patos.add(p);
		Bala b = new Bala(patos);
		Bala c = new Bala(patos);
		DoblePuntaje d = new DoblePuntaje(patos);
		int[] posiciones = {30,40,-10,10};
		p.ubicar(posiciones);
		b.disparar(57, 67);
		c.disparar(57, 67);
		d.disparar(57, 67);
		assertEquals(1000, d.getPuntaje());
	}
	
	@Test
	public void unaBalaSalvavidasAlFallarDeberiaRecargarUnaBalaNormal() {
		ArrayList<Pato> patos = new ArrayList<Pato>();
		Pato p = new Pato();
		patos.add(p);		
		int[] posiciones = {30,40,-10,10};
		p.ubicar(posiciones);
		Cazador jugador = new Cazador(patos);
		jugador.incluyaBala('S', 1);
		jugador.disparar(0,0);
		Bala[] b = jugador.getBalas();
		assertEquals('N', b[0].getEfecto());
		assertEquals(1, b[0].getTipo());
	}
	
	@Test
	public void unaBalaSalvavidasAlAcertarNoDeberiaRecargarUnaBalaNormal() {
		ArrayList<Pato> patos = new ArrayList<Pato>();
		Pato p = new Pato();
		patos.add(p);		
		int[] posiciones = {30,40,-10,10};
		p.ubicar(posiciones);
		Cazador jugador = new Cazador(patos);
		jugador.incluyaBala('S', 1);
		jugador.disparar(57, 67);
		Bala[] b = jugador.getBalas();
		assertEquals('S', b[0].getEfecto());
		assertEquals(0, b[0].getTipo());
	}
	
	@Test
	public void unaBalaRicochetAlAcertarDeberiaRecargarTresBalasConEfectoRicochet() {
		ArrayList<Pato> patos = new ArrayList<Pato>();
		Pato p = new Pato();
		patos.add(p);		
		int[] posiciones = {30,40,-10,10};
		p.ubicar(posiciones);
		Cazador jugador = new Cazador(patos);
		jugador.incluyaBala('R', 1);
		jugador.disparar(57, 67);
		Bala[] b = jugador.getBalas();
		assertEquals('r', b[0].getEfecto());
		assertEquals('r', b[1].getEfecto());
		assertEquals('r', b[2].getEfecto());
	}
	
	@Test
	public void unaBalaConEfectoRicochetDeberiaMatarPatosEnUnRango() {
		ArrayList<Pato> patos = new ArrayList<Pato>();
		Pato p = new Pato();
		Pato p2 = new Pato();
		patos.add(p);
		patos.add(p2);
		int[] posiciones = {30,40,-10,10};
		int[] posiciones2 = {0,0,-10,10};
		p.ubicar(posiciones);
		p2.ubicar(posiciones2);
		Cazador jugador = new Cazador(patos);
		jugador.incluyaBala('R', 1);
		jugador.disparar(0, 0);
		jugador.disparar(20, 10);
		assertFalse(p2.isAlive());
	}
}
