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
	private  List<Cliente> clientes  = new ArrayList<Cliente>();
	

	

	public void cargarDatos(String fileName) {
		
    System.out.println("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv:");
    String ruta = scanner.nextLine();
    File archivo = new File (ruta + "/" + fileName);
    System.out.println("--------------------------------------------\n");	

      try {			
			FileReader rd = new FileReader(archivo);
			BufferedReader br = new BufferedReader(rd);
			String line;
			while((line = br.readLine()) != null) {
				String [] datos = line.split(",");
			//	String rut = datos[0];
			//	if(!clientes.contains(rut)) {
					CategoriaEnum estado = null;
					if (datos[4].equals("Activo")){
						estado = CategoriaEnum.Activo;
					}
					else if (datos[4].equals("Inactivo")){
						estado = CategoriaEnum.Inactivo;
					}	
	
				Cliente agregaCliente = new Cliente(datos[0], datos[1], datos[2], datos[3], estado );
				clientes.add(agregaCliente);
				
			}
			rd.close();
			clienteServicio.setListaClientes(clientes);
		
			clienteServicio.listarClientes();
			
		  } catch (FileNotFoundException e) {
		 	
			e.printStackTrace();
		  } catch (IOException e) {
			
			e.printStackTrace();
		}
		
	
	System.out.println("Datos cargados correctamente en la lista");	
		
		
	}
	
	
	
	
	
	
	
	
	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		
		
		
		
	}


	
}
