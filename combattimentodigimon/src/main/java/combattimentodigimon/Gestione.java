package combattimentodigimon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Gestione {
    private Connection connessione;
	
	
	
	public Gestione() throws SQLException, ClassNotFoundException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	String password = "EzJ90IaSaP";
	String username = "ExmDFToJYb";
	String url = "jdbc:mysql://remotemysql.com:3306/ExmDFToJYb?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false";
	this.connessione = DriverManager.getConnection(url, username, password);
	}
	
	public void chiamaCreatore()throws SQLException, ClassNotFoundException{
		PreparedStatement prepareStatement = connessione.prepareStatement("select distinct idutente from digimon;");
		ResultSet executeQuery = prepareStatement.executeQuery();
		List<String> listaUtenti = new ArrayList<>();
		while (executeQuery.next()) {
			String id = executeQuery.getString(1);
			listaUtenti.add(id);
		}
	}
	
	
	
	
	
	
	
	
}
