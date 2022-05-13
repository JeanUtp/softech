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
            Usuario u = usuarioDao.UsuarioLogin("admin", "123456");
            System.out.println("Usuario: " + u.getNombre_usuario());
            System.out.println("Clave: " + u.getContrasena());
            System.out.println("ID: " + u.getId_usuario());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("**FIN**\n\n");
        
    }
}
