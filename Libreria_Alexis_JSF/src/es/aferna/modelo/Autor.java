/**
 * 
 */
package es.aferna.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Alexis
 *
 */
@Entity
@Table(name = "AUTORES")
public class Autor implements Serializable {

	private Integer idAutor;
	private String nombre;
	private String nacionalidad;
	private String comentarios;
	private Set<Libro> libros = new HashSet<>();

	public Autor() {
	}

	public Autor(String nombre, String nacionalidad, String comentarios) {
		super();
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.comentarios = comentarios;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_AUTOR", nullable = false, unique = true)
	public Integer getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Integer idAutor) {
		this.idAutor = idAutor;
	}

	@Column(name = "NOMBRE", length = 60, nullable = false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "NACIONALIDAD", length = 80)
	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	@Column(name = "COMENTARIOS", length = 500)
	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "autores")
	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}

	public void addLibro(Libro libro) {
		libros.add(libro);
		libro.getAutores().add(this);
	}

}
