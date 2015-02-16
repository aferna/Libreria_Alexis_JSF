package es.aferna.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Alexis
 *
 */
@Entity
@Table(name = "LIBROS")
public class Libro implements Serializable {

	private String isbn;
	private String titulo;
	private Editorial editorial;
	private Integer publicacion;
	private Double precio;
	private String descripcion;
	private Set<Autor> autores = new HashSet<>();

	public Libro() {
	}

	public Libro(String isbn, String titulo, Editorial editorial,
			Integer publicacion, Double precio, String descripcion) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.editorial = editorial;
		this.publicacion = publicacion;
		this.precio = precio;
		this.descripcion = descripcion;
	}

	@Id
	@Column(name = "ISBN", unique = true, nullable = false, length = 20)
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Column(name = "TITULO", length = 150, nullable = false)
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@ManyToOne
	// @Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "ID_EDITORIAL", referencedColumnName = "ID_EDITORIAL", nullable = false)
	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	@Column(name = "PUBLICACION", length = 4, nullable = false)
	public Integer getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(Integer publicacion) {
		this.publicacion = publicacion;
	}

	@Column(name = "PRECIO", precision = 2, nullable = false)
	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Column(name = "DESCRIPCION", length = 200)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	// @Cascade(CascadeType.SAVE_UPDATE)
	@JoinTable(name = "LIBRO_AUTOR", joinColumns = { @JoinColumn(name = "ISBN", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "ID_AUTOR", nullable = false, updatable = false) })
	public Set<Autor> getAutores() {
		return autores;
	}

	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}

	public void addAutor(Autor autor) {
		autores.add(autor);
		autor.getLibros().add(this);
	}

	@Override
	public String toString() {
		return "Libro: " + titulo + "\n\t ISBN: " + isbn + "\n\t Editorial: "
				+ editorial.getNombre() + "\n\t Año publicación: "
				+ publicacion + "\n\t Precio: " + precio
				+ "€ \n\t Descripción: " + descripcion + "\n";
	}

}
