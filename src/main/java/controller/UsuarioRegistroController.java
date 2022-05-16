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
 * Servlet implementation class UsuarioRegistroController
 */
@WebServlet(name = "UsuarioRegistroController", urlPatterns = { "/usuarioRegistro" })
public class UsuarioRegistroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioRegistroController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idparametro = request.getParameter("id");
		
		UsuarioValidator validator = new UsuarioValidator(request);
		
		if(idparametro == null) {
			Usuario usuario = new Usuario();
			request.setAttribute("usuario", usuario);
		}else {
			Integer id = Integer.parseInt(idparametro);
			validator.seleccionarUsuario(id);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("dist/mantenimiento/usuarioRegistro.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensaje;
		UsuarioValidator validator = new UsuarioValidator(request);
		Integer id = (request.getParameter("txtId") == ""
				) ? null : Integer.valueOf(request.getParameter("txtId"));
		
		if(id == null) {
			mensaje = validator.usuarioInsUpd(false);

		}else {
			mensaje = validator.usuarioInsUpd(true);
		}
		
		request.setAttribute("mensaje", mensaje);
		
		if(mensaje == null) {
			response.sendRedirect("/softech_web/usuario");
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("dist/mantenimiento/usuarioRegistro.jsp");
			dispatcher.forward(request, response);
		}
		

	}

}
