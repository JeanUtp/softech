package dao;
import java.util.List;

import dto.Usuario;

public interface UsuarioDao {
	Usuario UsuarioLogin(String usuario, String clave);
	
	Usuario seleccionarUsuario (Integer id_usuario);

	String insertarUsuario (Usuario user);
	
	String actualizarUsuario (Usuario user);
	
	String deshabilitarUsuario (Integer id_usuario);
	
	List<Usuario> listarUsuarios ();
	
}
