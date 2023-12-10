package Snake;

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

public class MenuTablaSnake extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tablaDatos;
	
	public MenuTablaSnake()
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
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};
		
		modelo.addColumn("Usuario");
		modelo.addColumn("Puntuación");
		modelo.addColumn("Tiempo");
		modelo.addColumn("Velocidad");
		modelo.addColumn("Bloques");
		modelo.addColumn("Paredes");
		
		Connection conexion = null;
		try
		{
			conexion = DriverManager.getConnection("jdbc:sqlite:base_datos.db");
			String consulta = "SELECT Nombre, Puntuación, Tiempo, Velocidad, Paredes, Bloques FROM TablaSnake";
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
						rS.getInt("Velocidad"),
						rS.getString("Paredes"),
						rS.getString("Bloques")
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
