/*PRUEBA FIN DE UNIDAD -- PROGRAMACIÓN BÁSICA EN JAVA ----- SISTEMA DE CLIENTES-------
 * ELABORADO POR: EDUARDO CAMENT OVIEDO
 * BOOTCAMP FULL STACK JAVA - G2
 * CHECK LIST: 
 * [X] Creación Paquetes: main, modelo, servicio, test, vista, utilidades 
 * [X] POJOS (Cliente, CategoriaEnum
 * [X] Clases(ClienteServicio, ArchivoServicio,Exportador, ExportadorTxt, ExportadorCsv, Utilidad)
 * [X] Métodos (exportar, agregarClientes, editarClientes, cargarDatos, listarClientes, métodos en el menu)
 * [X] Creación de métodos en utilidades */

package main;

import vista.Menu;
import utilidades.Utilidad;

public class Main {

	// Método Mmain llama a iniciarMenu
	public static void main(String[] args) {
		Utilidad utilidad = new Utilidad();
		Menu menu = new Menu();
	    utilidad.limpiarPantalla();
	    menu.iniciarMenu();
	     
		

	}

}
