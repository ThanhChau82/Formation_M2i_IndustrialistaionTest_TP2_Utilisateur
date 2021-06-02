package edu.m2i.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.m2i.service.UserService;
import edu.m2i.service.UserServiceImpl;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet("/AuthServlet")
public class AuthentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService;        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthentificationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String paramLogin = request.getParameter("login");
		final String paramMdp = request.getParameter("mdp");
		
		String messageErreur = "";
		if (paramLogin != null && !paramLogin.isBlank()
				&& paramMdp != null && !paramMdp.isBlank()) {
			userService = new UserServiceImpl();
			if (userService.authentifierUser(paramLogin, paramMdp)) {
				response.sendRedirect("user.jsp");				
			} else {
				messageErreur = "Login/Mdp erroné(s)";
				request.setAttribute("erreurAuthentification", messageErreur);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} else {
			messageErreur = "Params erronés";
			request.setAttribute("erreurAuthentification", messageErreur);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
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
