package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SeleccionOtros extends Seleccion{
	
	private JButton instrucciones;
	private static SeleccionOtros selection;
	private JButton puntajes;		
	
	/**
	 * Crea una ventana con otras opciones.
	 * @param gui, recibe el tablero de juego.
	 * @param menuI, recibe el menu inicial.
	 */
	private SeleccionOtros(POODuckGUI gui, MenuInicial menuI) {
		super(gui, menuI);
	}
	
	/**
	 * crea una unica ventana de seleccion de otras opciones
	 * @param juego, el tablero de juego
	 * @param menuInicial, el menu inical
	 * @return un objeto de tipo SeleccionOtros.
	 */
	public static SeleccionOtros instanceSeleccionOtros(POODuckGUI juego, MenuInicial menuInicial) {
		if (selection == null){
			selection = new SeleccionOtros(juego,menuInicial);			
        }
		return selection;
	}

	/**
	 * Prepara los elementos necesarios para mostrar la ventana otras opciones.
	 */
	protected void prepareElementos() {
		setTitle("OTROS");
		ajustarTamano();
		centrar();
		botones = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(imagenFondo,0,0,getWidth(),getHeight(),this);
			}
		};
		botones.setLayout(null);
		prepararBotones();
		contentPane.add(botones,BorderLayout.CENTER);
		setVisible(true);		
	}

	/**
	 * Prepara y ajusta todos los botones a mostrar en la ventana de seleccion de otras opciones.
	 */
	protected void prepararBotones() {
		instrucciones = new JButton("<html><p align=\"center\">Como</p><p align=\"center\">Jugar</p>");
		puntajes = new JButton("<html><p align=\"center\">Maximos</p><p align=\"center\">Puntajes</p>");
		volver = new JButton("Volver");
		estetica();
		botones.add(instrucciones);
		botones.add(puntajes);
		botones.add(volver);		
	}

	/**
	 * Ajusta el tamano de los botones en pantalla.
	 */
	protected void tamano() {
		int x = this.getWidth();
		int y = this.getHeight();
		instrucciones.setSize(x/3, y/3 + 10);
		puntajes.setSize(x/3, y/3 + 10);
		volver.setSize(x/3, y/8);		
	}

	/**
	 * Ajusta la posicion de los botones en pantalla.
	 */
	protected void posicion() {
		int x = this.getWidth();
		int y = this.getHeight();
		instrucciones.setLocation((x - (x / 3))/10, (y - (y / 8)) / 5);
		puntajes.setLocation((x - (x / 3) - x/8), (y - (y / 8)) / 5);
		volver.setLocation((x - (x / 3))/2, (y - (y / 3) - 20));
	}

	/**
	 * Ajusta las animaciones de los botones en pantalla.
	 */
	protected void animaciones() {
		instrucciones.setBorder(null);
		puntajes.setBorder(null); 
		volver.setBorder(null); 	
		instrucciones.setFocusable(false);	
		puntajes.setFocusable(false);	 
		volver.setFocusable(false);	
	}

	/**
	 * Ajusta las animaciones de los botones en pantalla.
	 */
	protected void colorFondo() {
		instrucciones.setBackground(colorBoton);
		puntajes.setBackground(colorBoton);
		volver.setBackground(colorBoton);		
	}

	/**
	 * Ajusta los textos de los elementos en pantalla.
	 */
	protected void fuentes() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int y = pantalla.height;
		instrucciones.setForeground(colorFuente); 
		puntajes.setForeground(colorFuente); 
		volver.setForeground(colorFuente);	
		instrucciones.setFont(new Font("Gill Sans Ultra Bold",0,y / 18)); 
		puntajes.setFont(new Font("Gill Sans Ultra Bold",0,y / 20)); 
		volver.setFont(new Font("Gill Sans Ultra Bold",0,y / 16));
	}

	/**
	 * Asigna funcionalidades a los botones en pantalla.
	 */
	protected void prepareAcciones() {
		ActionListener oyenteBotonInstrucciones = new ActionListener(){
			public void actionPerformed(ActionEvent we){
			}
		};
		ActionListener oyenteBotonPuntajes = new ActionListener(){
			public void actionPerformed(ActionEvent we){
			}
		};
		ActionListener oyenteBotonVolver = new ActionListener(){
			public void actionPerformed(ActionEvent we){
				atras();
			}
		};
		instrucciones.addActionListener(oyenteBotonInstrucciones);
		puntajes.addActionListener(oyenteBotonPuntajes);
		volver.addActionListener(oyenteBotonVolver);
	}

}
