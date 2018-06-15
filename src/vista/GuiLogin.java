package vista;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import controlador.ControladorHotel;
import modelo.AdministradorPojo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GuiLogin extends JDialog implements IHotel {
	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JLabel lblUsuario;
	private JPasswordField passwordField;
	private JLabel lblCandado;
	private JLabel lblContrasenya;
	private JButton btnAceptar;
	private JButton btnCancelar;

	public GuiLogin() {
		inicializar();
	}

	@Override
	public void inicializar() {
		// Obliga a que el JDialog sea Modal
		setModalityType(DEFAULT_MODALITY_TYPE);

		// T�tulo de la ventana
		setTitle("Identificaci\u00F3n Usuario");

		// Establece el fondo del ContentPane a Blanco
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);

		// Establece la dimensi�n del JDialog
		setBounds(100, 100, 500, 460);

		// Layout de los Componentes
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 1, 0, -10));
		{
			// Campo de Texto Usuario
			txtUsuario = new JTextField();
			txtUsuario.setFont(new Font("Avenir LT Std 45 Book", Font.PLAIN, 16));
			txtUsuario.setBorder(new LineBorder(new Color(233, 188, 103), 4));
			txtUsuario.setMinimumSize(new Dimension(6, 10));
			txtUsuario.setHorizontalAlignment(SwingConstants.CENTER);
			txtUsuario.setPreferredSize(new Dimension(100, 10));
			txtUsuario.setColumns(10);
		}
		{
			// Etiqueta Usuario
			lblUsuario = new JLabel("USUARIO");
			lblUsuario.setIcon(null);
			lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
			lblUsuario.setFont(new Font("Calibri", Font.PLAIN, 25));
		}
		// Etiqueta Candado
		lblCandado = new JLabel("");
		lblCandado.setIconTextGap(0);
		lblCandado.setHorizontalAlignment(SwingConstants.CENTER);
		lblCandado.setIcon(new ImageIcon(GuiLogin.class.getResource("/images/Candado.png")));
		contentPanel.add(lblCandado);
		contentPanel.add(lblUsuario);
		contentPanel.add(txtUsuario);

		// Etiqueta Contrase�a
		lblContrasenya = new JLabel("CONTRASE\u00D1A");
		lblContrasenya.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasenya.setFont(new Font("Calibri", Font.PLAIN, 25));
		contentPanel.add(lblContrasenya);
		{
			// Campo de Texto Contrase�a
			passwordField = new JPasswordField();
			passwordField.setHorizontalAlignment(SwingConstants.CENTER);
			passwordField.setFont(new Font("Avenir LT Std 45 Book", Font.PLAIN, 16));
			passwordField.setBorder(new LineBorder(new Color(233, 188, 103), 4));
			contentPanel.add(passwordField);
		}
		{
			// Panel de Botones
			JPanel buttonPane = new JPanel();
			buttonPane.setPreferredSize(new Dimension(10, 100));
			buttonPane.setBackground(new Color(255, 255, 255));
			FlowLayout fl_buttonPane = new FlowLayout(FlowLayout.CENTER);
			fl_buttonPane.setVgap(30);
			buttonPane.setLayout(fl_buttonPane);
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				// Bot�n Aceptar
				btnAceptar = new JButton("ACEPTAR");
				btnAceptar.setFont(new Font("Avenir LT Std 45 Book", Font.PLAIN, 14));
				btnAceptar.setBorder(null);
				btnAceptar.setBackground(new Color(233, 188, 103));
				btnAceptar.setPreferredSize(new Dimension(150, 40));
				btnAceptar.setActionCommand("OK");
				buttonPane.add(btnAceptar);
				getRootPane().setDefaultButton(btnAceptar);
			}
			{
				// Bot�n Cancelar
				btnCancelar = new JButton("CANCELAR");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});

				btnCancelar.setFont(new Font("Avenir LT Std 45 Book", Font.PLAIN, 14));
				btnCancelar.setBorder(null);
				btnCancelar.setBackground(new Color(233, 188, 103));
				btnCancelar.setPreferredSize(new Dimension(150, 40));
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		// centra el JDialog en el ViewPort
		setLocationRelativeTo(null);

	}

	@Override
	public void hacerVisible() {
		setVisible(true);
	}

	public void setControlador(ControladorHotel control) {
		btnAceptar.addActionListener(control);
		btnCancelar.addActionListener(control);
		
	}
	
	/*M�todo que obtiene los datos introducidos por el usuario
	y los almacena en un objeto de tipo AdministradorPojo*/
	public AdministradorPojo getDatos() {
		String usuario = "";
		String contrasenya = "";
		AdministradorPojo admin;
		
		usuario = txtUsuario.getText();
		contrasenya = convertirContrasenya(passwordField.getPassword());
		admin = new AdministradorPojo(usuario, contrasenya);
		
		return admin;
	}
	
	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	
	//M�todo que convierte la contrase�a a un String
	private String convertirContrasenya(char[] contrasenya) {
		String password = "";
		
		for (int i = 0; i < contrasenya.length; i++) {
			password += contrasenya[i];
		}
		return password;
	}
	
	//Deja en Blanco los textArea
	public void reciclar() {
		txtUsuario.setText("");
		passwordField.setText("");
	}
	
}
