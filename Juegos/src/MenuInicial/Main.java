package MenuInicial;

import BaseDeDatos.GestorBD;
import Pacman.juegoMenuPacman;
import Snake.juegoMenu;

public class Main 
{
	public void iniciarSnake()
	{
		new juegoMenu();
	}
	
	public void iniciarPacMan()
	{
		new juegoMenuPacman();
	}
}
