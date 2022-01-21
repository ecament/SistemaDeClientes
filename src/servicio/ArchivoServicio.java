package servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;


public class ArchivoServicio extends Exportador {
	
	private ClienteServicio clienteServicio = new ClienteServicio();
	private  List<Cliente> clientes  = clienteServicio.getListaClientes();
	

	
// Método que carga datos de clientes desde archivo: DBClientes.csv y lo transfiere a un arreglo 
// Luego es posible listarlo desde el Menu principal para su analisis y edición	
	public void cargarDatos(String fileName) {
		
    System.out.println("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv:");
    String ruta = scanner.nextLine();
    File archivo = new File (ruta + "/" + fileName);
    System.out.println("--------------------------------------------\n");	

      try {	
    	  
    	  
    	  // Se define FileReader y Bufferreader para leer archivo
			FileReader rd = new FileReader(archivo);
			BufferedReader br = new BufferedReader(rd);
			// Se lee cada línea del archivo, se separa los elementos por coma, y se guardan en un arreglo
			// Se llama a un bucle tipo While para leer todas las líneas del archivo
			String line;
			while((line = br.readLine()) != null && (!line.equals(""))) {
				String [] datos = line.split(",");
				// Primer elemento del afrreglo corresponde al Run del cliente
			 	String run = datos[0];
			 	
			 
			 	// Se hace uso de la libreria stream(), tal cual se solicita en el enunciado de la Prueba, para buscar
			 	// en la lista de clientes (ListaClientes) si el cliente ya existe, si es así se filtra  y no se agrega
			 	// a la Lista, de lo contrario se añade a la lista
                 Cliente findClient = clientes.stream().filter(cliente -> cliente.getRunCliente().equals(run)).findFirst().orElse(null);				
                 if (findClient == null) {
				
               // Se setea la categoria Enum dependiendo del estado del cliente leido desde el archivo
					CategoriaEnum estado = null;
					if (datos[4].equals("Activo")){
						estado = CategoriaEnum.Activo;
					}
					else if (datos[4].equals("Inactivo")){
						estado = CategoriaEnum.Inactivo;
					}	
	
				// de acuerdo a los datos obtenidos por línea leida desde archivo, se crea Cliente
				// y luego se añade a la lista de Clientes existentes en ListaClientes(se puede listar desde el menu principal)	
					 Cliente agregaCliente = new Cliente(datos[0], datos[1], datos[2], datos[3], estado );
					 clientes.add(agregaCliente);
		
                 }
			 	
				
			}
			br.close();
			
			//Se llama al método listarClientes para mostrar todos los clientes: Los existentes + Clienetes cargados desde archivo
			clienteServicio.listarClientes();	
			System.out.println("Datos cargados correctamente en la lista");	
			
			
		  } catch (FileNotFoundException e) {
		 	System.out.println(e.getMessage());
		 	System.out.println("Verifique el archivo exista en la ruta especificada!");
			//e.printStackTrace();
		  } catch (IOException e) {
			System.out.println(e.getMessage() + "Error inesperado de Entrada/Salida");
			//e.printStackTrace();
		  }catch (Exception e) {
				System.out.println(e.getMessage() + "Error inesperado");
			e.printStackTrace();
			  }
	}
	
	
	
	
	
	
	
	
	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		
		
		
		
	}


	
}
