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

    /**
     * Constructor de Bizum, donde se genera también el pin y seguidamente se valida el objeto
     * @param telefono
     */
    public Bizum(String telefono) {
        this.telefono=telefono;
        this.pin=generarPin();
        validarBizum(in.nextInt());
    }

    /**
     * Método para generar el pin del bizum, además como trampita se muestra por pantalla para poder acertarlo :)
     * @return
     */
    public static int generarPin() {
        int pin = rdm.nextInt(100000,999999);
        System.out.println(pin);
        return pin;
    }

    /**
     * Método para validar tanto el formato del teléfono, el cual deben ser 9 números y comprueba que el pin
     * introducido es correcto, en caso de no ser correcto sale del programa.
     * @param pin
     */
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
