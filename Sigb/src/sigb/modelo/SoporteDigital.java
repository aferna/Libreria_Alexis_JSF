package sigb.modelo;

import java.io.Serializable;

import sigb.utils.TipoSoporteDigital;

/**
 * 
 * @author Alexis
 *
 */
public final class SoporteDigital extends Material implements Serializable {

	TipoSoporteDigital tipo;

	public SoporteDigital(TipoSoporteDigital tipo) {
		this.tipo = tipo;
	}

}
