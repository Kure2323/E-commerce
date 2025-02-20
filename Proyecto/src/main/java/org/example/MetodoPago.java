package org.example;

abstract class MetodoPago {

    /**
     * Método que va a estar en todas las clases que extiendan de esta.
     * @param importe
     */
    abstract void procesarPago(double importe);

}
