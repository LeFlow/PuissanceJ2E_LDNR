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
		
		if(req.getMethod().equals("POST")) {
			getServletContext().log("Formulaire reçu");
			String pseudo = req.getParameter("pseudo");
			
			try {
				new PlayerDAO().insertPlayer(pseudo);;
			}catch (Exception ex) {
				getServletContext().log("Erreur : " + ex);
			}
		}
		
		
		try {
			new PlayerDAO().findPlayer(req.getParameter("pseudo"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
        HttpSession session = req.getSession();
        session.setAttribute("pseudo", req.getParameter("pseudo"));

        
        
        
		
		req.getRequestDispatcher("WEB-INF/views/loader.jsp").forward(req, resp);
	}
	
}
