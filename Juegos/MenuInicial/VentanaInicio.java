package MenuInicial;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import Pacman.InicioPacman;
import Snake.InicioSnake;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInicio {

	public static void main(String... args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();

		//ArrayList con los juegos
		ArrayList<Main> listaJuegos = new ArrayList<Main>();
		listaJuegos.add(new InicioSnake());		//Index 0
		listaJuegos.add(new InicioPacman());	//Index 1

		if (listaJuegos != null)
		{
			for (Main juego : listaJuegos)
			{
				JButton botonJuego = new JButton();
				botonJuego.setPreferredSize(new Dimension(100, 185));
				botonJuego.setText(juego.toString());
				botonJuego.setBounds((110 * listaJuegos.indexOf(juego)), 0, 100, 200);
				botonJuego.setVerticalAlignment(SwingConstants.BOTTOM);
				panel.add(botonJuego);

				botonJuego.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{	
						if(listaJuegos.indexOf(juego) == 0)
						{
							juego.iniciarSnake();
						}
						
						if(listaJuegos.indexOf(juego) == 1)
						{
							juego.iniciarPacMan();
						}	
					}

				});
			}
		}

		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 110, 480, 237);

		JPanel contentPane = new JPanel(null);
		contentPane.setPreferredSize(new Dimension(500, 400));
		contentPane.add(scrollPane);

		frame.setContentPane(contentPane);

		JLabel textoTitulo = new JLabel("Juegos Arcade");
		textoTitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		textoTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		textoTitulo.setBounds(10, 23, 480, 32);
		contentPane.add(textoTitulo);

		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
