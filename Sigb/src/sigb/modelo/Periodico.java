package sigb.modelo;

import java.io.Serializable;

/**
 * 
 * @author Alexis
 *
 */
public final class Periodico extends MaterialSuscribible implements Serializable {

	private String empresa;

	public Periodico() {
		super();
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

}
