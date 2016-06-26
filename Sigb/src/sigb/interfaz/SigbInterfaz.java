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

	// Inicializamos nuestra librer�a para poder utilizarla
	protected SIGB sigb = new SIGB();

	/**
	 * M�todo que inicia la aplicaci�n
	 */
	public abstract void inicioAplicacion() throws Exception;

}
