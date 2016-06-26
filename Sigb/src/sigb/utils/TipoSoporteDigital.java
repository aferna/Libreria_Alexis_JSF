/**
 * 
 */
package sigb.utils;

/**
 * 
 * Tipo enumerado para definir los tipos de soportes digitales
 * 
 * @author Alexis
 *
 */
public enum TipoSoporteDigital {

	AUDIO("Formato de audio", "AUDIO"), VIDEO("Formato de vídeo", "VIDEO");

	private String acronimo;
	private String nombre;

	private TipoSoporteDigital(String acronimo, String nombre) {
		this.acronimo = acronimo;
		this.nombre = nombre;
	}

	public String getAcronimo() {
		return acronimo;
	}

	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
