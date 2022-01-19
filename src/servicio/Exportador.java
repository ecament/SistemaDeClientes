package servicio;

import java.util.List;
import java.util.Scanner;

import modelo.Cliente;

public abstract class Exportador {
	Scanner scanner = new Scanner(System.in);
	public abstract void exportar(String fileName, List<Cliente> listaClientes);
	

}
