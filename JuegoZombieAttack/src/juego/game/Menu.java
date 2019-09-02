package juego.game;

import java.awt.CardLayout;
import juego.paneles.MenuPanel;

public class Menu {
	
	private MenuPanel pnlMenu; // PANEL DEL MENU, INTERFAZ DEL MENU.
	private Game juego; // OBJETO QUE CONTIENE LA VENTANA PRINCIPAL DE LA APLICACION. (JFRAME)
	private Boolean cliente;
	
	public Menu(Game juego, boolean cliente) {
		this.cliente = cliente;
		this.juego=juego;
		init();
		
	}

	public void init() {
		// TODO Auto-generated method stub
		if(cliente)
			pnlMenu=new MenuPanel(juego, cliente); // INICIALIZAMOS LA INTERFAZ DEL MENU
		else
			pnlMenu=new MenuPanel(juego, false);
		juego.getVentana().getPnlVista().add(pnlMenu, "Menu"); // AGREGAMOS EL PANEL DEL MENU AL CARDLAYOUT DE LA VENTANA PRINCIPAL.
	}


	// ESTE METODO MUESTRA EL PANEL DEL MENU.
	public void show() {
		// TODO Auto-generated method stub
		CardLayout c=(CardLayout) juego.getVentana().getPnlVista().getLayout(); // OBTENEMOS EL LAYOUT DE LA VENTANA.
		c.show(juego.getVentana().getPnlVista(), "Menu"); // MOSTRAMOS EN PANTALLA EL PANEL QUE CONTIENE LA INTERFAZ DEL MENU.
		juego.getVentana().setVisible(true); // HACEMOS VISIBLE LA VENTANA.
		
		//Recursos.audioMenu.loop(); // EJECUTAMOS AL SONIDO DE FORMA INFINITA.
	}
}
