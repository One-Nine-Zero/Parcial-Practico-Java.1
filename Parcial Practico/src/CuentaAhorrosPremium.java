public final class CuentaAhorrosPremium extends CuentaAhorros {
    private double comisionPorRetiro;

    public CuentaAhorrosPremium(String titular, String numeroCuenta, double saldo, double tasaInteres, int retirosMesActual, double comisionPorRetiro) {
        super(titular, numeroCuenta, saldo, tasaInteres, retirosMesActual);
        this.comisionPorRetiro = comisionPorRetiro;
    }

    private double totalADescontar;

    @Override
    public boolean retirar(double monto) {
        if (monto <= 0) {
            System.out.println("Monto invalido");
            return false;
        }
        totalADescontar = monto + comisionPorRetiro;
        if (totalADescontar > saldo) {
            System.out.println("Saldo insuficiente para cubrir retiro + comisión de " + comisionPorRetiro);
            return false;
        }
        saldo = saldo - totalADescontar;
        System.out.println("Retiro de " + monto + " + comisión " + comisionPorRetiro + ".\n\nSaldo: " + saldo);
        return true;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Tipo: Cuenta Premium");
        System.out.println("Comisión por retiro: $" + comisionPorRetiro);
        System.out.println("Sin límite de retiros mensuales");
    }
}