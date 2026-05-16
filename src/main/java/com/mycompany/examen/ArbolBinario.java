/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.examen;

/**
 *
 * @author Johan
 */
public class ArbolBinario {

    Nodo raiz;

    public void insertar(Producto producto) {
        raiz = insertarRec(raiz, producto);
    }

    private Nodo insertarRec(Nodo raiz, Producto producto) {

        if (raiz == null) {
            return new Nodo(producto);
        }

        if (producto.getCodigo().equals(raiz.producto.getCodigo())) {
            return raiz; // evitar duplicados
        }

        if (producto.getCodigo().compareTo(raiz.producto.getCodigo()) < 0) {
            raiz.izquierda = insertarRec(raiz.izquierda, producto);
        } else {
            raiz.derecha = insertarRec(raiz.derecha, producto);
        }

        return raiz;
    }

    public void mostrarOrden() {
        if (raiz == null) {
            System.out.println("Árbol vacío");
        } else {
            inOrden(raiz);
        }
    }

    private void inOrden(Nodo raiz) {
        if (raiz != null) {
            inOrden(raiz.izquierda);
            System.out.println(raiz.producto);
            inOrden(raiz.derecha);
        }
    }

}
