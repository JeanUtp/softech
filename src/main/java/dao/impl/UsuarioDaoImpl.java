package dao.impl;

import dao.UsuarioDao;
import dto.Usuario;
import util.ConectaBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDaoImpl implements UsuarioDao{
    
    private ConectaBD conectaBD;
 
    public UsuarioDaoImpl() {
        this.conectaBD = new ConectaBD();
    }
    
	@Override
	public Usuario UsuarioLogin(String usuario, String clave) {
		  Usuario user = new Usuario();

	       StringBuilder sql = new StringBuilder();
	       sql.append("SELECT")
	               .append(" * FROM usuario ")
	               .append("WHERE nombre_usuario = ? AND contrasena = ? ");
	        
	       try (Connection cn = conectaBD.Conectar()) {
                              
               try {
    	           PreparedStatement ps = cn.prepareStatement(sql.toString());
    	           ps.setString(1, usuario);
    	           ps.setString(2, clave);
    	           ResultSet rs = ps.executeQuery();
    	           while (rs.next()) {
    	        	   user.setId_usuario(rs.getInt(1));
    	        	   user.setNombre_usuario(rs.getString(2));
    	        	   user.setContrasena(rs.getString(7));
    	           }
               }catch(Exception e) {
               }
            
	
	       } catch (Exception e) {
	       }

	       return user;
	}

}
