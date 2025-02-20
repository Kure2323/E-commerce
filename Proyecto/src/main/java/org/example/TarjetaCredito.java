package org.example;


import lombok.ToString;

@ToString
public class TarjetaCredito extends MetodoPago{


    private String nro_tarjeta;
    private String tipo;

    /**
     * Constructor de la Tarjeta donde además seguidamente es validada la terjeta
     * @param nro_tarjeta
     * @param tipo
     */
    public TarjetaCredito(String nro_tarjeta, String tipo) {
        this.nro_tarjeta=nro_tarjeta;
        this.tipo=tipo;
        validarTarjeta(nro_tarjeta, tipo);
    }

    /**
     * Método para validar los atributos de la tarjeta, donde el número deben ser 16 números
     * y el tipo: visa, mastercard o maestro.
     * En caso de no ser correcto alguno de los atributos se sale del programa
     * con un mensaje de datos incorrectos
     * @param nro_tarjeta
     * @param tipo
     */
    private void validarTarjeta(String nro_tarjeta, String tipo) {
        System.out.println("Validando tarjeta...");
        if (nro_tarjeta.matches("\\d{16}") &&
                (tipo.equalsIgnoreCase("visa") ||
                        tipo.equalsIgnoreCase("mastercard") ||
                        tipo.equalsIgnoreCase("maestro"))) {
            return;
        }
        System.out.println("Los datos de tu tarjeta no son correctos.");
        System.exit(0);
    }


    /**
     * Método de la madre donde se muestra por pantalla el pago con su importe introducido
     * @param importe
     */
    @Override
    void procesarPago(double importe) {
        System.out.println("Procesando pago de " + importe + "€ con tarjeta de crédito VISA.");
    }
}
