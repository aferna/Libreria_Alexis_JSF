package sigb.modelo;

import java.io.Serializable;

/**
 * 
 * @author Alexis
 *
 */
public final class Revista extends MaterialSuscribible implements Serializable {

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

}
