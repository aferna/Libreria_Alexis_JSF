package sigb.servicios;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import sigb.modelo.Material;
import sigb.utils.AppendingObjectOutputStream;

/**
 * 
 * @author Alexis
 *
 */
public class GestionMateriales {

	private static final String PATH = System.getProperty("user.dir");
	private static final String NOMBRE_FICHERO = "materiales.txt";

	public void nuevoMaterial(Material mat) {

		// Creamos el fichero y una carpeta en la ruta del usuario
		File carpetaDatos = new File(PATH + "/datosLibreria/");
		carpetaDatos.mkdirs();
		File ficheroDatos = new File(carpetaDatos, NOMBRE_FICHERO);

		try {
			// no existe creamos el fichero
			if (!ficheroDatos.exists()) {

				FileOutputStream fos = new FileOutputStream(ficheroDatos);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(mat);
				oos.close();

			} else {// existe y procedemos a AÑADIR

				FileOutputStream fos = new FileOutputStream(ficheroDatos);
				AppendingObjectOutputStream oos = new AppendingObjectOutputStream(fos);
				oos.writeObject(mat);
				oos.close();

			}
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error inesperado");
		}
	}

	public List<Material> dameMateriales() {
		List<Material> materiales = new ArrayList<>();

		File carpetaDatos = new File(PATH + "/datosLibreria/");
		File ficheroDatos = new File(carpetaDatos, NOMBRE_FICHERO);

		FileInputStream fis;
		boolean eof = false;
		try {
			fis = new FileInputStream(ficheroDatos);
			ObjectInputStream ois = new ObjectInputStream(fis);

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
