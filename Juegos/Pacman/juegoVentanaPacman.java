package Pacman;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class juegoVentanaPacman extends JFrame{
/**
	 * 
	 */
	juegoContenidoPacman juegocontenido;
	int tiempo;
	
	private static final long serialVersionUID = 1L;
	
	public juegoVentanaPacman(int velocidad) {
		
		juegocontenido= new juegoContenidoPacman(velocidad);
		this.setTitle("Pac-man");
		getContentPane().add(juegocontenido);
		juegocontenido.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false); //No poder aumentar
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		juegocontenido.finish = true;
		
		JTextArea textPuntuacion = new JTextArea();
		textPuntuacion.setForeground(new Color(255, 255, 255));
		textPuntuacion.setBounds(580, 70, 90, 43);	
		textPuntuacion.setFont(new Font("Calisto MT", Font.BOLD, 20));
		textPuntuacion.setOpaque(false);
		juegocontenido.add(textPuntuacion);
		
		JTextArea textCronometro = new JTextArea();
		textCronometro.setForeground(new Color(255, 255, 255));
		textCronometro.setBounds(580, 180, 90, 43);	
		textCronometro.setFont(new Font("Calisto MT", Font.BOLD, 20));
		textCronometro.setOpaque(false);
		juegocontenido.add(textCronometro);
		
		Thread hilo = new Thread() {
			public void run() {
				while (juegocontenido.finish) {
					try {
						Thread.sleep(1);
						textPuntuacion.setText(String.valueOf(juegocontenido.puntuacion));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		hilo.start();
		
		Thread hilo2 = new Thread() {
			int cronometro = 0;
			public void run() {
				while (juegocontenido.finish) {
					try {
						textCronometro.setText(String.valueOf(cronometro));
						Thread.sleep(1000);
						cronometro++;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		hilo2.start();
		
		JLabel lblPuntuacion = new JLabel("Puntuación");
		lblPuntuacion.setForeground(new Color(255, 255, 255));
		lblPuntuacion.setBackground(new Color(0, 0, 0));
		lblPuntuacion.setBounds(550, 30, 140, 43);
		lblPuntuacion.setFont(new Font("Calisto MT", Font.BOLD, 20));
		juegocontenido.add(lblPuntuacion);
		
		JLabel lblCronometro = new JLabel("Tiempo");
		lblCronometro.setForeground(new Color(255, 255, 255));
		lblCronometro.setBackground(new Color(0, 0, 0));
		lblCronometro.setBounds(550, 140, 140, 43);
		lblCronometro.setFont(new Font("Calisto MT", Font.BOLD, 20));
		juegocontenido.add(lblCronometro);
	}
}