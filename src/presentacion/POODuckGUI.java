package presentacion;

import java.util.*;
import java.util.Timer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.URL;
import aplicacion.POODuck;
import java.lang.*;
import javax.swing.event.*;


public class POODuckGUI extends JFrame{	

	private MenuInicial menu;
	private POODuck juego;
	private JPanel tablero;
	private URL fondoUnJugador = this.getClass().getResource("FondoUnJugador.png");
	private Image imagenFondoUnJugador = new ImageIcon(fondoUnJugador).getImage();
	private URL fondoMultijugador = this.getClass().getResource("FondoMultijugador.png");
	private Image imagenFondoMultijugador = new ImageIcon(fondoMultijugador).getImage();
	private ArrayList<PatoGUI> patosGUI;
	private ImageIcon imagenMira = new ImageIcon(getClass().getResource("Mira.png"));
	private Toolkit Tk = Toolkit.getDefaultToolkit();
	private Cursor mira;
	
	public POODuckGUI(){
		prepareElementos();
		prepareAcciones();	
	}	

	public static void main(String[] args) {
		POODuckGUI gui = new POODuckGUI();				
	}
	
	private void prepareElementos(){
		setTitle("POODuck");
		setResizable(false);
		ajustarTamano();
		centrar();
		menu = new MenuInicial(this);
		this.mira = Tk.createCustomCursor(imagenMira.getImage(), new Point(1,1), "Mira.png");
		this.setCursor(mira);
		
	}
	
	public void unJugador(int nump){
		JPanel tablero = new JPanel() {
			public void paint(Graphics g) {
				g.drawImage(imagenFondoUnJugador,0,0,getWidth(),getHeight(),this);
			}
		};
		GridLayout layoutTablero = new GridLayout(1,1);
    	tablero.setLayout(layoutTablero);
		getContentPane().add(tablero);
		setVisible(true);
		juego = new POODuck();
		juego.inicieRonda(nump);
		Timer tiempoRonda = new Timer();
		TimerTask tarea = new TimerTask() {
			@Override
			public void run() {
				patosGUI = new ArrayList<PatoGUI>();
				for(int i = 0; i < nump; i++) {
					boolean estaVivo = juego.isAlive(i);
					String tipoPato = juego.getTipo(i);
					int[] posPato = juego.getPosicion(i);
					patosGUI.add(new PatoGUI(tablero, posPato, tipoPato));
				}
			}
		};
		tiempoRonda.schedule(tarea, 1000, 2000000);
		Timer actualizacion = new Timer();
		TimerTask actualizar = new TimerTask() {
			@Override
			public void run() {
				for(int i = 0; i < nump; i++) {
					boolean estaVivo = juego.isAlive(i);
					int dirPato = juego.getDireccion(i);
					int[] posPato = juego.getPosicion(i);
					patosGUI.get(i).actualizar(posPato, dirPato, estaVivo);
				}
			}
		};
		actualizacion.schedule(actualizar,2000, 100);
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