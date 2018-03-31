package jee.DAO.pack;

public class PartieBean {
	
	private String num_partie;
	private String joueur;
	private String adressecase;
	
	PartieBean (String num_partie,String joueur,String adressecase){
		this.num_partie = num_partie;
		this.joueur = joueur;
		this.adressecase = adressecase;
	}
	
	public String getNum_partie() {
		return num_partie;
	}
	public void setNum_partie(String num_partie) {
		this.num_partie = num_partie;
	}
	public String getJoueur() {
		return joueur;
	}
	public void setJoueur(String joueur) {
		this.joueur = joueur;
	}
	public String getAdressecase() {
		return adressecase;
	}
	public void setAdressecase(String adressecase) {
		this.adressecase = adressecase;
	}
}

