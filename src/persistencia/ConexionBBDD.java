package persistencia;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.sqlite.SQLiteConfig;

public class ConexionBBDD {
	private String driver;
	private String url;
	
	public ConexionBBDD() {
	
		try {
			//Carga un archivo properties con el tipo de driver y la url.
			InputStreamReader file = new FileReader("database/HotelApp.properties");
			Properties prop = new Properties();
			prop.load(file);
			
			//Asigna la información del fichero a los atributos de la clase
			this.driver =  prop.getProperty("driver");
			this. url = prop.getProperty("url");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Connection conectar() throws ClassNotFoundException, SQLException {
		
		//Genera un fichero de configuración de la base de datos Sqlite
		SQLiteConfig config = new SQLiteConfig();
		
		//Fuerza el funcionamiento de las claves ajenas en la base de datos
		config.enforceForeignKeys(true);
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, config.toProperties());
		
		return con;
	}
}
