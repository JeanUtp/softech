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
	public Usuario UsuarioLogin(String correo, String clave) {
		  Usuario usuario = new Usuario();

	       StringBuilder sql = new StringBuilder();
	       sql.append("SELECT")
	               .append(" * FROM usuarios ")
	               .append("WHERE user_correo = ? AND user_password = ? ");
	        
	       try (Connection cn = conectaBD.Conectar()) {
                              
               try {
    	           PreparedStatement ps = cn.prepareStatement(sql.toString());
    	           ps.setString(1, correo);
    	           ps.setString(2, clave);
    	           ResultSet rs = ps.executeQuery();
    	           while (rs.next()) {
    	               usuario.setUsua_id(rs.getInt(1));
    	               usuario.setUsua_correo(rs.getString(2));
    	               usuario.setUsua_clave(rs.getString(3));
    	           }
               }catch(Exception e) {
               }
            
	
	       } catch (Exception e) {
	       }

	       return usuario;
	}

}
