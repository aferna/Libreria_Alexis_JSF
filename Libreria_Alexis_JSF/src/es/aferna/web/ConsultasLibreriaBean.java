package es.aferna.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.aferna.modelo.Autor;
import es.aferna.modelo.Editorial;
import es.aferna.modelo.Libro;
import es.aferna.negocio.GestionLibreria;

/**
 * ConsultasLibreriaBean: Clase para hacer consultas a la libreria
 * 
 * @author Alexis
 *
 */
@Component("consultasLibreriaBean")
@ManagedBean
@RequestScoped
public class ConsultasLibreriaBean {

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
	public ConsultasLibreriaBean() {

	}

	/**
	 * Consulta todos los Libros desde la BD
	 * 
	 * @return
	 *
	 */
	public List<Libro> consultarLibros() {
		return gestionLibreria.consultarTodos();
	}

	public List<Editorial> dameEditoriales() {
		return gestionLibreria.consultarEditoriales();
	}

	public List<Autor> dameAutores() {
		return gestionLibreria.consultarAutores();
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
