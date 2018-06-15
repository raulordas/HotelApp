package vista;

import javax.swing.*;
import java.awt.Color;
import javax.swing.JPanel;
import controlador.ControladorHotel;
import java.awt.Dimension;
import javax.swing.WindowConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Insets;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class VistaPrincipal extends JFrame implements IHotel {
	private JScrollPane scrollPane;
	private JMenuItem menuHotel;
	private JMenuItem menuInicio;
	private JMenuItem menuHazteSocio;
	private JMenuItem menuMisReservas;
	
	public VistaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaPrincipal.class.getResource("/images/KeyLabel.png")));
		inicializar();
	}
	
	@Override
	public void inicializar() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Fondo del JFrame
		setBackground(Color.WHITE);
		
		//Anula el redimensionamiento
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		
		//Establece el tamaño del JFrame
		setBounds(0, 0, 1366, 768);
		
		//Establece el layout a null
		getContentPane().setLayout(null);
		
		//Scroll pane viewport de los paneles de la aplicación
		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(0, 0, 1294, 689);
		getContentPane().add(scrollPane);
		
		//Barra menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(10, 100, 0, 100));
		menuBar.setBorder(new LineBorder(Color.WHITE));
		menuBar.setPreferredSize(new Dimension(0, 50));
		setJMenuBar(menuBar);
		
		//Separator
		JSeparator separator_3 = new JSeparator();
		separator_3.setOpaque(true);
		separator_3.setForeground(Color.WHITE);
		menuBar.add(separator_3);
		
		//Elemento menu inicio
		menuInicio = new JMenuItem("                 INICIO");
		menuInicio.setBorder(new LineBorder(new Color(233, 188, 103), 2));
		menuInicio.setBackground(Color.WHITE);
		menuInicio.setForeground(new Color(233, 188, 103));
		menuInicio.setFont(new Font("Calibri", Font.BOLD, 16));
		menuBar.add(menuInicio);
		
		//Separator
		JSeparator separator = new JSeparator();
		separator.setOpaque(true);
		separator.setForeground(Color.WHITE);
		separator.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		menuBar.add(separator);
		
		//Elemento menu Hotel
		menuHotel = new JMenuItem("                    EL HOTEL");
		menuHotel.setIconTextGap(8);
		menuHotel.setMargin(new Insets(0, 100, 0, 0));
		menuHotel.setForeground(new Color(233, 188, 103));
		menuHotel.setFont(new Font("Calibri", Font.BOLD, 16));
		menuHotel.setBorder(new LineBorder(new Color(233, 188, 103), 2));
		menuHotel.setBackground(Color.WHITE);
		menuBar.add(menuHotel);
		
		//Separator
		JSeparator separator_1 = new JSeparator();
		separator_1.setOpaque(true);
		separator_1.setForeground(Color.WHITE);
		menuBar.add(separator_1);
		
		//Elemento menu mis reservas
		menuMisReservas = new JMenuItem("                 TUS RESERVAS");
		menuMisReservas.setForeground(new Color(233, 188, 103));
		menuMisReservas.setFont(new Font("Calibri", Font.BOLD, 16));
		menuMisReservas.setBorder(new LineBorder(new Color(233, 188, 103), 2));
		menuMisReservas.setBackground(Color.WHITE);
		menuBar.add(menuMisReservas);
		
		//Separator
		JSeparator separator_2 = new JSeparator();
		separator_2.setOpaque(true);
		separator_2.setForeground(Color.WHITE);
		menuBar.add(separator_2);
		
		//Elemento menu hazte socio
		menuHazteSocio = new JMenuItem("                  HAZTE SOCIO");
		menuHazteSocio.setForeground(new Color(233, 188, 103));
		menuHazteSocio.setFont(new Font("Calibri", Font.BOLD, 16));
		menuHazteSocio.setBorder(new LineBorder(new Color(233, 188, 103), 2));
		menuHazteSocio.setBackground(Color.WHITE);
		menuBar.add(menuHazteSocio);
		
		//Separator
		JSeparator separator_4 = new JSeparator();
		separator_4.setOpaque(true);
		separator_4.setForeground(Color.WHITE);
		menuBar.add(separator_4);
		
		//Establece la operación de salida por defecto
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}

	@Override
	public void hacerVisible() {
		setVisible(true);
	}
	
	public void setPanel (JPanel panel) {
		scrollPane.setViewportView(panel);
	}
	
	public void setControlador(ControladorHotel control) {
		menuHotel.addActionListener(control);
		menuInicio.addActionListener(control);
		menuHazteSocio.addActionListener(control);
		menuMisReservas.addActionListener(control);
	}

	public JMenuItem getMenuHotel() {
		return menuHotel;
	}

	public JMenuItem getMenuInicio() {
		return menuInicio;
	}

	public JMenuItem getMenuHazteSocio() {
		return menuHazteSocio;
	}

	public JMenuItem getMenuMisReservas() {
		return menuMisReservas;
	}
}
