package jee.servlet.pack;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial") 
@WebServlet("/game")

public class gameServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
					throws ServletException, IOException {
		
		//String num_partie = (String)req.getSession().getAttribute("jeu2");
		
		//on récupère sur la page la value ou le name est un "num_partie"
		String numeropartie = req.getParameter("num_partie");
		
		//on récupère sur la page la value ou le name est "joueur"
		String idjoueur = req.getParameter("joueur");
		
		//on récupère sur la page la value ou le nam est "adressecase"
		String adressecase = req.getParameter("adressecase");
		
		//on crée un tableau ou l'on stocke ces valeurs.
		String valeurcocheetab[] = {" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "};

		if(req.getMethod().equals("POST")) {
			getServletContext().log("ajout dans la table partie");
			try {
					new PartieDAO().insererPartie(
						req.getParameter("num_partie"),
						req.getParameter("joueur"),
						adressecase);
					
				}catch (Exception ex) {getServletContext().log("Exc:"+ ex);
			}
		}
		
		System.out.println("valeur idjoueur :" + idjoueur); //ok
		System.out.println("valeur numeropartie:" + numeropartie);//ok
		
		//for (String itemvaleur : valeurcocheetab)
		//	System.out.println(itemvaleur);
		
		//on créer une ArrayList des valeurrecuperer pour les positions pour "un joueur et une partie donnée"
		ArrayList<String> valeurrecuperer = new ArrayList<>();
		
		//on remplit dans des objets partie bean avec le même numéro de partie et le même idjoueur
		//la liste valeurrecuperer
		try {
			for (PartieBean partieitem : (new PartieDAO()).coordonneesBouton(numeropartie, idjoueur))
				valeurrecuperer.add(partieitem.getAdressecase());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//on parcours la liste valeur recuperer qui est composée d'objet String pour les convertir en int 
		//et pour la valeur récupérer on assignie X pour l'indice dans le tableau valeurcocheetab
		// si j'ai récupérer "3" on convertis 3 en int et on va placé à valeurcocheetab[3] = "X".
		// ce X sera alors affichée sur la grille par l'intermédiaire du ${valeurcocheetab[3]} donc X
		
		for (String itemvaleur : valeurrecuperer) {
			int toointvaleur = Integer.parseInt(itemvaleur);
			valeurcocheetab[toointvaleur]="X";
		}
		
		//for (String itemvaleur : valeurcocheetab)
			//System.out.println(itemvaleur);
		
		req.setAttribute("casecochees",valeurcocheetab);
			
		req.getRequestDispatcher("WEB-INF/views/game.jsp").include(req, res);
	}

}
