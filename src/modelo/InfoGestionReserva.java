package modelo;

import java.util.Date;

public class InfoGestionReserva {
	private int id_Reserva;
	private String nombre;
	private String apellidos;
	private int habitacion;
	private Date fecha_Entrada;
	private Date fecha_Salida;
	private double precio_Final;
	
	public InfoGestionReserva(int id_Reserva, String nombre, String apellidos, int habitacion, Date fecha_Entrada,
			Date fecha_Salida, double precio_Final) {
		this.id_Reserva = id_Reserva;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.habitacion = habitacion;
		this.fecha_Entrada = fecha_Entrada;
		this.fecha_Salida = fecha_Salida;
		this.precio_Final = precio_Final;
	}

	public int getId_Reserva() {
		return id_Reserva;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public int getHabitacion() {
		return habitacion;
	}

	public Date getFecha_Entrada() {
		return fecha_Entrada;
	}

	public Date getFecha_Salida() {
		return fecha_Salida;
	}

	public double getPrecio_Final() {
		return precio_Final;
	}
}
