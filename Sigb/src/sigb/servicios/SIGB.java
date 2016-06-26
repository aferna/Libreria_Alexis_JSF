/**
 * 
 */
package sigb.servicios;

import java.util.List;

import sigb.modelo.Libro;
import sigb.modelo.Material;
import sigb.modelo.Periodico;
import sigb.modelo.Revista;
import sigb.modelo.SoporteDigital;

/**
 * 
 * Servicio que encapsula toda la gestión de la Biblioteca (Materiales,
 * usuarios...)
 * 
 * @author Alexis
 *
 */
public class SIGB {

	private GestionMateriales gestionMateriales;

	/**
	 * Da de alta un nuevo material
	 * 
	 * @param mat
	 */
	public void nuevoMaterial(Material mat) {
		gestionMateriales = new GestionMateriales();
		gestionMateriales.nuevoMaterial(mat);
	}

	/**
	 * Lista todos los materiales
	 * 
	 * @throws Exception
	 */
	public void dameMateriales() throws Exception {
		gestionMateriales = new GestionMateriales();
		imprimemePorConsola(gestionMateriales.dameMateriales());
	}

	/**
	 * Método privado para imprimir por consola la lista de Materiales que
	 * recibe
	 * 
	 * @param materiales
	 * @throws Exception
	 */
	private void imprimemePorConsola(List<Material> materiales) throws Exception {
		// Recorremos los libros
		for (Material mat : materiales) {

			if (mat instanceof Libro) {
				System.out.println(((Libro) mat).toString());
			} else if (mat instanceof Revista) {
				System.out.println(((Revista) mat).toString());
			} else if (mat instanceof Periodico) {
				System.out.println(((Periodico) mat).toString());
			} else if (mat instanceof SoporteDigital) {
				System.out.println(((SoporteDigital) mat).toString());
			} else {
				throw new Exception("Tipo de material no válido");
			}
		}
	}
}
