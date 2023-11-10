package MenuInicial;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JScrollBar;

public class VentanaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelMain;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInicial frame = new VentanaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public VentanaInicial() {
		
		//Añadir Juegos al ArrayList
		ArrayList<String> listaJuegos = new ArrayList<String>();
		listaJuegos.add("Snake");
		listaJuegos.add("Pac-Man");
		listaJuegos.add("Tic-Tac-Toe");
		listaJuegos.add("Juego4");
		listaJuegos.add("Juego5");
		listaJuegos.add("Juego6");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 357);
		panelMain = new JPanel();
		panelMain.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelMain);
		panelMain.setLayout(null);
		
		JLabel textoTitulo = new JLabel("Título");
		textoTitulo.setBounds(10, 10, 500, 30);
		textoTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		textoTitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		panelMain.add(textoTitulo);
		
		JPanel panelJuegos = new JPanel();
		panelJuegos.setBounds(10, 65, 500, 245);
		panelMain.add(panelJuegos);
		panelJuegos.setLayout(null);
		
		//Crea botones para cada elemento de la lista (cada juego)
		if (listaJuegos != null)
		{	
			for (String j : listaJuegos)	
			{	
				JButton botonJuego = new JButton();
				botonJuego.setSize(100, 200);
				botonJuego.setText(j.toString());
				botonJuego.setBounds(0 + (110 * listaJuegos.indexOf(j)), 0, 100, 180);
				botonJuego.setVerticalAlignment(SwingConstants.BOTTOM);
				panelJuegos.add(botonJuego);
			}
		}
	}
}
