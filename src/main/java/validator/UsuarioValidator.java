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
}
