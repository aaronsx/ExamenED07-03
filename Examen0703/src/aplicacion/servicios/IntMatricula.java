package aplicacion.servicios;
import java.util.ArrayList;
import aplicacion.entidades.Matricula;
/**
 * Interfaz que define los métodos que darán servicio al menú.
 * @author 
 *
 */

public interface IntMatricula  {
	 
	/**
	 * Método que añade un alumno a la lista
	 * @param db Arraylista actual
	 * @return Arraylista actualizada 
	 */
	public Matricula addMatriculaAlumno(ArrayList<Matricula> db);
	
	
	/**
	 *Actualiza la lista de las matriculas y borrando el elemento que se le indique
	 * @param db Arraylista actual
	 * @return Arraylista actualizada 
	 * */
	public Matricula removeMatriculaAlumno(ArrayList<Matricula> db);
	
	/**
	 * Imprime por consola el listado de las matriculas existente
	 * @param db Arraylista actual
	 * @return muestra el Arraylista
	 */
	public void listarMatricula(ArrayList<Matricula> db);
}
