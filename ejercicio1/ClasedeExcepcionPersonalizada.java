package cuenta;

public class ClasedeExcepcionPersonalizada {

	
	
	 public static class ImporteInvalidoException extends Exception {
	    public ImporteInvalidoException(String mensaje) {
	        super(mensaje);
	    }
	}

	 public static class SaldoInsuficienteException extends Exception {
	    public SaldoInsuficienteException(String mensaje) {
	        super(mensaje);
	    }
	}

}
