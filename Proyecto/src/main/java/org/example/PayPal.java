package org.example;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Scanner;

@Setter @NoArgsConstructor
public class PayPal extends MetodoPago{
    static Scanner in = new Scanner(System.in);

    final double saldoDefault = 23;

    private String cuenta;
    private double saldo;

    public PayPal(String cuenta, double saldo) {
        this.saldo=saldo;
        this.cuenta=cuenta;
    }

    public PayPal(String cuenta) {
        this.cuenta=cuenta;
        this.saldo=saldoDefault;
    }

    private boolean validarPayPal(String cuenta, double importe) {
        System.out.println("Validando cuenta...");
        if (cuenta.matches(".*@*\\.com") && saldo >= importe) {
            return true;
        }
        System.out.println("Datos incorrectos o saldo insuficiente.");
        return false;
    }

    @Override
    void procesarPago(double importe) {
        System.out.println("Procesando pago de " + importe + " con PayPal...");
        if (validarPayPal(this.cuenta, importe)) {
            System.out.println("Pago aceptado.");
        }
    }

    @Override
    public String toString() {
        return "PayPal(cuenta=" + cuenta + ", saldo=" + saldo;
    }

}
