package modelo;

import java.util.Date;

public class Reserva {
	private int id_Reserva;
	private int cliente;
	private int habitacion;
	private Date fecha_Entrada;
	private Date fecha_Salida;
	private double precio_Final;
	
	public Reserva(int habitacion) {
		this.habitacion = habitacion;
	}
	
	public Reserva(int id_Reserva, int cliente, int habitacion, Date fecha_Entrada, Date fecha_Salida,
			double precio_Final) {
		this.id_Reserva = id_Reserva;
		this.cliente = cliente;
		this.habitacion = habitacion;
		this.fecha_Entrada = fecha_Entrada;
		this.fecha_Salida = fecha_Salida;
		this.precio_Final = precio_Final;
	}

	public int getHabitacion() {
		return habitacion;
	}

	@Override
	public boolean equals(Object obj) {
		 if (obj == null) return false;
		    if (!(obj instanceof Reserva))
		        return false;
		    if (obj == this)
		        return true;
		    return this.getHabitacion() == ((Reserva) obj).getHabitacion();
	}

	@Override
	public int hashCode() {
		return this.getHabitacion();
	}

	public int getId_Reserva() {
		return id_Reserva;
	}

	public int getCliente() {
		return cliente;
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
