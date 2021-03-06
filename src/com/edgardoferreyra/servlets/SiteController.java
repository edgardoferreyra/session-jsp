package com.edgardoferreyra.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SiteController
 */
@WebServlet("/SiteController")
public class SiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch(action) {
		case "login":
			request.getRequestDispatcher("login.jsp").forward(request, response);
			break;
		default:
				break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch(action) {
		case "loginSubmit":
			authenticate(request,response);
			break;
		}
	}
	
	public void authenticate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("edgardo") && password.contentEquals("ferreyra")) {
			request.getSession().invalidate();
			HttpSession newSession = request.getSession(true);
			newSession.setMaxInactiveInterval(300);
			
			newSession.setAttribute("username", username);
			//La siguiente l�nea es para crear un session ID si las cookies est�n deshabilitadas en el navegador
			String encode = response.encodeURL(request.getContextPath());
			
			
			response.sendRedirect(encode+"/MemberAreaController?action=memberArea");
		
			
		/*	Se crea una cookie para almacenar los datos de la sesi�n pero no se recomienda hacer esto
		 * debido a que la cookies deben utilizarse para brindar una mejor experiencia de usuario
		 * almacenando las preferencias de los usuarios que hayan elegido en la p�gina web.
		 * 
			Cookie cUsername = new Cookie("username",username);
			response.addCookie(cUsername);			
		*/
			
		}else {
			response.sendRedirect(request.getContextPath()+"/SiteController?action=login");
		}
	}

}
