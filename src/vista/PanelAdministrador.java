package vista;

import javax.swing.*;
import modelo.*;
import java.time.*;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.border.LineBorder;
import controlador.ControladorHotel;
import persistencia.ModeloTablaAlbaran;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class PanelAdministrador extends JPanel implements IHotel {
	private JButton btnBuscar;
	private JScrollPane scrollPane;
	private JTable table;
	private int idCliente;
	private JLabel label;
	private ModeloTablaGestionReservas model;
	private JButton btnHab100;
	private JDateChooser calendarioFechaSalida;
	private JDateChooser calendarioFechaEntrada;
	private JLabel lblFechaDeInicio;
	private JLabel lblFechaDeFin;
	private JButton btnHab103;
	private JButton btnHab102;
	private JButton btnHab104;
	private JButton btnHab105;
	private JButton btnHab106;
	private JLabel lblNumeroDeReservas;
	private JLabel lblFacturacion;
	private JLabel lblPorcentajeDeOcupacion;
	private JButton btnHab101;
	private JLabel periodoDias;
	
	public PanelAdministrador() {
		inicializar();
	}

	@Override
	public void inicializar() {
		
		//Color Background Panel
		setBackground(Color.WHITE);
		
		//Tamaño Panel
		setBounds(0, 0, 1294, 689);
		
		//Layout
		setLayout(null);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(PanelAdministrador.class.getResource("/images/Hotel_Logo_reducido.png")));
		label.setBounds(81, 11, 161, 118);
		add(label);
		
		//Panel Background Gris
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 167, 1284, 522);
		add(panel);
		panel.setLayout(null);
		
		//Boton Reserva
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setOpaque(false);
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("Calibri", Font.BOLD, 14));
		btnBuscar.setBorder(new LineBorder(new Color(233, 188, 103), 3));
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setBounds(605, 50, 208, 46);
		panel.add(btnBuscar);
		
		//Scroll Pane Tabla
		scrollPane = new JScrollPane();
		scrollPane.setBounds(385, 184, 857, 159);
		panel.add(scrollPane);
		
		//Componente JTable
		table = new JTable();
		table.setShowGrid(false);
		table.setRowSelectionAllowed(false);
		table.setFont(new Font("Calibri", Font.PLAIN, 12));
		table.setGridColor(new Color(255, 255, 255));
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		//Label Fecha inicio
		lblFechaDeInicio = new JLabel("FECHA DE INICIO");
		lblFechaDeInicio.setHorizontalTextPosition(SwingConstants.LEADING);
		lblFechaDeInicio.setHorizontalAlignment(SwingConstants.LEFT);
		lblFechaDeInicio.setForeground(Color.WHITE);
		lblFechaDeInicio.setFont(new Font("Calibri", Font.BOLD, 16));
		lblFechaDeInicio.setBounds(53, 38, 145, 29);
		panel.add(lblFechaDeInicio);
		
		//Calendario Fecha Entrada
		calendarioFechaEntrada = new JDateChooser();
		calendarioFechaEntrada.setBounds(208, 38, 343, 29);
		panel.add(calendarioFechaEntrada);
		
		//Label Fecha Fin
		lblFechaDeFin = new JLabel("FECHA DE FIN");
		lblFechaDeFin.setHorizontalTextPosition(SwingConstants.LEADING);
		lblFechaDeFin.setHorizontalAlignment(SwingConstants.LEFT);
		lblFechaDeFin.setForeground(Color.WHITE);
		lblFechaDeFin.setFont(new Font("Calibri", Font.BOLD, 16));
		lblFechaDeFin.setBounds(53, 92, 128, 29);
		panel.add(lblFechaDeFin);
		
		//Calendario Fecha Salida
		calendarioFechaSalida = new JDateChooser();
		calendarioFechaSalida.setBounds(208, 92, 343, 29);
		panel.add(calendarioFechaSalida);
		
		//Imagen Hab100
		btnHab100 = new JButton("100");
		btnHab100.setFont(new Font("Arial", Font.PLAIN, 16));
		btnHab100.setBackground(new Color(0, 255, 0));
		btnHab100.setBounds(53, 184, 64, 63);
		panel.add(btnHab100);

		//Imagen Hab101
		btnHab101 = new JButton("101");
		btnHab101.setFont(new Font("Arial", Font.PLAIN, 16));
		btnHab101.setBackground(Color.GREEN);
		btnHab101.setBounds(169, 184, 64, 63);
		panel.add(btnHab101);
		
		//Imagen Hab102
		btnHab102 = new JButton("102");
		btnHab102.setFont(new Font("Arial", Font.PLAIN, 16));
		btnHab102.setBackground(Color.GREEN);
		btnHab102.setBounds(284, 184, 64, 63);
		panel.add(btnHab102);
		
		//Imagen Hab103
		btnHab103 = new JButton("103");
		btnHab103.setFont(new Font("Arial", Font.PLAIN, 16));
		btnHab103.setBackground(Color.GREEN);
		btnHab103.setBounds(53, 293, 64, 63);
		panel.add(btnHab103);
		
		//Imagen Hab104
		btnHab104 = new JButton("104");
		btnHab104.setFont(new Font("Arial", Font.PLAIN, 16));
		btnHab104.setBackground(Color.GREEN);
		btnHab104.setBounds(169, 293, 64, 63);
		panel.add(btnHab104);
		
		//Imagen Hab105
		btnHab105 = new JButton("105");
		btnHab105.setFont(new Font("Arial", Font.PLAIN, 16));
		btnHab105.setBackground(Color.GREEN);
		btnHab105.setBounds(284, 293, 64, 63);
		panel.add(btnHab105);
		
		//Imagen Hab106
		btnHab106 = new JButton("106");
		btnHab106.setFont(new Font("Arial", Font.PLAIN, 16));
		btnHab106.setBackground(Color.GREEN);
		btnHab106.setBounds(53, 400, 64, 63);
		panel.add(btnHab106);
		
		//Label Numero Reserva
		lblNumeroDeReservas = new JLabel("");
		lblNumeroDeReservas.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNumeroDeReservas.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumeroDeReservas.setForeground(Color.WHITE);
		lblNumeroDeReservas.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNumeroDeReservas.setBounds(385, 354, 365, 29);
		panel.add(lblNumeroDeReservas);
		
		//Label Facturacion
		lblFacturacion = new JLabel("");
		lblFacturacion.setHorizontalTextPosition(SwingConstants.LEADING);
		lblFacturacion.setHorizontalAlignment(SwingConstants.LEFT);
		lblFacturacion.setForeground(Color.WHITE);
		lblFacturacion.setFont(new Font("Calibri", Font.BOLD, 16));
		lblFacturacion.setBounds(385, 381, 365, 29);
		panel.add(lblFacturacion);
		
		//Label Ocupacion
		lblPorcentajeDeOcupacion = new JLabel("");
		lblPorcentajeDeOcupacion.setHorizontalTextPosition(SwingConstants.LEADING);
		lblPorcentajeDeOcupacion.setHorizontalAlignment(SwingConstants.LEFT);
		lblPorcentajeDeOcupacion.setForeground(Color.WHITE);
		lblPorcentajeDeOcupacion.setFont(new Font("Calibri", Font.BOLD, 16));
		lblPorcentajeDeOcupacion.setBounds(385, 410, 748, 20);
		panel.add(lblPorcentajeDeOcupacion);
		
		//Label Periodo Dias
		periodoDias = new JLabel("");
		periodoDias.setHorizontalTextPosition(SwingConstants.LEADING);
		periodoDias.setHorizontalAlignment(SwingConstants.LEFT);
		periodoDias.setForeground(Color.WHITE);
		periodoDias.setFont(new Font("Calibri", Font.BOLD, 16));
		periodoDias.setBounds(385, 153, 748, 20);
		panel.add(periodoDias);
		
		//Label Reserva
		JLabel lblReserva = new JLabel("GESTI\u00D3N DE LAS RESERVAS");
		lblReserva.setHorizontalAlignment(SwingConstants.CENTER);
		lblReserva.setForeground(new Color(233, 188, 103));
		lblReserva.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		lblReserva.setBounds(0, 108, 1284, 48);
		add(lblReserva);
	}

	@Override
	public void hacerVisible() {
		setVisible(true);	
	}
	
	public Consulta getDatos() {
		
		if (calendarioFechaEntrada.getDate() == null) {
			JOptionPane.showMessageDialog(getParent(), "La Fecha de Entrada no puede estar vacía");
			return null;
		
		} else if (calendarioFechaSalida.getDate() == null) {
			JOptionPane.showMessageDialog(getParent(), "La Fecha de Salida no puede estar vacía");
			return null;
			
		} else if (calendarioFechaEntrada.getDate().after(calendarioFechaSalida.getDate())) {
			JOptionPane.showMessageDialog(getParent(), "La Fecha de Entrada no puede ser posterior a la de salida");
			return null;
			
		} else {
			return new Consulta(calendarioFechaEntrada.getDate(), calendarioFechaSalida.getDate());
		}
	}
	
	public void mostrarReserva(ModeloTablaAlbaran model) {
		table.setModel(model);
	}
	
	public void setControlador(ControladorHotel control) {
		btnBuscar.addActionListener(control);
	}
	
	public void mostrarDatos(Consulta consulta, ArrayList<InfoGestionReserva> listReservas) {		
		btnHab100.setBackground(Color.GREEN);
		btnHab101.setBackground(Color.GREEN);
		btnHab102.setBackground(Color.GREEN);
		btnHab103.setBackground(Color.GREEN);
		btnHab104.setBackground(Color.GREEN);
		btnHab105.setBackground(Color.GREEN);
		btnHab106.setBackground(Color.GREEN);
		
		model = new ModeloTablaGestionReservas(listReservas);
		table.setModel(model);
		
		lblNumeroDeReservas.setText("NUMERO DE RESERVAS EN EL PERIODO: " + listReservas.size());
		colorear(listReservas);
		facturacionPrevista(listReservas);
		ocupacionMedia(consulta, listReservas);
	}
	
	public Reserva getDatos(Habitacion habitacion, Consulta consulta, double precio_Final) {
		return new Reserva(0, idCliente, habitacion.getId_hab(),consulta.getFecha_Entrada(), consulta.getFecha_Salida(), precio_Final);
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public int getIdCliente() {
		return idCliente;
	}
	
	public void ocupacionMedia(Consulta consulta, ArrayList<InfoGestionReserva> listReservas) {
		LocalDateTime origen = LocalDateTime.ofInstant(consulta.getFecha_Entrada().toInstant(), ZoneId.systemDefault());
		LocalDateTime destino = LocalDateTime.ofInstant(consulta.getFecha_Salida().toInstant(), ZoneId.systemDefault());
		Duration d = Duration.between(origen, destino);
		long dias = d.toDays();
		long hab = dias * 7;
		
		double porcMedio = listReservas.size() * 100 / hab;
		periodoDias.setText("EL PERIODO ESCOGIDO ES DE " + dias + " dias");
		lblPorcentajeDeOcupacion.setText("EL PORCENTAJE MEDIO DE OCUPACIÓN EN EL PERIODO HA SIDO DEL " + porcMedio + "%");
		
	}
	
	private void facturacionPrevista(ArrayList<InfoGestionReserva> listReservas) {
		double facturacion = 0;

		for (int i = 0; i < listReservas.size(); i++) {
			facturacion += listReservas.get(i).getPrecio_Final();
		}
		lblFacturacion.setText("LA FACTURACION ESTIMADA ES: " +  facturacion + " €");
	}
	
	private void colorear(ArrayList<InfoGestionReserva> listReservas) {
		
		for (int i = 0; i < listReservas.size(); i++) {
			
			if (listReservas.get(i).getHabitacion() == Integer.parseInt(btnHab100.getText())) {
				btnHab100.setBackground(Color.RED);
			} else if (listReservas.get(i).getHabitacion() == Integer.parseInt(btnHab101.getText())) {
				btnHab101.setBackground(Color.RED);
			} else if (listReservas.get(i).getHabitacion() == Integer.parseInt(btnHab102.getText())) {
				btnHab102.setBackground(Color.RED);
			} else if (listReservas.get(i).getHabitacion() == Integer.parseInt(btnHab103.getText())) {
				btnHab103.setBackground(Color.RED);
			} else if (listReservas.get(i).getHabitacion() == Integer.parseInt(btnHab104.getText())) {
				btnHab104.setBackground(Color.RED);
			} else if (listReservas.get(i).getHabitacion() == Integer.parseInt(btnHab105.getText())) {
				btnHab105.setBackground(Color.RED);
			} else if (listReservas.get(i).getHabitacion() == Integer.parseInt(btnHab106.getText())) {
				btnHab106.setBackground(Color.RED);
			}
		}
		
	}
}
