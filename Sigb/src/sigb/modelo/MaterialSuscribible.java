package sigb.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Alexis
 *
 */
public abstract class MaterialSuscribible extends Material implements Serializable {

	private Long idMaterialSuscr;

	private Date fechaIniSuscr;
	private Date fechaFinSuscr;
	private Integer numeroEjemplares;
	// Tipo: semanal, diaria, quincenal...
	private String tipoSuscr;
	private Integer paginas;
	// Encuadernación: dura o blanda
	private String encuadernacion;

	public MaterialSuscribible() {
	}

}
