package vista;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;
import controlador.ControladorHotel;
import modelo.*;
import persistencia.ModeloTablaAlbaran;

@SuppressWarnings("serial")
public class PanelReserva extends JPanel implements IHotel {
	private JButton btnReserva;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtDireccion;
	private JTextField txtCodigoPostal;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblDireccion;
	private JLabel lblEmail;
	private JLabel lblCodigoPostal;
	private JLabel lblPrecioFinal;
	private JScrollPane scrollPane;
	private JTable table;
	private int idCliente;
	private JLabel label;
	
	public PanelReserva() {
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
		label.setIcon(new ImageIcon(PanelReserva.class.getResource("/images/Hotel_Logo_reducido.png")));
		label.setBounds(81, 11, 161, 118);
		add(label);
		
		//Panel Background Gris
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 167, 1284, 522);
		add(panel);
		panel.setLayout(null);
		
		//Boton Reserva
		btnReserva = new JButton("CONFIRMAR RESERVA");
		btnReserva.setOpaque(false);
		btnReserva.setForeground(Color.WHITE);
		btnReserva.setFont(new Font("Calibri", Font.BOLD, 14));
		btnReserva.setBorder(new LineBorder(new Color(233, 188, 103), 3));
		btnReserva.setBackground(Color.WHITE);
		btnReserva.setBounds(926, 390, 208, 46);
		panel.add(btnReserva);
		
		//Campo Nombre
		txtNombre = new JTextField();
		txtNombre.setBorder(new LineBorder(new Color(233, 188, 103), 2));
		txtNombre.setBounds(926, 66, 303, 33);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		//Campo Apellido
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBorder(new LineBorder(new Color(233, 188, 103), 2));
		txtApellido.setBounds(926, 123, 303, 33);
		panel.add(txtApellido);
		
		//Campo Email
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBorder(new LineBorder(new Color(233, 188, 103), 2));
		txtEmail.setBounds(926, 181, 303, 33);
		panel.add(txtEmail);
		
		//Campo Direccion
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBorder(new LineBorder(new Color(233, 188, 103), 2));
		txtDireccion.setBounds(926, 240, 303, 33);
		panel.add(txtDireccion);
		
		//Campo Codigo Postal
		txtCodigoPostal = new JTextField();
		txtCodigoPostal.setColumns(10);
		txtCodigoPostal.setBorder(new LineBorder(new Color(233, 188, 103), 2));
		txtCodigoPostal.setBounds(926, 300, 303, 33);
		panel.add(txtCodigoPostal);
		
		//Etiqueta Nombre
		lblNombre = new JLabel("NOMBRE");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNombre.setBounds(718, 74, 61, 16);
		panel.add(lblNombre);
		
		//Etiqueta Apellido
		lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblApellidos.setBounds(718, 132, 107, 16);
		panel.add(lblApellidos);
		
		//Etiqueta Direccion
		lblDireccion = new JLabel("EMAIL");
		lblDireccion.setForeground(Color.WHITE);
		lblDireccion.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblDireccion.setBounds(718, 190, 107, 16);
		panel.add(lblDireccion);
		
		//Etiqueta Email
		lblEmail = new JLabel("DIRECCION");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblEmail.setBounds(718, 249, 107, 16);
		panel.add(lblEmail);
		
		//Etiqueta Codigo Postal
		lblCodigoPostal = new JLabel("CODIGO POSTAL");
		lblCodigoPostal.setForeground(Color.WHITE);
		lblCodigoPostal.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblCodigoPostal.setBounds(718, 309, 119, 16);
		panel.add(lblCodigoPostal);
		
		//Etiqueta Precio Final
		lblPrecioFinal = new JLabel("PRECIO FINAL: 1385 \u20AC");
		lblPrecioFinal.setForeground(Color.WHITE);
		lblPrecioFinal.setFont(new Font("Calibri", Font.PLAIN, 36));
		lblPrecioFinal.setBounds(79, 386, 789, 45);
		panel.add(lblPrecioFinal);
		
		//Scroll Pane Tabla
		scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 66, 539, 267);
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
		JLabel lblReserva = new JLabel("DESGLOSE DE LA RESERVA");
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
	
	public void mostrarCliente(Cliente cliente) {
		idCliente = cliente.getId_cli();
		txtNombre.setText(cliente.getNombre());
		txtApellido.setText(cliente.getApellido());
		txtEmail.setText(cliente.getEmail());
		txtCodigoPostal.setText(String.valueOf(cliente.getCodigo_postal()));
		txtDireccion.setText(cliente.getDireccion());
		
		txtNombre.setEditable(false);
		txtApellido.setEditable(false);
		txtEmail.setEditable(false);
		txtCodigoPostal.setEditable(false);
		txtDireccion.setEditable(false);
	}
	
	public void reciclar() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtCodigoPostal.setText("");
		txtDireccion.setText("");
		txtEmail.setText("");
	}
	
	public Cliente datosCliente() {
		int codigo_postal = 0;
		if (!(txtNombre.getText().equals("") || txtApellido.getText().equals("") || txtEmail.getText().equals("") || txtDireccion.getText().equals("") || txtCodigoPostal.getText().equals(""))) {
			try {
				codigo_postal = Integer.parseInt(txtCodigoPostal.getText());
				
				return new Cliente(0, txtNombre.getText(), txtApellido.getText(), 
						txtEmail.getText(), txtDireccion.getText(), codigo_postal,
						"NO");
			
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(getParent(), "Debe introducir números en el código postal");
				return null;
			}
		} else {
			JOptionPane.showMessageDialog(getParent(), "Debe rellenar todos los campos");
			return null;
		}
	}
	
	public void mostrarPrecioFinal(double precio) {
		lblPrecioFinal.setText("El precio total de la reserva es " + String.valueOf(precio) + " €");
	}
	
	public void setControlador(ControladorHotel control) {
		btnReserva.addActionListener(control);
	}
	
	public Reserva getDatos(Habitacion habitacion, Consulta consulta, double precio_Final) {
		return new Reserva(0, idCliente, habitacion.getId_hab(),consulta.getFecha_Entrada(), consulta.getFecha_Salida(), precio_Final);
	}

	public JButton getBtnReserva() {
		return btnReserva;
	}

	public int getIdCliente() {
		return idCliente;
	}
}
