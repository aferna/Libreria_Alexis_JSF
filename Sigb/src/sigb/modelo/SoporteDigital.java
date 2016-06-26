package sigb.modelo;

import java.io.Serializable;

import sigb.utils.TipoSoporteDigital;

/**
 * 
 * @author Alexis
 *
 */
public final class SoporteDigital extends Material implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 889535305288223399L;
	TipoSoporteDigital tipo;

	public SoporteDigital() {
		super();
	}

	public SoporteDigital(TipoSoporteDigital tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return super.toString() + ", Tipo= " + tipo.getNombre();
	}

}
