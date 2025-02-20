package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;
import java.util.Scanner;

@ToString
public class Bizum extends  MetodoPago{
    static Random rdm = new Random();
    static Scanner in = new Scanner(System.in);

    private String telefono;
    private int pin;

    public Bizum(String telefono) {
        this.telefono=telefono;
        this.pin=generarPin();
        validarBizum(in.nextInt());
    }

    public static int generarPin() {
        int pin = rdm.nextInt(100000,999999);
        System.out.println(pin);
        return pin;
    }

    public void validarBizum(int pin) {
        System.out.println("Validando bizum...");
        if (telefono.matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]") && this.pin == pin) {
            System.out.println("Pin correcto");
        } else {
            System.out.println("Error");
            System.exit(0);
        }
    }


    @Override
    void procesarPago(double importe) {
        System.out.println("Procesando pago de " + importe + "€ con Bizum.");
    }
}
