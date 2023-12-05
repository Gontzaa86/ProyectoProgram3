package Pacman;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class juegoContenidoPacman extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	//pantalla
	static final int PANTALLA = 510;
	static final int CUADRITO_SIZE = 20;
	static final int CUADRITOS_PARALELO = (int)PANTALLA/CUADRITO_SIZE;
	
	//pacman
	int pacmanX;
	int pacmanY;
	
	//fantasma
	static final int TOTAL_FANTASMA = (PANTALLA*PANTALLA)/CUADRITO_SIZE;
	int[] fantasmaX = new int [TOTAL_FANTASMA];
	int[] fantasmaY = new int [TOTAL_FANTASMA];
	
	//punto
	static final int TOTAL_PUNTO = (PANTALLA*PANTALLA)/CUADRITO_SIZE;
	//int[] puntoX = new int [TOTAL_PUNTO];
	//int[] puntoY = new int[TOTAL_PUNTO];
	ArrayList<Integer> puntoX = new ArrayList<Integer>();
	ArrayList<Integer> puntoY = new ArrayList<Integer>();
	int inicialX = 8;
	int inicialY = 8;
	int contPunto= 0;
	
	//bloque
	static final int TOTAL_BLOQUE = (PANTALLA*PANTALLA)/CUADRITO_SIZE;
	int[] bloqueX = new int [TOTAL_BLOQUE];
	int[] bloqueY = new int [TOTAL_BLOQUE];
	
	//direccion
	char direccion = 'd';
	char direccion_siguiente = 'd';
	
	//timer
	int DELAY=200;
	Timer timer;
	
	//contador para cambiar a boca cerrada
	int contador = 2;
	
	//correr juego
	boolean running = true;
	
	Random random = new Random();
	
	public juegoContenidoPacman() {
		
		this.setPreferredSize(new Dimension(PANTALLA,PANTALLA));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new Controles());
		setLayout(null);
		agregarPunto();
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	public void moverPacman() {
		direccion = direccion_siguiente;
		switch(direccion){
		case 'd':
			pacmanX += CUADRITO_SIZE;
			break;
		case 'a':
			pacmanX -= CUADRITO_SIZE;
			break;
		case 'w':
			pacmanY -= CUADRITO_SIZE;
			break;
		case 's':
			pacmanY += CUADRITO_SIZE;
			break;
		}
	}
	
	public void agregarPunto() {
		while (contPunto < 169) {
			puntoX.add(inicialX);
			puntoY.add(inicialY);
						
			if (inicialX<500) {
				inicialX = inicialX + 40;
			}
			if (inicialX > 500) {
				inicialY = inicialY + 40;
				inicialX = 10;
			}
			
			contPunto++;
			agregarPunto();
			
		}
		
	}
	
	public void revisarPunto() {
		for (int i = 0; i<200;i++) {
			if (pacmanX == puntoX.get(i)) {
				
			}
		}
	}
	
	public void revisarColisiones(){
		//bloquear pared X menos el hueco
		if (pacmanX>PANTALLA && pacmanY==260) {
			pacmanX=0;
		}else if (pacmanX>(PANTALLA-20) && pacmanY!=260) {
			pacmanX=pacmanX-20;
		}else if (pacmanX<0 && pacmanY!=260) {
			pacmanX=pacmanX+20;
		}
		
		//bloquear pared Y menos el hueco
		if (pacmanX<0 && pacmanY==260) {
			pacmanX=PANTALLA;
		}else if (pacmanY>(PANTALLA-20)) {
			pacmanY=pacmanY-20;
		}else if (pacmanY<0) {
			pacmanY=pacmanY+20;
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (running) {
			moverPacman();
			revisarColisiones();
		}
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//borde del mapa
		g.setColor(Color.magenta);
		g.drawLine(0, 1, PANTALLA, 1);
		g.drawLine(0, 509, PANTALLA, 509);
		g.drawLine(1, 0, 1, 250);
		g.drawLine(1, 290, 1, 510);
		g.drawLine(509, 0, 509, 250);
		g.drawLine(509, 290, 509, 510);
		
		//puntos blancos
		g.setColor(Color.white);
		for (int i=0; i<contPunto; i++) {
			if (i == 0 || i==12 || i==156 || i == 168) {
				g.fillOval(puntoX.get(i), puntoY.get(i), CUADRITO_SIZE, CUADRITO_SIZE);
			}else {
				g.fillOval(puntoX.get(i), puntoY.get(i), 5, 5); //posicion x,y tamaño x,y
			}
		}
		
		/**Eliminar puntos
		g.setColor(Color.black);
		for (int i=0; i<contPunto; i++) {
			if (pacmanX > puntoX[i]-8) {
				if (i == 0 || i==12 || i==156 || i == 168) {
					g.fillOval(puntoX[i], puntoY[i], CUADRITO_SIZE, CUADRITO_SIZE);
				}else {
					g.fillOval(puntoX[i], puntoY[i], 5, 5); //posicion x,y tamaño x,y
				}
			}
		}**/
		
		//color pacman
		g.setColor(Color.yellow);
		if (contador%2==0) {
			if (direccion_siguiente == 'd') {
				g.fillArc(pacmanX, pacmanY, CUADRITO_SIZE, CUADRITO_SIZE, 45, 270);
			}
			else if (direccion_siguiente == 'a') {
				g.fillArc(pacmanX, pacmanY, CUADRITO_SIZE, CUADRITO_SIZE, 235, 270);
			}
			else if (direccion_siguiente == 's') {
				g.fillArc(pacmanX, pacmanY, CUADRITO_SIZE, CUADRITO_SIZE, 315, 270);
			}
			else if (direccion_siguiente == 'w') {
				g.fillArc(pacmanX, pacmanY, CUADRITO_SIZE, CUADRITO_SIZE, 135, 270);
			}
		}
		else {
			g.fillArc(pacmanX, pacmanY, CUADRITO_SIZE, CUADRITO_SIZE, 0, 360);
		}
		contador+=1; //Para que sea impar y cambie de color
	}
	
	public class Controles extends KeyAdapter{
		@Override
		public void keyPressed (KeyEvent e) {
			switch(e.getKeyChar()) { //Seleccionador de casos
				case 'w':
					direccion_siguiente='w';
					break;
				case 's':
					direccion_siguiente='s';
					break;
				case 'a':
					direccion_siguiente='a';
					break;
				case 'd':
					direccion_siguiente='d';
					break;
			}
			switch(e.getKeyCode()) {
				case KeyEvent.VK_UP:
					direccion_siguiente='w';
					break;
				case KeyEvent.VK_DOWN:
					direccion_siguiente='s';
					break;
				case KeyEvent.VK_LEFT:
					direccion_siguiente='a';
					break;
				case KeyEvent.VK_RIGHT:
					direccion_siguiente='d';
					break;
			}
		}
	}
}
