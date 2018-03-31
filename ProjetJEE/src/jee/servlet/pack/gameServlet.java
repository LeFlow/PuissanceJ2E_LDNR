package jee.servlet.pack;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jee.DAO.pack.PartieDAO;

@SuppressWarnings("serial") 
@WebServlet("/game")

public class gameServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
					throws ServletException, IOException {
		
		if(req.getMethod().equals("POST")) {
			getServletContext().log("ajout dans la table partie");
		try {
				String chaineadresse = req.getParameter("adressecase");
				String positionx = chaineadresse.substring(2,3);
				String positiony = chaineadresse.substring(6,7);
				
				//new JoueurDAO().insererJoueur(
				//	req.getParameter("pseudo"));
				
//				new PartieDAO().insererPartie(
//					req.getParameter("num_partie"),
//					req.getParameter("joueur"),
//					positionx,
//					positiony);
				
			}catch (Exception ex) {getServletContext().log("Exc:"+ ex);}
		}
		
		req.getRequestDispatcher("WEB-INF/views/game.jsp").include(req, res);
		
	}

}
