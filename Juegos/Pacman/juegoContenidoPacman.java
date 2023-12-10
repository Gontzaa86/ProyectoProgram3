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

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

<<<<<<< HEAD
public class juegoContenidoPacman extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	//pantalla
	static final int PANTALLA = 510;
	static final int CUADRITO_SIZE = 20;
	static final int CUADRITOS_PARALELO = (int)PANTALLA/CUADRITO_SIZE;
	
	//pacman
	int pacmanX = 0;
	int pacmanY = 0;
	
	//fantasma verde
	int fantasmaVerdeX = 100;
	int fantasmaVerdeY = 100;
	
	//fantasma rojo
	int fantasmaRojoX = 300;
	int fantasmaRojoY = 300;
	
	//fantasma rosa
	int fantasmaRosaX = 100;
	int fantasmaRosaY = 300;
	
	//fantasma naranja
	int fantasmaNaranjaX = 300;
	int fantasmaNaranjaY = 100;
	
	//punto
	static final int TOTAL_PUNTO = (PANTALLA*PANTALLA)/CUADRITO_SIZE;
	int[] puntoX = new int [TOTAL_PUNTO];
	int[] puntoY = new int[TOTAL_PUNTO];
	int inicialX = 8;
	int inicialY = 8;
	int contPunto= 0;
	
	//Eliminar puntos
	ArrayList<Integer>puntoNegroX = new ArrayList<Integer>();
	ArrayList<Integer>puntoNegroY = new ArrayList<Integer>();
	
	//bloque
	static final int TOTAL_BLOQUE = (PANTALLA*PANTALLA)/CUADRITO_SIZE;
	int[] bloqueX = new int [TOTAL_BLOQUE];
	int[] bloqueY = new int [TOTAL_BLOQUE];
	
	//direccion
	char direccion = 'd';
	char direccion_siguiente = 'd';
	
	//timer
	int DELAY;
	Timer timer;
	
	//contador para cambiar a boca cerrada
	int contador = 2;
	
	//puntuacion
	int puntuacion;
	
	//correr juego
	boolean running = true;
	boolean finish;
	
	Random random = new Random();
	
	public juegoContenidoPacman(int velocidad) {
		
		this.setPreferredSize(new Dimension(700,PANTALLA));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new Controles());
		agregarPunto();
		this.DELAY = 250-velocidad;
		timer = new Timer(DELAY, this);
		setLayout(null);
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
	
	public void moverFantasmas() {
		int numVerde = (int) (Math.random()*4);
		switch(numVerde){
		case 0:
			fantasmaVerdeX += CUADRITO_SIZE;
			break;
		case 1:
			fantasmaVerdeX -= CUADRITO_SIZE;
			break;
		case 2:
			fantasmaVerdeY -= CUADRITO_SIZE;
			break;
		case 3:
			fantasmaVerdeY += CUADRITO_SIZE;
			break;
		}
		
		int numRojo = (int) (Math.random()*4);
		switch(numRojo){
		case 0:
			fantasmaRojoX += CUADRITO_SIZE;
			break;
		case 1:
			fantasmaRojoX -= CUADRITO_SIZE;
			break;
		case 2:
			fantasmaRojoY -= CUADRITO_SIZE;
			break;
		case 3:
			fantasmaRojoY += CUADRITO_SIZE;
			break;
		}
		
		int numRosa = (int) (Math.random()*4);
		switch(numRosa){
		case 0:
			fantasmaRosaX += CUADRITO_SIZE;
			break;
		case 1:
			fantasmaRosaX -= CUADRITO_SIZE;
			break;
		case 2:
			fantasmaRosaY -= CUADRITO_SIZE;
			break;
		case 3:
			fantasmaRosaY += CUADRITO_SIZE;
			break;
		}
		
		int numNaranja = (int) (Math.random()*4);
		switch(numNaranja){
		case 0:
			fantasmaNaranjaX += CUADRITO_SIZE;
			break;
		case 1:
			fantasmaNaranjaX -= CUADRITO_SIZE;
			break;
		case 2:
			fantasmaNaranjaY -= CUADRITO_SIZE;
			break;
		case 3:
			fantasmaNaranjaY += CUADRITO_SIZE;
			break;
		}
		
	}
	
	public void agregarPunto() {
		while (contPunto < 169) {

			puntoX[contPunto] = inicialX;
			puntoY[contPunto] = inicialY;
						
			if (inicialX<500) {
				inicialX = inicialX + 40;
			}
			
			if (inicialX > 500) {
				inicialY = inicialY + 40;
				inicialX = 8;
			}
			contPunto++;
		}
	}
	
	public void revisarPunto() {
		for (int i=0; i<contPunto; i++) {
			if (pacmanX == puntoX[i]-8 && pacmanY == puntoY[i]-8) {
				puntoNegroX.add(puntoX[i]);
				puntoNegroY.add(puntoY[i]);
				if (i == 0 || i==12 || i==156 || i == 168) {
					puntuacion+=5;
				}
				puntuacion++;					
			}
		}
		if(puntoNegroX.size()==169) {
			running=false;
			finish=false;
			JOptionPane.showMessageDialog(null, "Has terminado");
		}
	}
	
	public void revisarColisiones(){
		//bloquear pared X menos el hueco
		if (pacmanX>PANTALLA && pacmanY==260) {
			pacmanX=0;
		}else if (pacmanX>(PANTALLA) && pacmanY!=260) {
			pacmanX=pacmanX-20;
		}else if (pacmanX<0 && pacmanY!=260) {
			pacmanX=pacmanX+20;
		}
		
		//bloquear pared Y menos el hueco
		if (pacmanX<0 && pacmanY==260) {
			pacmanX=PANTALLA-10;
		}else if (pacmanY>(PANTALLA)) {
			pacmanY=pacmanY-20;
		}else if (pacmanY<0) {
			pacmanY=pacmanY+20;
		}
		
		if (pacmanX == fantasmaVerdeX && pacmanY == fantasmaVerdeY
				|| pacmanX == fantasmaRojoX && pacmanY == fantasmaRojoY
				|| pacmanX == fantasmaRosaX && pacmanY == fantasmaRosaY
				|| pacmanX == fantasmaNaranjaX && pacmanY == fantasmaNaranjaY) {
			running=false;
			finish=false;
			JOptionPane.showMessageDialog(null, "Te ha comido el fantasma");
		}
		
		//Bloquear fantasma
		if (fantasmaVerdeX>(PANTALLA)) {
			fantasmaVerdeX-=40;
		}else if (fantasmaVerdeX<0) {
			fantasmaVerdeX+=40;
		}
		if (fantasmaVerdeY>(PANTALLA)) {
			fantasmaVerdeY-=40;
		}else if (fantasmaVerdeY<0) {
			fantasmaVerdeX+=40;
		}
		
		if (fantasmaRojoX>(PANTALLA)) {
			fantasmaRojoX-=40;
		}else if (fantasmaRojoX<0) {
			fantasmaRojoX+=40;
		}
		if (fantasmaRojoY>(PANTALLA)) {
			fantasmaRojoY-=40;
		}else if (fantasmaRojoY<0) {
			fantasmaRojoX+=40;
		}
		
		if (fantasmaRosaX>(PANTALLA)) {
			fantasmaRosaX-=40;
		}else if (fantasmaRosaX<0) {
			fantasmaRosaX+=40;
		}
		if (fantasmaRosaY>(PANTALLA)) {
			fantasmaRosaY-=40;
		}else if (fantasmaRosaY<0) {
			fantasmaRosaX+=40;
		}
		
		if (fantasmaNaranjaX>(PANTALLA)) {
			fantasmaNaranjaX-=40;
		}else if (fantasmaNaranjaX<0) {
			fantasmaNaranjaX+=40;
		}
		if (fantasmaNaranjaY>(PANTALLA)) {
			fantasmaNaranjaY-=40;
		}else if (fantasmaNaranjaY<0) {
			fantasmaNaranjaX+=40;
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (running) {
			moverPacman();
			moverFantasmas();
			revisarColisiones();
			revisarPunto();
		}
		repaint();//Para dibujar constantemente
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//puntos blancos
		g.setColor(Color.white);
		for (int i=0; i<contPunto; i++) {
			if (i == 0 || i==12 || i==156 || i == 168) {
				g.fillOval(puntoX[i], puntoY[i], CUADRITO_SIZE, CUADRITO_SIZE);
			}else {
				g.fillOval(puntoX[i], puntoY[i], 8, 8); //posicion x,y tamaño x,y
			}
		}
		
		g.setColor(Color.black);
		for (int i=0; i<puntoNegroX.size(); i++) {
			if (i == 0 || i==12 || i==156 || i == 168) {
				g.fillOval(puntoNegroX.get(i)-8, puntoNegroY.get(i)-8, CUADRITO_SIZE+10, CUADRITO_SIZE+10);
			}else {
				g.fillOval(puntoNegroX.get(i)-8, puntoNegroY.get(i)-8,  CUADRITO_SIZE+10, CUADRITO_SIZE+10); //posicion x,y tamaño x,y
			}
		}
		
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
		
		//Color fantasma verde
		g.setColor(Color.green);
		g.fillOval(fantasmaVerdeX, fantasmaVerdeY, CUADRITO_SIZE, CUADRITO_SIZE);
		
		//Color fantasma rojo
		g.setColor(Color.red);
		g.fillOval(fantasmaRojoX, fantasmaRojoY, CUADRITO_SIZE, CUADRITO_SIZE);
		
		//Color fantasma rosa
		g.setColor(Color.pink);
		g.fillOval(fantasmaRosaX, fantasmaRosaY, CUADRITO_SIZE, CUADRITO_SIZE);
		
		//Color fantasma naranja
		g.setColor(Color.orange);
		g.fillOval(fantasmaNaranjaX, fantasmaNaranjaY, CUADRITO_SIZE, CUADRITO_SIZE);
		
		//borde del mapa
		g.setColor(Color.magenta);
		g.drawLine(0, 1, PANTALLA, 1);
		g.drawLine(0, 509, PANTALLA, 509);
		g.drawLine(1, 0, 1, 250);
		g.drawLine(1, 290, 1, 510);
		g.drawLine(509, 0, 509, 250);
		g.drawLine(509, 290, 509, 510);
					
=======
import BaseDeDatos.GestorBD;

public class juegoContenidoPacman extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	//pantalla
	static final int PANTALLA = 510;
	static final int CUADRITO_SIZE = 20;
	static final int CUADRITOS_PARALELO = (int)PANTALLA/CUADRITO_SIZE;
	
	//pacman
	int pacmanX = 0;
	int pacmanY = 0;
	
	//fantasma verde
	int fantasmaVerdeX = 100;
	int fantasmaVerdeY = 100;
	
	//fantasma rojo
	int fantasmaRojoX = 300;
	int fantasmaRojoY = 300;
	
	//fantasma rosa
	int fantasmaRosaX = 100;
	int fantasmaRosaY = 300;
	
	//fantasma naranja
	int fantasmaNaranjaX = 300;
	int fantasmaNaranjaY = 100;
	
	//punto
	static final int TOTAL_PUNTO = (PANTALLA*PANTALLA)/CUADRITO_SIZE;
	int[] puntoX = new int [TOTAL_PUNTO];
	int[] puntoY = new int[TOTAL_PUNTO];
	int inicialX = 8;
	int inicialY = 8;
	int contPunto= 0;
	
	//Eliminar puntos
	ArrayList<Integer>puntoNegroX = new ArrayList<Integer>();
	ArrayList<Integer>puntoNegroY = new ArrayList<Integer>();
	
	//bloque
	static final int TOTAL_BLOQUE = (PANTALLA*PANTALLA)/CUADRITO_SIZE;
	int[] bloqueX = new int [TOTAL_BLOQUE];
	int[] bloqueY = new int [TOTAL_BLOQUE];
	
	//direccion
	char direccion = 'd';
	char direccion_siguiente = 'd';
	
	//timer
	int DELAY;
	Timer timer;
	
	//contador para cambiar a boca cerrada
	int contador = 2;
	
	//puntuacion
	int puntuacion;
	
	//correr juego
	boolean running = true;
	boolean finish;
	
	//Nombre usuario
	String nombre;
	
	//Tiempo fianl
	int tiempo = 0;
	
	Random random = new Random();
	
	public juegoContenidoPacman(int velocidad) {
		
		this.setPreferredSize(new Dimension(700,PANTALLA));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new Controles());
		agregarPunto();
		this.DELAY = 250-velocidad;
		timer = new Timer(DELAY, this);
		setLayout(null);
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
	
	public void moverFantasmas() {
		int numVerde = (int) (Math.random()*4);
		switch(numVerde){
		case 0:
			fantasmaVerdeX += CUADRITO_SIZE;
			break;
		case 1:
			fantasmaVerdeX -= CUADRITO_SIZE;
			break;
		case 2:
			fantasmaVerdeY -= CUADRITO_SIZE;
			break;
		case 3:
			fantasmaVerdeY += CUADRITO_SIZE;
			break;
		}
		
		int numRojo = (int) (Math.random()*4);
		switch(numRojo){
		case 0:
			fantasmaRojoX += CUADRITO_SIZE;
			break;
		case 1:
			fantasmaRojoX -= CUADRITO_SIZE;
			break;
		case 2:
			fantasmaRojoY -= CUADRITO_SIZE;
			break;
		case 3:
			fantasmaRojoY += CUADRITO_SIZE;
			break;
		}
		
		int numRosa = (int) (Math.random()*4);
		switch(numRosa){
		case 0:
			fantasmaRosaX += CUADRITO_SIZE;
			break;
		case 1:
			fantasmaRosaX -= CUADRITO_SIZE;
			break;
		case 2:
			fantasmaRosaY -= CUADRITO_SIZE;
			break;
		case 3:
			fantasmaRosaY += CUADRITO_SIZE;
			break;
		}
		
		int numNaranja = (int) (Math.random()*4);
		switch(numNaranja){
		case 0:
			fantasmaNaranjaX += CUADRITO_SIZE;
			break;
		case 1:
			fantasmaNaranjaX -= CUADRITO_SIZE;
			break;
		case 2:
			fantasmaNaranjaY -= CUADRITO_SIZE;
			break;
		case 3:
			fantasmaNaranjaY += CUADRITO_SIZE;
			break;
		}
		
	}
	
	public void agregarPunto() {
		while (contPunto < 169) {

			puntoX[contPunto] = inicialX;
			puntoY[contPunto] = inicialY;
						
			if (inicialX<500) {
				inicialX = inicialX + 40;
			}
			
			if (inicialX > 500) {
				inicialY = inicialY + 40;
				inicialX = 8;
			}
			contPunto++;
		}
	}
	
	public void revisarPunto() {
		for (int i=0; i<contPunto; i++) {
			if (pacmanX == puntoX[i]-8 && pacmanY == puntoY[i]-8) {
				puntoNegroX.add(puntoX[i]);
				puntoNegroY.add(puntoY[i]);
				if (i == 0 || i==12 || i==156 || i == 168) {
					puntuacion+=5;
				}
				puntuacion++;					
			}
		}
		if(puntoNegroX.size()==169) {
			running=false;
			finish=false;
			JOptionPane.showMessageDialog(null, "Has terminado");
			
			//Nombre de usuario
			nombre = JOptionPane.showInputDialog("Introduzca su usuario, si no lo hace, o lo cancela, la partida no quedará registrada");
			System.out.println(nombre);
			
			if (nombre.isEmpty() == false)
			{
				guardarDatosBaseDatos();
			}
			else
			{
				JOptionPane.showMessageDialog(this, "No se introdujo ningún nombre, por tanto, los datos no se guardarán");
			}
		}
	}
	
	public void revisarColisiones(){
		//bloquear pared X menos el hueco
		if (pacmanX>PANTALLA && pacmanY==260) {
			pacmanX=0;
		}else if (pacmanX>(PANTALLA) && pacmanY!=260) {
			pacmanX=pacmanX-20;
		}else if (pacmanX<0 && pacmanY!=260) {
			pacmanX=pacmanX+20;
		}
		
		//bloquear pared Y menos el hueco
		if (pacmanX<0 && pacmanY==260) {
			pacmanX=PANTALLA-10;
		}else if (pacmanY>(PANTALLA)) {
			pacmanY=pacmanY-20;
		}else if (pacmanY<0) {
			pacmanY=pacmanY+20;
		}
		
		if (pacmanX == fantasmaVerdeX && pacmanY == fantasmaVerdeY
				|| pacmanX == fantasmaRojoX && pacmanY == fantasmaRojoY
				|| pacmanX == fantasmaRosaX && pacmanY == fantasmaRosaY
				|| pacmanX == fantasmaNaranjaX && pacmanY == fantasmaNaranjaY) {
			running=false;
			finish=false;
			JOptionPane.showMessageDialog(null, "Te ha comido el fantasma");
			
			//Nombre de usuario
			nombre = JOptionPane.showInputDialog("Introduzca su usuario, si no lo hace, o lo cancela, la partida no quedará registrada");
			System.out.println(nombre);
			
			if (nombre.isEmpty() == false)
			{
				guardarDatosBaseDatos();
			}
			else
			{
				JOptionPane.showMessageDialog(this, "No se introdujo ningún nombre, por tanto, los datos no se guardarán");
			}
		}
		
		//Bloquear fantasma
		if (fantasmaVerdeX>(PANTALLA)) {
			fantasmaVerdeX-=40;
		}else if (fantasmaVerdeX<0) {
			fantasmaVerdeX+=40;
		}
		if (fantasmaVerdeY>(PANTALLA)) {
			fantasmaVerdeY-=40;
		}else if (fantasmaVerdeY<0) {
			fantasmaVerdeX+=40;
		}
		
		if (fantasmaRojoX>(PANTALLA)) {
			fantasmaRojoX-=40;
		}else if (fantasmaRojoX<0) {
			fantasmaRojoX+=40;
		}
		if (fantasmaRojoY>(PANTALLA)) {
			fantasmaRojoY-=40;
		}else if (fantasmaRojoY<0) {
			fantasmaRojoX+=40;
		}
		
		if (fantasmaRosaX>(PANTALLA)) {
			fantasmaRosaX-=40;
		}else if (fantasmaRosaX<0) {
			fantasmaRosaX+=40;
		}
		if (fantasmaRosaY>(PANTALLA)) {
			fantasmaRosaY-=40;
		}else if (fantasmaRosaY<0) {
			fantasmaRosaX+=40;
		}
		
		if (fantasmaNaranjaX>(PANTALLA)) {
			fantasmaNaranjaX-=40;
		}else if (fantasmaNaranjaX<0) {
			fantasmaNaranjaX+=40;
		}
		if (fantasmaNaranjaY>(PANTALLA)) {
			fantasmaNaranjaY-=40;
		}else if (fantasmaNaranjaY<0) {
			fantasmaNaranjaX+=40;
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (running) {
			moverPacman();
			moverFantasmas();
			revisarColisiones();
			revisarPunto();
		}
		repaint();//Para dibujar constantemente
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//puntos blancos
		g.setColor(Color.white);
		for (int i=0; i<contPunto; i++) {
			if (i == 0 || i==12 || i==156 || i == 168) {
				g.fillOval(puntoX[i], puntoY[i], CUADRITO_SIZE, CUADRITO_SIZE);
			}else {
				g.fillOval(puntoX[i], puntoY[i], 8, 8); //posicion x,y tamaño x,y
			}
		}
		
		g.setColor(Color.black);
		for (int i=0; i<puntoNegroX.size(); i++) {
			if (i == 0 || i==12 || i==156 || i == 168) {
				g.fillOval(puntoNegroX.get(i)-8, puntoNegroY.get(i)-8, CUADRITO_SIZE+10, CUADRITO_SIZE+10);
			}else {
				g.fillOval(puntoNegroX.get(i)-8, puntoNegroY.get(i)-8,  CUADRITO_SIZE+10, CUADRITO_SIZE+10); //posicion x,y tamaño x,y
			}
		}
		
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
		
		//Color fantasma verde
		g.setColor(Color.green);
		g.fillOval(fantasmaVerdeX, fantasmaVerdeY, CUADRITO_SIZE, CUADRITO_SIZE);
		
		//Color fantasma rojo
		g.setColor(Color.red);
		g.fillOval(fantasmaRojoX, fantasmaRojoY, CUADRITO_SIZE, CUADRITO_SIZE);
		
		//Color fantasma rosa
		g.setColor(Color.pink);
		g.fillOval(fantasmaRosaX, fantasmaRosaY, CUADRITO_SIZE, CUADRITO_SIZE);
		
		//Color fantasma naranja
		g.setColor(Color.orange);
		g.fillOval(fantasmaNaranjaX, fantasmaNaranjaY, CUADRITO_SIZE, CUADRITO_SIZE);
		
		//borde del mapa
		g.setColor(Color.magenta);
		g.drawLine(0, 1, PANTALLA, 1);
		g.drawLine(0, 509, PANTALLA, 509);
		g.drawLine(1, 0, 1, 250);
		g.drawLine(1, 290, 1, 510);
		g.drawLine(509, 0, 509, 250);
		g.drawLine(509, 290, 509, 510);
					
	}
	
	public void guardarDatosBaseDatos()
	{
		GestorBD datosSnake = new GestorBD();
		
		datosSnake.introducirDatosPacMan(nombre, puntuacion, tiempo, (250 - DELAY));
	}
	
	public void sumarTiempo()
	{
		Thread hiloTiempo = new Thread()
		{
			public void run()
			{
				while(finish)
				{
					try
					{
						Thread.sleep(1000);
						tiempo++;
						System.out.println(tiempo);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
		};
		hiloTiempo.start();
>>>>>>> branch 'master' of https://github.com/Gontzaa86/ProyectoProgram3
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
