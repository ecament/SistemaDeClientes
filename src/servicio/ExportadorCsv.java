package servicio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import modelo.Cliente;

public class ExportadorCsv extends Exportador {

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
	
		
				File archivo = new File(fileName + ".csv");

				
				try {
					if(!archivo.exists()) {
						archivo.createNewFile();
					}
					
					FileWriter fileW = new FileWriter(archivo);
					PrintWriter pW= new PrintWriter(fileW);
					

					listaClientes.forEach(client -> {
						
						pW.append(client.getRunCliente()).append(",")
						.append(client.getNombreCliente()).append(",")
						.append(client.getAniosCliente()).append(",")
						.append(client.getAniosCliente()).append(",")
						.append(client.getNombreCategoria().name()).append(",")
						.println();
					});	
					pW.close();
				    System.out.println("Datos de clientes exportados correctamente en formato .csv");
					
				
				} catch (IOException e) {
					e.printStackTrace();
				
				
			}

		
	}
	
	

}
