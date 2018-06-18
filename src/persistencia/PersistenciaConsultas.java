package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import modelo.*;

public class PersistenciaConsultas {
	private ConexionBBDD conexion;
	private int numReservas;

	public PersistenciaConsultas() {
		this.conexion = new ConexionBBDD();
	}
	
	public ArrayList<Reserva> consultarDisponibilidad(Consulta consulta) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query;
		ArrayList<Reserva> listReservas = new ArrayList<Reserva>();
		Reserva reservaAux = null;
		String fecha_Entrada;
		String fecha_Salida;
		
		fecha_Entrada = new CalculadoraFechas().conversorFechaSQLite(consulta.getFecha_Entrada());
		fecha_Salida = new CalculadoraFechas().conversorFechaSQLite(consulta.getFecha_Salida());
			
		try {
			con = conexion.conectar();
			st = con.createStatement();
			
			query = "SELECT HABITACION FROM RESERVA WHERE (FECHA_ENTRADA BETWEEN '" 
					+ fecha_Entrada + "' AND '" + fecha_Salida + "' OR FECHA_SALIDA BETWEEN '" 
					+ fecha_Entrada + "' AND '" + fecha_Salida + "' OR (FECHA_ENTRADA < '" 
					+ fecha_Entrada + "' AND FECHA_SALIDA >= '" + fecha_Salida +"'))";
			
			rs = st.executeQuery(query);
				
			while (rs.next()) {
					reservaAux = new Reserva(rs.getInt(1));
					listReservas.add(reservaAux);
			}
			
			numReservas = listReservas.size();
			
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
		return listReservas;
	}

	public int getNumReservas() {
		return numReservas;
	}
	
	public ArrayList<InfoGestionReserva> consultarReservasPeriodo(Consulta consulta) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query;
		ArrayList<InfoGestionReserva> listReservas = new ArrayList<InfoGestionReserva>();
		InfoGestionReserva reservaAux = null;
		String fecha_Entrada;
		String fecha_Salida;
		Date fechaAux_E = null;
		Date fechaAux_S = null;
		
		fecha_Entrada = new CalculadoraFechas().conversorFechaSQLite(consulta.getFecha_Entrada());
		fecha_Salida = new CalculadoraFechas().conversorFechaSQLite(consulta.getFecha_Salida());
		
		try {
			con = conexion.conectar();
			st = con.createStatement();
			
			query = "SELECT RESERVA.ID_RESERVA, CLIENTE.NOMBRE, CLIENTE.APELLIDOS, RESERVA.HABITACION, "
					+ "RESERVA.FECHA_ENTRADA, RESERVA.FECHA_SALIDA, RESERVA.PRECIO_FINAL "
					+ "FROM RESERVA, CLIENTE WHERE (FECHA_ENTRADA BETWEEN '" 
					+ fecha_Entrada + "' AND '" + fecha_Salida + "' OR FECHA_SALIDA BETWEEN '" 
					+ fecha_Entrada + "' AND '" + fecha_Salida + "' OR (FECHA_ENTRADA < '" 
					+ fecha_Entrada + "' AND FECHA_SALIDA >= '" + fecha_Salida +"')) AND RESERVA.CLIENTE = CLIENTE.ID_CLI";

			rs = st.executeQuery(query);
				
			while (rs.next()) {
				fechaAux_E = new CalculadoraFechas().conversorFechaDate(rs.getString(5));
				fechaAux_S = new CalculadoraFechas().conversorFechaDate(rs.getString(6));
				
				reservaAux = new InfoGestionReserva(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), fechaAux_E, fechaAux_S, rs.getDouble(7));
				listReservas.add(reservaAux);
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
		return listReservas;
	}
}
