package Pacman;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Snake.juegoMenu;
import Snake.juegoVentana;

public class juegoMenuPacman extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Icon icon;
	juegoVentanaPacman juegoventanapacman;

	public juegoMenuPacman() {
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 664, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOpciones = new JLabel("Opciones");
		lblOpciones.setForeground(new Color(255, 255, 255));
		lblOpciones.setBounds(241, 410, 109, 24);
		lblOpciones.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblOpciones);
		
		JLabel lblVelocidad = new JLabel("Velocidad");
		lblVelocidad.setForeground(new Color(255, 255, 255));
		lblVelocidad.setBackground(new Color(255, 255, 255));
		lblVelocidad.setBounds(268, 95, 82, 13);
		lblVelocidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblVelocidad);
		
		JSlider slVelocidad = new JSlider();
		slVelocidad.setMajorTickSpacing(50);
		slVelocidad.setMinorTickSpacing(10);
		slVelocidad.setForeground(new Color(255, 255, 255));
		slVelocidad.setMaximum(250);
		slVelocidad.setOpaque(false);
		slVelocidad.setSnapToTicks(true);
		slVelocidad.setPaintTicks(true);
		slVelocidad.setPaintLabels(true);
		slVelocidad.setBounds(176, 119, 331, 44);
		contentPane.add(slVelocidad);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(517, 123, 20, 15);
		contentPane.add(textArea);
		
		JLabel lblBloques = new JLabel("Bloques");
		lblBloques.setForeground(new Color(255, 255, 255));
		lblBloques.setBounds(236, 209, 69, 23);
		lblBloques.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblBloques);
		
		JCheckBox chBloques = new JCheckBox("");
		chBloques.setOpaque(false);
		chBloques.setBounds(122, 180, 21, 24);
		contentPane.add(chBloques);
		
		JLabel lblPared = new JLabel("Pared");
		lblPared.setForeground(new Color(255, 255, 255));
		lblPared.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPared.setBounds(191, 278, 69, 23);
		contentPane.add(lblPared);
		
		JCheckBox chPared = new JCheckBox("");
		chPared.setOpaque(false);
		chPared.setBounds(122, 228, 21, 24);
		contentPane.add(chPared);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(0, 0, 255));
		btnCancelar.setOpaque(false);
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCancelar.setOpaque(true);
			}
			public void mouseExited(MouseEvent e) {
				btnCancelar.setOpaque(false);
			}
		});
		btnCancelar.setBounds(476, 405, 134, 29);
		contentPane.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				juegoventanapacman = new juegoVentanaPacman();
			}
		});
		btnAceptar.setForeground(new Color(255, 255, 255));
		btnAceptar.setBackground(new Color(255, 255, 0));
		btnAceptar.setOpaque(false);
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAceptar.setOpaque(true);
			}
			public void mouseExited(MouseEvent e) {
				btnAceptar.setOpaque(false);
			}
		});
		btnAceptar.setBounds(50, 405, 134, 29);
		contentPane.add(btnAceptar);
		
		JLabel lblFondo = new JLabel("New label");
		lblFondo.setBounds(0, 0, 650, 444);
		contentPane.add(lblFondo);
		SetImageLabel(lblFondo, juegoMenuPacman.class.getResource("PacmanFondo.png"));
		
	}
	
	private void SetImageLabel (JLabel labelName, URL url) {
		ImageIcon image = new ImageIcon(url);
		icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(),labelName.getHeight(),Image.SCALE_AREA_AVERAGING));
		labelName.setIcon(icon);
		this.repaint();
	}

}
