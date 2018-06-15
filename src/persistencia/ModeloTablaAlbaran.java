package persistencia;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelo.Albaran;

@SuppressWarnings("serial")
public class ModeloTablaAlbaran extends AbstractTableModel {
	private ArrayList<Albaran> listAlbaran;
	private String datos[] = {"FECHA","PRECIO_ALTA", "PRECIO_BAJA", "COEFICIENTE", "PRECIO POR DIA"};
	
	public ModeloTablaAlbaran() {
		listAlbaran = new ArrayList<Albaran>();	
	}
	
	public void agregarAlbaran(Albaran albaran) {
		listAlbaran.add(albaran);
	}
	
	@Override
	public String getColumnName(int index) {
		return datos[index];
	}

	@Override
	public int getColumnCount() {
		return datos.length;
	}

	@Override
	public int getRowCount() {
		return listAlbaran.size();
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int fila, int col) {
		if (col == 0) {
			return listAlbaran.get(fila).getFecha();
		
		} else if (col == 1) {
			return listAlbaran.get(fila).getPrecio_Alta();
			
		} else if (col == 2) {
			return listAlbaran.get(fila).getPrecio_Baja();
		
		} else if (col == 3) {
			return listAlbaran.get(fila).getCoeficiente();
		
		} else {
			return listAlbaran.get(fila).getPrecio_dia();
		}
	}
}
