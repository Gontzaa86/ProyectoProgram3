package MenuInicial;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.ImageIcon;
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
import java.awt.BorderLayout;
import java.awt.Color;

public class VentanaInicio{

	public static void main(String... args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));

		//ArrayList con los juegos
		ArrayList<Main> listaJuegos = new ArrayList<Main>();
		listaJuegos.add(new InicioSnake());		
		listaJuegos.add(new InicioPacman());	

		if (listaJuegos != null)
		{
			for (Main juego : listaJuegos)
			{
				JButton botonJuego = new JButton();
				botonJuego.setPreferredSize(new Dimension(165, 250));
				botonJuego.setText(juego.toString());
				botonJuego.setBounds((110 * listaJuegos.indexOf(juego)), 0, 100, 200);
				botonJuego.setHorizontalTextPosition( SwingConstants.CENTER );
				botonJuego.setVerticalTextPosition( SwingConstants.BOTTOM );
				//Código para poner un icono según el "toString()" del juego
				//Para poder implementar otro juego de la misma forma habría que crear un método toString() en el "inicio" de dicho juego
				if(juego.toString() == "SNAKE")
				{
					botonJuego.setIcon(new ImageIcon(VentanaInicio.class.getResource("snakeIcon.png")));
				}
				if(juego.toString() == "PAC-MAN")
				{
					botonJuego.setIcon(new ImageIcon(VentanaInicio.class.getResource("pacmanIcon.png")));
				}
				panel.add(botonJuego);

				botonJuego.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{	
						if(juego.toString() == "SNAKE")
						{
							juego.iniciarSnake();
						}
						
						if(juego.toString() == "PAC-MAN")
						{
							juego.iniciarPacMan();
						}	
					}

				});
			}
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(225, 97, 180, 277);

		JPanel contentPane = new JPanel(null);
		contentPane.setPreferredSize(new Dimension(626, 432));
		contentPane.setLayout(null);
		contentPane.add(scrollPane);
		
		frame.getContentPane().setPreferredSize(new Dimension(626, 432));
		frame.setContentPane(contentPane);

		JLabel textoTitulo = new JLabel("  Juegos Arcade");
		textoTitulo.setForeground(new Color(255, 255, 255));
		textoTitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		textoTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		textoTitulo.setBounds(10, 62, 598, 32);
		contentPane.add(textoTitulo);
		
		JLabel lblFondo = new JLabel();
		lblFondo.setIcon(new ImageIcon(VentanaInicio.class.getResource("game.png")));
		lblFondo.setLayout(new BorderLayout());
		lblFondo.setBounds(0, 0, 626, 432);
		contentPane.add(lblFondo);
		
		frame.pack();
		
	}
}
