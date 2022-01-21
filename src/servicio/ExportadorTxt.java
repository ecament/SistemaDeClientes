package servicio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import modelo.Cliente;

public class ExportadorTxt extends Exportador{

	
	// Se hace un Overrride desde el método exportar en la clase Abstracta Exportador
	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		
		File archivo = new File(fileName + ".txt");
		System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.txt:");
		String ruta = scanner.nextLine();
		System.out.println("--------------------------------------------\n");
		
		try {
			if(!archivo.exists()) {
				archivo.createNewFile();
			}
			
			FileWriter fileW = new FileWriter(ruta + "/" + archivo);
			PrintWriter pW= new PrintWriter(fileW);
		

			//Se verifica que lista de clientes no es null o no está vacía antes de guardar en archivo
			if(!listaClientes.equals(null) || (listaClientes.size() !=0)) {
	

				// se usa una iteración tipo forEach y se usa print Writer de acuerdo a los solicitado
				// en el enunciado de la Prueba	
				listaClientes.forEach(client -> {
					
					pW.append("RUN: ").append(client.getRunCliente())
					.println();
					pW.append("Nombre: ").append(client.getNombreCliente())
					.println();
					pW.append("Apellido: ").append(client.getApellidoCliente())
					.println();
					pW.append("Años: ").append(client.getAniosCliente())
					.println();
					pW.append("Estado: ").append(client.getNombreCategoria().name())
					.println();
					pW.append("-------------------------------")
					.println();
					pW.append("-------------------------------")
					.println();
				});	
				pW.close();
			}
		    System.out.println("Datos de clientes exportados correctamente en formato .txt");
			
		
		}  catch(FileNotFoundException e) {
			
			System.out.println(e.getMessage() + ", Archivo no encontrado!");
			
		} catch (IOException e) {
			System.out.println(e.getMessage()+", Ingrese ruta correcta!");
		//	e.printStackTrace();
		
		}  catch (Exception e) {
			System.out.println("Error inesperado: " + e.getMessage());
		//	e.printStackTrace();
		}	


	}
	
	

}
