package Snake;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class juegoVentana extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public juegoVentana(int velocidad, boolean bloque, boolean pared) {
		
		juegoContenido juegocontenido = new juegoContenido(velocidad,bloque,pared);
		this.setTitle("Serpiente");
		getContentPane().add(juegocontenido);
		//juegocontenido.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false); //No poder aumentar
		this.pack();
		this.setLocationRelativeTo(null);
		juegocontenido.setOpaque(false);
		this.setVisible(true);
		
		int puntuacionActual = juegocontenido.puntuacion;

		
		JLabel textoPuntos = new JLabel();
		textoPuntos.setForeground(new Color(255, 128, 64));
		textoPuntos.setHorizontalAlignment(SwingConstants.CENTER);
		textoPuntos.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		textoPuntos.setBounds(382, 0, 118, 42);
		textoPuntos.setText(String.valueOf(puntuacionActual));
		juegocontenido.add(textoPuntos);
		
		
		JLabel lblHierba = new JLabel("New label");
		lblHierba.setIcon(new ImageIcon(juegoVentana.class.getResource("hierba.jpg")));
		lblHierba.setBounds(0, 0, 500, 500);
		getContentPane().add(lblHierba);
		//juegocontenido.add(lblHierba); Para modificar tamaño	
	}
	
}
