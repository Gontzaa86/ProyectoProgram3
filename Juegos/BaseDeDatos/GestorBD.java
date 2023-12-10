package BaseDeDatos;

import java.sql.*;

public class GestorBD 
{
	//Código para imnplementar datos en el snake (SOLO SNAKE) 
	//De la aplicación a la BD
	public static void introducirDatosSnake(String nombre, int puntos, int tiempo, int velocidad, String bloque, String pared)
	{
		Connection conexion = null;
		try
		{
			conexion = DriverManager.getConnection("jdbc:sqlite:base_datos.db");
			String sentencia = "INSERT INTO TablaSnake(Nombre, Puntuación, Tiempo, Velocidad, Paredes, Bloques) VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conexion.prepareStatement(sentencia);
				{
					stmt.setString(1, nombre);
					stmt.setInt(2, puntos);
					stmt.setInt(3, tiempo);
					stmt.setInt(4, velocidad);
					stmt.setString(5, bloque);
					stmt.setString(6, pared);
				}
			
			stmt.executeUpdate();
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	//Código para implementar datos en el PacMan (SOLO PACMAN)
	//De la aplicación a la BD
	public static void introducirDatosPacMan(String nombre, int puntos, int tiempo, int velocidad){
		Connection conexion = null;
		try
		{
			conexion = DriverManager.getConnection("jdbc:sqlite:base_datos.db");
			String sentencia = "INSERT INTO TablaPacMan(Nombre, Puntuación, Tiempo, Velocidad) VALUES(?, ?, ?, ?)";
			PreparedStatement stmt = conexion.prepareStatement(sentencia);
			{
				stmt.setString(1, nombre);
				stmt.setInt(2, puntos);
				stmt.setInt(3, tiempo);
				stmt.setInt(4, velocidad);
			}
			
			stmt.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
