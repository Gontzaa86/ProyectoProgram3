package Pacman;

import java.awt.Color;
import java.awt.Graphics;

public class Puntos extends juegoContenidoPacman{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.white);
		for (int i=0; i<contPunto; i++) {
			if (i == 0 || i==12 || i==156 || i == 168) {
				g.fillOval(puntoX.get(i), puntoY.get(i), CUADRITO_SIZE, CUADRITO_SIZE);
			}else {
				g.fillOval(puntoX.get(i), puntoY.get(i), 5, 5); //posicion x,y tamaño x,y
			}
		}
		
	}
}
