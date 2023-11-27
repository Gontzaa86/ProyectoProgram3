package Pacman;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Pacman.juegoContenidoPacman;

public class juegoVentanaPacman extends JFrame{
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
