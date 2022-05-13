package dao;
import dto.Usuario;

public interface UsuarioDao {
	Usuario UsuarioLogin(String usuario, String clave);
}
