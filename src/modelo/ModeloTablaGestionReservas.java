package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ModeloTablaGestionReservas extends AbstractTableModel {
	private ArrayList<InfoGestionReserva> listReservas;
	private String[] nombreColumnas = {"IDENTIFICADOR_RESERVA", "NOMBRE", "APELLIDOS", "HABITACION","FECHA_ENTRADA", "FECHA SALIDA", "PRECIO RESERVA"};

	public ModeloTablaGestionReservas(ArrayList<InfoGestionReserva> listReservas) {
		this.listReservas = listReservas;
	}

	@Override
	public int getColumnCount() {
		return nombreColumnas.length;
	}

	@Override
	public int getRowCount() {
		return listReservas.size();
	}

	@Override
	public Object getValueAt(int fila, int col) {
		
		InfoGestionReserva reserva = listReservas.get(fila);
		Calendar cal = Calendar.getInstance();
		cal.setTime(reserva.getFecha_Entrada());
		String fechaE = cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.DAY_OF_MONTH) + "-" + cal.get(Calendar.YEAR);
		cal.setTime(reserva.getFecha_Salida());
		String fechaS = cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.DAY_OF_MONTH) + "-" + cal.get(Calendar.YEAR);
		
		if (col == 0) {
			return reserva.getId_Reserva();
		} else if (col == 1) {
			return reserva.getNombre();
		} else if (col == 2) {
			return reserva.getApellidos();
		} else if (col == 3) {
			return reserva.getHabitacion();
		} else if (col == 4) {
			return fechaE;
		} else if (col == 5) {
			return fechaS;
		} else {
			return reserva.getPrecio_Final() + " €";
		}
	}

	@Override
	public String getColumnName(int columna) {
		return nombreColumnas[columna];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
}
