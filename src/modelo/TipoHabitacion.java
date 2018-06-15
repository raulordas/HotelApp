package modelo;

public class TipoHabitacion {
	private int id_tipo;
	private double precio_alta;
	private double precio_baja;
	private double coeficiente_ocupacion;
	private String descripcion;
	
	public TipoHabitacion(int id_tipo, double precio_alta, double precio_baja, double coeficiente_ocupacion,
			String descripcion) {
		this.id_tipo = id_tipo;
		this.precio_alta = precio_alta;
		this.precio_baja = precio_baja;
		this.coeficiente_ocupacion = coeficiente_ocupacion;
		this.descripcion = descripcion;
	}

	public int getId_tipo() {
		return id_tipo;
	}

	public double getPrecio_alta() {
		return precio_alta;
	}

	public double getPrecio_baja() {
		return precio_baja;
	}

	public double getCoeficiente_ocupacion() {
		return coeficiente_ocupacion;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
