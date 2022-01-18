package vista;

import java.util.List;
import java.util.Scanner;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.Exportador;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;
import utilidades.Utilidad;

public class Menu {
	
	Scanner scanner = new Scanner(System.in);
	ArchivoServicio archivoServicio;
	ClienteServicio clienteServicio = new ClienteServicio();
	Utilidad utilidad = new Utilidad();
	
	// Se definen variables de archivos importar/exportar
	String fileName = "Clientes";  // Nombre archico para exportar
	String fileName1 = "DBClientes.csv"; // Nombre archivo tipo csv para importación de datos
	List<Cliente> clientes = clienteServicio.getListaClientes();
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
		clienteServicio.listarClientes();
		
	}
	
	private void agregarCliente() {
		
		System.out.println("------------------- Crear Clientes -------------------");
		System.out.println("Ingrese el RUN del Cliente:");
		String run = scanner.nextLine();
		System.out.println("Ingrese el Nombre del Cliente:");
		String nombre = scanner.nextLine();
		System.out.println("Ingrese el Apellido del Cliente:");
		String apellido = scanner.nextLine();
		System.out.println("Ingrese años como Cliente:");
		String  anios = scanner.nextLine();
		
		Cliente cliente = new Cliente (run, nombre, apellido, anios, CategoriaEnum.Activo);
		//Se llama al método agregarCliente ubicado en ClienteServicio
		clienteServicio.agregarCliente(cliente);
		System.out.println("Cliente agregado");
		
		
		
		
		
	}
	
	private void editarCliente() {
		// Menú de edición
		utilidad.limpiarPantalla();
		System.out.println("------------------- Editar Cliente -------------------");
		System.out.println("1. Cambiar el estado del Cliente");
		System.out.println("2. Editar los datos ingresados del Cliente");
		System.out.println("\n\nIngrese opción:");
		System.out.println("------------------------------------------------------");
		String opcion = scanner.nextLine();	
		
		//Se selcciona 1 de 2 opciones de edición
		// Si Opción es "1" se muestra menú para editar estado del Cliente
		if (opcion.equals("1")) {
			// Si opción 1 se se cambia el estado del cliente
			
			System.out.println("Ingrse RUN del Cliente a editar:");
			String run = scanner.nextLine();
			System.out.println("-------------- Actualizando estado  Cliente ---------------");
			Cliente cliente = obtenerCliente(run); 
			String estado = cliente.getNombreCategoria().name();
			System.out.println("El estado actual es: " + estado);
			System.out.println("1. Si desea cambiar el estado del Cliente a Inactivo");
			System.out.println("2. Si desea cambiar el estado del Cliente a Activo");
			System.out.println("Ingrese opción:");
			System.out.println("------------------------------------------------------");
			String op = scanner.nextLine();
			String estadoNum = null;
			if (estado.equals("Inactivo")){
				estadoNum = "1";
			}
			
			if (estado.equals("Activo")) {
				estadoNum = "2";
			}
			if (op.equals(estadoNum)) {
				System.out.println("El estado del Cliente ya es " + estado );
			}
			
			else {
				
				if (op.equals("1")) {
					cliente.setNombreCategoria(CategoriaEnum.Inactivo);
					System.out.println("Estado del Cliente actualizado");
					
				}
			    
			    else if (op.equals("2")) {
			    	cliente.setNombreCategoria(CategoriaEnum.Activo);
			    	System.out.println("Estado del Cliente actualizado");
			    }
				
			    else {
			    	System.out.println("Opción no válida");
			    }
			}
			
			
			
		
		}
		// Si la Opción es "2", se llama a menú para editar datos del Cliente
		else if (opcion.equals("2"))
			{
			
			System.out.println("Ingrese RUN del Cliente a editar:");  
			String run = scanner.nextLine();
			Cliente cliente = obtenerCliente(run);
			
			// Llama a método editarCliente para editar datos del Cliente y actualizar lista de clientes
			clienteServicio.editarCliente(cliente);
			
				
		}
		
		
	}
	
	
	private void importarDatos() {
		// TODO Auto-generated method stub
		
	}



	private void exportarDatos() {
		Exportador exportadorTxt = new ExportadorTxt();
		Exportador exportadorCsv = new ExportadorCsv();
		utilidad.limpiarPantalla();
		System.out.println("Exportación de datos:");
		System.out.println("1. Exportar en archivo tipo .TXT");
		System.out.println("2. Exportar en archivo tipo .CVS");
		System.out.println("Selecione tipo de archivo a exportar:");
		String opcion = scanner.nextLine();
		utilidad.espera();
		
		if(opcion.equals("1")) {
			((Exportador) exportadorTxt).exportar(fileName, clientes);
			
		}
		else if (opcion.equals("2")) {			
			((Exportador) exportadorCsv).exportar(fileName, clientes);
		}
		
	}
	
	

	
	
	private void terminarPrograma(){
		
	}
	
	
	// Método devuelve el Cliente al recibir el RUN como parámetro de entrada
	private Cliente obtenerCliente(String run) {
		Cliente cliente = null;
		if(clientes != null) {
			for (Cliente client : clientes ) {
				
				String rutLista = client.getRunCliente();
				if (rutLista.equals(run)) {
					cliente = client;
					
				}	
			}			
		 }
		return cliente;	
	}		
}



