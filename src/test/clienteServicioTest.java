package test;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ClienteServicio;

public class clienteServicioTest {
	Cliente cliente1;
	ClienteServicio clienteServicio = new ClienteServicio();
	
	
	@Before
	public void setUp() throws Exception {
		cliente1 = new Cliente("1111111-1", "Pepe", "PPPP", "3", CategoriaEnum.Activo); 
		
	}

	
	// Se crea 1 cliente y se verifica con Assertions // Test exitoso
	@Test
	public void agregarClienteTest() {
		
	//Cuando
		clienteServicio.agregarCliente(cliente1);
	//Resulta
		Assert.assertEquals(1, clienteServicio.getListaClientes().size());
		
	}
	
	
   @Test // Test para probar en caso de Cliente = Null
	public void agregarClienteNullTest() {
		//Dado
	   cliente1 = null;
		//Cuando
		clienteServicio.agregarCliente(cliente1);
		//Resulta
		Assert.assertEquals(0, clienteServicio.getListaClientes().size());
		
	}

}
