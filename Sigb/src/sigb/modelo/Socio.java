/**
 * 
 */
package sigb.modelo;

import java.util.Date;

/**
 * @author Alexis
 *
 */
public final class Socio extends Usuario {

	public Integer numeroSocio;
	public Date fechaBloqueo;
	public Date fechaBajaBloqueo;

	public Integer getNumeroSocio() {
		return numeroSocio;
	}

	public void setNumeroSocio(Integer numeroSocio) {
		this.numeroSocio = numeroSocio;
	}

	public Date getFechaBloqueo() {
		return fechaBloqueo;
	}

	public void setFechaBloqueo(Date fechaBloqueo) {
		this.fechaBloqueo = fechaBloqueo;
	}

	public Date getFechaBajaBloqueo() {
		return fechaBajaBloqueo;
	}

	public void setFechaBajaBloqueo(Date fechaBajaBloqueo) {
		this.fechaBajaBloqueo = fechaBajaBloqueo;
	}

}
