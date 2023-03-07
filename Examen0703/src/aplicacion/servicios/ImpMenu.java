package aplicacion.servicios;

public class ImpMenu implements IntMenu{

	@Override
	public void MostrarMenu() {
		System.out.println("0. Salir");
		System.out.println("1. Matricular alumno");
		System.out.println("2. Borrar alumno");
		System.out.println("3. Mostrar alumnos");
		
	}

}
