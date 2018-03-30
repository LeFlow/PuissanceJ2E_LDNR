package jee.DAO.pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PlayerDAO {
	
	private Connection conn;
	
	public PlayerDAO() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/puissancebase","ldnr","groupe3");
		conn.createStatement().execute("CREATE TABLE IF NOT EXISTS JOUEURS(ID int primary key AUTO_INCREMENT NOT NULL,PSEUDO VARCHAR(100))");
	}
	
	public void insererJoueur (String pseudo) throws Exception{
		PreparedStatement ps = conn.prepareStatement("INSERT INTO JOUEURS (pseudo) VALUES(?)");
		ps.setString(1,pseudo);
		ps.executeUpdate();
	}
	
}