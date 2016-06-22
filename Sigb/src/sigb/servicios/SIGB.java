/**
 * 
 */
package sigb.servicios;

import sigb.modelo.Material;

/**
 * @author Alexis
 *
 */
public class SIGB {

	private GestionMateriales gestionMateriales;

	// Gestion de Materiales
	public void nuevoMaterial(Material mat) {
		gestionMateriales = new GestionMateriales();
		gestionMateriales.nuevoMaterial(mat);
	}
}
