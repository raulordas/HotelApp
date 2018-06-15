package modelo;

import java.util.Date;

public class Consulta {
	private Date fecha_Entrada;
	private Date fecha_Salida;
	
	public Consulta(Date fecha_Entrada, Date fecha_Salida) {
		this.fecha_Entrada = fecha_Entrada;
		this.fecha_Salida = fecha_Salida;
	}

	public Date getFecha_Entrada() {
		return fecha_Entrada;
	}

	public Date getFecha_Salida() {
		return fecha_Salida;
	}
}
