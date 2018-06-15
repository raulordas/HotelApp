package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import controlador.ControladorHotel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class PanelHotel extends JPanel implements IHotel {
	private String imagenCarrusel = "/images/img9.jpg";
	private JLabel lblLogo;
	private JLabel imagen1;
	private JLabel lblDescripcion;
	private JButton btnHazteSocio;
	private int cont;
	private Timer temporizador;
	
	public PanelHotel() {
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
		
		//Imagen Logo
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(PanelHotel.class.getResource("/images/Hotel_Logo.png")));
		lblLogo.setBounds(514, 42, 255, 212);
		add(lblLogo);
		
		//Carga la imagen inicial
		imagen1 = new JLabel("");
		imagen1.setBounds(0, 24, 1284, 476);
		add(imagen1);
		imagen1.setIcon(new ImageIcon(PanelHotel.class.getResource(imagenCarrusel)));
		
		//Panel Background Gris
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 501, 1284, 188);
		add(panel);
		panel.setLayout(null);
		
		//Label Descripcion
		lblDescripcion = new JLabel("Nuestro hotel se encuentra situado en un enclave exclusivo. Posee Habitaciones con vistas al mar y a la monta\u00F1a. Disfruta de la paz en nuestras exclusivas instalaciones.");
		lblDescripcion.setForeground(new Color(255, 255, 255));
		lblDescripcion.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblDescripcion.setBounds(93, 21, 1114, 57);
		panel.add(lblDescripcion);
		
		//Boton Contacto
		btnHazteSocio = new JButton("\u00A1HAZTE SOCIO!");
		btnHazteSocio.setOpaque(false);
		btnHazteSocio.setForeground(Color.WHITE);
		btnHazteSocio.setFont(new Font("Calibri", Font.BOLD, 14));
		btnHazteSocio.setBorder(new LineBorder(new Color(233, 188, 103), 3));
		btnHazteSocio.setBackground(Color.WHITE);
		btnHazteSocio.setBounds(517, 99, 208, 46);
		panel.add(btnHazteSocio);
		
		//Estado inicial del contador del carrusel de imagenes
		cont = -1;
		
		//Metodo carrusel que ejecuta el bucle cada intervalo.
		carrusel();
	}

	@Override
	public void hacerVisible() {
		setVisible(true);	
	}
	
	private void carrusel() {
		temporizador = new Timer(2000, new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				cont++;
				if (cont == 0) {
					imagen1.setIcon(new ImageIcon(PanelHotel.class.getResource("/images/img9.jpg")));
				} else if (cont == 1) {
					imagen1.setIcon(new ImageIcon(PanelHotel.class.getResource("/images/img8.jpg")));
				} else if (cont == 2) {
					imagen1.setIcon(new ImageIcon(PanelHotel.class.getResource("/images/img4.jpg")));
				} else if (cont == 3) {
					imagen1.setIcon(new ImageIcon(PanelHotel.class.getResource("/images/img2.jpg")));
				} else if (cont == 4) {
					imagen1.setIcon(new ImageIcon(PanelHotel.class.getResource("/images/img3.jpg")));
				} else {
					cont = -1;
				}
			}
		});
		temporizador.setRepeats(true);
		temporizador.start();
	}
	
	public void setControlador(ControladorHotel control) {
		btnHazteSocio.addActionListener(control);
	}

	public JButton getBtnHazteSocio() {
		return btnHazteSocio;
	}
}
