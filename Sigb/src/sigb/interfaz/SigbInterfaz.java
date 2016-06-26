/**
 * 
 */
package sigb.interfaz;

import sigb.servicios.SIGB;

/**
 * @author Alexis
 *
 */
public abstract class SigbInterfaz {

	// Inicializamos nuestra librería para poder utilizarla
	protected SIGB sigb = new SIGB();

	/**
	 * Método que inicia la aplicación
	 */
	public abstract void inicioAplicacion() throws Exception;

}
