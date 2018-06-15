package modelo;

public class AdministradorPojo {
	private String usuario;
	private String contrasenya;
	
	public AdministradorPojo(String usuario) {
		this.usuario = usuario;
	}
	
	public AdministradorPojo(String usuario, String contrasenya) {
		this.usuario = usuario;
		this.contrasenya = contrasenya;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public String getContrasenya() {
		return contrasenya;
	}
}