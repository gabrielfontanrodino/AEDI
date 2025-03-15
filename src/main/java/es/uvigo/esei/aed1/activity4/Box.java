/*
 * The MIT License
 *
 * Copyright 2025 Escola Superior de Enxeñaría Informática - Universidade de Vigo.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package es.uvigo.esei.aed1.activity4;

/**
 *
 * Interfaz que define una caja genérica que puede contener elementos de tipo T.
 *
 * @param <T> el tipo de elementos que la caja puede contener
 *
 * @autor gfrodinho_esei.uvigo
 */
public interface Box<T> {
    /**
     * Añade un valor a la caja.
     *
     * @param value el valor a añadir
     * @throws NullPointerException si el valor es null
     */
    void add(T value) throws NullPointerException;

    /**
     * Añade todos los elementos de otra caja a esta caja.
     *
     * @param box la caja cuyos elementos se van a añadir
     * @throws NullPointerException si la caja es null
     */
    void addBox(Box<T> box) throws NullPointerException;

    /**
     * Elimina un valor de la caja.
     *
     * @param value el valor a eliminar
     * @return true si el valor fue eliminado, false en caso contrario
     */
    boolean remove(T value);

    /**
     * Obtiene un valor de la caja.
     *
     * @return el valor obtenido
     * @throws EmptyException si la caja está vacía
     */
    T get() throws EmptyException;

    /**
     * Devuelve el número de elementos en la caja.
     *
     * @return el tamaño de la caja
     */
    int size();
}