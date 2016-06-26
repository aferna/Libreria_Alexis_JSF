/**
 * 
 */
package sigb.modelo;

import java.io.Serializable;

/**
 * @author Alexis
 *
 */
public final class Libro extends Material implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5780747827726914082L;
	private String autor;
	private String editorial;

	public Libro() {
		super();
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	@Override
	public String toString() {
		return super.toString() + ", Autor=" + autor + ", Editorial=" + editorial;
	}

}
