/**
 * Ejemplo de refactorización orientada a objetos para una operación de
 * transferencia bancaria.  Se crean clases para encapsular el estado y el
 * comportamiento de las cuentas y de la operación de transferencia,
 * facilitando así la mantenibilidad y la extensibilidad.
 */

/**
 * se instancia la clase CuentaBancaria
 */
class CuentaBancaria {
    //encapsulamiento de variables 
    //solo se pueden modificar con getters y setters
    //en este caso los métodos modifican los variables de la clase
    private String titular;
    private double saldo;

    //construye la clase CuentaBancaria recibiendo el titular y saldo inicial de la cuenta
    public CuentaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // valida si tiene saldo y es superior al monto
    public boolean retirar(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    //deposita, sumando el monto enviado al saldo
    public void depositar(double monto) {
        saldo += monto;
    }

    //retorna el saldo de una cuenta
    public double getSaldo() {
        return saldo;
    }

    //retorna el nombre del titular de la cuenta
    public String getTitular() {
        return titular;
    }
}

class Transferencia {
    /**
     * Método 'realizar' recibe dos cuentas origin destino y un monto
     */
    public void realizar(CuentaBancaria origen, CuentaBancaria destino, double monto) {
        if (origen.retirar(monto)) {
            destino.depositar(monto);
            System.out.println("Transferencia de " + monto + " de " + origen.getTitular() + " a " + destino.getTitular());
        } else {
            System.out.println("Saldo insuficiente");
        }
    }
}

public class Step1OOP {
    public static void main(String[] args) {
        //se crean dos cuentas bancarias
        CuentaBancaria cuentaA = new CuentaBancaria("A", 1000);
        CuentaBancaria cuentaB = new CuentaBancaria("B", 500);
        Transferencia transferencia = new Transferencia();//instancia la clase transferencia
        transferencia.realizar(cuentaA, cuentaB, 200);
        System.out.println("Saldo A: " + cuentaA.getSaldo() + ", Saldo B: " + cuentaB.getSaldo());
    }
}