package org.example;

import java.util.Scanner;

public class Tienda {

    static Scanner in = new Scanner(System.in);

    /**
     * Método por donde pasan todos los métodos de pago, es decir, las clases hijas formadas por polimorfismo
     * y donde se realiza el pago (llama a procesar pago de cada hija)
     * @param metodo
     * @param importe
     */
    static void realizarPago(MetodoPago metodo, double importe) {
        metodo.procesarPago(importe);
    }

    /**
     * Método donde inicia todo el proceso, donde el usuario elige el método de pago y a partir de ahí
     * se distribuye a cada método con un switch-case, en caso de no introducir uno de los anteriores
     * vuelve a preguntar el tipo de pago.
     * Cada clase hija tiene su propio método para su proceso de pago
     */
   static void iniciarPago() {
       System.out.println("¿Qué método de pago quieres usar? [Bizum, PayPal, Tarjeta]:");
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

    /**
     * Donde se desarrolla el proceso entero de pedir datos y crear el objeto de tarjeta de crédito
     */
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

    /**
     * Método donde se desarrolla el proceso de introducir los datos de un bizum
     * y la creación del objeto de dicho método de pago
     */
   private static void procesoBizum() {
       System.out.println("Introduzca su número de teléfono:");
       String telefono = in.next();
       System.out.println("Introduzca el pin:");
       MetodoPago bizum = new Bizum(telefono);
       System.out.println("Introduce el importe a pagar:");
       realizarPago(bizum, in.nextDouble());
   }

    /**
     * Método donde es desarrollado el proceso de introducción de datos y creación del objeto de paypal
     * En este al haber poder introducir o no el saldo, debe ser preguntado si se quiere introducir o no,
     * por ello se ha realizado un if-else para cada caso
     */
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
