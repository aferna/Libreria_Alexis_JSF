package es.aferna.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.aferna.modelo.Autor;
import es.aferna.modelo.Editorial;
import es.aferna.modelo.Libro;
import es.aferna.modelo.LibroNoEncontradoException;
import es.aferna.persistencia.ItfzLibrosDao;

/**
 * 
 * @author Alexis
 *
 */
@Service("gestionLibreria")
public class GestionLibreria implements ItfzGestionLibreria {

	@Autowired
	private ItfzLibrosDao librosDao;

	/**
	 * Constructor
	 */
	public GestionLibreria() {
	}

	@Override
	public Boolean altaLibro(Libro libro) throws LibroNoEncontradoException {
		return librosDao.altaLibro(libro);
	}

	@Override
	public Boolean eliminarLibro(String isbn) throws LibroNoEncontradoException {
		return librosDao.eliminarLibro(isbn);
	}

	@Override
	public List<Libro> consultarTodos() {
		return librosDao.consultarTodos();
	}

	@Override
	public List<Editorial> consultarEditoriales() {
		return librosDao.consultarEditoriales();
	}

	@Override
	public List<Autor> consultarAutores() {
		return librosDao.consultarAutores();
	}

	@Override
	public Libro consultarISBN(String isbn) throws LibroNoEncontradoException {
		return librosDao.consultarISBN(isbn);
	}

	@Override
	public List<Libro> consultarTitulo(String titulo)
			throws LibroNoEncontradoException {
		return librosDao.consultarTitulo(titulo);
	}

	@Override
	public Boolean modificarPrecio(String isbn, double precio)
			throws LibroNoEncontradoException {
		return librosDao.modificarPrecio(isbn, precio);
	}

	public ItfzLibrosDao getLibrosDao() {
		return librosDao;
	}

	public void setLibrosDao(ItfzLibrosDao librosDao) {
		this.librosDao = librosDao;
	}

}
