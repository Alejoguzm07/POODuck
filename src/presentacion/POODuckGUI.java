package presentacion;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import aplicacion.*;
import java.lang.*;
import javax.swing.event.*;


public class POODuckGUI extends JFrame{	
	
	private Container contentPane;
	private MenuInicial menu;
	private POODuck juego;
	private JLayeredPane tablero;
	
	public POODuckGUI(){
		prepareElementos();
		prepareAcciones();	
	}	

	public static void main(String[] args) {
		POODuckGUI gui = new POODuckGUI();				
	}
	
	private void prepareElementos(){
		contentPane = getContentPane();
		setTitle("POODuck");
		setResizable(false);
		menu = new MenuInicial(this);
	}
	
	public void unJugador(int nump){
		setVisible(true);
		ajustarTamano();
		centrar();		
	}
	
	public void unJugador(String dif){
		setVisible(true);
		ajustarTamano();
		centrar();		
	}
	
	public void multijugador(){
		setVisible(true);
		ajustarTamano();
		centrar();	
	}
	
	private void prepareAcciones(){
		WindowAdapter oyenteCerrarVentana = new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				salga();
			}
		};
		addWindowListener(oyenteCerrarVentana);
		MouseAdapter disparadorMouse = new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				//disparo(arg0.getX(),arg0.getY());
			}
			
		};
		addMouseListener(disparadorMouse);
	}
	
	private void salga(){
		int respuesta = JOptionPane.showConfirmDialog(this,"Are you sure?","Exit",JOptionPane.YES_NO_OPTION);
		if(respuesta == JOptionPane.YES_OPTION){
			juego = null;
			setVisible(false);
			menu.setVisible(true);
		}
		else{
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		}
	}
	
	private void ajustarTamano() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int x = pantalla.width;
		int y = pantalla.height;
		setSize(x * 92/100, y * 46/50);
	}
	
	private void centrar() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (pantalla.width - getSize().width) / 2;
		int y = (pantalla.height - getSize().height) / 2 - pantalla.height*1/30;
		setLocation(x,y);
	}
}