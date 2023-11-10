package MenuInicial;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class VentanaInicio {

	public static void main(String... args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();

		//Añadir Juegos al ArrayList
		ArrayList<String> listaJuegos = new ArrayList<String>();
		listaJuegos.add("Snake");
		listaJuegos.add("Pac-Man");
		listaJuegos.add("Tic-Tac-Toe");
		listaJuegos.add("Juego4");
		listaJuegos.add("Juego5");
		listaJuegos.add("Juego6");


		if (listaJuegos != null)
		{
			for (String j : listaJuegos)
			{
				JButton botonJuego = new JButton();
				botonJuego.setPreferredSize(new Dimension(100, 200));
				botonJuego.setText(j.toString());
				botonJuego.setBounds((110 * listaJuegos.indexOf(j)), 0, 100, 180);
				botonJuego.setVerticalAlignment(SwingConstants.BOTTOM);
				panel.add(botonJuego);
			}
		}

		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 110, 480, 248);

		JPanel contentPane = new JPanel(null);
		contentPane.setPreferredSize(new Dimension(500, 400));
		contentPane.add(scrollPane);

		frame.setContentPane(contentPane);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
}