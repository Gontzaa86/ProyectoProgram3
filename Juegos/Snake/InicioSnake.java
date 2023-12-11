package Snake;

import MenuInicial.Main;

public class InicioSnake extends Main{
	public static void main (String args[]) {
		new juegoMenu();
	}
	
	@Override
	public String toString() {
		String texto = "SNAKE";
		return texto;
	}
}
