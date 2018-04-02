package jee.servlet.pack;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import puissanceldnrproject.PartieBean;
import puissanceldnrproject.PartieDAO;

@SuppressWarnings("serial") 
@WebServlet("/game")

public class gameServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
					throws ServletException, IOException {
		
		//HttpSession session = req.getSession(true);
		
		Integer cpt = (Integer)req.getSession().getAttribute("refresh");
		if (cpt == null)
			cpt = 0;
		req.getSession().setAttribute("refresh", cpt);
		
		
		req.setAttribute("gagnant","perdant");
		//on récupère sur la page la value ou le name est un "num_partie"
		String numeropartie = req.getParameter("num_partie");
		
		//on récupère sur la page la value ou le name est "joueur"
		String idjoueur = req.getParameter("joueur");
		String idjoueur2 = req.getParameter("joueur2");
		
		//on récupère sur la page la value ou le nam est "adressecase"
		String adressecase = req.getParameter("adressecase");
		//on vide l'attribut adresse pour le premier chargement
		req.setAttribute("adressecase"," ");
		
		//on crée un tableau ou l'on stocke ces valeurs.
		String valeurcocheetab[] = {" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "};
		
		if(req.getMethod().equals("POST")) {	
			getServletContext().log("//////////////////////// PASSAGE DANS LE GET ////////////////////////");
			//dès que l'on sectionne la méthode POST on EFFACE la ligne dans la base
			try {
					new PartieDAO().effacer(
						req.getParameter("num_partie"),
						req.getParameter("joueur"),
						adressecase);
					
				}catch (Exception ex) {getServletContext().log("Exc:"+ ex);}
			//dès que l'on sectionne la méthode POST on AJOUTE la ligne dans la base
			try {
				new PartieDAO().insererPartie(
					req.getParameter("num_partie"),
					req.getParameter("joueur"),
					adressecase);
				
			}catch (Exception ex) {getServletContext().log("Exc:"+ ex);}
				
		}
		
		//on créer une ArrayList des valeurrecuperer pour les positions pour "un joueur et une partie donnée"
		ArrayList<String> valeurrecuperer = new ArrayList<>();
		ArrayList<String> valeurrecuperer2 = new ArrayList<>();
		
		//on remplit dans des objets partie bean avec le même numéro de partie et le même idjoueur
		//la liste valeurrecuperer
		try {
			getServletContext().log("creation des beans id1");
			for (PartieBean partieitem : (new PartieDAO()).coordonneesBouton(numeropartie, idjoueur))
				valeurrecuperer.add(partieitem.getAdressecase());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			getServletContext().log("creation des beans id2");
			for (PartieBean partieitem : (new PartieDAO()).coordonneesBouton(numeropartie, idjoueur2))
				valeurrecuperer2.add(partieitem.getAdressecase());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		if ( 
		//Solution 1 : case 0,1,2,3 cochee
		( valeurrecuperer.contains("0") && valeurrecuperer.contains("1") && valeurrecuperer.contains("2") && valeurrecuperer.contains("3") ) ||
		//Solution 2 : case 1,2,3,4 cochee
	    ( valeurrecuperer.contains("1") && valeurrecuperer.contains("2") && valeurrecuperer.contains("3") && valeurrecuperer.contains("4") ) ||
	    //Solution 3 : case 5,6,7,8 cochee
	    ( valeurrecuperer.contains("5") && valeurrecuperer.contains("6") && valeurrecuperer.contains("7") && valeurrecuperer.contains("8") ) ||	
	    //Solution 4: case 6,7,8,9 cochee
	    ( valeurrecuperer.contains("6") && valeurrecuperer.contains("7") && valeurrecuperer.contains("8") && valeurrecuperer.contains("9") ) ||
	    //Solution 5 : case 10,11,12,13 cochee	
	    ( valeurrecuperer.contains("10") && valeurrecuperer.contains("11") && valeurrecuperer.contains("12") && valeurrecuperer.contains("13") ) ||	
	    //Solution 6 : case 11,12,13,14 cochee
	    ( valeurrecuperer.contains("11") && valeurrecuperer.contains("12") && valeurrecuperer.contains("13") && valeurrecuperer.contains("14") ) ||	
	    //Solution 7 : case 15,16,17,18 cochee
	    ( valeurrecuperer.contains("15") && valeurrecuperer.contains("16") && valeurrecuperer.contains("17") && valeurrecuperer.contains("18") ) ||	
	    //Solution 8 : case 16,17,18,19 cochee
	    ( valeurrecuperer.contains("16") && valeurrecuperer.contains("17") && valeurrecuperer.contains("18") && valeurrecuperer.contains("19") ) ||	
	    //Solution 9 : case 20, 21, 22, 23
	    ( valeurrecuperer.contains("20") && valeurrecuperer.contains("21") && valeurrecuperer.contains("22") && valeurrecuperer.contains("23") ) ||	
	    //Solution 10 : case 21 , 22, 23 ,24 
	    ( valeurrecuperer.contains("21") && valeurrecuperer.contains("22") && valeurrecuperer.contains("23") && valeurrecuperer.contains("24") ) ||
	    //Solution 11 : case 0, 5, 10 , 15
	    ( valeurrecuperer.contains("0") && valeurrecuperer.contains("5") && valeurrecuperer.contains("10") && valeurrecuperer.contains("15") ) ||
		//Solution 12 : case 5, 10,15 , 20
	    ( valeurrecuperer.contains("5") && valeurrecuperer.contains("10") && valeurrecuperer.contains("15") && valeurrecuperer.contains("20") ) ||
	    //Solution 13 : case 1,6,11,21
	    ( valeurrecuperer.contains("1") && valeurrecuperer.contains("6") && valeurrecuperer.contains("11") && valeurrecuperer.contains("16") ) ||
	    //Solution 14 : case 6,11,16,21
	    ( valeurrecuperer.contains("6") && valeurrecuperer.contains("11") && valeurrecuperer.contains("16") && valeurrecuperer.contains("21") ) ||
	    //Solution 15 : case 2,7,12,17
	    ( valeurrecuperer.contains("2") && valeurrecuperer.contains("7") && valeurrecuperer.contains("12") && valeurrecuperer.contains("17") ) ||
	    //Solution 16 : case 7,12,17,22
	    ( valeurrecuperer.contains("7") && valeurrecuperer.contains("12") && valeurrecuperer.contains("17") && valeurrecuperer.contains("22") ) ||
	    //Solution 17 : case 3,8,13,18
	    ( valeurrecuperer.contains("3") && valeurrecuperer.contains("8") && valeurrecuperer.contains("13") && valeurrecuperer.contains("18") ) ||
	    //Solution 18 : case 8,13,18,23
	    ( valeurrecuperer.contains("8") && valeurrecuperer.contains("13") && valeurrecuperer.contains("18") && valeurrecuperer.contains("23") ) ||
	    //Solution 19 : case 4,9,14,19
	    ( valeurrecuperer.contains("4") && valeurrecuperer.contains("9") && valeurrecuperer.contains("14") && valeurrecuperer.contains("19") ) ||
	    //Solution 20 : case 9,14,19,24
	    ( valeurrecuperer.contains("9") && valeurrecuperer.contains("14") && valeurrecuperer.contains("19") && valeurrecuperer.contains("24") ) ||
	    //Solution 21 : case 0 ,6,12, 18
	    ( valeurrecuperer.contains("0") && valeurrecuperer.contains("6") && valeurrecuperer.contains("12") && valeurrecuperer.contains("18") ) ||
	    //Solution 22 : case 6,12,18,24
	    ( valeurrecuperer.contains("6") && valeurrecuperer.contains("12") && valeurrecuperer.contains("18") && valeurrecuperer.contains("24") )  ||
	    //Solution 23 : case 4,8,12,16
	    ( valeurrecuperer.contains("4") && valeurrecuperer.contains("8") && valeurrecuperer.contains("12") && valeurrecuperer.contains("16") ) ||
	    //Solution 24 : case 8,12,16,20
	    ( valeurrecuperer.contains("8") && valeurrecuperer.contains("12") && valeurrecuperer.contains("16") && valeurrecuperer.contains("20") )  ||
	    //Solution 25 : case 1,7,13,19
	    ( valeurrecuperer.contains("1") && valeurrecuperer.contains("7") && valeurrecuperer.contains("13") && valeurrecuperer.contains("19") ) ||
	    //Solution 26 : case 5,11,17,23
	    ( valeurrecuperer.contains("5") && valeurrecuperer.contains("11") && valeurrecuperer.contains("17") && valeurrecuperer.contains("23") ) ||
	    //Solution 27 : case 3,7,11,15
	    ( valeurrecuperer.contains("3") && valeurrecuperer.contains("7") && valeurrecuperer.contains("11") && valeurrecuperer.contains("15") ) ||
	    //Solution 28 : case 9,13,17,21
	    ( valeurrecuperer.contains("9") && valeurrecuperer.contains("13") && valeurrecuperer.contains("17") && valeurrecuperer.contains("21") )		
		
		) 
			{
			try {
				new PartieDAO().viderTablePartie();
			} catch (Exception e) {
				e.printStackTrace();
			}
			req.setAttribute("adressecase"," ");
			req.setAttribute("gagnant","gagne");
		}
		
		//on parcours la liste valeur recuperer qui est composée d'objet String pour les convertir en int 
		//et pour la valeur récupérer on assignie X pour l'indice dans le tableau valeurcocheetab
		// si j'ai récupérer "3" on convertis 3 en int et on va placé à valeurcocheetab[3] = "X".
		// ce X sera alors affichée sur la grille par l'intermédiaire du ${valeurcocheetab[3]} donc X
		
		for (String itemvaleur : valeurrecuperer) {
			getServletContext().log("recupere valeur X");
			int toointvaleur = Integer.parseInt(itemvaleur);
			valeurcocheetab[toointvaleur]="X";
		}
		
		for (String itemvaleur : valeurrecuperer2) {
			getServletContext().log("recupere valeur O");
			int toointvaleur = Integer.parseInt(itemvaleur);
			valeurcocheetab[toointvaleur]="O";
		}
		
		//on affiche dans la c:out dans jeu.jsp les valeurs qui sont cochées.
		req.setAttribute("casecochees",valeurcocheetab);
			
		req.getRequestDispatcher("WEB-INF/views/jeu.jsp").forward(req, res);
	}

}
