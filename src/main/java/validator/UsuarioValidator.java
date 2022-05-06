package validator;

import dao.UsuarioDao;
import dao.impl.UsuarioDaoImpl;
import dto.Usuario;
import javax.servlet.http.HttpServletRequest;

public class UsuarioValidator {
    private final HttpServletRequest request;
	UsuarioDao usuarioDao;
	
	public UsuarioValidator(HttpServletRequest request) {
        this.request = request;
        this.usuarioDao = new UsuarioDaoImpl();
    }
    
	public String usuarioLogin(String correo, String clave) {
		StringBuilder result = new StringBuilder("<ol>");
		 
		if(correo == null || correo.trim().length() == 0) {
			result.append("<li>Correo requerido</li>");
		}
		
		if(clave== null || clave.trim().length() == 0) {
			result.append("<li>Clave requerida</li>");
		}
		
		Usuario usuario = new Usuario();
		
		if(result.length() == 4) {
			usuario = usuarioDao.UsuarioLogin(correo,clave);
			
			if(usuario.getUsua_correo() == null || usuario.getUsua_clave() == null) {
				result.append("<li>Correo o clave incorrecta</li>");
			}
		}
		if(result.length()>4) {
			
		}
	 	return result.length() == 4 ? null : result.append("</ol>").toString();
	}
}
