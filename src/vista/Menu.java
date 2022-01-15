package vista;

import java.util.Scanner;

import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ClienteServicio;
import utilidades.Utilidad;

public class Menu {
	
	Scanner scanner = new Scanner(System.in);
	ArchivoServicio archivoServicio = new ArchivoServicio();
	ClienteServicio clienteServicio = new ClienteServicio();
	Utilidad utilidad = new Utilidad();
	
	// Se definen variables de archivos importar/exportar
	String fileName = "Clientes";  // Nombre archico para exportar
	String fileName1 = "DBClientes.csv"; // Nombre archivo tipo csv para importación de datos
	
	// Menú iniciarMenu
	public final void iniciarMenu() {
		
		System.out.println("\n1. Listar Clientes");
		System.out.println("2. Agregar Cliente");
		System.out.println("3. Editar Cliente");
		System.out.println("4. Cargar Datos");
		System.out.println("5. Esportar Datos");
		System.out.println("6. Salir");

		System.out.println("Ingrese una opción:");
		String seleccion = scanner.nextLine();
		
		switch (seleccion) {
		case "1":
			listarCliente();
			break;
		case "2":
			agregarCliente();
			break;
		case "3":
			editarCliente();
			break;
		case "4":
			importarDatos();
			break;
		case "5":
			exportarDatos();
			break;
		case "6":
			terminarPrograma();
			break;
		default:
			System.out.println("La selección no es válida");

		}
//	utilidad.limpiarPantalla();	
	iniciarMenu();	
	}

	
	
	
	private void listarCliente() {
		// TODO Auto-generated method stub
		
	}
	
	private void agregarCliente() {
		// TODO Auto-generated method stub
		
	}
	
	private void editarCliente() {
		// TODO Auto-generated method stub
		
	}
	
	
	private void importarDatos() {
		// TODO Auto-generated method stub
		
	}



	private void exportarDatos() {
		// TODO Auto-generated method stub
		
	}
	
	

	private void terminarPrograma(){
		
	}
	
	

	
	
	

	
}



