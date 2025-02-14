package org.example;

import java.util.Scanner;

public class Tienda {

    static Scanner in = new Scanner(System.in);

    static void realizarPago(MetodoPago metodo, double importe) {
        metodo.procesarPago(importe);
    }

   static void iniciarPago() {
       System.out.println("¿Qué método de pago quieres usar? [Bizum,PayPal,tarjeta]:");
       do {
           switch (in.next()) {
               case "Bizum":
                   MetodoPago bizum = new Bizum();
               case "PayPal":
                   MetodoPago paypal = new PayPal();
               case "Tarjeta":
                   MetodoPago tarjeta = new TarjetaCredito();
               default:
                   System.out.println("Introduce de nuevo:");
           }
       } while (1=1);
   }

}
