package Snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Logger;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import BaseDeDatos.GestorBD;

public class juegoContenido extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//pantalla
	static final int PANTALLA = 500;
	static final int CUADRITO_SIZE = 20;
	static final int CUADRITOS_PARALELO = (int)PANTALLA/CUADRITO_SIZE;
	
	//serpiente
	static final int TOTAL_CUERPO_SERPIENTE = (PANTALLA*PANTALLA)/CUADRITO_SIZE;
	int[] serpienteX = new int [TOTAL_CUERPO_SERPIENTE];
	int[] serpienteY = new int[TOTAL_CUERPO_SERPIENTE];
	int cuerpo_serpiente = 3;
	
	//direccion
	char direccion = 'd';
	char direccion_siguiente = 'd';
	
	//comida
	int comidaX;
	int comidaY;
	
	//bloque
	static final int TOTAL_BLOQUE = (PANTALLA*PANTALLA)/CUADRITO_SIZE;
	int[] bloqueX = new int [TOTAL_BLOQUE];
	int[] bloqueY = new int[TOTAL_BLOQUE];
	int contBloque = 0;
	boolean bloque;
	
	//timer
	int DELAY;
	Timer timer;
	
	//correr el juego
	boolean running = true;
	boolean finish;
	
	//Revisar pared
	boolean pared;
	
	//otros
	Random random = new Random();
	
	//Puntos
	int puntuacion;
	
	//Nombre usuario
	String nombre;
	
	//Tiempo final de la partida
	int tiempo;
	
	//Logger
	Logger logger = Logger.getLogger(juegoContenido.class.getName());
	
	public juegoContenido(int velocidad, boolean bloque, boolean pared){
		
		this.setPreferredSize(new Dimension(700,PANTALLA)); //tammax y tammin
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new Controles());
		agregarComida();
		this.bloque = bloque;
		agregarBloque(bloque);
		this.pared = pared;
		this.DELAY = 250-velocidad;
		timer = new Timer (DELAY,this);
		setLayout(null);
		timer.start();
	}
	
	public void agregarComida() {
		comidaX = random.nextInt(CUADRITOS_PARALELO)*CUADRITO_SIZE;
		comidaY = random.nextInt(CUADRITOS_PARALELO)*CUADRITO_SIZE;
	}
	
	public void agregarBloque(boolean bloque) {
		if (bloque) {
			bloqueX[contBloque] = random.nextInt(CUADRITOS_PARALELO)*CUADRITO_SIZE;
			bloqueY[contBloque] = random.nextInt(CUADRITOS_PARALELO)*CUADRITO_SIZE;
			contBloque++;
		}
	}
	
	public void moverSerpiente() {
		for(int i=cuerpo_serpiente; i>0; i--) {
			serpienteX[i] = serpienteX[i-1];
			serpienteY[i] = serpienteY[i-1];
		}
		if ((direccion=='w' || direccion=='s') && (direccion_siguiente=='a' || direccion_siguiente=='d')) {
			direccion=direccion_siguiente;
		}
		if ((direccion=='a' || direccion=='d') && (direccion_siguiente=='w' || direccion_siguiente=='s')) {
			direccion=direccion_siguiente;
		}
				
		switch(direccion){
		case 'd':
			serpienteX[0] += CUADRITO_SIZE;
			break;
		case 'a':
			serpienteX[0] -= CUADRITO_SIZE;
			break;
		case 'w':
			serpienteY[0] -= CUADRITO_SIZE;
			break;
		case 's':
			serpienteY[0] += CUADRITO_SIZE;
			break;
		}
		
	}
	
	public void revisarComida() {
		if(serpienteX[0]==comidaX && serpienteY[0]==comidaY) {
			cuerpo_serpiente++;
			agregarComida();
			agregarBloque(this.bloque);
			this.puntuacion++;
		}
	}

	public void revisarColisiones(boolean pared) {
		//Pared
		if (pared==true) {
			if(serpienteX[0]<0 || serpienteY[0]<0 || serpienteX[0]==PANTALLA || serpienteY[0]==PANTALLA) {
				running=false;
				this.finish=false;
				JOptionPane.showMessageDialog(this, "Has chochado");
				
				//Nombre de usuario
				nombre = JOptionPane.showInputDialog("Introduzca su usuario, si no lo hace, o lo cancela, la partida no quedará registrada");
				
				if (nombre.isEmpty() == false)
				{
					guardarDatosBaseDatos();
					logger.info("La variable 'Nombre' fue asignada correctamente: " + nombre);
				}
				else
				{
					JOptionPane.showMessageDialog(this, "No se introdujo ningún nombre, por tanto, los datos no se guardarán");
				}
			}
		}
		
		//Sin pared
		else {
			if (serpienteX[0]==PANTALLA) {
				serpienteX[0]=0;
			}else if(serpienteX[0]<0){
				serpienteX[0]=PANTALLA;
			}
			if (serpienteY[0]==PANTALLA) {
				serpienteY[0]=0;
			}else if(serpienteY[0]<0) {
				serpienteY[0]=PANTALLA;
			}
		}
		
		//Serpiente
		for(int i = cuerpo_serpiente; i > 0; i--) {
			if (serpienteX[0]==serpienteX[i] && serpienteY[0]==serpienteY[i]) {
				running = false;
				this.finish=false;
				JOptionPane.showMessageDialog(this, "Has chochado");
				
				//Nombre de usuario
				nombre = JOptionPane.showInputDialog("Introduzca su usuario, si no lo hace, o lo cancela, la partida no quedará registrada");
				
				if (nombre.isEmpty() == false)
				{
					guardarDatosBaseDatos();
					logger.info("La variable 'Nombre' fue asignada correctamente: " + nombre);
				}
				else
				{
					JOptionPane.showMessageDialog(this, "No se introdujo ningún nombre, por tanto, los datos no se guardarán");
				}
				
				break;
			}	
		}
		
		//Bloque
		for(int i = 0; i < contBloque; i++) {
			if (serpienteX[0]==bloqueX[i] && serpienteY[0]==bloqueY[i]) {
				running = false;
				this.finish=false;
				JOptionPane.showMessageDialog(this, "Has chochado");
				
				//Nombre de usuario
				nombre = JOptionPane.showInputDialog("Introduzca su usuario, si no lo hace, o lo cancela, la partida no quedará registrada");
				
				if (nombre.isEmpty() == false)
				{
					guardarDatosBaseDatos();
					logger.info("La variable 'Nombre' fue asignada correctamente, usuario: " + nombre);
				}
				else
				{
					JOptionPane.showMessageDialog(this, "No se introdujo ningún nombre, por tanto, los datos no se guardarán");
				}
				
				break;
			}	
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.running) {
			moverSerpiente();
			revisarComida();
			revisarColisiones(pared);
		}
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//Color fondo
		for(int i=0; i<CUADRITOS_PARALELO; i++) {
			g.drawLine(0, CUADRITO_SIZE*i, PANTALLA, CUADRITO_SIZE*i);
			g.drawLine(CUADRITO_SIZE*i, 0, CUADRITO_SIZE*i, PANTALLA);
		}
		//Color fruta
		g.setColor(Color.red);
		g.fillOval(comidaX, comidaY, CUADRITO_SIZE, CUADRITO_SIZE);
		
		//Color serpiente
		g.setColor(Color.orange);
		for(int i=0; i<cuerpo_serpiente; i++) {
			g.fillRect(serpienteX[i], serpienteY[i], CUADRITO_SIZE, CUADRITO_SIZE);
		}
		
		//Color bloque
		g.setColor(Color.white);
		for(int i=0; i<contBloque; i++) {
			g.fillRect(bloqueX[i], bloqueY[i], CUADRITO_SIZE, CUADRITO_SIZE);
		}
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
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}
				logger.info("La variable 'Tiempo' fue asignada correctamente, tiempo: " + tiempo + " segundos");
			}
		};
		hiloTiempo.start();
	}
	
	public void guardarDatosBaseDatos()
	{
		GestorBD datosSnake = new GestorBD();
		
		String bloqueTexto;
		String paredTexto;
		
		
		if(bloque == true)
		{
			bloqueTexto = "True";
		}
		else
		{
			bloqueTexto = "False";
		}
		
		if(pared == true)
		{
			paredTexto = "True";
		}
		else
		{
			paredTexto = "False";
		}
		
		datosSnake.introducirDatosSnake(nombre, puntuacion, tiempo, (250 - DELAY), paredTexto, bloqueTexto);
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
