package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Usuario;
import validator.UsuarioValidator;

/**
 * Servlet implementation class Login
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
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
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("dist/login.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");
        
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        String result = "";
        
        UsuarioValidator validator = new UsuarioValidator(request);
        Usuario user = new Usuario();
        
        try {
        	result = validator.usuarioLogin(usuario,clave);
        	
        	if(result == null) {
        		response.sendRedirect("");
        	}else {
        		user.setNombre_usuario(usuario);
        		user.setContrasena(clave);
    
            	request.setAttribute("usuario", user);
            	request.setAttribute("mensaje", result);
            	RequestDispatcher dispatcher = request.getRequestDispatcher("dist/login.jsp");
                dispatcher.forward(request, response);
        	}

        }catch(Exception e) {
        	
        }
	}

}
