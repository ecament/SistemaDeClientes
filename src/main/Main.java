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
		Boolean continuar  = true;
		Menu menu = new Menu();
	   /* while(continuar)*/ 
	    	utilidad.espera();
	    utilidad.limpiarPantalla();
			menu.iniciarMenu();
	        System.out.println("PRUEBA");
		

	}

}
