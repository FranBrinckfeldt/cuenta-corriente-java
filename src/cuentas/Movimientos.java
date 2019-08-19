package cuentas;

public class Movimientos {

    //Atributos.
    private int tipo;
    private String fecha;
    private int monto;
    private CuentaCorriente cuenta;

    //Contructor.
    public Movimientos(int tipo, String fecha, int monto, CuentaCorriente cuenta) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.monto = monto;
        this.cuenta = cuenta;
        this.calcular();
        this.ingresarMovimiento();
    }

    //Método get para atributo 'tipo'.
    public int getTipo() {
        return tipo;
    }

    //Método set para atributo 'tipo'.
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    //Método get para atributo 'fecha'.
    public String getFecha() {
        return fecha;
    }

    //Método set para atributo 'fecha'.
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    //Método get para atributo 'monto'.
    public int getMonto() {
        return monto;
    }

    //Método set para atributo ' monto'.
    public void setMonto(int monto) {
        this.monto = monto;
    }

    //Método get para atributo 'cuenta'.
    public CuentaCorriente getCuenta() {
        return cuenta;
    }

    //Método set para atributo 'cuenta'.
    public void setCuenta(CuentaCorriente cuenta) {
        this.cuenta = cuenta;
    }

    //Método para calcular y mostrar el saldo de la cuenta dependiendo del tipo de movimiento.
    //Agregado en el constructor.
    public void calcular() {
        if(tipo == 1) {
            this.cuenta.setSaldo(this.cuenta.getSaldo() + this.monto);
            System.out.println("Se abonó " + this.monto + " a la cuenta " + this.cuenta.getNumero());
        }
        if (tipo == 2) {
            this.cuenta.setSaldo(this.cuenta.getSaldo() - this.monto);
            if (this.cuenta.getSaldo() < 0) {
                this.cuenta.setSaldo(0);
            }
            System.out.println("Se cargó " + this.monto + " a la cuenta " + this.cuenta.getNumero());
        }
    }

    //Método para añadir los movimientos de una cuenta al ArrayList movimientos.
    //Agregado en el constructor.
    public void ingresarMovimiento() {
        if (tipo==1 || tipo==2) {
            this.cuenta.agregarMovimiento(this);
        } else {
            System.out.println("No hay movimiento");
        }
    }

    //Método toString para mostrar la información del movimiento realizado.
    public String toString() {
        if (tipo == 1) {
            return "El tipo de movimiento es un abono de " + this.monto + " realizado en la fecha " + this.fecha + " en la cuenta " + this.cuenta.getNumero();
        } else {
            return "El tipo de movimiento es un cargo de " + this.monto + " realizado en la fecha " + this.fecha + " en la cuenta " + this.cuenta.getNumero();
        }
    }
}

