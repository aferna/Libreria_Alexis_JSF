package sigb;

import sigb.interfaz.SigbInterfaz;
import sigb.interfaz.SigbInterfazConsola;

/**
 * 
 */

/**
 * @author Alexis
 *
 */
public class sigb {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// Instancias Gestores
		// GestionMateriales gMateriales = new GestionMateriales();
		//
		// Material mat = new Libro();
		// mat.setAcabado("color");
		// mat.setEncuadernacion("blanda");
		// mat.setFechaRegistro(new Date());
		// mat.setIdMaterial(001l);
		// mat.setPaginas(30);
		// mat.setTitulo("EL Mundo");
		// mat.setUserRegistro("bibliotecario00214");
		//
		// gMateriales.nuevoMaterial(mat);
		//
		// gMateriales.dameMateriales();

		SigbInterfaz interfaz = new SigbInterfazConsola();
		interfaz.inicioAplicacion();
	}

}
