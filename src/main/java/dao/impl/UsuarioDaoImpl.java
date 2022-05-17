package dao.impl;

import dao.UsuarioDao;
import dto.Usuario;
import util.ConectaBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImpl implements UsuarioDao {

	private ConectaBD conectaBD;
	private String mensaje;

	public UsuarioDaoImpl() {
		this.conectaBD = new ConectaBD();
	}

	@Override
	public List<Usuario> listarUsuarios() {
		List<Usuario> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("*")
                .append(" FROM usuario WHERE estado <> 0");
        
        try (Connection cn = conectaBD.Conectar()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            
            while (rs.next()) {
            	Usuario user = new Usuario();
            	user.setId_usuario(rs.getInt(1));
				user.setNombre_usuario(rs.getString(2));
				user.setTipo_usuario(rs.getString(3));
				user.setNombres(rs.getString(4));
				user.setApellidos(rs.getString(5));
				user.setEstado(rs.getInt(6));
				user.setContrasena(rs.getString(7));

                list.add(user);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
	}

	@Override
	public Usuario seleccionarUsuario(Integer id_usuario) {
		Usuario user = new Usuario();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ").append("*").append(" FROM usuario").append(" WHERE id_usuario = ?")
		.append(" AND estado <> 0");

		try (Connection cn = conectaBD.Conectar()) {
			PreparedStatement ps = cn.prepareStatement(sql.toString());
			ps.setInt(1, id_usuario);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user.setId_usuario(rs.getInt(1));
				user.setNombre_usuario(rs.getString(2));
				user.setTipo_usuario(rs.getString(3));
				user.setNombres(rs.getString(4));
				user.setApellidos(rs.getString(5));
				user.setEstado(rs.getInt(6));
				user.setContrasena(rs.getString(7));
			}
		} catch (Exception e) {
			mensaje = e.getMessage();
		}
		return user;
	}

	@Override
	public String insertarUsuario(Usuario user) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO usuario( ").append("nombre_usuario,").append("tipo_usuario,").append("nombres,")
				.append("apellidos,").append("estado,").append("contrasena").append(") VALUES (?,?,?,?,?,?) ");

		try (Connection cn = conectaBD.Conectar()) {
			PreparedStatement ps = cn.prepareStatement(sql.toString());
			ps.setString(1, user.getNombre_usuario());
			ps.setString(2, user.getTipo_usuario());
			ps.setString(3, user.getNombres());
			ps.setString(4, user.getApellidos());
			ps.setInt(5, user.getEstado());
			ps.setString(6, user.getContrasena());

			int ctos = ps.executeUpdate();
			if (ctos == 0) {
				mensaje = "Cero filas insertadas";
			}
		} catch (Exception e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	@Override
	public String actualizarUsuario(Usuario user) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE usuario SET ").append("nombre_usuario = ? ,").append("tipo_usuario = ? ,")
				.append("nombres = ? ,").append("apellidos = ? ,").append("estado = ? ,").append("contrasena = ?")
				.append(" WHERE id_usuario = ?");

		try (Connection cn = conectaBD.Conectar()) {
			PreparedStatement ps = cn.prepareStatement(sql.toString());
			ps.setString(1, user.getNombre_usuario());
			ps.setString(2, user.getTipo_usuario());
			ps.setString(3, user.getNombres());
			ps.setString(4, user.getApellidos());
			ps.setInt(5, user.getEstado());
			ps.setString(6, user.getContrasena());
			ps.setInt(7, user.getId_usuario());

			int ctos = ps.executeUpdate();
			if (ctos == 0) {
				mensaje = "Cero filas actualizadas";
			}
		} catch (Exception e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	@Override
	public String deshabilitarUsuario(Integer id_usuario) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE usuario")
		.append(" SET estado = 0")
		.append(" WHERE id_usuario = ?");

		try (Connection cn = conectaBD.Conectar()) {
			PreparedStatement ps = cn.prepareStatement(sql.toString());
			ps.setInt(1, id_usuario);

			int ctos = ps.executeUpdate();
			if (ctos == 0) {
				mensaje = "Cero filas eliminadas";
			}
		} catch (Exception e) {
			mensaje = e.getMessage();
		}
		return mensaje;
	}

	@Override
	public Usuario UsuarioLogin(String usuario, String clave) {
		Usuario user = new Usuario();

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT").append(" * FROM usuario ")
		.append("WHERE nombre_usuario = ? AND contrasena = ? AND estado <> 0 ");

		try (Connection cn = conectaBD.Conectar()) {
			PreparedStatement ps = cn.prepareStatement(sql.toString());
			ps.setString(1, usuario);
			ps.setString(2, clave);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user.setId_usuario(rs.getInt(1));
				user.setNombre_usuario(rs.getString(2));
				user.setContrasena(rs.getString(7));
			}

		} catch (Exception e) {
			mensaje = e.getMessage();
		}

		return user;
	}

}
