package modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import persistencia.ModeloTablaAlbaran;

public class CalculadoraPrecios {
	private double precio_Alta;
	private double precio_Baja;
	private double precio_Final;
	private double precio_Dia;
	private ModeloTablaAlbaran modeloTabla;
	Albaran albaran;
	
	public CalculadoraPrecios(ArrayList<String> listaFechasReserva, Consulta consulta, Habitacion habitacionEscogida, int numReservas) {
		
		//Comparador de String para ordenar las fechas que se muestran al usuario
		Comparator<String> comp = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				StringTokenizer tokenizerA = new StringTokenizer(o1);
				StringTokenizer tokenizerB = new StringTokenizer(o2);
				
				tokenizerA.nextToken();
				tokenizerA.nextToken();
				
				tokenizerB.nextToken();
				tokenizerB.nextToken();
				
			return tokenizerA.nextToken().compareTo(tokenizerB.nextToken());
			
			}
		};
		
		//Ordena la lista que se le muestra al usuario por fecha ascendente
		Collections.sort(listaFechasReserva, comp);
		
		precio_Final = 0;
		modeloTabla = new ModeloTablaAlbaran();
		int dia_semana;
		int mes;
		StringTokenizer fecha = null;
		
		//Analiza los costes para las fechas escogidas y la habitación seleccionada por el usuario
		for (int i = 0; i < listaFechasReserva.size(); i++) {
			fecha = new StringTokenizer(listaFechasReserva.get(i));
			precio_Dia = 0;
			precio_Alta = 0;
			precio_Baja = 0;
			
			dia_semana = Integer.parseInt(fecha.nextToken());
			mes = Integer.parseInt(fecha.nextToken());
			
			//Extrae la duración en dias de la consulta a partir de la seleccion del usuario
			LocalDateTime origen = LocalDateTime.ofInstant(consulta.getFecha_Entrada().toInstant(), ZoneId.systemDefault());
			LocalDateTime destino = LocalDateTime.ofInstant(consulta.getFecha_Salida().toInstant(), ZoneId.systemDefault());
			Duration d = Duration.between(origen, destino);
			long dias = d.toDays();
			
			//Calcula el porcentaje de ocupación en el periodo elegido por el usuario
			long porcPeriodo = numReservas * 100 / dias * 7;
						
			//Aplica un precio si es temporada alta (fines de semana o julio y agosto)
			if (dia_semana == 6 || dia_semana == 7 || mes == 7 || mes == 8 || mes == 12) {
				precio_Alta = habitacionEscogida.getTipo().getPrecio_alta();
				
				//Rectifica el precio aplicado si la ocupacion es alta, añadiéndole un porcentaje definido en el objeto.
				if (porcPeriodo >= 60) {
					precio_Dia = precio_Alta - precio_Alta * (habitacionEscogida.getTipo().getCoeficiente_ocupacion() / 100);
				
				//Rectifica el precio aplicado si la ocupacion es alta, añadiéndole un porcentaje definido en el objeto.
				} else if (porcPeriodo < 60) {
					precio_Dia = precio_Alta + precio_Alta * (habitacionEscogida.getTipo().getCoeficiente_ocupacion() / 100);
				}
				
			//Aplica un precio si es temporada baja
			} else {
				precio_Baja =  habitacionEscogida.getTipo().getPrecio_baja();
				
				//Rectifica el precio aplicado si la ocupacion es alta, añadiéndole un porcentaje definido en el objeto.
				if (porcPeriodo >= 60) {
					precio_Dia = precio_Baja - precio_Baja * (habitacionEscogida.getTipo().getCoeficiente_ocupacion() / 100);
				
				//Rectifica el precio aplicado si la ocupacion es alta, añadiéndole un porcentaje definido en el objeto.
				} else if (porcPeriodo < 60) {
					precio_Dia = precio_Baja + precio_Baja * (habitacionEscogida.getTipo().getCoeficiente_ocupacion() / 100);
				}
			}
			
			//Genera un objeto de tipo albaran que se mostrará como resultado al cliente antes de confirmar la reserva
			albaran = new Albaran(listaFechasReserva.get(i), precio_Alta, precio_Baja, habitacionEscogida.getTipo().getCoeficiente_ocupacion(), precio_Dia);	
			modeloTabla.agregarAlbaran(albaran);
			precio_Final += precio_Dia;
		}	
	}

	public double getPrecio_Final() {
		return precio_Final;
	}

	public ModeloTablaAlbaran getModeloTabla() {
		return modeloTabla;
	}
}
