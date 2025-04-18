package es.uvigo.esei.aed1.activity7;

import java.util.Objects;

/**
 * Representa una terna que contiene un valor y dos números enteros asociados.
 *
 * @param <T> el tipo del valor contenido en la terna
 */
public class Terna<T> {
    private final T value;
    private final int numTimes1, numTimes2;

    /**
     * Crea una nueva instancia de Terna con el valor y los números especificados.
     *
     * @param t  el valor de tipo T contenido en la terna
     * @param n1 el primer número asociado
     * @param n2 el segundo número asociado
     */
    public Terna(T t, int n1, int n2) {
        value = t;
        numTimes1 = n1;
        numTimes2 = n2;
    }

    /**
     * Obtiene el valor contenido en la terna.
     *
     * @return el valor de tipo T contenido en la terna
     */
    public T getValue() {
        return value;
    }

    /**
     * Compara esta terna con otro objeto para determinar si son iguales.
     * Dos ternas son iguales si tienen el mismo valor y los mismos números asociados.
     *
     * @param o el objeto a comparar
     * @return true si las ternas son iguales, false en caso contrario
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof Terna) {
            Terna<T> t = (Terna<T>) o;
            return this.value.equals(t.value) && this.numTimes1 == t.numTimes1 && this.numTimes2 == t.numTimes2;

        }
        return false;

    }

    /**
     * Calcula el código hash de esta terna basado en su valor y números asociados.
     *
     * @return el código hash de la terna
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(this.value) + this.numTimes1 + this.numTimes2;
    }
}