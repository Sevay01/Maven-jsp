package fr.m2i.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOGINPAGE = "/WEB-INF/pages/inc/_login.jsp";
	private static final String ACCUEILPAGE = "/welcome";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isLogoff = request.getParameter("logoff");
		if(isLogoff != null && !isLogoff.isEmpty() && isLogoff.equals("true")) {
			logoff(request);
			this.getServletContext().getRequestDispatcher(ACCUEILPAGE).forward(request, response);
		}else {
			this.getServletContext().getRequestDispatcher(LOGINPAGE).forward(request, response);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String mdp = request.getParameter("mdp");

		if(login != null && !login.isEmpty() && mdp != null && !mdp.isEmpty()) {
			logon(login, mdp, request);
		}
		
		
		response.sendRedirect(request.getContextPath() + ACCUEILPAGE);
	}
	
	
	protected void logon(String login, String mdp, HttpServletRequest request) {
		/* RAJOUTER UNE VERIF */
		HttpSession session = request.getSession();
		
		session.setAttribute("auth", true);
		session.setAttribute("login", login);

	}
	protected void logoff(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		session.removeAttribute("auth");
		session.removeAttribute("login");
		
	}

}
