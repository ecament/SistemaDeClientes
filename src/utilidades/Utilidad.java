package utilidades;

public class Utilidad {
	public void limpiarPantalla() {
		for(int i = 0; i < 5; i++) {
			System.out.println(" ");
		}
	}
	
	
	public void espera() {
		for(int i = 0; i < 10; i++) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void printLine(String mensaje) {
		System.out.println(mensaje);
	}


}
