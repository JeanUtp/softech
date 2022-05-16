package test;

import java.util.List;

import dao.UsuarioDao;
import dao.impl.UsuarioDaoImpl;
import dto.Usuario;

public class testUsuario {
	public static void main(String[] args) {
		UsuarioDao usuarioDao = new UsuarioDaoImpl();

		/*
		 * Probar Logueo de Usuario
		 */
		System.out.println("**LOGIN DE USUARIO**");
		try {
			Usuario u = usuarioDao.UsuarioLogin("admin", "123456");
			System.out.println("Usuario: " + u.getNombre_usuario());
			System.out.println("Clave: " + u.getContrasena());
			System.out.println("ID: " + u.getId_usuario());
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		System.out.println("**FIN**\n\n");
		
		/*
		 * Probar Seleccionar Usuario
		 */
		System.out.println("**SELECCIONAR USUARIO**");
		try {
			Usuario seleccionarUsuario = new Usuario();

			seleccionarUsuario = usuarioDao.seleccionarUsuario(1);
			
			System.out.println("ID: " + seleccionarUsuario.getId_usuario());
			System.out.println("User: " + seleccionarUsuario.getNombre_usuario());
			System.out.println("Tipo: " + seleccionarUsuario.getTipo_usuario());
			System.out.println("Nombres: " + seleccionarUsuario.getNombres());
			System.out.println("Apellidos: " + seleccionarUsuario.getApellidos());
			System.out.println("Estado: " + seleccionarUsuario.getEstado());
			System.out.println("Contraseña: " + seleccionarUsuario.getContrasena());
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		System.out.println("**FIN**\n\n");

		/*
		 * Probar Insertar Usuario
		 */
		System.out.println("**INSERTAR USUARIO**");
		try {
			Usuario nuevoUsuario = new Usuario();
			nuevoUsuario.setNombre_usuario("user1");
			nuevoUsuario.setNombres("Fernando Paulo");
			nuevoUsuario.setApellidos("Perez Ramon");
			nuevoUsuario.setTipo_usuario("administrador");
			nuevoUsuario.setEstado(1);
			nuevoUsuario.setContrasena("123456");

			String mensajeInsertar = (usuarioDao.insertarUsuario(nuevoUsuario)) == null ?
					"Exito": "No se logro";
			
			System.out.println("Respuesta: " + mensajeInsertar);
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		System.out.println("**FIN**\n\n");
		
		/*
		 * Probar Actualizar Usuario
		 */
		System.out.println("**ACTUALIZAR USUARIO**");
		try {
			Usuario usuarioExistente = new Usuario();
			usuarioExistente.setNombre_usuario("user2");
			usuarioExistente.setNombres("Fernando Paulo");
			usuarioExistente.setApellidos("Perez Ramon");
			usuarioExistente.setTipo_usuario("administrador");
			usuarioExistente.setEstado(1);
			usuarioExistente.setContrasena("123456");
			usuarioExistente.setId_usuario(3);

			String mensajeInsertar = (usuarioDao.actualizarUsuario(usuarioExistente)) == null ?
					"Exito": "No se logro";
			
			System.out.println("Respuesta: " + mensajeInsertar);
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		System.out.println("**FIN**\n\n");
		
		
		/*
		 * Probar Eliminar Usuario
		 */
		System.out.println("**ELIMINAR USUARIO**");
		try {

			String mensajeInsertar = (usuarioDao.eliminarUsuario(6)) == null ?
					"Exito": "No se logro";
			
			System.out.println("Respuesta: " + mensajeInsertar);
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		System.out.println("**FIN**\n\n");
		
		/*
		 * Probar Listar Usuarios
		 */
		System.out.println("**LISTAR USUARIOS**");

        try {

            List<Usuario> lista = usuarioDao.listarUsuarios();

            lista.forEach((Usuario t) -> {

                System.out.println(
                        "ID: " + t.getId_usuario());
            });
        } catch (Exception e) {
        	System.out.println("Error: " + e.getMessage());
        }
		System.out.println("**FIN**\n\n");
		

	}
}
