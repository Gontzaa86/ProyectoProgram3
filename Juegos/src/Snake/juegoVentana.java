package Snake;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class juegoVentana extends JFrame {
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
		
		JLabel lblHierba = new JLabel("New label");
		lblHierba.setIcon(new ImageIcon("C:\\Users\\antonio.cancio\\OneDrive - Universidad de Deusto\\Documentos\\2º Ingeniería\\Programacion3\\Juegos\\Retro\\src\\Snake3\\hierba.jpg"));
		lblHierba.setBounds(0, 0, 500, 500);
		getContentPane().add(lblHierba);
		//juegocontenido.add(lblHierba); para modificar tamaño
	}
}
