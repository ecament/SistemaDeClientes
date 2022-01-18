package servicio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import modelo.Cliente;

public class ExportadorTxt extends Exportador{

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		
		File archivo = new File(fileName + ".txt");

		
		try {
			if(!archivo.exists()) {
				archivo.createNewFile();
			}
			
			FileWriter fileW = new FileWriter(archivo);
			PrintWriter pW= new PrintWriter(fileW);
			

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
		    System.out.println("Datos de clientes exportados correctamente en formato .txt");
			
		
		} catch (IOException e) {
			e.printStackTrace();
		
		
	}


	}
	
	

}
