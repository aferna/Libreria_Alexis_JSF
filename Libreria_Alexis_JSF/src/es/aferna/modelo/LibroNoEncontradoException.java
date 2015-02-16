package es.aferna.modelo;

/**
 * 
 * Excepción personalizada que muestra un mensaje al no encontrar un libro.
 * 
 * @author Alexis
 *
 */
public class LibroNoEncontradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3572726760326588039L;
	private static String MENSAJE = "\tNo se ha encontrado ningún libro.\n";

	public LibroNoEncontradoException() {
	}

	public String mostrarMensaje() {
		return MENSAJE;
	}

}
