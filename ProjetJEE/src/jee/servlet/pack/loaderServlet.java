package jee.servlet.pack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jee.DAO.pack.PlayerDAO;

@SuppressWarnings("serial")
@WebServlet("/loading")
public class loaderServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
        HttpSession session = req.getSession();

        if(session.getAttribute("pseudo")!=null && session.getAttribute("pseudo").equals(req.getParameter("pseudo")) ) {
        	try {
				new PlayerDAO().reinitPlayer(req.getParameter("pseudo"));
			} catch (Exception e) {
				e.printStackTrace();
			}
    		req.getRequestDispatcher("WEB-INF/views/loader.jsp").forward(req, resp);
        }else {
    		PlayerDAO player;
			try {
				player = new PlayerDAO();
        		Boolean exist = player.verifyIfIsExist(req.getParameter("pseudo"));
        		System.out.println(exist);
            	if(exist == false) {
            		if(req.getMethod().equals("POST")) {
            			session.setAttribute("pseudo", req.getParameter("pseudo"));
            			getServletContext().log("Formulaire re�u");
            			String pseudo = req.getParameter("pseudo");
            			
            			try {
            				new PlayerDAO().insertPlayer(pseudo);;
            			}catch (Exception ex) {
            				getServletContext().log("Erreur : " + ex);
            			}
            		}
            	}else {
            		session.setAttribute("pseudo", req.getParameter("pseudo"));
                	try {
        				new PlayerDAO().reinitPlayer(req.getParameter("pseudo"));
        			} catch (Exception e) {
        				e.printStackTrace();
        			}
            	}
        	req.getRequestDispatcher("WEB-INF/views/loader.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
        
        
//Recherche un adversaire
//		try {
//			new PlayerDAO().findOpponent(req.getParameter("pseudo"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
        
        

	}
	
}
