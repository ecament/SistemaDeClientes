package servicio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import modelo.Cliente;

public class ExportadorCsv extends Exportador {

	
	// Se hace un Overrride desde el método exportar en la clase Abstracta Exportador
	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
	
		       System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.csv:");
		       String ruta = scanner.nextLine();
		       File archivo = new File(ruta + "/" + fileName + ".csv");
			   
			   System.out.println("--------------------------------------------\n");
				
				
				try {
					if(!archivo.exists()) {
						archivo.createNewFile();
					}
					
					
					//Se verifica que lista de clientes no es null o no está vacía antes de guardar en archivo
					if(!listaClientes.equals(null) || (listaClientes.size() !=0))
					{
						FileWriter fileW = new FileWriter(archivo);
						PrintWriter pW= new PrintWriter(fileW);
				
					// se usa una iteración tipo forEach y se usa print Writer de acuerdo a los solicitado
					// en el enunciado de la Prueba	
						listaClientes.stream().forEach(client -> {
							
							pW.append(client.getRunCliente()).append(",")
							.append(client.getNombreCliente()).append(",")
							.append(client.getAniosCliente()).append(",")
							.append(client.getAniosCliente()).append(",")
							.append(client.getNombreCategoria().name())
							.println();
						});	
						pW.close();
						
						
					    System.out.println("Datos de clientes exportados correctamente en formato .csv");
					}
				
				} catch (IOException e) {
					System.out.println(e.getMessage() + ", Ingrese una ruta existente!");
				//	e.printStackTrace();	
				}  catch (Exception e) {
					System.out.println("Error inesperado: " + e.getMessage());
				//	e.printStackTrace();	
				
			}

		
	}
	
	

}
