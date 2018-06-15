package persistencia;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.*;

public class PersistenciaUsuarios {
	private ConexionBBDD conexion;

	public PersistenciaUsuarios() {
		conexion = new ConexionBBDD();
	}
	
	public int comprobarPassword(AdministradorPojo usuario) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = conexion.conectar();
			
			String query = "SELECT * FROM CLIENTE WHERE USUARIO = ? AND PASSWORD = ?";
			
			ps = con.prepareStatement(query);
			ps.setString(1, usuario.getUsuario());
			ps.setString(2, usuario.getContrasenya());
			rs = ps.executeQuery();
			
			//Si la contraseña es correcta retorna un dato de tipo entero (1) al controlador
			if (rs.next()) {
				return 1;
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
		return 0;
	}
	
	public int insertarClientePermanente(ClientePermanente cliente) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int num = 0;
		
		try {
			con = conexion.conectar();
			
			String query = "INSERT INTO CLIENTE (NOMBRE, APELLIDOS, EMAIL, DIRECCION, CODIGO_POSTAL,"
					+ " PERMANENTE, USUARIO, PASSWORD) VALUES (?,?,?,?,?,?,?,?)";
			
			ps = con.prepareStatement(query);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setString(3, cliente.getEmail());
			ps.setString(4, cliente.getDireccion());
			ps.setInt(5, cliente.getCodigo_postal());
			ps.setString(6, cliente.getPermanente());
			ps.setString(7, cliente.getUsuario());
			ps.setString(8, cliente.getPassword());
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
	
	public int insertarCliente(Cliente cliente) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int num = 0;
		
		try {
			con = conexion.conectar();
			
			String query = "INSERT INTO CLIENTE (NOMBRE, APELLIDOS, EMAIL, DIRECCION, CODIGO_POSTAL,"
					+ " PERMANENTE) VALUES (?,?,?,?,?,?)";
			
			ps = con.prepareStatement(query);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setString(3, cliente.getEmail());
			ps.setString(4, cliente.getDireccion());
			ps.setInt(5, cliente.getCodigo_postal());
			ps.setString(6, cliente.getPermanente());
			
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
	
	public Cliente consultarUsuarioPermanente(AdministradorPojo usuario) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Cliente cliente = null;
		
		try {
			con = conexion.conectar();
			
			String query = "SELECT * FROM CLIENTE WHERE USUARIO = ? AND PASSWORD = ?";
			
			ps = con.prepareStatement(query);
			ps.setString(1, usuario.getUsuario());
			ps.setString(2, usuario.getContrasenya());
			rs = ps.executeQuery();
		
			while (rs.next()) {
				cliente = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7));
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
		return cliente;
	}
	
	public ArrayList<String> consultarListaUsuarios () {
		ArrayList<String> listaUsuarios = new ArrayList<String>();
		String adminAux = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = conexion.conectar();
			
			String query = "SELECT USUARIO FROM CLIENTE WHERE NOT USUARIO IS NULL";
			
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				adminAux = rs.getString(1);
				listaUsuarios.add(adminAux);
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
		return listaUsuarios;
	}
}