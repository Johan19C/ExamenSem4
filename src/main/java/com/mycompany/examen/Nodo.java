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
public class Nodo {

    Producto producto;
    Nodo izquierda;
    Nodo derecha;

    public Nodo(Producto producto) {
        this.producto = producto;
        this.izquierda = null;
        this.derecha = null;
    }

}
