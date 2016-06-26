package sigb.modelo;

import java.io.Serializable;

/**
 * 
 * @author Alexis
 *
 */
public final class Periodico extends MaterialSuscribible implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6015474980924869518L;
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
	
	@Override
	public String toString() {
		return super.toString() + ", Empresa= " + empresa;
	}

}
