package Snake3;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;

public class juegoMenu extends JFrame {

	private JPanel contentPane;
	Icon icon;
	juegoVentana juegoventana;

	public juegoMenu() {
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 624, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("EL JUEGO DE LA SERPIENTE");
		lblTitulo.setForeground(new Color(0, 0, 0));
		lblTitulo.setBounds(109, 19, 419, 34);
		lblTitulo.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 28));
		contentPane.add(lblTitulo);
		
		JLabel lblOpciones = new JLabel("Opciones");
		lblOpciones.setForeground(new Color(0, 0, 0));
		lblOpciones.setBounds(264, 63, 117, 24);
		lblOpciones.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblOpciones);
		
		JLabel lblVelocidad = new JLabel("Velocidad");
		lblVelocidad.setForeground(new Color(0, 0, 0));
		lblVelocidad.setBackground(new Color(255, 255, 255));
		lblVelocidad.setBounds(50, 97, 93, 13);
		lblVelocidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblVelocidad);
		
		JSlider slVelocidad = new JSlider();
		slVelocidad.setMajorTickSpacing(50);
		slVelocidad.setMinorTickSpacing(10);
		slVelocidad.setForeground(new Color(0, 0, 0));
		slVelocidad.setMaximum(250);
		slVelocidad.setOpaque(false);
		slVelocidad.setSnapToTicks(true);
		slVelocidad.setPaintTicks(true);
		slVelocidad.setPaintLabels(true);
		slVelocidad.setBounds(50, 130, 331, 44);
		contentPane.add(slVelocidad);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(122, 97, 20, 15);
		contentPane.add(textArea);
		
		JLabel lblBloques = new JLabel("Bloques");
		lblBloques.setForeground(new Color(0, 0, 0));
		lblBloques.setBounds(50, 180, 69, 23);
		lblBloques.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblBloques);
		
		JCheckBox chBloques = new JCheckBox("");
		chBloques.setOpaque(false);
		chBloques.setBounds(122, 180, 21, 24);
		contentPane.add(chBloques);
		
		JLabel lblPared = new JLabel("Pared");
		lblPared.setForeground(Color.BLACK);
		lblPared.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPared.setBounds(50, 229, 69, 23);
		contentPane.add(lblPared);
		
		JCheckBox chPared = new JCheckBox("");
		chPared.setOpaque(false);
		chPared.setBounds(122, 228, 21, 24);
		contentPane.add(chPared);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(0, 0, 0));
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
		btnCancelar.setBounds(333, 343, 134, 29);
		contentPane.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valor_velocidad= String.valueOf(slVelocidad.getValue());
				textArea.setText(valor_velocidad);
	
				if (chBloques.isSelected() && chPared.isSelected()) {
					juegoventana = new juegoVentana(slVelocidad.getValue(), true, true);
				}else if (chBloques.isSelected() && chPared.isSelected()==false){
					juegoventana = new juegoVentana(slVelocidad.getValue(),true, false);
				}else if (chBloques.isSelected()==false && chPared.isSelected()) {
					juegoventana = new juegoVentana (slVelocidad.getValue(), false, true);
				}else {
					juegoventana = new juegoVentana (slVelocidad.getValue(), false, false);
				}
			}
		});
		btnAceptar.setForeground(new Color(255, 255, 255));
		btnAceptar.setBackground(new Color(0, 0, 0));
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
		btnAceptar.setBounds(101, 343, 134, 29);
		contentPane.add(btnAceptar);
		
		JLabel lblFondo = new JLabel("New label");
		lblFondo.setBounds(0, 0, 610, 395);
		contentPane.add(lblFondo);
		SetImageLabel(lblFondo, "C:\\Users\\antonio.cancio\\OneDrive - Universidad de Deusto\\Documentos\\2º Ingeniería\\Programacion3\\Juegos\\Retro\\src\\Snake3\\SnakeFondo.png");
		
		
	}
	
	private void SetImageLabel (JLabel labelName, String root) {
		ImageIcon image = new ImageIcon(root);
		icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(),labelName.getHeight(),Image.SCALE_AREA_AVERAGING));
		labelName.setIcon(icon);
		this.repaint();
	}
}
