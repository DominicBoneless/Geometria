package Controlador;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controlador controlador = new Controlador("Java Repartos");
		Scanner scanner = new Scanner(System.in);
		int ctrl = 0;
		
		while(ctrl != 4) {
			
			System.out.println("Seleciona opcion: \n1.Camiones\n2.Clientes\n3.Conductores\n4.Salir");
			
			ctrl = scanner.nextInt();
			
			if(ctrl == 1) {
				int ctrlCamion = 0;
				System.out.println("CAMIONES\nSeleciona opcion:\n1.Anadir camion\n2.Ver camiones\n3.Selecionar camion\n4.Salir");
				ctrlCamion = scanner.nextInt();
				if(ctrlCamion == 1) {
					System.out.println("Introduce matricula: ");
					String matricula = scanner.next();
					System.out.println("Introduce autonomia: ");
					int autonomia = scanner.nextInt();
					System.out.println("Introduce carga maxima en Kg's: ");
					int carga = scanner.nextInt();
					if(controlador.anadirCamion(matricula, autonomia, carga)) {
						System.out.println("Se ha anadido correctamente el camion");
					}
					else {
						System.out.println("Se ha actualizado el camion");
					}
				}
				if(ctrlCamion == 2) {
					for(Camion camion: controlador.getFlota().values()) {
						System.out.println("Matricula: " + camion.getMatricula() + "Autonomia: " + camion.getAutonomiaKms() + "Carga maxima: " + camion.getCargaMaximaKG());
					}
				}
				if(ctrlCamion == 3) {
					System.out.println("Introduce matricula: ");
					String matricula = scanner.next();
					if(controlador.getFlota().containsKey(matricula)) {
						Camion camion = controlador.getFlota().get(matricula);
						System.out.println("Matricula: " + camion.getMatricula() + "Autonomia: " + camion.getAutonomiaKms() + "Carga maxima: " + camion.getCargaMaximaKG());
						if(camion.getReparto() == null) {
							System.out.println("Quieres añadir un reparto a este camion?(si/no):");
							String opcion = scanner.next();
							if(opcion.equals("si")) {
								boolean terminado = false;
								while(!terminado) {
									System.out.println("Introduce el nif del destinatario de la mercancia: ");
									String destinatario = scanner.next();
									
									System.out.println("Introduce el peso de la mercancia: ");
									int peso = scanner.nextInt();
									
								}
							}
						}else {
							System.out.println("ID: " + camion.getReparto().getId() + "Conductor: " + camion.getReparto().getConductor().getNif() + "\nClientes:");
							for(Cliente cliente: camion.getReparto().getRuta()) {
								System.out.println("Nombre: " + cliente.getNombre() + "Direccion: " + cliente.getDireccion() + "NIF: " + cliente.getNif());
							}
							System.out.println("Mercancias: ");
							for(Mercancia mercancia: camion.getReparto().getMercancias()) {
								System.out.println("Peso: " + mercancia.getPeso() + "Detalles: " + mercancia.getDetalles() + "En frio:" + mercancia.isEnFrio() + "Destinatario" + mercancia.getDestinario().getNif());
							}
						}
					}else {
						System.out.println("No existe ningun camion con esta matricula");
					}
				}
			}
			
		}

	}

}
