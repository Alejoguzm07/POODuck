package presentacion;

import aplicacion.Pato;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.lang.*;
import javax.swing.event.*;

public class Tablero extends JPanel{
	
	private URL fondo = this.getClass().getResource("FondoOriginal.png");
	private Image imagenFondo = new ImageIcon(fondo).getImage();
	private Cursor mira;	
	private ImageIcon imagenMira = new ImageIcon(getClass().getResource("Mira.png"));
	private Toolkit Tk = Toolkit.getDefaultToolkit();
	private ArrayList<PatoGUI> patosGUI;
	
	public Tablero() {
		patosGUI = new ArrayList<PatoGUI>();
		prepareElementos();
	}
	
	public void iniciarJuego(ArrayList<Pato> p) {
		ArrayList<Pato> patos = p;
		for(int i = 0; i < patos.size(); i++) {
			Pato pt = patos.get(i);
			PatoGUI pa = new PatoGUI(this);			
			patosGUI.add(pa);
			this.add(pa);
			pa.iniciar(pt.getTipo(), pt.getVelocidad());
		}
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(imagenFondo,0,0,getWidth(),getHeight(),this);
	}
	
	private void prepareElementos() {
		this.mira = Tk.createCustomCursor(imagenMira.getImage(), new Point(1,1), "Mira.png");
		this.setCursor(mira);
	}
	
	public ArrayList<PatoGUI> getPatos(){
		return patosGUI;
	}
	
}
