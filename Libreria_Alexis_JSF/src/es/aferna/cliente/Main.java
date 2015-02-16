package es.aferna.cliente;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.aferna.modelo.Autor;
import es.aferna.modelo.Direccion;
import es.aferna.modelo.Editorial;
import es.aferna.modelo.Libro;
import es.aferna.modelo.LibroNoEncontradoException;
import es.aferna.negocio.GestionLibreria;
import es.aferna.negocio.ItfzGestionLibreria;

/**
 * 
 * @author Alexis
 *
 */
public class Main {

	private static final String TITULO = "Vinci";
	private static final String ISBN = "84-9968-20-1";
	private static final String ISBN_BORRAR = "978-84-415-3178-9";
	private static final Double NUEVO_PRECIO = 45.95;

	@SuppressWarnings("resource")
	public static void main(String[] args) throws LibroNoEncontradoException {
		ApplicationContext contenedor = new ClassPathXmlApplicationContext(
				"spring.xml");

		ItfzGestionLibreria gestionLibreria = contenedor
				.getBean(GestionLibreria.class);

		List<Libro> listaLibros = new ArrayList<Libro>(0);
		Libro libroConsultado;

		// Creamos las Editoriales
		Editorial editSantillana = new Editorial("Santillana", new Direccion(
				"C/Alcalá", 463, "Madrid", 28017, "Madrid"), "48536591Y");

		Editorial editPlaneta = new Editorial("Planeta", new Direccion(
				"Paseo de la Castellana", 185, "Madrid", 28019, "Madrid"),
				"6523570P");

		Editorial editAnaya = new Editorial("Anaya", new Direccion(
				"Av. Portal de l'Àngel", 6, "Barcelona", 18002, "Barcelona"),
				"8523571D");

		// Creamos los Autores
		Autor autor1 = new Autor("Dan Brown", "EEUU", "");
		Autor autor2 = new Autor("J. K. Rowling", "Reino Unido", "");
		Autor autor3 = new Autor("Miguel de Cervantes", "España", "");
		Autor autor4 = new Autor("Mikkel Birkegaard", "Francia", "");

		// Creamos los Libros
		Libro libro1 = new Libro("84-666-1059-6",
				"Harry Potter y la cámara secreta", editAnaya, 2002, 20.20,
				"El misterio de Harry Potter y la cámara secreta, está en castellano.");

		Libro libro2 = new Libro("84-9968-20-1",
				"Los crímenes de un escritor imperfecto", editSantillana, 2012,
				9.90, "Colección Narrativa");

		Libro libro3 = new Libro("978-84-415-3178-9", "Java 7", editAnaya,
				2012, 56.85, "");

		Libro libro4 = new Libro("84-6952-62-8", "El Quijote", editPlaneta,
				1615, 47.20, "Imprenta de Juan de la Cuesta");

		Libro libro5 = new Libro("84-95618-60-5", "El Codigo Da Vinci",
				editSantillana, 2003, 22.50, "Novela policiaca de ficción");

		// Añadimos los diferentes autores a los libros
		libro1.addAutor(autor1);

		libro2.addAutor(autor4);
		libro2.addAutor(autor2);
		libro2.addAutor(autor1);

		libro3.addAutor(autor4);

		libro4.addAutor(autor3);

		libro5.addAutor(autor1);

		// Alta de los libros
		gestionLibreria.altaLibro(libro1);
		gestionLibreria.altaLibro(libro2);
		gestionLibreria.altaLibro(libro3);
		gestionLibreria.altaLibro(libro4);
		gestionLibreria.altaLibro(libro5);
		// Vuelvo a intentar insertar el libro5 para que salte una excepción
		gestionLibreria.altaLibro(libro5);

		// Consultar Todos
		System.out.println("\n----- Consulta de Todos los Libros ------");
		listaLibros = gestionLibreria.consultarTodos();
		for (Libro libro : listaLibros) {
			System.out.println(libro);
		}

		// Modificar el precio de un libro
		System.out.println("----- Modifica el precio del libro con ISBN: "
				+ ISBN + " ------");
		if (gestionLibreria.modificarPrecio(ISBN, NUEVO_PRECIO)) {
			System.out.println("\tEl precio se ha modificado correctamente\n");
		}

		// Modificar el precio de un libro que no existe
		System.out.println("----- Modifica el precio del libro con ISBN: "
				+ ISBN + 1 + " ------");
		if (gestionLibreria.modificarPrecio(ISBN + 1, NUEVO_PRECIO)) {
			System.out.println("\tEl precio se ha modificado correctamente\n");
		}

		// Consulta por ISBN
		System.out.println("----- Consulta por ISBN: " + ISBN + " ------");
		libroConsultado = gestionLibreria.consultarISBN(ISBN);
		if (libroConsultado != null) {
			System.out.println(libroConsultado);
		}

		// Consulta por Título
		System.out.println("----- Consulta por Título: " + TITULO + " ------");
		listaLibros = gestionLibreria.consultarTitulo(TITULO);
		for (Libro libro : listaLibros) {
			System.out.println(libro);
		}

		// Borrado de un libro
		System.out.println("----- Borra el libro con ISBN: " + ISBN_BORRAR
				+ "------");
		if (gestionLibreria.eliminarLibro(ISBN_BORRAR)) {
			System.out.println("\tEl Libro se ha borrado correctamente\n");
		}
		// Borrado de un libro que no existe
		System.out.println("----- Borra el libro con ISBN: " + ISBN_BORRAR + 1
				+ "------");
		if (gestionLibreria.eliminarLibro(ISBN_BORRAR + 1)) {
			System.out.println("\tEl Libro se ha borrado correctamente\n");
		}

	}
}
