package fr.m2i.servlets;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="WelcomeServlet", urlPatterns = "/welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Map<String, String> PAGES;
	
	static {
		PAGES  = new TreeMap<String, String>();
		PAGES.put("ACCUEIL", "/WEB-INF/pages/welcome.jsp");
		PAGES.put("AUTRE", "/WEB-INF/pages/autre.jsp");
	}

    public Welcome() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selectPage = request.getParameter("page");
		
		request.setAttribute("exemple", "exemple");
	
		
		if(selectPage != null && !selectPage.isEmpty() && PAGES.containsKey(selectPage)) {
			selecteurPage(PAGES.get(selectPage), request, response);
		}else
		{
			selecteurPage(PAGES.get("ACCUEIL"), request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	protected void selecteurPage(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean sessionAuth = (request.getSession().getAttribute("auth") != null) ? (boolean)request.getSession().getAttribute("auth") : false;
		
		if(sessionAuth)
			this.getServletContext().getRequestDispatcher(url).forward(request, response);
		else
			this.getServletContext().getRequestDispatcher(PAGES.get("ACCUEIL")).forward(request, response);
	}

}
