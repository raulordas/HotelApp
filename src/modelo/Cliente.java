package modelo;

public class Cliente {
	protected int id_cli;
	protected String nombre;
	protected String apellido;
	protected String email;
	protected String direccion;
	protected int codigo_postal;
	protected String permanente;
	
	public Cliente(int id_cli, String nombre, String apellido, String email, String direccion, int codigo_postal,
			String permanente) {
		this.id_cli = id_cli;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.direccion = direccion;
		this.codigo_postal = codigo_postal;
		this.permanente = permanente;
	}

	public int getId_cli() {
		return id_cli;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getEmail() {
		return email;
	}

	public String getDireccion() {
		return direccion;
	}

	public int getCodigo_postal() {
		return codigo_postal;
	}

	public String getPermanente() {
		return permanente;
	}
}
