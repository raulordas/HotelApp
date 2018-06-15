package modelo;

public class ClientePermanente extends Cliente {
	private String usuario;
	private String password;
	
	public ClientePermanente(int id_cli, String nombre, String apellido, String email, String direccion,
			int codigo_postal, String permanente, String usuario, String password) {
		super(id_cli, nombre, apellido, email, direccion, codigo_postal, permanente);
		this.usuario = usuario;
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getPassword() {
		return password;
	}
}
