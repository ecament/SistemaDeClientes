/*
 * [] Creaci�n Paquetes
 * [] POJOS (Cliente, CategoriaEnum
 * [] Clases(ClienteServicio, ArchivoServicio, Utilidad)
 * [] M�todos (ExportarCsv, ExportarTxt*/

package main;

import vista.Menu;
import utilidades.Utilidad;

public class Main {

	public static void main(String[] args) {
		Utilidad utilidad = new Utilidad();
		Menu menu = new Menu();
	    utilidad.limpiarPantalla();
	    menu.iniciarMenu();
	     
		

	}

}
