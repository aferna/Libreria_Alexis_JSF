/**
 * 
 */
package sigb.interfaz;

import java.util.Date;
import java.util.Scanner;

import sigb.modelo.Libro;
import sigb.modelo.Material;
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
	public void inicioAplicacion() {

		this.dameMenuPrincipal();

	}

	/**
	 * Muestra el menú principal por consola
	 */
	private void dameMenuPrincipal() {
		System.out.println("Bienvenido a la Biblioteca");

		System.out.println("¿Que desea hacer?");

		System.out.println("1.- Gestión Materiales");
		System.out.println("2.- Gestión Suscripciones");
		System.out.println("0.- Salir");

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
	private void dameMenuGestionMateriales() {
		System.out.println("1. Nuevo Material");
		System.out.println("0.- Atrás");

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
			System.out.println("0.- Atrás");

			// Según el tipo de Material seleccionado instaciamos un tipo u otro
			switch (entradaTeclado.nextLine()) {
			case "1":

				material = new Libro();

				rellenaCamposGenericosMaterial(material, entradaTeclado);

				System.out.println("Autor:");
				((Libro) material).setAutor(entradaTeclado.nextLine());

				break;
			case "2":
				material = new Periodico();

				rellenaCamposGenericosMaterial(material, entradaTeclado);

				System.out.println("Empresa:");
				((Periodico) material).setEmpresa(entradaTeclado.nextLine());

				break;
			case "3":
				material = new Revista();

				rellenaCamposGenericosMaterial(material, entradaTeclado);

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

			material.setIdMaterial(new Date().getTime());

			sigb.nuevoMaterial(material);

			System.out.println("***** Libro dado de alta correctamente *****");
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
	private void rellenaCamposGenericosMaterial(Material material, Scanner entradaTeclado) {

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

}
