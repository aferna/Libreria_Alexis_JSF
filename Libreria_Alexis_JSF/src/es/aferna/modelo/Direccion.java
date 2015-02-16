/**
 * 
 */
package es.aferna.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Alexis
 *
 */
@Embeddable
public class Direccion implements Serializable {

	private String calle;
	private Integer numero;
	private String poblacion;
	private Integer cp;
	private String provincia;

	public Direccion() {
	}

	public Direccion(String calle, Integer numero, String poblacion,
			Integer cp, String provincia) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.poblacion = poblacion;
		this.cp = cp;
		this.provincia = provincia;
	}

	@Column(name = "CALLE", length = 300, nullable = false)
	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	@Column(name = "NUMERO", nullable = false)
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Column(name = "POBLACION", length = 80, nullable = false)
	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	@Column(name = "CODIGO_POSTAL", length = 5, nullable = false)
	public Integer getCp() {
		return cp;
	}

	public void setCp(Integer cp) {
		this.cp = cp;
	}

	@Column(name = "PROVINCIA", length = 150, nullable = false)
	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
}
