package aplicacion.servicios;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Scanner;

import aplicacion.entidades.Matricula;

public class ImpMatricula implements IntMatricula {

	@Override
	public Matricula addMatriculaAlumno(ArrayList<Matricula> db) {
		Matricula Matricula = new Matricula();
		Scanner valores = new Scanner(System.in);
		//Generamos la fecha actual
		String dateTime = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm:ss a").format(LocalDateTime.now());
				
		//Pide Nombre apellido del alumno y lo guarda con el metodo setNombre y setApellidos
		System.out.println("Introduzca el nombre del alumno : ");
		Matricula.setNombre(valores.next());
		System.out.println("Introduzca los apellidos del alumno : ");
		String apellido1=valores.next();
		String apellido2=valores.next();
		Matricula.setApellidos(apellido1+" "+apellido2);
		//Pide al usuario la marca y el modelo para guardarlo en un string
		System.out.println("Introduzca el modelo del portatil: ");
		String modelo=valores.next();
		System.out.println("Introduzca la marca del portatil: ");
		String marca=valores.next().toUpperCase();
		//Comprobamos si la marca y el modelo es mayor de 3 si es mayor que 3 entra y 
		//divide la palabra y si no entra en el else y develve la marca entera
		if(marca.length()>3||modelo.length()>3) 
		{
			if(marca.length()>3&&modelo.length()<3)
			{
				char primeraletramarca= marca.charAt(0);
				char segundaletramarca= marca.charAt(1);
				char terceraletramarca= marca.charAt(2);
				
				Matricula.setIdModelo(modelo+"-"+primeraletramarca+segundaletramarca+terceraletramarca);
			}
			else if(marca.length()<3&&modelo.length()>3) 
			{
				char primeraletra= modelo.charAt(0);
				char segundaletra= modelo.charAt(1);
				char terceraletra= modelo.charAt(2);
				
				Matricula.setIdModelo(primeraletra+segundaletra+terceraletra+"-"+marca);
			}
			else
			{
				char primeraletramarca= marca.charAt(0);
				char segundaletramarca= marca.charAt(1);
				char terceraletramarca= marca.charAt(2);
				char primeraletra= modelo.charAt(0);
				char segundaletra= modelo.charAt(1);
				char terceraletra= modelo.charAt(2);
				Matricula.setIdModelo(primeraletra+segundaletra+terceraletra+"-"+primeraletramarca+segundaletramarca+terceraletramarca);
			}
		}
		else
			Matricula.setIdModelo(modelo+"-"+marca);
		
			
		
		//Añadimos la fecha del alta
		Matricula.setFchalta(dateTime);
		//Guarda una id en orden de creada 
		Matricula.setId(calculoNuevoId(db));

		
		return Matricula;

		
	}

	@Override
	public Matricula removeMatriculaAlumno(ArrayList<Matricula> db) {
		
		Matricula Matricula = new Matricula();
		//boolean para saber si pulsa otra tecla
		boolean ok;
		do 
		{
			//pide una id si la encuneta en existe cuenta te devuelve la lista que quieres eliminar si pulsas si la eliminas si no pulsa pues no la elimina
			//si introduce algo que no es S, Si o N, No da error
			ok=true;
			Scanner eliminar = new Scanner(System.in);
			System.out.println("Introduce el inditifador de la matricula que deseas eliminar:");
			int numeroEliminar=eliminar.nextInt();
			if (ExisteCuenta(numeroEliminar,db))
			{
				System.out.println("Las lista que quieres eliminar es: "+db.get(contador)+"[S=Si o N=No]");
				String siono=eliminar.next().toUpperCase();
				switch(siono)
				{
				case "S":case "SI":
					db.remove(contador);
					break;
				case "N":case "NO":
					break;
					default:
						ok=false;
				}
			}
			
		}while(!ok);
		//Devuelve sin la lista elimininada 
		return Matricula;
	}

	@Override
	public void listarMatricula(ArrayList<Matricula> db) {
		//Muestra todas las listas
		Matricula Matricula = new Matricula();
		for(Matricula alumno:db) 
		{
			if(contador==0)
				System.out.println("Sin iva");
			 //El if no me sale quiero que solo muestre que cuando la id sea distinto a 0 pero me sigue saliendo 
			//if(Matricula.getId()!=0)
				System.out.println(alumno.toString());
				
			contador++;	
		}
		
	}
	//Para saber si existe una cuenta no
	//El contador es para saber en que posicion esta para luego eliminar 
	private int contador;
	private boolean ExisteCuenta (int numeroEliminar, ArrayList<Matricula> bd) 
	{
		contador=0;
		//Te compra si el numero que quiere eliminar existe 
		//si existe devuelve true y si no pues false
		for(Matricula matricula: bd) {			
			int numeroExistente = matricula.getId();
			if(numeroExistente==numeroEliminar) 
			return true;
			
			contador++;			
		}	
		return false;
		
		
	}
	//Calcula id
	//Crea una id y la envia a la bd 
	private int calculoNuevoId(ArrayList<Matricula> listaMatricula) {
		
		int auxiliar = 0;
		for(int i=0;i<listaMatricula.size();i++) {
			
			int j = listaMatricula.get(i).getId();
			if(auxiliar < j) {
				auxiliar = j;
			}
			
		}
		
		return auxiliar+1;
	}

}
