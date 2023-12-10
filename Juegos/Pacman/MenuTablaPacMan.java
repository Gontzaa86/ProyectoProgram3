package Pacman;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MenuTablaPacMan extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JTable tablaDatos;
	
	public MenuTablaPacMan()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setSize(600, 400);
	    setTitle("Registro de partidas");
	    
	    DefaultTableModel modelo = obtenerModeloTabla();
	    
	    tablaDatos = new JTable(modelo);
	    
	    JScrollPane scroll = new JScrollPane(tablaDatos);
	    
	    getContentPane().add(scroll, BorderLayout.CENTER);
	    
	    setVisible(true);
	}
	
	//Establecer como modelo los datos de la BD
	private DefaultTableModel obtenerModeloTabla()
	{
		DefaultTableModel modelo = new DefaultTableModel()
		{
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};
		
		modelo.addColumn("Usuario");
		modelo.addColumn("Puntuación");
		modelo.addColumn("Tiempo");
		modelo.addColumn("Velocidad");
		
		Connection conexion = null;
		try
		{
			conexion = DriverManager.getConnection("jdbc:sqlite:base_datos.db");
			String consulta = "SELECT Nombre, Puntuación, Tiempo, Velocidad FROM TablaPacMan ORDER BY Puntuación DESC";
			try
			{
				PreparedStatement stmt = conexion.prepareStatement(consulta);
				ResultSet rS = stmt.executeQuery();
				
				while(rS.next())
				{
					Object[] fila = 
					{
						rS.getString("Nombre"),
						rS.getInt("Puntuación"),
						rS.getInt("Tiempo"),
						rS.getInt("Velocidad")
					};
					
					modelo.addRow(fila);
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return modelo;
	}
}
