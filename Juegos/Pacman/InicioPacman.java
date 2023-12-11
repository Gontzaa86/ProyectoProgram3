package Pacman;

import MenuInicial.Main;

public class InicioPacman extends Main{
	public static void main (String args[]) {
		new juegoMenuPacman();
	}
	
	@Override
	public String toString() {
		String texto = "PAC-MAN";
		return texto;
	}
}
