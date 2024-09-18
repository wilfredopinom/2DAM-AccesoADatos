package cuenta;

import cuenta.ClasedeExcepcionPersonalizada.ImporteInvalidoException;
import cuenta.ClasedeExcepcionPersonalizada.SaldoInsuficienteException;

public class Cuenta {
	


    // ATRIBUTOS
	
    private String nombre;
    private String numeroCuenta;
    private double tipoInteres; // DE MOMENTO NO LO UTILIZAMOS
    private double saldo;

    // CONSTRUCTORES
    
    
    public Cuenta() {
        super();
    }

    
    public Cuenta(String nombre, String numeroCuenta, double tipoInteres, double saldo) {
        super();
        this.nombre = nombre;
        this.numeroCuenta = numeroCuenta;
        this.tipoInteres = tipoInteres; // Cambiado a "tipoInteres"
        this.saldo = saldo;
    }

    
    
    // GETTER AND SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(double tipoInteres) { 
        this.tipoInteres = tipoInteres;
    }

    public double getSaldo() {
        return saldo;
    }

    private void setSaldo(double saldo) { // SE COLOCA EN PRIVADO POR SEGURIDAD
        this.saldo = saldo;
    }

    
    
    // TO_STRING
    
    
    @Override
    public String toString() {
        return "Cuenta [nombre=" + nombre + ", numeroCuenta=" + numeroCuenta + ", tipoInteres=" + tipoInteres
                + ", saldo=" + saldo + "]";
    }

    // METODO INGRESAR
    
    
    public boolean ingresar(double cantidad) throws ImporteInvalidoException {
        if (cantidad <= 0) {
            throw new ImporteInvalidoException("La cantidad a ingresar debe ser mayor que cero.");
        }

        saldo += cantidad; // Aumenta el saldo
        System.out.println("Ingreso exitoso. Nuevo saldo: " + saldo);
        return true; // Retorna true si el ingreso fue exitoso
    }
    
    

    // METODO RETIRAR
    public boolean retirar(double cantidad) throws ImporteInvalidoException, SaldoInsuficienteException {
        if (cantidad <= 0) {
            throw new ImporteInvalidoException("La cantidad a retirar debe ser mayor que cero.");
        }

        if (saldo >= cantidad) {
            saldo -= cantidad;
            System.out.println("Retiro exitoso. Nuevo saldo: " + saldo);
            return true; // Retorna true si el retiro fue exitoso
        } else {
            throw new SaldoInsuficienteException("NO DISPONE DE SALDO SUFICIENTE");
        }
    }

    // Método para realizar transferencias
    
    public boolean transferencia(Cuenta cuentaDestino, double cantidad) throws ImporteInvalidoException, SaldoInsuficienteException {
        if (cantidad <= 0) {
            throw new ImporteInvalidoException("La cantidad a transferir no puede ser negativa o cero.");
        }
        this.retirar(cantidad); 
        cuentaDestino.ingresar(cantidad); 
       
        return true;
    }
}

