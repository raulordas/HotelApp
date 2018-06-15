package persistencia;

import java.sql.*;
import modelo.*;
import java.util.ArrayList;

public class PersistenciaHabitaciones {
	private ConexionBBDD conexion;

	public PersistenciaHabitaciones() {
		this.conexion = new ConexionBBDD();
	}
	
	public ArrayList<Habitacion> consultarHabitaciones() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query;
		ArrayList<Habitacion> listaHabitaciones = new ArrayList<Habitacion>();
		Habitacion habitacionAux = null;
		TipoHabitacion tipoHabitacionAux = null;
		
		try {
			con = conexion.conectar();
			st = con.createStatement();
			query = "SELECT  * FROM HABITACION, TIPOHABITACION WHERE HABITACION.TIPO = TIPOHABITACION.ID_T";
			rs = st.executeQuery(query);
				
			while (rs.next()) {
				tipoHabitacionAux = new TipoHabitacion(rs.getInt(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getString(7));
				habitacionAux = new Habitacion(rs.getInt(1), tipoHabitacionAux);
				listaHabitaciones.add(habitacionAux);
			}
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return listaHabitaciones;
	}
	
	public ArrayList<TipoHabitacion> consultarTipoHabitaciones() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query;
		ArrayList<TipoHabitacion> listaHabitaciones = new ArrayList<TipoHabitacion>();
		TipoHabitacion tipoHabitacionAux = null;
		
		try {
			con = conexion.conectar();
			st = con.createStatement();
			query = "SELECT  * FROM TIPOHABITACION";
			rs = st.executeQuery(query);
				
			while (rs.next()) {
				tipoHabitacionAux = new TipoHabitacion(rs.getInt(1), rs.getDouble(2), rs.getDouble(3), rs.getDouble(4), rs.getString(5));
				listaHabitaciones.add(tipoHabitacionAux);
			}
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return listaHabitaciones;
	}
}
