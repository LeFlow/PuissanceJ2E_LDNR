package jee.DAO.pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerDAO {
	
	private Connection conn;
	
	public PlayerDAO() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/puissancebase", "root", "");
		conn.createStatement().execute("CREATE TABLE IF NOT EXISTS JOUEURS(ID int primary key AUTO_INCREMENT NOT NULL,PSEUDO VARCHAR(100))");
	}
	
	public void insertPlayer (String pseudo) throws Exception{
		PreparedStatement ps = conn.prepareStatement("INSERT INTO player (name, isWaiting) VALUES(?, ?)");
		ps.setString(1,pseudo);
		ps.setBoolean(2,true);
		ps.executeUpdate();
	}
	
	public void findPlayer (String pseudo) {
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("SELECT idPlayer FROM player WHERE isWaiting = true AND name!=? LIMIT 1");
			ps.setString(1,pseudo);
			ResultSet result = ps.executeQuery();
			result.first();
			System.out.println("Resultat : " + result.getInt("idPlayer"));
			
			
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}
	
}