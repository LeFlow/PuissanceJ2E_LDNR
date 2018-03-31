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
	
	public int findOpponent (String pseudo) {
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("SELECT idPlayer FROM player WHERE isWaiting = true AND name!=? LIMIT 1");
			ps.setString(1,pseudo);
			ResultSet result = ps.executeQuery();
			result.first();
			
			return result.getInt("idPlayer");
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public void reinitPlayer(String pseudo) throws SQLException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("UPDATE player SET isWaiting=true WHERE name=?");
			ps.setString(1,pseudo);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Boolean verifyIfIsExist (String pseudo) {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("SELECT COUNT(*) AS verif_exist FROM player WHERE name=?");
			ps.setString(1,pseudo);
			ResultSet result = ps.executeQuery();
			result.first();
			return result.getBoolean("verif_exist");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public String findPlayerNameById(int id) {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("SELECT name FROM player WHERE idPlayer=?");
			ps.setInt(1,id);
			ResultSet result = ps.executeQuery();
			result.first();
			System.out.println(result.getString("name"));
			return result.getString("name");
			
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	
	
	
	
	
}