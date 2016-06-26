/**
 * 
 */
package sigb.interfaz;

import java.util.Date;
import java.util.Scanner;

import sigb.modelo.Libro;
import sigb.modelo.Material;
import sigb.modelo.MaterialSuscribible;
import sigb.modelo.Periodico;
import sigb.modelo.Revista;
import sigb.modelo.SoporteDigital;
import sigb.utils.TipoSoporteDigital;

/**
 * @author Alexis
 *
 */
public class SigbInterfazConsola extends SigbInterfaz {

	@Override
	public void inicioAplicacion() throws Exception {
		try {
			this.dameMenuPrincipal();
		} catch (Exception ex) {
			System.out.println("Ha ocurrido un error inesperado, inténtelo de nuevo");
			this.dameMenuPrincipal();
		}
	}

	/**
	 * Muestra el menú principal por consola
	 */
	private void dameMenuPrincipal() throws Exception {
		System.out.println("\nBienvenido a la Biblioteca");

		System.out.println("\t1. Gestión Materiales");
		System.out.println("\t2. Gestión Suscripciones");
		System.out.println("\t0. Salir");

		// Creación de un objeto Scanner para recoger lo escrito por teclado
		Scanner entradaTeclado = new Scanner(System.in);

		switch (entradaTeclado.nextLine()) {
		case "1": // Gestión Materiales
			dameMenuGestionMateriales();
			break;
		case "2": // Gestión Suscripciones

			break;
		case "0": // Salir
			System.exit(0);
			break;
		default:
			this.inicioAplicacion();
			break;
		}
		entradaTeclado.close(); // Cerramos el Scanner

	}

	/**
	 * Muestra el menú para la gestión de materiales
	 */
	private void dameMenuGestionMateriales() throws Exception {
		System.out.println("\n -- Menú Gestión Materiales -- ");
		System.out.println("\t1. Nuevo Material");
		System.out.println("\t2. Listar todos");
		System.out.println("\t0. Atrás");

		// Creación de un objeto Scanner para recoger lo escrito por teclado
		Scanner entradaTeclado = new Scanner(System.in);

		switch (entradaTeclado.nextLine()) {
		case "1": // Nuevo Material
			Material material = null;
			System.out.println("1. Libro");
			System.out.println("2. Periodico");
			System.out.println("3. Revista");
			System.out.println("4. Audio");
			System.out.println("5. Vídeo");
			System.out.println("0. Atrás");

			// Según el tipo de Material seleccionado instaciamos un tipo u otro
			switch (entradaTeclado.nextLine()) {
			case "1":

				material = new Libro();

				rellenaCamposGenericosMaterial(material, entradaTeclado);

				System.out.println("Autor:");
				((Libro) material).setAutor(entradaTeclado.nextLine());

				System.out.println("Editorial:");
				((Libro) material).setEditorial(entradaTeclado.nextLine());

				break;
			case "2":
				material = new Periodico();

				rellenaCamposGenericosMaterial(material, entradaTeclado);

				((MaterialSuscribible) material).setIdMaterialSuscr(new Date().getTime());

				System.out.println("Empresa:");
				((Periodico) material).setEmpresa(entradaTeclado.nextLine());

				break;
			case "3":
				material = new Revista();

				rellenaCamposGenericosMaterial(material, entradaTeclado);

				((MaterialSuscribible) material).setIdMaterialSuscr(new Date().getTime());

				System.out.println("Imprenta:");
				((Revista) material).setImprentaEditora(entradaTeclado.nextLine());

				break;
			case "4":
				material = new SoporteDigital(TipoSoporteDigital.AUDIO);
				break;
			case "5":
				material = new SoporteDigital(TipoSoporteDigital.VIDEO);
				break;
			case "0":
				dameMenuGestionMateriales();
				break;
			default:
				dameMenuGestionMateriales();

			}

			sigb.nuevoMaterial(material);

			System.out.println("***** Libro dado de alta correctamente *****");
			this.inicioAplicacion();

			break;

		case "2": // Listar materiales
			sigb.dameMateriales();
			this.inicioAplicacion();
			break;

		case "0": // Atras
			dameMenuPrincipal();
			break;
		default:
			this.inicioAplicacion();
			break;
		}
		entradaTeclado.close(); // Cerramos el Scanner
	}

	/**
	 * Genera la parte del menú común a todos los materiales
	 * 
	 * @param material
	 * @param entradaTeclado
	 */
	private void rellenaCamposGenericosMaterial(Material material, Scanner entradaTeclado) throws Exception {

		material.setIdMaterial(new Date().getTime());

		System.out.println("Titulo:");
		material.setTitulo(entradaTeclado.nextLine());

		// Controlamos que sea numérico
		System.out.println("Número de páginas:");
		try {
			material.setPaginas(Integer.parseInt(entradaTeclado.nextLine()));
		} catch (NumberFormatException nfe) {
			System.out.println("Número de páginas debe ser numérico");
			dameMenuGestionMateriales();

		}
		material.setFechaRegistro(new Date());

		System.out.println("Acabado(b/n o color):");
		material.setAcabado(entradaTeclado.nextLine());

		System.out.println("Encuadernación (dura o blanda):");
		material.setEncuadernacion(entradaTeclado.nextLine());

	}

	/**
	 * Genera la parte del menú común a todos los materiales suscribibles
	 * 
	 * @param material
	 * @param entradaTeclado
	 */
	private void rellenaCamposMaterialSuscribible(Material material, Scanner entradaTeclado) throws Exception {

		// SimpleDateFormat parserSDF = new SimpleDateFormat("dd/MM/yyyy");

		rellenaCamposGenericosMaterial(material, entradaTeclado);

		// ((MaterialSuscribible) material).setIdMaterialSuscr(new
		// Date().getTime());
		/*
		 * try { System.out.println("Fecha inicio suscripción (dd/mm/yyyy):");
		 * ((MaterialSuscribible)
		 * material).setFechaIniSuscr(parserSDF.parse(entradaTeclado.nextLine())
		 * );
		 * 
		 * System.out.println("Fecha fin suscripción (dd/mm/yyyy):");
		 * ((MaterialSuscribible)
		 * material).setFechaFinSuscr(parserSDF.parse(entradaTeclado.nextLine())
		 * );
		 * 
		 * } catch (ParseException pe) { System.out.println(
		 * "Formato fecha incorrecto"); dameMenuGestionMateriales(); }
		 */
		System.out.println("Tipo (semanal, diaria, quincenal...):");
		// ((MaterialSuscribible)
		// material).setTipoSuscr(entradaTeclado.nextLine());

	}

}
