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
	
	private Scanner scanner = new Scanner(System.in);
	ArchivoServicio archivoServicio = new ArchivoServicio();
	ClienteServicio clienteServicio = new ClienteServicio();
	private List<Cliente> clientes = clienteServicio.getListaClientes();
		
	Utilidad utilidad = new Utilidad();
	
	// Se definen variables de archivos importar/exportar
	String fileName = "Clientes";  // Nombre archico para exportar
	String fileName1 = "DBClientes.csv"; // Nombre archivo tipo csv para importación de datos
   
	//iniciarMenu
	public final void iniciarMenu() {
		//Creación de menú inicial
		System.out.println("\n1. Listar Clientes");
		System.out.println("2. Agregar Cliente");
		System.out.println("3. Editar Cliente");
		System.out.println("4. Cargar Datos");
		System.out.println("5. Exportar Datos");
		System.out.println("6. Salir");

		// De acuerdo a la opción elegida se llama a los métodos 
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
	
	
	// Se limpia pantalla y se da un retardo antes de llamar de nuevo al menú
	utilidad.limpiarPantalla();	
	utilidad.espera();
	iniciarMenu();	
	}

	
	
	//Listar Clientes
	private void listarCliente() {
		
		clienteServicio.listarClientes();
		
	}
	
	
	// Se llama método para agregar clientes
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
	
	
	
	// Método para editar Cliente
	private void editarCliente() {
		// Menú de edición
		//clientes = clienteServicio.getListaClientes();
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
			Cliente cliente = null;
			while(cliente ==null) {//Si RUN no existe ne Lista cliente es null y
								   // y se solicita ingresar RUN correcto
				System.out.println("Ingrse RUN del Cliente a editar:");
				String run = scanner.nextLine();
				System.out.println("-------------- Actualizando estado  Cliente ---------------");	
				cliente = obtenerCliente(run, clientes);
				if(cliente == null) {
					System.out.println("El Cliente no existe o no ingresó el RUN correctamente");
				}
			}	
			    String estado = cliente.getNombreCategoria().name();
			
				
			
			//Se crea sub menú para cambiar estado del cliente
			System.out.println("El estado actual es: " + estado);
			System.out.println("1. Si desea cambiar el estado del Cliente a Inactivo");
			System.out.println("2. Si desea cambiar el estado del Cliente a Activo");
			System.out.println("Ingrese opción:");
			System.out.println("------------------------------------------------------");
			String op = scanner.nextLine();
			String estadoNum = "";
			//Se verifica diferentes estados: Si el cliente ya posee el estado seleccioando, Si no lo tenía se cambia el estado
			// y si se selecciona una opción no valida se imprime en pantalla.
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
				
				// Se cambia y actualiza estado del cliente
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
			Cliente cliente = null;
			while(cliente == null) {
				 System.out.println("Ingrese RUN del Cliente a editar:");  
				 String run = scanner.nextLine();
				 cliente = obtenerCliente(run, clientes);
				 if (cliente == null) {
				     System.out.println("El Cliente no existe o no ingresó el RUN correctamente");
				 }
				
			}
			
			// Llama a método editarCliente para editar datos del Cliente y actualizar lista de clientes
			clienteServicio.editarCliente(cliente);
			
				
		}
		
		
	}
	
	// Método para llamar método cargarDatos ubicado en la clase ArchivoServicio
	private void importarDatos() {
		
		ArchivoServicio archivoServicio = new ArchivoServicio();
		System.out.println("-------------- Cargar datos --------------");
		//Sincroniza lista de clientes con la lista existente en ArchivoServicios antes 
		// de llamar al método cargarDatos
		archivoServicio.setClientes(clientes);
		clientes = archivoServicio.cargarDatos(fileName1);
		// Actualiza instancia de ListaClientes en ClienteServicio
		clienteServicio.setListaClientes(clientes);
		
	}	
	
	
	// Este método da la opción de exportar datos y llama método exportarTxt o exportarCsv
	// ubicados en la clases ExportadorTxt / ExportadorCsv

	private void exportarDatos() {
		
		
		//List<Cliente> clientes = clienteServicio.getListaClientes();
		utilidad.limpiarPantalla();
		System.out.println("-------------- Exportar datos --------------");
		System.out.println("Seleccione el formato a exportar:");
		System.out.println("1. Formato .txt");
		System.out.println("2. Formato .csv");
		System.out.println("\n7. Ingrese una opción para exportar:");
		System.out.println("--------------------------------------------");
		String opcion = scanner.nextLine();
		System.out.println("\n-------------- Exportar datos --------------");
		
		utilidad.espera();
		
		
		//A continuación se llama el método exportar opción 1 o 2 depende del tipo
		//de archivo a exportar
		
		
		if(opcion.equals("1")) {
		
			Exportador exportadorTxt = new ExportadorTxt();	
			exportadorTxt.exportar(fileName, clientes);
		
			
		}
		else if (opcion.equals("2")) {			
			Exportador exportadorCvs = new ExportadorCsv();
			exportadorCvs.exportar(fileName, clientes);
		}
		
	}
	
	
	// Método devuelve el Cliente al recibir el RUN como parámetro de entrada
		private Cliente obtenerCliente(String run, List<Cliente> clientes) {
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
	
	

	
	//*****Método termina el Programa
	private void terminarPrograma(){
		
		
		String mensaje = "Terminando programa .......";
		utilidad.printLine(mensaje);
		utilidad.espera();
		mensaje = "Adios....";
		utilidad.limpiarPantalla();
		utilidad.printLine(mensaje);
		System.exit(0);
		
		
	}
	
	
	
}



