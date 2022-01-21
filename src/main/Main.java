/*PRUEBA FIN DE UNIDAD -- PROGRAMACI�N B�SICA EN JAVA ----- SISTEMA DE CLIENTES-------
 * ELABORADO POR: EDUARDO CAMENT OVIEDO
 * BOOTCAMP FULL STACK JAVA - G2
 * CHECK LIST: 
 * [X] Creaci�n Paquetes: main, modelo, servicio, test, vista, utilidades 
 * [X] POJOS (Cliente, CategoriaEnum
 * [X] Clases(ClienteServicio, ArchivoServicio,Exportador, ExportadorTxt, ExportadorCsv, Utilidad)
 * [X] M�todos (exportar, agregarClientes, editarClientes, cargarDatos, listarClientes, m�todos en el menu)
 * [X] Creaci�n de m�todos en utilidades */

package main;

import vista.Menu;
import utilidades.Utilidad;

public class Main {

	// M�todo Mmain llama a iniciarMenu
	public static void main(String[] args) {
		Utilidad utilidad = new Utilidad();
		Menu menu = new Menu();
	    utilidad.limpiarPantalla();
	    menu.iniciarMenu();
	     
		

	}

}
