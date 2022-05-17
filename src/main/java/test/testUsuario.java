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

			seleccionarUsuario = usuarioDao.seleccionarUsuario(20);
			
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
			nuevoUsuario.setNombre_usuario("alias2");
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
			usuarioExistente.setNombre_usuario("admin");
			usuarioExistente.setNombres("Fernando Paulo");
			usuarioExistente.setApellidos("Perez Palomino");
			usuarioExistente.setTipo_usuario("administrador");
			usuarioExistente.setEstado(1);
			usuarioExistente.setContrasena("123456");
			usuarioExistente.setId_usuario(20);

			String mensajeActualizar = (usuarioDao.actualizarUsuario(usuarioExistente)) == null ?
					"Exito": "No se logro";
			
			System.out.println("Respuesta: " + mensajeActualizar);
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		System.out.println("**FIN**\n\n");
		
		
		/*
		 * Probar Eliminar Usuario
		 */
		System.out.println("**ELIMINAR USUARIO**");
		try {

			String mensajeDeshabilitar = (usuarioDao.deshabilitarUsuario(20)) == null ?
					"Exito": "No se logro";
			
			System.out.println("Respuesta: " + mensajeDeshabilitar);
			
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
