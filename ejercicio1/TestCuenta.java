package cuenta;

import java.util.Scanner;

import cuenta.ClasedeExcepcionPersonalizada.ImporteInvalidoException;
import cuenta.ClasedeExcepcionPersonalizada.SaldoInsuficienteException;

public class TestCuenta {

	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        
	        try {
	            // Crear cuentas
	        	
	        	Cuenta cuenta1=new Cuenta ("Pino","001-001",0.01,1500);
	        	Cuenta cuenta2=new Cuenta ("Virgi","002-002",0.02,2500);
	        	
	        	 // Probar ingreso
	            cuenta1.ingresar(100);
	            System.out.println("==============================================");
	            System.out.println("Nuevo saldo de cuenta 1: " + cuenta1.getSaldo());
	            
	            // Probar reintegro
	            cuenta1.retirar(50);
	            System.out.println("==============================================");
	            System.out.println("Nuevo saldo de cuenta 1 después del reintegro: " + cuenta1.getSaldo());
	            
	            // Probar transferencia
	            cuenta1.transferencia(cuenta2, 60);
	            System.out.println("==============================================");
	            System.out.println("Nuevo saldo de cuenta 1: " + cuenta1.getSaldo());
	            System.out.println("Nuevo saldo de cuenta 2: " + cuenta2.getSaldo());
	            
	        } catch (ImporteInvalidoException | SaldoInsuficienteException e) {
	            System.err.println("Error: " + e.getMessage());
	        } finally {
	            scanner.close();
	        }
	    }
	}
	        	
	        	
	        	
	        	
				
	            
	           


