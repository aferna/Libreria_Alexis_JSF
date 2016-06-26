package sigb.servicios;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import sigb.modelo.Material;
import sigb.utils.AppendingObjectOutputStream;

/**
 * 
 * Servicio que gestiona los materiales (alta, modificación, borrado...)
 * 
 * @author Alexis
 *
 */
public class GestionMateriales {

	private static final String PATH = System.getProperty("user.dir") + "/datosLibreria/";
	private static final String NOMBRE_FICHERO = "materiales.txt";

	public void nuevoMaterial(Material mat) {

		try {
			// Creamos el path del fichero
			Path p = Paths.get(PATH + NOMBRE_FICHERO);
			// Comprobamos si está vacio
			boolean tieneDatos = Files.size(p) != 0;

			// NO tiene datos, incluye cabecera
			if (!tieneDatos) {

				FileOutputStream fout = new FileOutputStream(p.toString());
				ObjectOutputStream oos = new ObjectOutputStream(fout);
				oos.writeObject(mat);
				oos.close();

			} else {// tiene datos y procedemos a añadir sin cabecera

				// OJO, el segundo parametro es true.
				// Indica que abrimos el fichero para añadir
				FileOutputStream fout = new FileOutputStream(p.toString(), true);

				// Clase personalizada que evita que pinte una cabecera nueva en
				// el fichero
				AppendingObjectOutputStream oos = new AppendingObjectOutputStream(fout);
				oos.writeObject(mat);
				oos.close();

			}

		} catch (IOException e) {
			System.out.println("Ha ocurrido un error inesperado");
		}
	}

	public List<Material> dameMateriales() {
		List<Material> materiales = new ArrayList<>();

		try {
			// Creamos el path del fichero
			Path p = Paths.get(PATH + NOMBRE_FICHERO);
			// Comprobamos si está vacio
			boolean tieneDatos = Files.size(p) != 0;

			if (!tieneDatos)
				throw new FileNotFoundException();

			FileInputStream fis;
			boolean eof = false;

			fis = new FileInputStream(p.toString());
			ObjectInputStream ois = new ObjectInputStream(fis);

			// Recorre el fichero para obtener todos los materiales
			while (!eof) {
				try {
					Material material = (Material) ois.readObject();
					materiales.add(material);
				} catch (EOFException e) {
					eof = true;
					ois.close();
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe");
		} catch (IOException e) {
			System.out.println("ERROR");
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR");
		}

		return materiales;
	}
}
