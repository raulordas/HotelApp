package controlador;
import modelo.*;
import persistencia.*;
import vista.*;
import java.awt.event.*;
import javax.swing.*;

public class ControladorHotel implements ActionListener, MouseListener {
	private static final AdministradorPojo admin = new AdministradorPojo("ADMIN", "1234");
	private boolean esAdmin = false;
	private boolean solicitaAcceso = false;
	private VistaPrincipal mainGui;
	private PanelIntro panelIntro;
	private PanelHotel panelHotel;
	private PanelHazteSocio panelHazteSocio;
	private PersistenciaConsultas pConsultas;
	private PersistenciaHabitaciones pHabitaciones;
	private PersistenciaUsuarios pUsuarios;
	private PersistenciaReservas pReservas;
	private PanelHabitaciones panelHabitaciones;
	private CalculadoraHabitaciones calculadoraHabitaciones;
	private PanelReserva panelReserva;
	private PanelMisReservas panelMisReservas;
	private PanelAdministrador panelAdministrador;
	private CalculadoraFechas calcuFechas;
	private CalculadoraPrecios calcuPrecios;
	private GuiLogin ventanaLogin;
	private Consulta consultaAux;
	private Consulta consultaAdmin;
	private ClientePermanente clienteP;
	private Cliente clienteAux;
	private AdministradorPojo usuarioSesion;
	private Habitacion habitacion;
	
	public ControladorHotel(VistaPrincipal mainGui, PanelIntro panelIntro, PanelHotel panelHotel,
			PanelHazteSocio panelHazteSocio, PanelHabitaciones panelHabitaciones, 
			GuiLogin ventanaLogin, PanelReserva panelReserva, PanelMisReservas panelMisReservas, PanelAdministrador panelAdministrador) {
		this.mainGui = mainGui;
		this.panelIntro = panelIntro;
		this.panelHotel = panelHotel;
		this.panelHazteSocio = panelHazteSocio;
		this.panelHabitaciones = panelHabitaciones;
		this.ventanaLogin = ventanaLogin;
		this.panelReserva = panelReserva;
		this.panelMisReservas = panelMisReservas;
		this.panelAdministrador = panelAdministrador;
		calcuFechas = new CalculadoraFechas();
		pConsultas = new PersistenciaConsultas();
		pHabitaciones = new PersistenciaHabitaciones();
		pUsuarios = new PersistenciaUsuarios();
		pReservas = new PersistenciaReservas();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		
		//Detecta los eventos de la barra de menús del JFrame
		if (event instanceof JMenuItem) {
			
			//Detecta el evento de hacer click en el menu Inicio
			if (event.equals(mainGui.getMenuInicio())) {
				mainGui.setPanel(panelIntro);
			
			//Detecta el evento de hacer click en el menú El Hotel
			} else if (event.equals(mainGui.getMenuHotel())) {
				mainGui.setPanel(panelHotel);
			
			//Detecta el evento de hacer click en el menú Hazte Socio
			} else if (event.equals(mainGui.getMenuHazteSocio())) {
				mainGui.setPanel(panelHazteSocio);
			
			//Detecta el evento de hacer click en el menú Mis Reservas
			} else if (event.equals(mainGui.getMenuMisReservas())) {
				
				if (usuarioSesion != null) {
					panelMisReservas.mostrarDatos(pReservas.consultarReservas(usuarioSesion));
					mainGui.setPanel(panelMisReservas);
				
				} else {
					JOptionPane.showMessageDialog(mainGui, "Debe hacer LOGIN para poder ver sus reservas");
				}
			
			//Detecta el evento de hacer click en el boton volver de Mis Reservas
			} else if (event.equals(panelMisReservas.getBtnVolver())) {
				mainGui.setPanel(panelIntro);
			}
		}
		
		//Detecta los eventos de pulsar en un JButton
		if (event instanceof JButton) {
			
			//Detecta el evento de pulsar el JButton de Consultar Disponibilidad
			if(event.equals(panelIntro.getBtnConsultarDisponibilidad())) {
				
				//Presenta las opciones de habitaciones disponibles si las hay.
				if (panelIntro.getDatos() != null) {
					consultaAux = panelIntro.getDatos();
					calculadoraHabitaciones = new CalculadoraHabitaciones(pHabitaciones.consultarHabitaciones());
					calculadoraHabitaciones.calcularHabitacionesDisponibles(pConsultas.consultarDisponibilidad(panelIntro.getDatos()));
					panelHabitaciones.mostrarCantidadHabitaciones(calculadoraHabitaciones.getNumSencillas(), calculadoraHabitaciones.getNumDobles(), calculadoraHabitaciones.getNumSuite());
					panelHabitaciones.mostrarDescripcionHabitaciones(pHabitaciones.consultarTipoHabitaciones());
					mainGui.setPanel(panelHabitaciones);
				}
				
			//Detecta el evento de pulsar el boton Login para abrir la ventana de identificacion
			} else if (event.equals(panelIntro.getBtnLogin())) {
				solicitaAcceso = false;
				ventanaLogin.hacerVisible();
			
			//Detecta el evento de pulsar el boton aceptar para intentar hacer login como cliente
			} else if (event.equals(ventanaLogin.getBtnAceptar()) && !solicitaAcceso) {
				usuarioSesion = ventanaLogin.getDatos();
				int res = pUsuarios.comprobarPassword(usuarioSesion);
				
				if (res == 1) {
					JOptionPane.showMessageDialog(ventanaLogin, "Los Datos Introducidos son correctos");
					panelIntro.setLblUsuarioIdentificado("Bienvenido usuario: " + usuarioSesion.getUsuario());
					esAdmin = false;
					ventanaLogin.reciclar();
					ventanaLogin.dispose();
				
				} else {
					JOptionPane.showMessageDialog(ventanaLogin, "Los Datos Introducidos son Incorrectos");
					usuarioSesion = null;
					ventanaLogin.reciclar();
				}
			
			//Detecta el evento de pulsar el boton aceptar para intentar hacer login como admin
			} else if (event.equals(ventanaLogin.getBtnAceptar()) && solicitaAcceso) {
				
				if (ventanaLogin.getDatos().getUsuario().equals(admin.getUsuario()) 
						&& ventanaLogin.getDatos().getContrasenya().equals(admin.getContrasenya())) {
			
					JOptionPane.showMessageDialog(ventanaLogin, "Los Datos Introducidos son correctos");
					panelIntro.setLblUsuarioIdentificado("Bienvenido Administrador");
					esAdmin = true;
					usuarioSesion = null;
					ventanaLogin.reciclar();
					ventanaLogin.dispose();
					mainGui.setPanel(panelAdministrador);
				
				} else {
					JOptionPane.showMessageDialog(ventanaLogin, "Datos Incorrectos. No se puede acceder al sistema");
					ventanaLogin.reciclar();
				}	
			
			//Detecta el evento de elegir una habitación sencilla para continuar la reserva
			} else if(event.equals(panelHabitaciones.getBtnReservarSencilla())) {
				habitacion = calculadoraHabitaciones.escogerHabitacion(1);
				calcuFechas = new CalculadoraFechas();
				calcuFechas.extraerFechasPosibles(consultaAux);
				calcuPrecios = new CalculadoraPrecios(calcuFechas.getFechasDisponibles(), consultaAux, habitacion, pConsultas.getNumReservas());
				panelReserva.mostrarReserva(calcuPrecios.getModeloTabla());
				panelReserva.mostrarPrecioFinal(calcuPrecios.getPrecio_Final());
				mainGui.setPanel(panelReserva);
				
				if (usuarioSesion != null) {
					clienteAux = pUsuarios.consultarUsuarioPermanente(usuarioSesion);
					panelReserva.mostrarCliente(clienteAux);
				}
				
			//Detecta el evento de elegir una habitación doble para continuar la reserva
			} else if(event.equals(panelHabitaciones.getBtnReservarDoble())) {
				habitacion = calculadoraHabitaciones.escogerHabitacion(2);
				calcuFechas = new CalculadoraFechas();
				calcuFechas.extraerFechasPosibles(consultaAux);
				calcuPrecios = new CalculadoraPrecios(calcuFechas.getFechasDisponibles(), consultaAux, habitacion, pConsultas.getNumReservas());
				panelReserva.mostrarReserva(calcuPrecios.getModeloTabla());
				panelReserva.mostrarPrecioFinal(calcuPrecios.getPrecio_Final());
				mainGui.setPanel(panelReserva);
				
				if (usuarioSesion != null) {
					clienteAux = pUsuarios.consultarUsuarioPermanente(usuarioSesion);
					panelReserva.mostrarCliente(clienteAux);
				}	
			
			//Detecta el evento de elegir una habitación Suite para continuar la reserva
			} else if(event.equals(panelHabitaciones.getBtnReservarSuite())) {
				habitacion = calculadoraHabitaciones.escogerHabitacion(3);
				calcuFechas = new CalculadoraFechas();
				calcuFechas.extraerFechasPosibles(consultaAux);
				calcuPrecios = new CalculadoraPrecios(calcuFechas.getFechasDisponibles(), consultaAux, habitacion, pConsultas.getNumReservas());
				panelReserva.mostrarReserva(calcuPrecios.getModeloTabla());
				panelReserva.mostrarPrecioFinal(calcuPrecios.getPrecio_Final());
				mainGui.setPanel(panelReserva);
				
				if (usuarioSesion != null) {
					clienteAux = pUsuarios.consultarUsuarioPermanente(usuarioSesion);
					panelReserva.mostrarCliente(clienteAux);
				}	
				
			//Detecta el evento de hacer click para dar de alta un usuario permanente
			} else if (event.equals(panelHazteSocio.getBtnAltaUsuario())) {
				clienteP = panelHazteSocio.getDatos(pUsuarios.consultarListaUsuarios());
				
				if (clienteP != null) {
					int res = pUsuarios.insertarClientePermanente(clienteP);
					
					if (res == 1) {
						panelHazteSocio.reciclar();
						JOptionPane.showMessageDialog(panelHazteSocio, "Se ha realizado el alta de manera satisfactoria");
						new Email();
						Email.send("hotelappjavapplication@gmail.com", "abderraman234", clienteP.getEmail(), "Bievenido a nuestro hotel", "Su usuario es " + clienteP.getUsuario() + " y su contraseña es " + clienteP.getPassword());
						
					} else {
						JOptionPane.showMessageDialog(panelHazteSocio, "Ha ocurrido un error durante el proceso");
					}
				}
			
			//Detecta el evento de confirmar la reserva definitivamente
			} else if (event.equals(panelReserva.getBtnReserva())) {	
				int res = 0;
				
				if (panelReserva.getIdCliente() == 0 && panelReserva.datosCliente() != null) {
					res = pReservas.insertarReserva(panelReserva.getDatos(habitacion, consultaAux, calcuPrecios.getPrecio_Final()));
					pUsuarios.insertarCliente(panelReserva.datosCliente());
				} else {
					res = pReservas.insertarReserva(panelReserva.getDatos(habitacion, consultaAux, calcuPrecios.getPrecio_Final()));
				}
				
				if (res == 1) {
					JOptionPane.showMessageDialog(panelReserva, "Se ha realizado la reserva de manera satisfactoria");
					mainGui.setPanel(panelIntro);
				} else {
					JOptionPane.showMessageDialog(panelReserva, "Ha ocurrido un error al realizar la reserva, repita el proceso");
					mainGui.setPanel(panelIntro);
				}
			
			//Detecta el evento de hacer click para hacer Log OUT
			} else if (event.equals(panelIntro.getBtnLogout())) {
				
				if (usuarioSesion != null) {
					usuarioSesion = null;
					JOptionPane.showMessageDialog(panelIntro, "Ha desconectado su cuenta satisfactoriamente");
					panelIntro.setLblUsuarioIdentificado("HAGA LOGIN PARA ACCEDER A SU CUENTA DE CLIENTE");
				} else {
					JOptionPane.showMessageDialog(panelIntro, "No se ha identificado aun como cliente, no necesita hacer Log Out");
				}
				
			
			//Detecta el evento de pulsar Hazte Socio en el panel hotel
			} else if (event.equals(panelHotel.getBtnHazteSocio())) {
				mainGui.setPanel(panelHazteSocio);
			
			} else if (event.equals(panelAdministrador.getBtnBuscar())) {
				consultaAdmin = panelAdministrador.getDatos();
				if (consultaAdmin != null) {
					panelAdministrador.mostrarDatos(consultaAdmin, pConsultas.consultarReservasPeriodo(consultaAdmin));
				}		
			
			//Detecta el evento de pulsar el botón volver del panel Mis Reservas
			} else if (event.equals(panelMisReservas.getBtnVolver())) {
				mainGui.setPanel(panelIntro);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e2) {
		Object event2 = e2.getSource();
		
		
		if (event2 instanceof JLabel) {
			
			//Detecta el evento de hacer click en la imagen de la llave para acceder al area de administrador
			if (event2.equals(panelIntro.getLblKey()) && esAdmin) {
				mainGui.setPanel(panelAdministrador);
				
			} else {
				solicitaAcceso = true;
				ventanaLogin.hacerVisible();
			}
		}	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
