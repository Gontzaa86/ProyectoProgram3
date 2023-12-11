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

public class juegoMenuPacman extends JFrame {

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
		lblVelocidad.setBounds(327, 144, 82, 13);
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
		slVelocidad.setBounds(178, 187, 331, 44);
		contentPane.add(slVelocidad);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(536, 187, 20, 15);
		contentPane.add(textArea);
		
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
				String valor_velocidad= String.valueOf(slVelocidad.getValue());
				textArea.setText(valor_velocidad);
				juegoventanapacman = new juegoVentanaPacman(slVelocidad.getValue());
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
		
		JButton btnTabla = new JButton("Puntuaciones");
		btnTabla.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				new MenuTablaPacMan();
			}
		});
		btnTabla.setBounds(298, 270, 134, 29);
		btnTabla.setForeground(new Color (255, 255, 255));
		btnTabla.setBackground(new Color(0, 0, 0));
		btnTabla.setOpaque(false);
		btnTabla.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				btnTabla.setOpaque(true);
			}
			public void mouseExited(MouseEvent e) 
			{
				btnTabla.setOpaque(false);
			}
		});
		contentPane.add(btnTabla);
		
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
