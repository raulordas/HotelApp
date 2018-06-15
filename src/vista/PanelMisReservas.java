package vista;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.border.LineBorder;
import controlador.ControladorHotel;
import modelo.*;
import javax.swing.*;
import persistencia.ModeloTablaAlbaran;

@SuppressWarnings("serial")
public class PanelMisReservas extends JPanel implements IHotel {
	private JButton btnVolver;
	private JScrollPane scrollPane;
	private JTable table;
	private int idCliente;
	private JLabel label;
	private ModeloTablaReservas model;
	
	public PanelMisReservas() {
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
		label.setIcon(new ImageIcon(PanelMisReservas.class.getResource("/images/Hotel_Logo_reducido.png")));
		label.setBounds(81, 11, 161, 118);
		add(label);
		
		//Panel Background Gris
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 167, 1284, 522);
		add(panel);
		panel.setLayout(null);
		
		//Boton Reserva
		btnVolver = new JButton("VOLVER");
		btnVolver.setOpaque(false);
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(new Font("Calibri", Font.BOLD, 14));
		btnVolver.setBorder(new LineBorder(new Color(233, 188, 103), 3));
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(533, 390, 208, 46);
		panel.add(btnVolver);
		
		//Scroll Pane Tabla
		scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 66, 1136, 267);
		panel.add(scrollPane);
		
		//Componente JTable
		table = new JTable();
		table.setShowGrid(false);
		table.setRowSelectionAllowed(false);
		table.setFont(new Font("Calibri", Font.PLAIN, 12));
		table.setGridColor(new Color(255, 255, 255));
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		//Label Reserva
		JLabel lblReserva = new JLabel("ESTAS SON TUS RESERVAS");
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
	
	public void mostrarReserva(ModeloTablaAlbaran model) {
		table.setModel(model);
	}
	
	public void setControlador(ControladorHotel control) {
		btnVolver.addActionListener(control);
	}
	
	public void mostrarDatos(ArrayList<Reserva> listReservas) {
		model = new ModeloTablaReservas(listReservas);
		table.setModel(model);
	}
	
	public Reserva getDatos(Habitacion habitacion, Consulta consulta, double precio_Final) {
		return new Reserva(0, idCliente, habitacion.getId_hab(),consulta.getFecha_Entrada(), consulta.getFecha_Salida(), precio_Final);
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public int getIdCliente() {
		return idCliente;
	}
}
