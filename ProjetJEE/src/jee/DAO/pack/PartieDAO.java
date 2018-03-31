package jee.DAO.pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PartieDAO {
	
	private Connection conn;
	
	public PartieDAO() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/puissancebase","ldnr","groupe3");
		conn.createStatement().execute("CREATE TABLE IF NOT EXISTS PARTIEENCOURS(NUM_PARTIE VARCHAR(100),JOUEUR VARCHAR(100),ADRESSECASE VARCHAR(100))");
	}
	
	public void insererPartie (String num_partie,String joueur,String adressecase) throws Exception{
		PreparedStatement ps = conn.prepareStatement("INSERT INTO PARTIEENCOURS (num_partie,joueur,adressecase) VALUES (?,?,?)");
		ps.setString(1,num_partie);
		ps.setString(2,joueur);
		ps.setString(3,adressecase);
		ps.executeUpdate();
	}
	
	public ArrayList<PartieBean> coordonneesBouton (String numeropartie,String joueur) throws Exception{
		ArrayList<PartieBean> partielist = new ArrayList<>();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM PARTIEENCOURS WHERE num_partie=? AND joueur=?");
		ps.setString(1,numeropartie);
		ps.setString(2,joueur);
		ResultSet result = ps.executeQuery();
		while (result.next()) {
			String num_partie_bean = result.getString("num_partie");
			String joueur_bean = result.getString("joueur");
			String adresse_case_bean = result.getString("adressecase");
			partielist.add(new PartieBean(num_partie_bean, joueur_bean, adresse_case_bean));
		}
		return partielist;
	}
}