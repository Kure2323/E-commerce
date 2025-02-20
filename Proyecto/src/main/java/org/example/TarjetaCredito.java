package org.example;


import lombok.ToString;

@ToString
public class TarjetaCredito extends MetodoPago{


    private String nro_tarjeta;
    private String tipo;

    /**
     * 
     * @param nro_tarjeta
     * @param tipo
     */
    public TarjetaCredito(String nro_tarjeta, String tipo) {
        this.nro_tarjeta=nro_tarjeta;
        this.tipo=tipo;
        validarTarjeta(nro_tarjeta, tipo);
    }

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



    @Override
    void procesarPago(double importe) {
        System.out.println("Procesando pago de " + importe + "€ con tarjeta de crédito VISA.");
    }
}
