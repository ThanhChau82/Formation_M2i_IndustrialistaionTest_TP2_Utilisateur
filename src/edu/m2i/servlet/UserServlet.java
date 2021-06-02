package edu.m2i.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.m2i.entities.User;
import edu.m2i.service.UserService;
import edu.m2i.service.UserServiceImpl;
import edu.m2i.validation.ValidateUser;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ValidateUser validateUser;
	
	private UserService userService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramNom = request.getParameter("nom");
		String paramPrenom = request.getParameter("prenom");
		String paramLogin = request.getParameter("login");
		String paramMdp = request.getParameter("password");
		
		String message = "";
		if (paramNom != null && !paramNom.isBlank() &&  
			paramPrenom != null && !paramPrenom.isBlank() && 
			paramLogin!= null && !paramLogin.isBlank() && 
			paramMdp != null && !paramMdp.isBlank()) {
			
			
			User user = new User(paramNom, paramPrenom, paramLogin, paramMdp);
			validateUser = new ValidateUser();
			if (validateUser.verifChaineNonNull(user.getNom(), user.getPrenom(), user.getLogin(), user.getPassword())) {
				userService = new UserServiceImpl();
				userService.inscrireUser(user);
				message = "Ajout succès de l'utilisateur";
				request.setAttribute("confirmationSaveUser", message);
				request.getRequestDispatcher("/user.jsp").forward(request, response);
			} else {
				message = "Echec d'ajout de l'utilisateur";
				request.setAttribute("erreurSaveUser", message);
				request.getRequestDispatcher("/user.jsp").forward(request, response);
			}
			
		} else {			
			message = "Paramètre(s) null(s) ou blank(s)";
			request.setAttribute("erreurSaveUser", message);
			request.getRequestDispatcher("/user.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
