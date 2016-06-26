package sigb.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Alexis
 *
 */
public abstract class Material implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3097693469894771140L;
	private Long idMaterial;
	private String titulo;
	private Integer paginas;
	// Acabado: color o B/N
	private String acabado;
	// Encuadernación: dura o blanda
	private String encuadernacion;

	// Campos auditoria
	private Date fechaRegistro;
	private String userRegistro;

	public Material() {
	}

	public Long getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(Long idMaterial) {
		this.idMaterial = idMaterial;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	public String getAcabado() {
		return acabado;
	}

	public void setAcabado(String acabado) {
		this.acabado = acabado;
	}

	public String getEncuadernacion() {
		return encuadernacion;
	}

	public void setEncuadernacion(String encuadernacion) {
		this.encuadernacion = encuadernacion;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getUserRegistro() {
		return userRegistro;
	}

	public void setUserRegistro(String userRegistro) {
		this.userRegistro = userRegistro;
	}

	@Override
	public String toString() {
		return "Título=" + titulo + ", Páginas=" + paginas + ", Acabado=" + acabado + ", Encuadernación=" + encuadernacion + ", Fecha de Registro=" + fechaRegistro;
	}

}
