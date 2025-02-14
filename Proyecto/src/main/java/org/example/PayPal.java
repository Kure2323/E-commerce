package org.example;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @NoArgsConstructor
public class PayPal extends MetodoPago{

    final double saldoDefault = 23;

    private String cuenta;
    private double saldo;

    public PayPal(String cuenta, double saldo) {
        if (validarPayPal(cuenta)) {
            this.cuenta = cuenta;
        }
        this.saldo=saldo;
    }

    public PayPal(String cuenta) {
        if (validarPayPal(cuenta)) {
            this.cuenta = cuenta;
        }
        saldo=saldoDefault;
    }

    private boolean validarPayPal(String cuenta) {
        if (cuenta.matches(".*@*\\.com")) {
            return true;
        }
        return false;
    }

    @Override
    void procesarPago(double importe) {
        if (saldo >= importe) {
            System.out.println("Procesando pago de " + importe + "€ con PayPal.");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    @Override
    public String toString() {
        return "PayPal(cuenta=" + cuenta + ", saldo=" + saldo;
    }

}
