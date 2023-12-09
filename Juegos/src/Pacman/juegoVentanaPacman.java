package Pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Snake.juegoMenu;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class juegoVentanaPacman extends JFrame{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Icon icon;
	public juegoVentanaPacman() {
		
		juegoContenidoPacman juegocontenido = new juegoContenidoPacman();
		this.setTitle("Pac-man");
		getContentPane().add(juegocontenido);
		juegocontenido.setLayout(null);
		//juegocontenido.setOpaque(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//this.setResizable(false); //No poder aumentar
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 510, 510);
		getContentPane().add(lblFondo);
		SetImageLabel(lblFondo, juegoVentanaPacman.class.getResource("Escenario.png"));
	}
	private void SetImageLabel (JLabel labelName, URL url) {
		ImageIcon image = new ImageIcon(url);
		icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(),labelName.getHeight(),Image.SCALE_AREA_AVERAGING));
		labelName.setIcon(icon);
		this.repaint();
	}
}