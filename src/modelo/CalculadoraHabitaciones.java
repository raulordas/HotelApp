package modelo;

import java.util.ArrayList;

public class CalculadoraHabitaciones {
	private int numSencillas;
	private int numDobles;
	private int numSuite;
	private ArrayList<Habitacion> listaHabitaciones;
	
	//Constructor que asigna el número de habitaciones del hotel
	public CalculadoraHabitaciones(ArrayList<Habitacion> listaHabitaciones) {
		this.listaHabitaciones = listaHabitaciones;
		
		for (int i = 0; i < listaHabitaciones.size(); i++) {
			
			if (this.listaHabitaciones.get(i).getTipo().getId_tipo() == 1) {
				numSencillas++;
			
			} else if (this.listaHabitaciones.get(i).getTipo().getId_tipo() == 2) {
				numDobles++;
			
			} else {
				numSuite++;
			}
		}
	}
	
	//Método que ajusta las habitaciones disponibles en función de las reservas del periodo
	public ArrayList<Habitacion> calcularHabitacionesDisponibles(ArrayList<Reserva> listReservas) {
		ArrayList<Habitacion> listaBorrar = new ArrayList<Habitacion>();
		
		for (int i = listaHabitaciones.size() -1; i >= 0; i--) {
			
			for (Reserva aux : listReservas) {
				
				if (listaHabitaciones.get(i).getId_hab() == aux.getHabitacion()) {
					listaBorrar.add(listaHabitaciones.get(i));
					
					if (listaHabitaciones.get(i).getTipo().getId_tipo() == 1) {
						numSencillas--;

					} else if (listaHabitaciones.get(i).getTipo().getId_tipo() == 2) {
						numDobles--;
					
					} else if (listaHabitaciones.get(i).getTipo().getId_tipo() == 3) {
						numSuite--;
					}
				}
			}
		}
		
		for (int j = 0; j < listaBorrar.size(); j++) {
			listaHabitaciones.remove(listaBorrar.get(j));
		}
		return listaHabitaciones;
	}
	
	//Método que escoge una habitación disponible para la reserva
	public Habitacion escogerHabitacion(int index) {
		Habitacion habitacionElegida = null;
		boolean stop = false;
		
		for (int i = 0; i < listaHabitaciones.size() && !stop; i++) {
			
			if (listaHabitaciones.get(i).getTipo().getId_tipo() == index) {
				habitacionElegida = listaHabitaciones.get(i);
				stop = true;
			}
		}
		return habitacionElegida;
	}

	public int getNumSencillas() {
		if (numSencillas < 0) {
			return 0;
		} else {
			return numSencillas;
		}
	}

	public int getNumDobles() {
		if (numDobles < 0) {
			return 0;
		} else {
			return numDobles;
		}
	}

	public int getNumSuite() {
		if (numSuite < 0) {
			return 0;
		} else {
			return numSuite;
		}
	}	
}
