package modelo;

public class Cliente {
	


	private String runCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String aniosCliente;
	private CategoriaEnum nombreCategoria;
	
	
	public Cliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
			CategoriaEnum nombreCategoria) {
		super();
		this.runCliente = runCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.aniosCliente = aniosCliente;
		this.nombreCategoria = nombreCategoria;
	}


	String getRunCliente() {
		return runCliente;
	}


	void setRunCliente(String runCliente) {
		this.runCliente = runCliente;
	}


	String getNombreCliente() {
		return nombreCliente;
	}


	void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}


	String getApellidoCliente() {
		return apellidoCliente;
	}


	void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}


	String getAniosCliente() {
		return aniosCliente;
	}


	void setAniosCliente(String aniosCliente) {
		this.aniosCliente = aniosCliente;
	}


	CategoriaEnum getNombreCategoria() {
		return nombreCategoria;
	}


	void setNombreCategoria(CategoriaEnum nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	
	
	// Método toString
	
	@Override
	public String toString() {
		return "Cliente [runCliente=" + runCliente + ", nombreCliente=" + nombreCliente + ", apellidoCliente="
				+ apellidoCliente + ", aniosCliente=" + aniosCliente + ", nombreCategoria=" + nombreCategoria + "]";
	}
	
	
	
}



