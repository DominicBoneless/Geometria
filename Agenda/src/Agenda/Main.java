package Agenda;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Agenda agenda = new Agenda();
		int ctrl = 0;
		
		//Opcion 1: Añadir
		//Opcion 2: Editar
		//Opcion 3: Borrar
		//Opcion 4: Mostrar agenda
		//Opción 5: Mostrar un contacto
		//Opcion 6: Salir

		while(ctrl != 6) {
			System.out.println("Menu de agenda \nOpción 1: Añadir\nOpción 2: Editar\nOpción 3: Borrar\nOpción 4: Mostrar agenda\nOpción 5:Mostara un contacto\nOpción 6: Salir");
			System.out.print("Introduzca opción: ");
		    ctrl = scanner.nextInt();
		    if(ctrl < 1 || ctrl > 6) {
		    	System.out.println("Introduce numero del 1 al 6");
		    }
		    try {
			    if(ctrl == 1) {
			    	System.out.print("Indroduce nombre: ");
			    	String nombre = scanner.next();
			    	if(agenda.buscarContacto(nombre) == null) {
				    	System.out.print("Indroduce Correo: ");
				    	String correo = scanner.next();
				    	System.out.print("Indroduce numero: ");
				    	int numero = scanner.nextInt();
				    	agenda.anadirContacto(nombre, correo, numero);
			    	}else {
			    		System.out.println("Ya tienes un contacto con este nombre");
			    	}
			    		
			    }
		    }catch(Exception e){
		    	System.out.println("Por favor introduce un numero");
		    }
		    if(ctrl == 2) {
		    	System.out.print("Indroduce nombre del contacto que quiere editar: ");
		    	String nombre = scanner.next();
		    	System.out.println("Que parte del contacto quieres editar\n1.Nombre\n2.Correo\n3.Numero");
		    	int opcion = scanner.nextInt();
		    	if(opcion == 1) {
		    		System.out.print("Indroduce el nombre nuevo del contacto");
		    		String nombreNuevo = scanner.next();
		    		agenda.buscarContacto(nombre).setNombre(nombreNuevo);
		    	}
		    	if(opcion == 2) {
		    		System.out.print("Indroduce el correo nuevo del contacto");
		    		String correoNuevo = scanner.next();
		    		agenda.buscarContacto(nombre).setCorreo(correoNuevo);
		    	}
		    	if(opcion == 3) {
		    		System.out.print("Indroduce el numero nuevo del contacto");
		    		int numeroNuevo = scanner.nextInt();
		    		agenda.buscarContacto(nombre).setNumero(numeroNuevo);
		    	}
		    }
		    if(ctrl == 3) {
		    	System.out.print("Indroduce nombre del contacto que quiere borrar: ");
		    	String nombre = scanner.next();
		    	agenda.eliminarContacto(nombre);
		    }
		    if(ctrl == 4) {
		    	for(int i = 0; i < agenda.contactosTotales(); i++) {
		    		System.out.println((i + 1) + "." + agenda.getContactos().get(i).toString());
		    	}
		    }
		    if(ctrl == 5) {
		    	System.out.print("Indroduce nombre del contacto que quiere mostrar: ");
		    	String nombre = scanner.next();
		    	System.out.println(agenda.buscarContacto(nombre).toString());
		    }
		}


	}

}
