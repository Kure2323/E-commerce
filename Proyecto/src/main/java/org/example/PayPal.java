package org.example;

import java.util.Scanner;

public class PayPal extends MetodoPago{
    static Scanner in = new Scanner(System.in);

    //Saldo por defecto por si no es introducido por el usuario
    final double saldoDefault = 23;

    private String cuenta;
    private double saldo;

    /**
     * Constructor de PayPal donde el usuario introduce el saldo
     * @param cuenta
     * @param saldo
     */
    public PayPal(String cuenta, double saldo) {
        this.saldo=saldo;
        this.cuenta=cuenta;
    }

    /**
     * Constructor de paypal donde el usuario no introduce el saldo y se le asigna el por defecto
     * @param cuenta
     */
    public PayPal(String cuenta) {
        this.cuenta=cuenta;
        this.saldo=saldoDefault;
    }

    /**
     * Método para validar y comprobar que el formato de la cuenta sea correcto y adecuado para un mail, además
     * de comprobar que el importe a pagar ser igual o menor al saldo de la cuenta.
     * Devuelve true/false dependiendo de si es correcto o incorrecto respectivamente los valores introducidos
     */
    private boolean validarPayPal(String cuenta, double importe) {
        System.out.println("Validando cuenta...");
        if (cuenta.matches(".*@*\\.com") && saldo >= importe) {
            return true;
        }
        System.out.println("Datos incorrectos o saldo insuficiente.");
        return false;
    }

    /**
     * Donde es ejecutado el método validarPayPal y por ende procesado el pago con el importe introducido
     * @param importe
     */
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
