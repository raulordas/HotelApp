package vista;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.border.LineBorder;
import controlador.ControladorHotel;
import modelo.TipoHabitacion;

@SuppressWarnings("serial")
public class PanelHabitaciones extends JPanel implements IHotel {
	private JButton btnReservarSencilla;
	private JLabel lblHabSencilla;
	private JLabel lblTitulo;
	private JLabel imagenHabSencilla;
	private JLabel imagenHabDoble;
	private JLabel imagenSuite;
	private JLabel lblHabitacionDoble;
	private JLabel lblSuitePresidencial;
	private JLabel cantidadSencillas;
	private JLabel labelBajaSencilla;
	private JTextArea descripcionDoble;
	private JScrollPane scrollPaneSencilla;
	private JTextArea descripcionSencilla;
	private JTextArea descripcionSuite;
	private JScrollPane scrollPaneDoble;
	private JScrollPane scrollPaneSuite;
	private JButton btnReservarSuite;
	private JButton btnReservarDoble;
	private JLabel labelAltaSencilla;
	private JLabel labelAltaDobles;
	private JLabel labelBajaDobles;
	private JLabel cantidadDobles;
	private JLabel labelAltaSuites;
	private JLabel labelBajaSuites;
	private JLabel cantidadSuites;
	private JLabel lblLogo;
	public PanelHabitaciones() {
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
		
		//Panel Background Gris
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 167, 1284, 522);
		add(panel);
		panel.setLayout(null);
		
		//Etiqueta Habitaciones Disponibles
		lblTitulo = new JLabel("HABITACIONES DISPONIBLES");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(233, 188, 103));
		lblTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		lblTitulo.setBounds(0, 108, 1284, 31);
		add(lblTitulo);
		
		//Scroll Pane Sencilla
		scrollPaneSencilla = new JScrollPane();
		scrollPaneSencilla.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneSencilla.setBounds(282, 64, 311, 101);
		panel.add(scrollPaneSencilla);
		
		//ScrollPane Doble
		scrollPaneDoble = new JScrollPane();
		scrollPaneDoble.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneDoble.setEnabled(false);
		scrollPaneDoble.setBounds(282, 224, 311, 99);
		panel.add(scrollPaneDoble);
		
		
		//ScrollPane Suite
		scrollPaneSuite = new JScrollPane();
		scrollPaneSuite.setEnabled(false);
		scrollPaneSuite.setBounds(282, 386, 311, 99);
		panel.add(scrollPaneSuite);
		
		
		//Descripcion Sencilla
		descripcionSencilla = new JTextArea();
		descripcionSencilla.setEditable(false);
		descripcionSencilla.setWrapStyleWord(true);
		descripcionSencilla.setLineWrap(true);
		scrollPaneSencilla.setViewportView(descripcionSencilla);
	
		//Descripcion Doble
		descripcionDoble = new JTextArea();
		descripcionDoble.setEditable(false);
		descripcionDoble.setWrapStyleWord(true);
		descripcionDoble.setLineWrap(true);
		descripcionDoble.setBounds(283, 226, 309, 62);
		scrollPaneDoble.setViewportView(descripcionDoble);
		
		//Descripcion Suite
		descripcionSuite = new JTextArea();
		descripcionSuite.setEditable(false);
		descripcionSuite.setLineWrap(true);
		descripcionSuite.setBounds(284, 388, 309, 97);
		scrollPaneSuite.setViewportView(descripcionSuite);
		
		//Imagen Sencilla
		imagenHabSencilla = new JLabel("");
		imagenHabSencilla.setBorder(new LineBorder(new Color(233, 188, 103), 2));
		imagenHabSencilla.setIcon(new ImageIcon(PanelHabitaciones.class.getResource("/images/habsencilla.jpg")));
		imagenHabSencilla.setBounds(100, 32, 145, 133);
		panel.add(imagenHabSencilla);
		
		//Imagen Habitacion doble
		imagenHabDoble = new JLabel("");
		imagenHabDoble.setIcon(new ImageIcon(PanelHabitaciones.class.getResource("/images/habdoble.jpeg")));
		imagenHabDoble.setBorder(new LineBorder(new Color(233, 188, 103), 2));
		imagenHabDoble.setBounds(100, 190, 145, 133);
		panel.add(imagenHabDoble);
		
		//Imagen Suite
		imagenSuite = new JLabel("");
		imagenSuite.setIcon(new ImageIcon(PanelHabitaciones.class.getResource("/images/suite.jpg")));
		imagenSuite.setBorder(new LineBorder(new Color(233, 188, 103), 2));
		imagenSuite.setBounds(100, 352, 145, 133);
		panel.add(imagenSuite);
		
		//Etiqueta Habitacion Sencilla
		lblHabSencilla = new JLabel("HABITACION SENCILLA");
		lblHabSencilla.setForeground(new Color(255, 255, 255));
		lblHabSencilla.setFont(new Font("Calibri", Font.BOLD, 20));
		lblHabSencilla.setBounds(282, 32, 249, 22);
		panel.add(lblHabSencilla);
		
		//Etiqueta Habitacion Doble
		lblHabitacionDoble = new JLabel("HABITACION DOBLE");
		lblHabitacionDoble.setForeground(Color.WHITE);
		lblHabitacionDoble.setFont(new Font("Calibri", Font.BOLD, 20));
		lblHabitacionDoble.setBounds(282, 190, 249, 22);
		panel.add(lblHabitacionDoble);
		
		//Etiqueta Suite Presidencial
		lblSuitePresidencial = new JLabel("SUITE PRESIDENCIAL");
		lblSuitePresidencial.setForeground(Color.WHITE);
		lblSuitePresidencial.setFont(new Font("Calibri", Font.BOLD, 20));
		lblSuitePresidencial.setBounds(282, 352, 249, 22);
		panel.add(lblSuitePresidencial);
		
		//Precio Medio Sencilla
		labelBajaSencilla = new JLabel("T.BAJA 200 \u20AC/NOCHE");
		labelBajaSencilla.setHorizontalAlignment(SwingConstants.CENTER);
		labelBajaSencilla.setForeground(Color.WHITE);
		labelBajaSencilla.setFont(new Font("Calibri", Font.BOLD, 20));
		labelBajaSencilla.setBounds(662, 78, 230, 22);
		panel.add(labelBajaSencilla);
	
		//Cantidad Sencillas
		cantidadSencillas = new JLabel("QUEDAN 3 HABITACIONES");
		cantidadSencillas.setHorizontalAlignment(SwingConstants.CENTER);
		cantidadSencillas.setForeground(Color.WHITE);
		cantidadSencillas.setFont(new Font("Calibri", Font.PLAIN, 16));
		cantidadSencillas.setBounds(631, 111, 321, 22);
		panel.add(cantidadSencillas);

		//Boton Reservar
		btnReservarSencilla = new JButton("RESERVAR");
		btnReservarSencilla.setOpaque(false);
		btnReservarSencilla.setForeground(Color.WHITE);
		btnReservarSencilla.setFont(new Font("Calibri", Font.BOLD, 14));
		btnReservarSencilla.setBorder(new LineBorder(new Color(233, 188, 103), 3));
		btnReservarSencilla.setBackground(Color.WHITE);
		btnReservarSencilla.setBounds(984, 70, 172, 46);
		panel.add(btnReservarSencilla);
		
		//Boton Reservar Doble
		btnReservarDoble = new JButton("RESERVAR");
		btnReservarDoble.setOpaque(false);
		btnReservarDoble.setForeground(Color.WHITE);
		btnReservarDoble.setFont(new Font("Calibri", Font.BOLD, 14));
		btnReservarDoble.setBorder(new LineBorder(new Color(233, 188, 103), 3));
		btnReservarDoble.setBackground(Color.WHITE);
		btnReservarDoble.setBounds(984, 231, 172, 46);
		panel.add(btnReservarDoble);
		
		//Boton Reservar Suite
		btnReservarSuite = new JButton("RESERVAR");
		btnReservarSuite.setOpaque(false);
		btnReservarSuite.setForeground(Color.WHITE);
		btnReservarSuite.setFont(new Font("Calibri", Font.BOLD, 14));
		btnReservarSuite.setBorder(new LineBorder(new Color(233, 188, 103), 3));
		btnReservarSuite.setBackground(Color.WHITE);
		btnReservarSuite.setBounds(984, 388, 172, 46);
		panel.add(btnReservarSuite);
		
		//Label Precio Alta Sencilla
		labelAltaSencilla = new JLabel("T.ALTA 200 \u20AC/NOCHE");
		labelAltaSencilla.setHorizontalAlignment(SwingConstants.CENTER);
		labelAltaSencilla.setForeground(Color.WHITE);
		labelAltaSencilla.setFont(new Font("Calibri", Font.BOLD, 20));
		labelAltaSencilla.setBounds(662, 52, 230, 22);
		panel.add(labelAltaSencilla);
		
		//Label Precio Alta Dobles
		labelAltaDobles = new JLabel("T.ALTA 200 \u20AC/NOCHE");
		labelAltaDobles.setHorizontalAlignment(SwingConstants.CENTER);
		labelAltaDobles.setForeground(Color.WHITE);
		labelAltaDobles.setFont(new Font("Calibri", Font.BOLD, 20));
		labelAltaDobles.setBounds(662, 211, 230, 22);
		panel.add(labelAltaDobles);
		
		//Label Precio Baja Dobles
		labelBajaDobles = new JLabel("T.BAJA 200 \u20AC/NOCHE");
		labelBajaDobles.setHorizontalAlignment(SwingConstants.CENTER);
		labelBajaDobles.setForeground(Color.WHITE);
		labelBajaDobles.setFont(new Font("Calibri", Font.BOLD, 20));
		labelBajaDobles.setBounds(662, 237, 230, 22);
		panel.add(labelBajaDobles);
		
		//Label Cantidad Dobles
		cantidadDobles = new JLabel("QUEDAN 3 HABITACIONES");
		cantidadDobles.setHorizontalAlignment(SwingConstants.CENTER);
		cantidadDobles.setForeground(Color.WHITE);
		cantidadDobles.setFont(new Font("Calibri", Font.PLAIN, 16));
		cantidadDobles.setBounds(631, 270, 321, 22);
		panel.add(cantidadDobles);
		
		//Label Precio Alta Suites
		labelAltaSuites = new JLabel("T.ALTA 200 \u20AC/NOCHE");
		labelAltaSuites.setHorizontalAlignment(SwingConstants.CENTER);
		labelAltaSuites.setForeground(Color.WHITE);
		labelAltaSuites.setFont(new Font("Calibri", Font.BOLD, 20));
		labelAltaSuites.setBounds(662, 369, 230, 22);
		panel.add(labelAltaSuites);
		
		//Label Precio Baja Suites
		labelBajaSuites = new JLabel("T.BAJA 200 \u20AC/NOCHE");
		labelBajaSuites.setHorizontalAlignment(SwingConstants.CENTER);
		labelBajaSuites.setForeground(Color.WHITE);
		labelBajaSuites.setFont(new Font("Calibri", Font.BOLD, 20));
		labelBajaSuites.setBounds(662, 395, 230, 22);
		panel.add(labelBajaSuites);
		
		//Label Cantidad Suites
		cantidadSuites = new JLabel("QUEDAN 3 HABITACIONES");
		cantidadSuites.setHorizontalAlignment(SwingConstants.CENTER);
		cantidadSuites.setForeground(Color.WHITE);
		cantidadSuites.setFont(new Font("Calibri", Font.PLAIN, 16));
		cantidadSuites.setBounds(631, 428, 321, 22);
		panel.add(cantidadSuites);
		
		//Label Logo
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(PanelHabitaciones.class.getResource("/images/Hotel_Logo_reducido.png")));
		lblLogo.setBounds(99, 26, 161, 118);
		add(lblLogo);
	}

	@Override
	public void hacerVisible() {
		setVisible(true);	
	}
	
	public void setControlador(ControladorHotel control) {
		btnReservarSencilla.addActionListener(control);
		btnReservarDoble.addActionListener(control);
		btnReservarSuite.addActionListener(control);
	}
	
	public void mostrarDescripcionHabitaciones(ArrayList<TipoHabitacion> tipoHabitaciones) {
		for (int i = 0; i < tipoHabitaciones.size(); i++) {
			
			if (tipoHabitaciones.get(i).getId_tipo() == 1) {
				descripcionSencilla.setText(tipoHabitaciones.get(i).getDescripcion());
				labelAltaSencilla.setText("Temporada Alta: " + String.valueOf(tipoHabitaciones.get(i).getPrecio_alta() + "€"));
				labelBajaSencilla.setText("Temporada Baja: " + String.valueOf(tipoHabitaciones.get(i).getPrecio_baja() + "€"));
			
			} else if (tipoHabitaciones.get(i).getId_tipo() == 2) {
				descripcionDoble.setText(tipoHabitaciones.get(i).getDescripcion());
				labelAltaDobles.setText("Temporada Alta: " + String.valueOf(tipoHabitaciones.get(i).getPrecio_alta() + "€"));
				labelBajaDobles.setText("Temporada Baja: " + String.valueOf(tipoHabitaciones.get(i).getPrecio_baja() + "€"));
			
			} else if (tipoHabitaciones.get(i).getId_tipo() == 3) {
				descripcionSuite.setText(tipoHabitaciones.get(i).getDescripcion());
				labelAltaSuites.setText("Temporada Alta: " + String.valueOf(tipoHabitaciones.get(i).getPrecio_alta() + "€"));
				labelBajaSuites.setText("Temporada Baja: " + String.valueOf(tipoHabitaciones.get(i).getPrecio_baja() + "€"));
			}
		}
	}
	
	public void mostrarCantidadHabitaciones(int numSencillas, int numDobles, int numSuites) {
		btnReservarSencilla.setEnabled(true);
		btnReservarDoble.setEnabled(true);
		btnReservarSuite.setEnabled(true);
		
		if (numSencillas == 0) {
			cantidadSencillas.setText("NO HAY HABITACIONES DISPONIBLES");
			btnReservarSencilla.setEnabled(false);
		} else {
			cantidadSencillas.setText("HAY " + numSencillas + " HABITACIONES DISPONIBLES");
		}
		
		if (numDobles == 0) {
			cantidadDobles.setText("NO HAY HABITACIONES DISPONIBLES");
			btnReservarDoble.setEnabled(false);
		
		} else {
			cantidadDobles.setText("HAY " + numDobles + " HABITACIONES DISPONIBLES");
		}
		
		if (numSuites == 0) {
			cantidadSuites.setText("NO HAY HABITACIONES DISPONIBLES");
			btnReservarSuite.setEnabled(false);
		} else {
			cantidadSuites.setText("HAY " + numSuites + " HABITACIONES DISPONIBLES");
		}
	}

	public JButton getBtnReservarSencilla() {
		return btnReservarSencilla;
	}

	public JButton getBtnReservarSuite() {
		return btnReservarSuite;
	}

	public JButton getBtnReservarDoble() {
		return btnReservarDoble;
	}
}
