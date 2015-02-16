/**
 * 
 */
package es.aferna.utilidades;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import es.aferna.modelo.Libro;

/**
 * @author Alexis
 *
 */
@Aspect
@Component("interceptor")
public class Interceptor {

	/**
	 * Método interceptarAltaLibro: se ejecuta cuando interceptamos el método
	 * altaLibro() mediante Spring AOP
	 * 
	 * @return result
	 */
	@Around("execution(* es.aferna.persistencia.LibrosDaoImpl.altaLibro(..)) && args(libro)")
	public Boolean interceptarAltaLibro(ProceedingJoinPoint jp, Libro libro) {
		Boolean result = true;
		try {
			result = (Boolean) jp.proceed();
			if (!result) {
				System.out
						.println(">> El Libro con ISBN: "
								+ libro.getIsbn()
								+ " no se ha podido insertar, ya existe en la Base de Datos.");
			} else {
				System.out.println(">> El Libro con ISBN: " + libro.getIsbn()
						+ " se ha insertado correctamente.");
			}
		} catch (Throwable e) {
			System.out.println(">> Error, el Libro con ISBN: "
					+ libro.getIsbn() + " no se ha podido insertar.");

		}
		return result;
	}

}
