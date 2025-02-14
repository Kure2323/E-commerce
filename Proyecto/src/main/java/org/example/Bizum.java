package org.example;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;
@ToString @Setter @NoArgsConstructor
public class Bizum extends  MetodoPago{
    Random rdm = new Random();

    private String telefono;
    private int pin;

    public Bizum(String telefono, int pin) {

    }

    private int generarPin() {
        return rdm.nextInt(100000,999999);
    }

    private void validarBizum() {

    }


    @Override
    void procesarPago(double importe) {
        System.out.println("Procesando pago de " + importe + "€ con Bizum.");
    }
}
