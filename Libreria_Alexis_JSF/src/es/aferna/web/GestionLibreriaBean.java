package es.aferna.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.aferna.modelo.Autor;
import es.aferna.modelo.Direccion;
import es.aferna.modelo.Editorial;
import es.aferna.modelo.Libro;
import es.aferna.modelo.LibroNoEncontradoException;
import es.aferna.negocio.GestionLibreria;

/**
 * GestionLibreriaBean: Clase para gestionar la libreria, altas, modificaciones,
 * bajas...
 * 
 * @author Alexis
 *
 */
@Component("gestionLibreriaBean")
@ManagedBean
@RequestScoped
public class GestionLibreriaBean {

	// Constantes
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";

	// Servicios
	@Autowired
	private GestionLibreria gestionLibreria;

	// Campos formulario
	private Integer idEditorial;
	private Integer[] idAutor;
	private String isbn;
	private String titulo;
	private Integer anio;
	private Double precio;
	private String descripcion;

	// Constructor
	public GestionLibreriaBean() {

	}

	// Métodos
	public void creameLibros() throws LibroNoEncontradoException {
		// Creamos las Editoriales
		Editorial editSantillana = new Editorial("Santillana", new Direccion(
				"C/Alcalá", 463, "Madrid", 28017, "Madrid"), "48536591Y");

		Editorial editPlaneta = new Editorial("Planeta", new Direccion(
				"Paseo de la Castellana", 185, "Madrid", 28019, "Madrid"),
				"6523570P");

		Editorial editAnaya = new Editorial("Anaya", new Direccion(
				"Av. Portal de l'Àngel", 6, "Barcelona", 18002, "Barcelona"),
				"8523571D");

		// Creamos los Autores
		Autor autor1 = new Autor("Dan Brown", "EEUU", "");
		Autor autor2 = new Autor("J. K. Rowling", "Reino Unido", "");
		Autor autor3 = new Autor("Miguel de Cervantes", "España", "");
		Autor autor4 = new Autor("Mikkel Birkegaard", "Francia", "");

		// Creamos los Libros
		Libro libro1 = new Libro("84-666-1059-6",
				"Harry Potter y la cámara secreta", editAnaya, 2002, 20.20,
				"El misterio de Harry Potter y la cámara secreta, está en castellano.");

		Libro libro2 = new Libro("84-9968-20-1",
				"Los crímenes de un escritor imperfecto", editSantillana, 2012,
				9.90, "Colección Narrativa");

		Libro libro3 = new Libro("978-84-415-3178-9", "Java 7", editAnaya,
				2012, 56.85, "");

		Libro libro4 = new Libro("84-6952-62-8", "El Quijote", editPlaneta,
				1615, 47.20, "Imprenta de Juan de la Cuesta");

		Libro libro5 = new Libro("84-95618-60-5", "El Codigo Da Vinci",
				editSantillana, 2003, 22.50, "Novela policiaca de ficción");

		// Añadimos los diferentes autores a los libros
		libro1.addAutor(autor1);

		libro2.addAutor(autor4);
		libro2.addAutor(autor2);
		libro2.addAutor(autor1);

		libro3.addAutor(autor4);

		libro4.addAutor(autor3);

		libro5.addAutor(autor1);

		// Alta de los libros
		gestionLibreria.altaLibro(libro1);
		gestionLibreria.altaLibro(libro2);
		gestionLibreria.altaLibro(libro3);
		gestionLibreria.altaLibro(libro4);
		gestionLibreria.altaLibro(libro5);
	}

	/**
	 * Da de alta un libro desde el formulario web
	 * 
	 * @return
	 * @throws LibroNoEncontradoException
	 *
	 */
	public String altaLibro() throws LibroNoEncontradoException {

		// Creamos la editorial seleccionada
		Editorial edit = new Editorial();
		edit.setIdEditorial(idEditorial);

		// Creamos el libro con los datos del form
		Libro libro = new Libro(isbn, titulo, edit, anio, precio, descripcion);

		// Añade los autores seleccionados
		Autor autor;
		for (int i = 0; i < idAutor.length; i++) {
			autor = new Autor();
			autor.setIdAutor(idAutor[i]);
			libro.addAutor(autor);
		}

		boolean result = gestionLibreria.altaLibro(libro);

		return result ? SUCCESS : ERROR;
	}

	// Getters y Setters
	public GestionLibreria getGestionLibreria() {
		return gestionLibreria;
	}

	public void setGestionLibreria(GestionLibreria gestionLibreria) {
		this.gestionLibreria = gestionLibreria;
	}

	public Integer getIdEditorial() {
		return idEditorial;
	}

	public void setIdEditorial(Integer idEditorial) {
		this.idEditorial = idEditorial;
	}

	public Integer[] getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Integer[] idAutor) {
		this.idAutor = idAutor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
