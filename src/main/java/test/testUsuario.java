package test;

import dao.UsuarioDao;
import dao.impl.UsuarioDaoImpl;
import dto.Usuario;

public class testUsuario {
    public static void main(String[] args) {
        /*
         *Probar Logueo de Usuario
         */
        System.out.println("**LOGIN DE USUARIO**");
        UsuarioDao usuarioDao = new UsuarioDaoImpl();
        try {
            Usuario u = usuarioDao.UsuarioLogin("admin@gmail.com", "123456");
            System.out.println("Correo: " + u.getUsua_correo());
            System.out.println("Clave: " + u.getUsua_clave());
            System.out.println("ID: " + u.getUsua_id());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("**FIN**\n\n");
        
    }
}
