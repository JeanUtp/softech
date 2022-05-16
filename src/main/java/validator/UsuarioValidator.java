package validator;

import dao.UsuarioDao;
import dao.impl.UsuarioDaoImpl;
import dto.Usuario;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class UsuarioValidator {
	private final HttpServletRequest request;
	UsuarioDao usuarioDao;

	public UsuarioValidator(HttpServletRequest request) {
		this.request = request;
		this.usuarioDao = new UsuarioDaoImpl();
	}

	public String listarUsuarios() {
		String result = null;
		List<Usuario> list = usuarioDao.listarUsuarios();
		if (list != null) {
			request.setAttribute("listaUsuarios", list);
		}
		return result;
	}

	public String usuarioLogin(String usuario, String clave) {
		StringBuilder result = new StringBuilder("");

		if (usuario == null || usuario.trim().length() == 0) {
			result.append("Correo requerido");
		}

		if (clave == null || clave.trim().length() == 0) {
			result.append("Clave requerida");
		}

		Usuario user = new Usuario();

		if (result.length() == 0) {
			user = usuarioDao.UsuarioLogin(usuario, clave);

			if (user.getNombre_usuario() == null || user.getContrasena() == null) {
				result.append("Correo o clave incorrecta");
			}
		}
		return result.length() == 0 ? null : result.toString();
	}

	public String seleccionarUsuario(Integer id) {
		String result = null;

		Usuario usuario = usuarioDao.seleccionarUsuario(id);

		if (usuario != null) {
			request.setAttribute("usuario", usuario);
		}
		return result;
	}
	
	public String eliminarUsuario(Integer id) {
		String result = null;
		result = usuarioDao.eliminarUsuario(id);
		return result;
	}


	public String usuarioInsUpd(boolean upd) {

		StringBuilder result = new StringBuilder("");

		Integer id = (request.getParameter("txtId") == ""
				) ? null : Integer.valueOf(request.getParameter("txtId"));
		String nombres = request.getParameter("txtNombres").trim();
		String apellidos = request.getParameter("txtApellidos").trim();
		String rol = request.getParameter("txtRol").trim();
		Integer estado = (request.getParameter("txtEstado") == null) ? 0 : 1;
		String nombre_usuario = request.getParameter("txtUsuario").trim();
		String contrasena = request.getParameter("txtContrasena").trim();

		if (upd == true && id == null) {
			result.append("<br>Id requerido");
		}
	
		if (nombres == null || nombres.trim().length() == 0) {
			result.append("<br>Nombres requerido");
		} else if (nombres.trim().length() < 3 || nombres.trim().length() > 50) {
			result.append("<br>La dimensión del nombre debe estar entre").append(" 3 a 50 caracteres");
		}

		if (apellidos == null || apellidos.trim().length() == 0) {
			result.append("<br>Apellidos requerido");
		} else if (apellidos.trim().length() < 3 || apellidos.trim().length() > 50) {
			result.append("<br>La dimensión del Apellido debe estar entre").append(" 3 a 50 caracteres");
		}
		if (rol == null || rol.trim().length() == 0) {
			result.append("<br>Tipo de usuario requerido");
		} 
		if (nombre_usuario == null || nombre_usuario.trim().length() == 0) {
			result.append("<br>Usuario requerido");
		} else if (nombre_usuario.trim().length() < 3 || nombre_usuario.trim().length() > 50) {
			result.append("<br>La dimensión del usuario debe estar entre").append(" 3 a 50 caracteres");
		}
		if (contrasena == null || contrasena.trim().length() == 0) {
			result.append("<br>Contraseña requerida");
		} else if (contrasena.trim().length() < 6 || contrasena.trim().length() > 50) {
			result.append("<br>La dimensión de la contraseña debe estar entre").append(" 6 a 50 caracteres");
		}
	
		Usuario usuario = new Usuario();
		usuario.setId_usuario(id);
		usuario.setApellidos(apellidos);
		usuario.setNombres(nombres);
		usuario.setNombre_usuario(nombre_usuario);
		usuario.setContrasena(contrasena);
		usuario.setEstado(estado);
		usuario.setTipo_usuario(rol);
	

		if (result.length() == 0) {
			String msg;
			
			if(upd==true) {
				msg = usuarioDao.actualizarUsuario(usuario);
			}else {
				msg = usuarioDao.insertarUsuario(usuario);
			}
			if (msg != null) {
				result.append(msg);
			}
		}
		if (result.length() > 0) {
			request.setAttribute("usuario", usuario);
		}
		return result.length() == 0 ? null : result.toString();
	}

}
