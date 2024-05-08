package Agenda;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Contacto.Contacto;

public class AgendaMenu {
	
	private enum AppState{
		MAIN_MENU,
        EDIT_CONTACT,
        ADD_CONTACT
	}
	
    private AppState currentState = AppState.MAIN_MENU;
    private Map<AppState, Map<String, Runnable>> stateCommands = new HashMap<>();
    private Map<String, Runnable> mainMenuCommands = new HashMap<>();
    private Map<String, Runnable> editContactCommands = new HashMap<>();
    private Agenda agenda; // Assuming this is your class for managing contacts
    private Scanner scanner;

    public AgendaMenu(Agenda agenda) {
        this.setAgendaMenu(agenda);
        initializeMainMenuCommands();
        initializeEditContactCommands();
        
        scanner = new Scanner(System.in);
        
     // Associate each state with its command map
        stateCommands.put(AppState.MAIN_MENU, mainMenuCommands);
        stateCommands.put(AppState.EDIT_CONTACT, editContactCommands);
        // Add more states and their command maps as needed
    }

    private void initializeMainMenuCommands() {
    	mainMenuCommands.put("editar", this::enterEditMode);
    	mainMenuCommands.put("añadir", this::enterAddMode);
    	mainMenuCommands.put("contactos", this::ensenarContactos);
        mainMenuCommands.put("borrar", this::eliminarContacto);
        // Add other main menu commands here
    }

    private void initializeEditContactCommands() {
        editContactCommands.put("nombre", this::editContactName);
        editContactCommands.put("numero", this::editContactNumber);
        editContactCommands.put("correo", this::editContactCorreo);
        editContactCommands.put("atras", this::goBackToMainMenu);
        // Add other edit contact commands here
    }

    public void enterEditMode() {
        // Change state to EDIT_CONTACT
        currentState = AppState.EDIT_CONTACT;
        // Perhaps prompt the user to select a contact to edit
        System.out.println("Que parte del contacto quieres cambiar: ");
    }
    
    public void enterAddMode() {
        currentState = AppState.ADD_CONTACT;
        String name, correo;
        int numero;
        
        System.out.print("Nombre: ");
        name = scanner.nextLine();
        
        System.out.print("Numero: ");
        numero = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left-over
        
        System.out.print("Correo: ");
        correo = scanner.nextLine();
        
        agenda.anadirContacto(name, correo, numero);
        goBackToMainMenu();
    }
    
    public void ensenarContactos() {
    	for(int i = 0; i < agenda.getContactos().size(); i++) {
    		System.out.println(agenda.getContactos().get(i).toString());
    	}
    }
    
    public void eliminarContacto() {
    	System.out.print("Introduce el nombre del contacto: ");
    	String currentName = scanner.nextLine();
    	if(agenda.eliminarContacto(currentName)) {
    		System.out.println("Contacto eliminado");
    	}else {
    		System.out.println("Contacto no encontrado"); 
    	}
		goBackToMainMenu();
    }


    public void goBackToMainMenu() {
        currentState = AppState.MAIN_MENU;
    }
    
    public Contacto inputContacto() {
    	//Esta funcion hace que no necesites pedir nombre para cada funcion de de editar
        System.out.print("Introduce el nombre actual del contacto: ");
        String currentName = scanner.nextLine();
        
        // Si el contacto no se encuentra en Agenda, ya se Imprime eso
        Contacto contact = agenda.buscarContacto(currentName);
        if (contact != null) {
        	return contact;
        }else {
        	System.out.println("Contacto no encontrado");
        	enterEditMode();
        	return null;
        }
    }
    
 // Define methods like editContactName, editContactNumber, etc.
    
    public void editContactName() {
    	Contacto contacto = inputContacto();
    	if (contacto != null) {
    		System.out.print("Introducir nuevo nombre: ");
    		String newName = scanner.nextLine();
    		contacto.setNombre(newName);
    		System.out.println("Nombre del contacto actualizado.");
    		goBackToMainMenu();
    	}
    }
    public void editContactCorreo() {
    	Contacto contacto = inputContacto();
    	if (contacto != null) {
    		System.out.print("Introducir nuevo correo: ");
    		String newName = scanner.nextLine();
    		contacto.setCorreo(newName);
    		System.out.println("Correo del contacto actualizado.");
    		goBackToMainMenu();
    	}
    }
    public void editContactNumber() {
    	Contacto contacto = inputContacto();
    	if (contacto != null) {
    		System.out.print("Introducir nuevo numero: ");
            int newNumber = scanner.nextInt();
            contacto.setNumero(newNumber);
            System.out.println("Numero del contacto actualizado.");
            goBackToMainMenu();
    	}
    }

    public void handleCommand(String input) {
        Map<String, Runnable> activeCommands = stateCommands.get(currentState);
        
        if (activeCommands != null) {
            Runnable command = activeCommands.get(input);
            if (command != null) {
                command.run();
            } else {
                System.out.println("Unknown command");
            }
        } else {
            System.out.println("No commands available for the current state.");
        }
    }


	public Agenda getAgendaMenu() {
		return agenda;
	}

	public void setAgendaMenu(Agenda agenda) {
		this.agenda = agenda;
	}
}

