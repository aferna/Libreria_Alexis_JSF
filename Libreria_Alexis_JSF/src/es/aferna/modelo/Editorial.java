/**
 * 
 */
package es.aferna.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * @author Alexis
 *
 */
@Entity
@Table(name = "EDITORIALES")
public class Editorial implements Serializable {

	private Integer idEditorial;
	private String nombre;
	private Direccion direccion;
	private String nif;
	private Set<Libro> libros = new HashSet<>();

	public Editorial() {
	}

	public Editorial(String nombre, Direccion direccion, String nif) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.nif = nif;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_EDITORIAL", nullable = false, unique = true)
	public Integer getIdEditorial() {
		return idEditorial;
	}

	public void setIdEditorial(Integer idEditorial) {
		this.idEditorial = idEditorial;
	}

	@Column(name = "NOMBRE", length = 60, nullable = false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Embedded
	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Column(name = "NIF", length = 9, nullable = false)
	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	@OneToMany(mappedBy = "editorial", fetch = FetchType.LAZY)
	@Cascade(CascadeType.SAVE_UPDATE)
	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}

	public void addLibro(Libro libro) {
		libros.add(libro);
		libro.setEditorial(this);

	}

}
