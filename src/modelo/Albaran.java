package modelo;

public class Albaran {
	private String fecha;
	private double precio_Alta;
	private double precio_Baja;
	private double coeficiente;
	private double precio_dia;
	
	public Albaran() {}
	
	public Albaran(String fecha, double precio_Alta, double precio_Baja, double coeficiente, double precio_dia) {
		super();
		this.fecha = fecha;
		this.precio_Alta = precio_Alta;
		this.precio_Baja = precio_Baja;
		this.coeficiente = coeficiente;
		this.precio_dia = precio_dia;
	}

	public String getFecha() {
		return fecha;
	}

	public double getPrecio_Alta() {
		return precio_Alta;
	}

	public double getPrecio_Baja() {
		return precio_Baja;
	}

	public double getCoeficiente() {
		return coeficiente;
	}

	public double getPrecio_dia() {
		return precio_dia;
	}
}
