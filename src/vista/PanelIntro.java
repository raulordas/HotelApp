package vista;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import controlador.ControladorHotel;
import modelo.Consulta;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PanelIntro extends JPanel implements IHotel {
	private JLabel lblLogo;
	private JPanel panelBgGray;
	private JLabel lblTitulo;
	private JLabel lblFechaDeEntrada;
	private JLabel lblFechaDeSalida;
	private JDateChooser calendarioFechaEntrada;
	private JDateChooser calendarioFechaSalida;
	private JLabel lblAccesoClientes;
	private JButton btnLogin;
	private JButton btnConsultarDisponibilidad;
	private JLabel lblUsuarioIdentificado;
	private JButton btnLogout;
	private JLabel lblKey;
	
	public PanelIntro() {
		inicializar();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void inicializar() {
		
		//Color Background Panel
		setBackground(Color.WHITE);
		
		//Tamaño Panel
		setBounds(0, 0, 1294, 689);
		
		//Layout
		setLayout(null);
		
		//Imagen Logo
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(PanelIntro.class.getResource("/images/Hotel_Logo.png")));
		lblLogo.setBounds(512, 52, 255, 212);
		add(lblLogo);
		
		//Panel Fondo Gris
		panelBgGray = new JPanel();
		panelBgGray.setLayout(null);
		panelBgGray.setBackground(Color.DARK_GRAY);
		panelBgGray.setBounds(0, 290, 1284, 399);
		add(panelBgGray);
		
		
		//Caja Calendario Fecha Salida
		calendarioFechaSalida = new JDateChooser();
		calendarioFechaSalida.getCalendarButton().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				if (calendarioFechaEntrada.getDate() != null) {
					Date dt = calendarioFechaEntrada.getDate();
					Calendar c = Calendar.getInstance(); 
					c.setTime(dt); 
					c.add(Calendar.DATE, 1);
					dt = c.getTime();
					calendarioFechaSalida.setSelectableDateRange(dt, new Date("31/12/2200"));
				}	
			}
		});
		calendarioFechaSalida.setBounds(473, 217, 343, 29);
		panelBgGray.add(calendarioFechaSalida);
		
		//Cajas Calendario Fecha Entrada
		calendarioFechaEntrada = new JDateChooser();
		calendarioFechaEntrada.setDate(new Date());
		calendarioFechaEntrada.setBounds(473, 133, 343, 29);
		calendarioFechaEntrada.setSelectableDateRange(new Date(), new Date("31/12/2200"));
		panelBgGray.add(calendarioFechaEntrada);
	
		//Boton Consultar Disponibilidad
		btnConsultarDisponibilidad = new JButton("CONSULTAR DISPONIBILIDAD");
		btnConsultarDisponibilidad.setOpaque(false);
		btnConsultarDisponibilidad.setForeground(new Color(255, 255, 255));
		btnConsultarDisponibilidad.setBackground(new Color(255, 255, 255));
		btnConsultarDisponibilidad.setBorder(new LineBorder(new Color(233, 188, 103), 3));
		btnConsultarDisponibilidad.setFont(new Font("Calibri", Font.BOLD, 14));
		btnConsultarDisponibilidad.setBounds(543, 299, 208, 46);
		panelBgGray.add(btnConsultarDisponibilidad);
		
		//Etiqueta Titulo
		lblTitulo = new JLabel("<html><body style ='text-align: center;'>Introduzca una fecha de entrada y una fecha de salida y pulse en consultar disponibilidad.<br>Le mostraremos las habitaciones disponibles para las fechas indicadas.<br>Recuerde que el mejor precio disponible se encuentra en nuestra web.</body></html>");
		lblTitulo.setHorizontalTextPosition(SwingConstants.LEADING);
		lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitulo.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setBounds(367, 11, 556, 78);
		panelBgGray.add(lblTitulo);
		
		//Etiqueta Fecha Entrada
		lblFechaDeEntrada = new JLabel("FECHA DE ENTRADA");
		lblFechaDeEntrada.setHorizontalTextPosition(SwingConstants.LEADING);
		lblFechaDeEntrada.setHorizontalAlignment(SwingConstants.LEFT);
		lblFechaDeEntrada.setForeground(Color.WHITE);
		lblFechaDeEntrada.setFont(new Font("Calibri", Font.BOLD, 16));
		lblFechaDeEntrada.setBounds(570, 100, 145, 29);
		panelBgGray.add(lblFechaDeEntrada);
		
		//Etiqueta Fecha Salida
		lblFechaDeSalida = new JLabel("FECHA DE SALIDA");
		lblFechaDeSalida.setHorizontalTextPosition(SwingConstants.LEADING);
		lblFechaDeSalida.setHorizontalAlignment(SwingConstants.LEFT);
		lblFechaDeSalida.setForeground(Color.WHITE);
		lblFechaDeSalida.setFont(new Font("Calibri", Font.BOLD, 16));
		lblFechaDeSalida.setBounds(587, 183, 128, 29);
		panelBgGray.add(lblFechaDeSalida);
		
		//Etiqueta Usuario Identificado
		lblUsuarioIdentificado = new JLabel("HAGA LOGIN PARA ACCEDER A SU CUENTA DE CLIENTE");
		lblUsuarioIdentificado.setForeground(new Color(255, 255, 255));
		lblUsuarioIdentificado.setBounds(31, 331, 397, 14);
		panelBgGray.add(lblUsuarioIdentificado);
		lblUsuarioIdentificado.setFont(new Font("Calibri", Font.PLAIN, 12));
		
		//Boton Login
		btnLogin = new JButton("LOGIN");
		btnLogin.setBounds(1014, 316, 103, 29);
		panelBgGray.add(btnLogin);
		btnLogin.setBorder(null);
		btnLogin.setBackground(new Color(233, 188, 103));
		
		//Etiqueta Acceso Clientes
		lblAccesoClientes = new JLabel("ACCESO CLIENTES");
		lblAccesoClientes.setForeground(new Color(255, 255, 255));
		lblAccesoClientes.setBounds(1080, 287, 103, 14);
		panelBgGray.add(lblAccesoClientes);
		lblAccesoClientes.setFont(new Font("Calibri", Font.BOLD, 14));
		
		//Boton Logout
		btnLogout = new JButton("LOG-OUT");
		btnLogout.setBorder(null);
		btnLogout.setBackground(new Color(233, 188, 103));
		btnLogout.setBounds(1143, 316, 103, 29);
		panelBgGray.add(btnLogout);
		
		//Label Acceso Admin
		lblKey = new JLabel("KEY");
		lblKey.setBounds(1160, 52, 64, 60);
		add(lblKey);
		lblKey.setIcon(new ImageIcon(PanelIntro.class.getResource("/images/KeyLabel.png")));
		lblKey.setBackground(Color.GREEN);
		
	}

	public void setLblUsuarioIdentificado(String texto) {
		lblUsuarioIdentificado.setText(texto);
	}

	@Override
	public void hacerVisible() {
		setVisible(true);	
	}
	
	public void setControlador(ControladorHotel control) {
		btnConsultarDisponibilidad.addActionListener(control);
		btnLogin.addActionListener(control);
		btnLogout.addActionListener(control);
		lblKey.addMouseListener(control);
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

	public JButton getBtnConsultarDisponibilidad() {
		return btnConsultarDisponibilidad;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}

	public JLabel getLblKey() {
		return lblKey;
	}
	
}
