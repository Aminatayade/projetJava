package MesClasses;
import java.io.FileInputStream;
//import java.io.FileOutputStream;
import java.sql.*;
import java.util.Properties;
public class ConnexionDB {
	public static Connection connectDB()
	{
		try {
			Properties p =new Properties ();
			try (FileInputStream file= new  FileInputStream("Config.properties")){
			p.load(file);
			}
			String urlPilote=p.getProperty("jdbc.driver.class");
			Class.forName(urlPilote);
			System.out.println("Le pilote est bien charge");
			String urlBD=p.getProperty("jdbc.url");
			String user=p.getProperty("jdbc.login");
			String  password=p.getProperty("jdbc.password");
			Connection con=DriverManager.getConnection(urlBD, user, password);
			System.out.println("La connexion avec le serveur MySQL est bien �tablie");
			return con;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
			}//fin catch
		}//fin connectDB()
	
	public static void main (String [] args) throws Exception {
		Connection  machaine=connectDB();
		Statement  s=machaine.createStatement();
		ResultSet  re=s.executeQuery("select * from vente");
		//affichage de la table Banque
		System.out.println("ID"+"\t"+"Code"+"\t"+"Nom");
		while ( re.next())
		{
			System.out.println(re.getInt(1)+"\t"+re.getString(2)+"\t"+re.getString(3));
		}
		
	}
	}//fin class


