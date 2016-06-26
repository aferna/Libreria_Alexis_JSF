package sigb.modelo;

import java.io.Serializable;

/**
 * 
 * @author Alexis
 *
 */
public final class Revista extends MaterialSuscribible implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3259064001769943545L;
	private String imprentaEditora;

	public Revista() {
		super();
	}

	public String getImprentaEditora() {
		return imprentaEditora;
	}

	public void setImprentaEditora(String imprentaEditora) {
		this.imprentaEditora = imprentaEditora;
	}

	@Override
	public String toString() {
		return super.toString() + ", Imprenta editora= " + imprentaEditora;
	}

}
