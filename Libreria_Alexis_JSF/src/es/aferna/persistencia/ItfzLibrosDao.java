package es.aferna.persistencia;

import java.util.List;

import es.aferna.modelo.Autor;
import es.aferna.modelo.Editorial;
import es.aferna.modelo.Libro;
import es.aferna.modelo.LibroNoEncontradoException;

/**
 * 
 * @author Alexis
 *
 */
public interface ItfzLibrosDao {

	// Se declaran los métodos
	public Boolean altaLibro(Libro libro) throws LibroNoEncontradoException;

	public Boolean eliminarLibro(String isbn) throws LibroNoEncontradoException;

	public List<Libro> consultarTodos();

	public List<Editorial> consultarEditoriales();

	public List<Autor> consultarAutores();

	public Libro consultarISBN(String isbn) throws LibroNoEncontradoException;

	public List<Libro> consultarTitulo(String titulo)
			throws LibroNoEncontradoException;

	public Boolean modificarPrecio(String isbn, double precio)
			throws LibroNoEncontradoException;
}
