public class CuentaAhorros extends Cuenta {
    private double tasaInteres;
    private int retirosMesActual;

    public CuentaAhorros(String titular, String numeroCuenta, double saldo, double tasaInteres, int retirosMesActual) {
        super(titular, numeroCuenta, saldo);
        this.tasaInteres = tasaInteres;
        this.retirosMesActual = 0;
    }

    @Override
    public boolean retirar(double monto) {
        if (retirosMesActual >= 3) {
            System.out.println("Límite de 3 retiros mensuales alcanzado");
            return false;
        }
        if (monto <= 0 || monto > saldo) {
            System.out.println("Monto inválido o saldo insuficiente");
            return false;
        }
        saldo = saldo - monto;
        retirosMesActual = retirosMesActual + 1;
        System.out.println("Retiro #" + retirosMesActual + " de " + monto + ". \n\nSaldo: " + saldo);
        return true;
    }

    public void aplicarInteres(double interes) {
        interes = saldo * tasaInteres;
        saldo = saldo + interes;
        retirosMesActual = 0;
        System.out.println("Interés aplicado: " + interes + ". \n\nNuevo saldo: " + saldo);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Tipo: Cuenta de Ahorros");
        System.out.println("Tasa de interés: " + (tasaInteres * 100) + "%");
        System.out.println("Retiros este mes: " + retirosMesActual + "/3");
    }
}
