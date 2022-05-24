package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import validator.UsuarioValidator;

//VISTA LISTADO
@WebServlet(name = "UsuarioController", urlPatterns = { "/usuario" })
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public UsuarioController() {
		super();
	}

	
	//LISTADO - ELIMINAR (DESHABILITAR) 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idparametro = request.getParameter("id");

		UsuarioValidator validator = new UsuarioValidator(request);
		validator.listarUsuarios();

		if (idparametro != null) { //idparametro tiene contenido
			Integer id = Integer.parseInt(idparametro);
			validator.deshabilitarUsuario(id);
			
			response.sendRedirect("/softech_web/usuario");//<a href="/softech_web/usuario">
		}else {

			RequestDispatcher dispatcher = request.getRequestDispatcher("dist/mantenimiento/usuario.jsp");
			dispatcher.forward(request, response);
		}


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
