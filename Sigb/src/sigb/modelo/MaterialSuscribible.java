package sigb.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Alexis
 *
 */
public abstract class MaterialSuscribible extends Material implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7339132923981577270L;

	private Long idMaterialSuscr;

	private Date fechaIniSuscr;
	private Date fechaFinSuscr;
	private Integer numeroEjemplares;
	// Tipo: semanal, diaria, quincenal...
	private String tipoSuscr;

	public MaterialSuscribible() {
		super();
	}

	public Long getIdMaterialSuscr() {
		return idMaterialSuscr;
	}

	public void setIdMaterialSuscr(Long idMaterialSuscr) {
		this.idMaterialSuscr = idMaterialSuscr;
	}

	public Date getFechaIniSuscr() {
		return fechaIniSuscr;
	}

	public void setFechaIniSuscr(Date fechaIniSuscr) {
		this.fechaIniSuscr = fechaIniSuscr;
	}

	public Date getFechaFinSuscr() {
		return fechaFinSuscr;
	}

	public void setFechaFinSuscr(Date fechaFinSuscr) {
		this.fechaFinSuscr = fechaFinSuscr;
	}

	public Integer getNumeroEjemplares() {
		return numeroEjemplares;
	}

	public void setNumeroEjemplares(Integer numeroEjemplares) {
		this.numeroEjemplares = numeroEjemplares;
	}

	public String getTipoSuscr() {
		return tipoSuscr;
	}

	public void setTipoSuscr(String tipoSuscr) {
		this.tipoSuscr = tipoSuscr;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
