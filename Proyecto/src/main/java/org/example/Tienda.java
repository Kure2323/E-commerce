package org.example;

import java.util.Scanner;

public class Tienda {

    static Scanner in = new Scanner(System.in);

    static void realizarPago(MetodoPago metodo, double importe) {
        metodo.procesarPago(importe);
    }

   static void iniciarPago() {
       System.out.println("¿Qué método de pago quieres usar? [Bizum,PayPal,tarjeta]:");
       patata:
       while (true) {
           String entrada = in.nextLine().toLowerCase();
           switch (entrada) {
               case "bizum":
                   procesoBizum();
                   break patata;
               case "paypal":
                   procesoPayPal();
                   break patata;
               case "tarjeta":
                   procesoTarjeta();
                   break patata;
               default:
                   System.out.println("Introduce de nuevo el tipo de pago:");
           }
       }
   }

   private static void procesoTarjeta() {
       System.out.println("Introduce los datos de tu tarjeta:");
       System.out.println("Número (16 dígitos):");
       String nro_tarjeta = in.next();
       System.out.println("tipo (VISA o MASTERCARD):");
       String tipo = in.next().toUpperCase();
       MetodoPago tarjeta = new TarjetaCredito(nro_tarjeta, tipo);
       System.out.println("Introduce el importe a pagar:");
       realizarPago(tarjeta, in.nextDouble());
   }

   private static void procesoBizum() {
       System.out.println("Introduzca su número de teléfono:");
       String telefono = in.next();
       System.out.println("Introduzca el pin:");
       MetodoPago bizum = new Bizum(telefono);
       System.out.println("Introduce el importe a pagar:");
       realizarPago(bizum, in.nextDouble());
   }

   private static void procesoPayPal() {
       System.out.println("Introduzca mail asociado a la cuenta:");
       String cuenta = in.next();
       System.out.println("¿Quiere introducir el saldo? (S/N)");
       if (in.next().equalsIgnoreCase("S")) {
           System.out.println("Introduzca su saldo:");
           MetodoPago paypal = new PayPal(cuenta, in.nextDouble());
           System.out.println("Introduzca el importe a pagar:");
           realizarPago(paypal,in.nextDouble());
       } else {
           MetodoPago paypal = new PayPal(cuenta);
           System.out.println("Introduzca el importe a pagar:");
           realizarPago(paypal, in.nextDouble());
       }
   }

}
