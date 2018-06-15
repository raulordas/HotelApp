package modelo;

public class Habitacion {
	private int id_hab;
	private TipoHabitacion tipo;
	
	public Habitacion(int id_hab, TipoHabitacion tipo) {
		this.id_hab = id_hab;
		this.tipo = tipo;
	}

	public int getId_hab() {
		return id_hab;
	}

	public TipoHabitacion getTipo() {
		return tipo;
	}
}
