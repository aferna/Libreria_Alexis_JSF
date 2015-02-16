package es.aferna.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.aferna.modelo.Autor;
import es.aferna.modelo.Editorial;
import es.aferna.modelo.Libro;
import es.aferna.modelo.LibroNoEncontradoException;

/**
 * 
 * @author Alexis
 *
 */
@Repository("librosDao")
@Transactional
public class LibrosDaoImpl implements ItfzLibrosDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	/**
	 * Método altaLibro: guarda un objeto Libro en la base de datos
	 * 
	 * @param libro
	 * @return boolean
	 */
	@Override
	// Se desabilita el modo sólo lectura de la Transacción
	@Transactional(readOnly = false)
	public Boolean altaLibro(Libro libro) throws LibroNoEncontradoException {

		// Comprobamos si el isbn ya existe en la BBDD
		List<Libro> listaLibros = (List<Libro>) getHibernateTemplate().find(
				"from Libro lib where lib.isbn='" + libro.getIsbn() + "'");

		if (listaLibros.isEmpty()) {
			getHibernateTemplate().save(libro);
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Método eliminarLibro: elimina un objeto Libro de la base de datos por su
	 * isbn
	 * 
	 * @param isbn
	 * @return boolean
	 */
	@Override
	@Transactional(readOnly = false)
	public Boolean eliminarLibro(String isbn) throws LibroNoEncontradoException {

		// Buscamos el libro a borrar por el isbn
		Libro libroBorrar = this.consultarISBN(isbn);

		if (libroBorrar != null) {
			getHibernateTemplate().delete(libroBorrar);
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Método consultarTodos: consulta todos los Libros
	 * 
	 * @return List<Libro>
	 */
	@Override
	public List<Libro> consultarTodos() {

		List<Libro> listaLibros = new ArrayList<>();
		try {

			listaLibros = (List<Libro>) getHibernateTemplate().find(
					"from Libro lib order by lib.publicacion");

			if (listaLibros.size() == 0) {
				throw new LibroNoEncontradoException();
			}
		} catch (LibroNoEncontradoException ex) {
			System.out.println(ex.mostrarMensaje());
		}
		return listaLibros;
	}

	/**
	 * Método consultarTodos: consulta todos los Libros
	 * 
	 * @return List<Libro>
	 */
	@Override
	public List<Editorial> consultarEditoriales() {

		List<Editorial> listaLibros = new ArrayList<>();
		try {

			listaLibros = (List<Editorial>) getHibernateTemplate().find(
					"from Editorial edit order by edit.nombre");

			if (listaLibros.size() == 0) {
				throw new LibroNoEncontradoException();
			}
		} catch (LibroNoEncontradoException ex) {
			System.out.println(ex.mostrarMensaje());
		}
		return listaLibros;
	}

	/**
	 * Método consultarTodos: consulta todos los Libros
	 * 
	 * @return List<Libro>
	 */
	@Override
	public List<Autor> consultarAutores() {

		List<Autor> listaLibros = new ArrayList<>();
		try {

			listaLibros = (List<Autor>) getHibernateTemplate().find(
					"from Autor autor order by autor.nombre");

			if (listaLibros.size() == 0) {
				throw new LibroNoEncontradoException();
			}
		} catch (LibroNoEncontradoException ex) {
			System.out.println(ex.mostrarMensaje());
		}
		return listaLibros;
	}

	/**
	 * Método consultarISBN: consulta un Libro por su ISBN
	 * 
	 * @param isbn
	 * @return Libro
	 */
	@Override
	public Libro consultarISBN(String isbn) throws LibroNoEncontradoException {
		List<Libro> listaLibros = new ArrayList<Libro>(0);
		try {

			listaLibros = (List<Libro>) getHibernateTemplate().find(
					"from Libro lib where lib.isbn='" + isbn + "'");

			if (listaLibros.isEmpty()) {
				throw new LibroNoEncontradoException();
			}

		} catch (LibroNoEncontradoException ex) {
			System.out.println(ex.mostrarMensaje());
			return null;
		}
		return listaLibros.get(0);
	}

	/**
	 * Método consultarTitulo: consulta de Libros por su título
	 * 
	 * @param titulo
	 * @return List<Libro>
	 */
	@Override
	public List<Libro> consultarTitulo(String titulo)
			throws LibroNoEncontradoException {
		List<Libro> listaLibros = new ArrayList<Libro>(0);
		try {

			listaLibros = (List<Libro>) getHibernateTemplate().find(
					"from Libro lib where lib.titulo like '%" + titulo + "%'");

			if (listaLibros.isEmpty()) {
				throw new LibroNoEncontradoException();
			}

		} catch (LibroNoEncontradoException ex) {
			System.out.println(ex.mostrarMensaje());
		}
		return listaLibros;
	}

	/**
	 * Método modificarPrecio: modifica el precio de un Libro
	 * 
	 * @param isbn
	 *            , precio
	 * @return boolean
	 */
	@Override
	@Transactional(readOnly = false)
	public Boolean modificarPrecio(String isbn, double precio)
			throws LibroNoEncontradoException {

		// Buscamos el libro a modificar por el isbn
		Libro libroUpdate = this.consultarISBN(isbn);

		if (libroUpdate != null) {
			libroUpdate.setPrecio(precio);
			getHibernateTemplate().merge(libroUpdate);
			return true;
		} else {
			return false;
		}

	}

	// Getters y Setters
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
