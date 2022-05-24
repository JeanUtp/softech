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

//VISTA DE REGISTRO
@WebServlet(name = "UsuarioRegistroController", urlPatterns = { "/usuarioRegistro" })
public class UsuarioRegistroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UsuarioRegistroController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idparametro = request.getParameter("id");
		
		UsuarioValidator validator = new UsuarioValidator(request);
		
		if(idparametro == null) { //idparametro vacio
			Usuario usuario = new Usuario();
			request.setAttribute("usuario", usuario);
		}else {
			Integer id = Integer.parseInt(idparametro);
			validator.seleccionarUsuario(id);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("dist/mantenimiento/usuarioRegistro.jsp");
		dispatcher.forward(request, response);
	}


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
