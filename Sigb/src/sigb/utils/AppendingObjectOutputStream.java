/**
 * 
 */
package sigb.utils;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * 
 * Clase para A�ADIR una linea a un Fichero sin que te vuelva a a�adir un
 * encabezado y quede corrupto al tener varios.
 * 
 * FUENTE:
 * http://stackoverflow.com/questions/1194656/appending-to-an-objectoutputstream
 * 
 * @author Alexis
 *
 */
public class AppendingObjectOutputStream extends ObjectOutputStream {

	public AppendingObjectOutputStream(OutputStream out) throws IOException {
		super(out);
	}

	@Override
	protected void writeStreamHeader() throws IOException {
		// do not write a header, but reset:
		// this line added after another question
		// showed a problem with the original
		reset();
	}

}
