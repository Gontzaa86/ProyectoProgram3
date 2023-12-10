package Snake;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class SnakeTest 
{
	@Test
	public void pruebaSnake()
	{
		juegoContenido snake = new juegoContenido(150, false, false);
		
		//Comprobar que se genean comidas
		snake.agregarComida();
		int comidaX = snake.comidaX;
		int comidaY = snake.comidaY;
		
		assertNotEquals(0, comidaX);
		assertNotEquals(0, comidaY);
		
		//Comprobar que se crean bloques
		snake.agregarBloque(true);
		int[] bloqueX = snake.bloqueX;
		int[] bloqueY = snake.bloqueY;
		
		assertNotEquals(0, bloqueX);
		assertNotEquals(0, bloqueY);
	}
}
