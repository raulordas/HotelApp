package modelo;
import java.util.*;

public class CalculadoraFechas {
	ArrayList<String> fechasDisponibles;
	
	public CalculadoraFechas() {
		fechasDisponibles = new ArrayList<String>();
	}
	
	/* Método que almacena en un ArrayList todas las listas comprendidas
	 * en el rango facilitado por el usuario al realizar la consulta.
	 * Para ello, almacena en el ArrayList la fecha de entrada y de salida y
	 * posteriormente le va restando un dia a la fecha de salida hasta que
	 * la fecha de salida sea posterior a la de entrada. 
	 */
	@SuppressWarnings("deprecation")
	public void extraerFechasPosibles (Consulta consulta) {
		fechasDisponibles.clear();
		Calendar c = Calendar.getInstance();
		Date fechaEntrada = consulta.getFecha_Entrada();
		Date fechaSalida = consulta.getFecha_Salida();
		Date fechaAux = fechaSalida;
		String fechEliminar;
		
		c.setTime(fechaSalida);
		fechEliminar = c.get(Calendar.DAY_OF_WEEK) + " " + (c.get(Calendar.MONTH) + 1) + " " 
				+ c.get(Calendar.DAY_OF_MONTH) + " " + c.get(Calendar.YEAR);
		
		fechasDisponibles.add(fechEliminar);
		
		c.setTime(fechaEntrada);
		fechasDisponibles.add(c.get(Calendar.DAY_OF_WEEK) + " " + (c.get(Calendar.MONTH) + 1) + " " 
		+ c.get(Calendar.DAY_OF_MONTH) + " " + c.get(Calendar.YEAR));
		
		while (fechaAux.getDate() != fechaEntrada.getDate()) {
			c.setTime(fechaAux);
			c.add(Calendar.DATE, -1);
			fechaAux = c.getTime();

			if (fechaAux.getDate() != fechaEntrada.getDate()) {
				fechasDisponibles.add(c.get(Calendar.DAY_OF_WEEK) + " " 
						+ (c.get(Calendar.MONTH) + 1) + " " + c.get(Calendar.DAY_OF_MONTH) + " " + c.get(Calendar.YEAR));
			}
			
		}
		
		//Elimina el dia de salida de la lista, ya que este no se factura ni cuenta realmente.
		for (int i = 0; i < fechasDisponibles.size(); i ++) {
			if (fechasDisponibles.get(i).equals(fechEliminar)) {
				fechasDisponibles.remove(i);
			}
		}
	}

	public ArrayList<String> getFechasDisponibles() {
		return fechasDisponibles;
	}
	
	//Método para solventar las limitaciones de Date en Java y SQLite
	@SuppressWarnings("deprecation")
	public String conversorFechaSQLite(Date fecha) {
		Calendar c = Calendar.getInstance();
		c.setTime(fecha);
		String fechaResultado = "";
		
		if (fecha.getMonth() <= 9 && fecha.getDate() <= 9) {
			fechaResultado = "0" + (c.get(Calendar.MONTH) + 1) + "-" + "0" + c.get(Calendar.DAY_OF_MONTH) + "-" 
					+ c.get(Calendar.YEAR);
		
		} else if (fecha.getDate() <= 9) {
			fechaResultado = (c.get(Calendar.MONTH) + 1) + "-" + "0" + c.get(Calendar.DAY_OF_MONTH) + "-" 
					+ c.get(Calendar.YEAR);
		
		} else if (fecha.getMonth() <= 9) {
			fechaResultado = "0" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DAY_OF_MONTH) + "-" 
					+ c.get(Calendar.YEAR);
		} else {
			fechaResultado = (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DAY_OF_MONTH) + "-" 
					+ c.get(Calendar.YEAR);
		}
		
		return fechaResultado;
	}
	
	//Método para solventar las limitaciones de Date en Java y SQLite
	@SuppressWarnings("deprecation")
	public Date conversorFechaDate(String fechaSQLite) {
		Date fecha;
		StringTokenizer tokenizador = new StringTokenizer(fechaSQLite, "-");
		
		int mesAux = Integer.parseInt(tokenizador.nextToken());
		mesAux++;
		
		String mes = String.valueOf(mesAux);
		String dia = tokenizador.nextToken();
		String anyo = tokenizador.nextToken();
		
		fecha = new Date(mes + "/" + dia + "/" + anyo);
		
		return fecha;
	}
}
