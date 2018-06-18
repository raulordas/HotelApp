package persistencia;

import java.util.ArrayList;
import java.util.Date;
import modelo.*;
import java.sql.*;

public class PersistenciaReservas {
	private ConexionBBDD conexion;

	public PersistenciaReservas() {
		conexion = new ConexionBBDD();
	}
	
	public int insertarReserva(Reserva reserva) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int num = 0;
		String fecha_Entrada;
		String fecha_Salida;
		
		fecha_Entrada = new CalculadoraFechas().conversorFechaSQLite(reserva.getFecha_Entrada());
		fecha_Salida = new CalculadoraFechas().conversorFechaSQLite(reserva.getFecha_Salida());
				
		try {
			con = conexion.conectar();
			
			String query = "INSERT INTO RESERVA (CLIENTE, HABITACION, FECHA_ENTRADA, FECHA_SALIDA, PRECIO_FINAL) VALUES (?,?,?,?,?)";
			
			ps = con.prepareStatement(query);
			ps.setInt(1, reserva.getCliente());
			ps.setInt(2, reserva.getHabitacion());
			ps.setString(3, fecha_Entrada);
			ps.setString(4, fecha_Salida);
			ps.setDouble(5, reserva.getPrecio_Final());

			num = ps.executeUpdate();
			
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
			
			if (ps != null) {
				try {
					ps.close();
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
		return num;
	}
	
	public ArrayList<Reserva> consultarReservas(AdministradorPojo usuario) {
		ArrayList<Reserva> listaReservas = new ArrayList<Reserva>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Reserva reserva = null;
		Date fechaAux_E = null;
		Date fechaAux_S = null;
		
		try {
			con = conexion.conectar();
			
			String query = "SELECT * FROM RESERVA, CLIENTE WHERE CLIENTE.USUARIO = ? "
					+ "AND CLIENTE.ID_CLI = RESERVA.CLIENTE";
			
			ps = con.prepareStatement(query);
			ps.setString(1, usuario.getUsuario());
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				fechaAux_E = new CalculadoraFechas().conversorFechaDate(rs.getString(4));
				fechaAux_S = new CalculadoraFechas().conversorFechaDate(rs.getString(5));
				
				reserva = new Reserva(rs.getInt(1), rs.getInt(2), rs.getInt(3), fechaAux_E, fechaAux_S, rs.getDouble(6));
				listaReservas.add(reserva);
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
			
			if (ps != null) {
				try {
					ps.close();
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
		return listaReservas;
	}
	public int insertarReservaAnonima(Reserva reserva, Cliente cliente) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int num = 0;
		String fecha_Entrada;
		String fecha_Salida;
		int idCli = 0;
		
		fecha_Entrada = new CalculadoraFechas().conversorFechaSQLite(reserva.getFecha_Entrada());
		fecha_Salida = new CalculadoraFechas().conversorFechaSQLite(reserva.getFecha_Salida());
				
		try {
			con = conexion.conectar();
			
			String query = "INSERT INTO CLIENTE (NOMBRE, APELLIDOS, EMAIL, DIRECCION, CODIGO_POSTAL,"
					+ " PERMANENTE) VALUES (?,?,?,?,?,?)";
			
			//Inserta el cliente anónimo en la base de datos
			ps = con.prepareStatement(query);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setString(3, cliente.getEmail());
			ps.setString(4, cliente.getDireccion());
			ps.setInt(5, cliente.getCodigo_postal());
			ps.setString(6, cliente.getPermanente());

			num = ps.executeUpdate();
			ps.close();
			
			//Consulta el identificador generado automaticamente para dicho usuario
			query = "SELECT MAX(ID_CLI) FROM CLIENTE";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				idCli = rs.getInt(1);
			}
			
			rs.close();
			ps.close();
			
			//Inserta la reserva en nombre del nuevo cliente generado.
			query = "INSERT INTO RESERVA (CLIENTE, HABITACION, FECHA_ENTRADA, FECHA_SALIDA, PRECIO_FINAL) VALUES (?,?,?,?,?)";
			
			ps = con.prepareStatement(query);
			ps.setInt(1, idCli);
			ps.setInt(2, reserva.getHabitacion());
			ps.setString(3, fecha_Entrada);
			ps.setString(4, fecha_Salida);
			ps.setDouble(5, reserva.getPrecio_Final());

			num = ps.executeUpdate();
			
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
			
			if (ps != null) {
				try {
					ps.close();
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
		return num;
	}
}
