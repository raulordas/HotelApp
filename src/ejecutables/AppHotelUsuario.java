package ejecutables;

import java.awt.EventQueue;

import controlador.ControladorHotel;
import vista.GuiLogin;
import vista.PanelAdministrador;
import vista.PanelHabitaciones;
import vista.PanelHazteSocio;
import vista.PanelHotel;
import vista.PanelIntro;
import vista.PanelMisReservas;
import vista.PanelReserva;
import vista.VistaPrincipal;

public class AppHotelUsuario {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					// Declara e inicializa las clases correspondientes al interfaz gráfico
					VistaPrincipal mainGui = new VistaPrincipal();
					PanelIntro panelIntro = new PanelIntro();
					PanelHotel panelHotel = new PanelHotel();
					PanelHazteSocio panelHazteSocio = new PanelHazteSocio();
					PanelHabitaciones panelHabitaciones = new PanelHabitaciones();
					PanelReserva panelReserva = new PanelReserva();
					PanelMisReservas panelMisReservas = new PanelMisReservas();
					PanelAdministrador panelAdministrador = new PanelAdministrador();
					GuiLogin ventanaLogin = new GuiLogin();

					// Declara e inicializa el controlador de la aplicación
					ControladorHotel control = new ControladorHotel(mainGui, panelIntro, panelHotel, panelHazteSocio,
							panelHabitaciones, ventanaLogin, panelReserva, panelMisReservas, panelAdministrador);

					// Asigna el controlador a las clases de la vista
					mainGui.setControlador(control);
					panelIntro.setControlador(control);
					ventanaLogin.setControlador(control);
					panelHabitaciones.setControlador(control);
					panelReserva.setControlador(control);
					panelHazteSocio.setControlador(control);
					panelHotel.setControlador(control);
					panelMisReservas.setControlador(control);
					panelAdministrador.setControlador(control);

					// Hace visible el hilo visual principal de la aplicación
					mainGui.hacerVisible();
					mainGui.setPanel(panelIntro);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
