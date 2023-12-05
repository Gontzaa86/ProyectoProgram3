package Snake;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

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
		
		JLabel lblHierba = new JLabel("New label");
		lblHierba.setIcon(new ImageIcon(juegoVentana.class.getResource("hierba.jpg")));
		lblHierba.setBounds(0, 0, 500, 500);
		getContentPane().add(lblHierba);
		//juegocontenido.add(lblHierba); para modificar tamaño
	}
}
