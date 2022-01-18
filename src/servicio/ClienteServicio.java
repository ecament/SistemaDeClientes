package servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageTranscoder;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ClienteServicio {
	
	List<Cliente> listaClientes = new ArrayList<Cliente>();
	Scanner scanner = new Scanner (System.in);
	
	public ClienteServicio(List<Cliente> listaClientes) {
		super();
		this.listaClientes = listaClientes;
	}
	
	
	public ClienteServicio() {}
	

	//Getter Lista de Clientes
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}


	//Setter
	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}


	// Método ListarClientes, llamado desde Menú
	public void listarClientes() {
		
			listaClientes.forEach(client -> {
			System.out.println("-------------------- Datos del Cliente -------------------- ");	
			System.out.println("RUN del Cliente: " + client.getRunCliente());
			System.out.println("Nombre del Cliente: " + client.getNombreCliente());
			System.out.println("Apellido del Cliente: " + client.getApellidoCliente());
			System.out.println("Años como Cliente: " + client.getAniosCliente());
			System.out.println("Categoría del Cliente: " + client.getNombreCategoria().name());
			System.out.println("------------------------------------------------------------ ");	
			});
			
	}
	
	
	


	// Método para agregar clientes en el arreglo ListaCliente
	public void  agregarCliente(Cliente cliente) {
		listaClientes.add(cliente);
		
	}
	
	
	
	public void editarCliente(Cliente cliente) {
		System.out.println("-------------------- Actualizando datos del Cliente --------------------\n\n");	
		System.out.println("1. El RUN del Cliente es: " + cliente.getRunCliente());
		System.out.println("2. El nombre del Cliente es: " + cliente.getNombreCliente());
		System.out.println("3. El apellido del Cliente: " + cliente.getApellidoCliente() );
		System.out.println("4. Los años como Cliente son: " + cliente.getAniosCliente());
		
		System.out.println("Ingrese opcion a editar de los datos del cliente:");
		System.out.println("------------------------------------------------------------------------\n");
		String opcion = scanner.nextLine();
		switch(opcion) {
		case "1": 
			System.out.println("Ingrese nuevo RUN del Cliente:");
			String run = scanner.nextLine();
			cliente.setRunCliente(run);
			break;
			
		case "2": 
			System.out.println("Ingrese nuevo nombre del Cliente:");
			String nombre = scanner.nextLine();
			cliente.setNombreCliente(nombre);
			break;	
			
		case "3": 
			System.out.println("Ingrese nuevo apellido del Cliente:");
			String apellido = scanner.nextLine();
			cliente.setApellidoCliente(apellido);
			break;	
			
		case "4": 
			System.out.println("Ingrese nuevos años como Cliente:");
			String anios = scanner.nextLine();
			cliente.setAniosCliente(anios);
			break;			
		}
		System.out.println("------------------------------------------------------------------------\n");	
		
	System.out.println("Datos creados con éxito");
	}
	
	
	
	
	
	
	
	
}
