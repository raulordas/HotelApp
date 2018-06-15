package vista;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.border.LineBorder;
import controlador.ControladorHotel;
import modelo.ClientePermanente;

@SuppressWarnings("serial")
public class PanelHazteSocio extends JPanel implements IHotel {
	private String imagenCarrusel = "/images/TarjetaGoldMember.jpg";
	private JLabel imagen1;
	private JButton btnAltaUsuario;
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
	private JLabel lblRecibirUnCorreo;
	private JLabel lblLogo;
	public PanelHazteSocio() {
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
		
		//Label Logo
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(PanelHazteSocio.class.getResource("/images/Hotel_Logo_reducido.png")));
		lblLogo.setBounds(102, 24, 161, 118);
		add(lblLogo);
		
		//Panel Background Gris
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 167, 1284, 522);
		add(panel);
		panel.setLayout(null);
		
		//Boton Contacto
		btnAltaUsuario = new JButton("REGISTRAR USUARIO");
		btnAltaUsuario.setOpaque(false);
		btnAltaUsuario.setForeground(Color.WHITE);
		btnAltaUsuario.setFont(new Font("Calibri", Font.BOLD, 14));
		btnAltaUsuario.setBorder(new LineBorder(new Color(233, 188, 103), 3));
		btnAltaUsuario.setBackground(Color.WHITE);
		btnAltaUsuario.setBounds(888, 390, 208, 46);
		panel.add(btnAltaUsuario);		
		
		//Carga la imagen inicial
		imagen1 = new JLabel("");
		imagen1.setBounds(0, 0, 655, 532);
		panel.add(imagen1);
		imagen1.setIcon(new ImageIcon(PanelHazteSocio.class.getResource(imagenCarrusel)));
		
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
		
		//Etiqueta Apellidos
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
		
		//Etiqueta email
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
		
		//Etiqueta Recibir Correo
		lblRecibirUnCorreo = new JLabel("Recibir\u00E1 un correo electr\u00F3nico con su usuario y contrase\u00F1a");
		lblRecibirUnCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecibirUnCorreo.setForeground(Color.WHITE);
		lblRecibirUnCorreo.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblRecibirUnCorreo.setBounds(654, 26, 630, 16);
		panel.add(lblRecibirUnCorreo);
		
		//Etiqueta Titulo Panel
		JLabel lblNewLabel = new JLabel("FORMULARIO ALTA SOCIO HOTEL APP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(233, 188, 103));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		lblNewLabel.setBounds(0, 108, 1284, 48);
		add(lblNewLabel);
	}

	@Override
	public void hacerVisible() {
		setVisible(true);	
	}
	
	public void setControlador(ControladorHotel control) {
		btnAltaUsuario.addActionListener(control);
	}
	
	public ClientePermanente getDatos(ArrayList<String> listaUsuarios) {
		int codigo_postal = 0;
		if (!(txtNombre.getText().equals("") || txtApellido.getText().equals("") || txtEmail.getText().equals("") || txtDireccion.getText().equals("") || txtCodigoPostal.getText().equals(""))) {
			try {
				codigo_postal = Integer.parseInt(txtCodigoPostal.getText());
				System.out.println(txtCodigoPostal.getText());
				
				return new ClientePermanente(0, txtNombre.getText(), txtApellido.getText(), 
						txtEmail.getText(), txtDireccion.getText(), codigo_postal,
						"SI", random(listaUsuarios), randomPass());
			
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(getParent(), "Debe introducir números en el código postal");
				return null;
			}
		} else {
			JOptionPane.showMessageDialog(getParent(), "Debe rellenar todos los campos");
			return null;
		}
	}
	
	public String random(ArrayList<String> listaUsuarios) {
		String user = "";
		Random r = null;
		
		//Genera un usuario único aleatorio que no este contenido en la base de datos
		do {

			String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			r = new Random();

			for (int i = 0; i < 8; i++) {
				user += caracteres.charAt(r.nextInt(caracteres.length()));
			}
			
		} while (listaUsuarios.contains(user));
		
		return user;
	}
	
	public String randomPass() {
		String user = "";
		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		Random r = new Random();

		for (int i = 0; i < 8; i++) {
			user += caracteres.charAt(r.nextInt(caracteres.length()));
		}

		return user;
	}

	public void reciclar() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtDireccion.setText("");
		txtEmail.setText("");
		txtCodigoPostal.setText("");
	}
	
	public JButton getBtnAltaUsuario() {
		return btnAltaUsuario;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}	
}
