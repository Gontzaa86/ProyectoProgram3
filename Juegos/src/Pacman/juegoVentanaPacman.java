package Pacman;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class juegoVentanaPacman extends JFrame{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public juegoVentanaPacman() {
		
		juegoContenidoPacman juegocontenido = new juegoContenidoPacman();
		this.setTitle("Pac-man");
		getContentPane().add(juegocontenido);
		juegocontenido.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//this.setResizable(false); //No poder aumentar
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}