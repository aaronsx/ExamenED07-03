package aplicacion.controladores;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import aplicacion.entidades.Matricula;
import aplicacion.servicios.ImpMenu;
import aplicacion.servicios.IntMenu;
import aplicacion.servicios.ImpMatricula;
import aplicacion.servicios.IntMatricula;


public class Menu {

	public static void main(String[] args) {
		//Implementamos los servicios para poder utilizarce en el menu
		IntMatricula impM = new ImpMatricula();
		IntMenu intM = new ImpMenu();
		//Listado de repostajes (BD)
		ArrayList<Matricula> db = new ArrayList<Matricula>();
						
						// Imprimir el menú por consola
						// Scanner con la opción del usuario
						Scanner entradaOpcion = new Scanner(System.in);		
						Boolean cerrarMenu = false;
						int opcion;
						while(!cerrarMenu) {	
							//Mostramos el menú
							intM.MostrarMenu();
							System.out.println("Introduza la opción deseada: ");
							opcion = entradaOpcion.nextInt();
							System.out.println("[INFO] - Has seleccionado la opcion " + opcion);
							
							switch (opcion) {					
								case 0:
									cerrarMenu = true;
									break;							
								case 1:
									db.add(impM.addMatriculaAlumno(db));				
									
									break;
								case 2:
									db.add(impM.removeMatriculaAlumno(db));	
									break;
								case 3:
									impM.listarMatricula(db);
									break;
								
								default:

							}
						}

	}

}
