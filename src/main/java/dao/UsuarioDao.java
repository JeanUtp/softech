package dao;
import dto.Usuario;

public interface UsuarioDao {
	Usuario UsuarioLogin(String correo, String clave);
}
