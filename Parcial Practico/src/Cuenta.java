public class Cuenta {
    private String titular;
    private String numeroCuenta;
    private double saldo;

    public Cuenta (String titular, String numeroCuenta, double saldo) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        if (saldo < 0) {
            this.saldo = 0;
        } else {
            this.saldo = saldo;
        }
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo = saldo + monto;
            System.out.println("Desposito de " + monto + " realizado. \n\nNuevos saldo: " + saldo);
        } else {
            System.out.println("El monto debe ser positivo");
        }
    }

    public void depositar(double monto, String concepto) {
        if (monto > 0) {
            saldo = saldo + monto;
            System.out.println("Desposito de " + monto + " por concepto '" + concepto + "'.\n\nNuevos saldo: " + saldo);
        } else {
            System.out.println("El monto debe ser positivo");
        }
    }

    public boolean retirar(double monto) {
        if (monto <= 0) {
            System.out.println("Monto inválido");
            return false;
        }
        if (monto <= saldo) {
            saldo = saldo - monto;
            System.out.println("Retiro de " + monto + " exitoso. \n\nSaldo restante: " + saldo);
            return true;
        } else {
            System.out.println("Saldo insuficiente");
            return false;
        }
    }

    public void mostrarInfo() {
        System.out.println("=== Información de Cuenta ===");
        System.out.println("Titular: " + titular);
        System.out.println("Número: " + numeroCuenta);
        System.out.println("Saldo: " + saldo);
    }

    public double getSaldo() {
        return saldo;
    }
}
