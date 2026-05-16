/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.examen;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Johan
 */
public class GestionarProductos {

    ArrayList<Producto> lista = new ArrayList<>();
    Stack<String> historial = new Stack<>();
    Queue<Producto> colaVentas = new LinkedList<>();
    ArbolBinario arbol = new ArbolBinario();

    public boolean registrarProducto(Producto p) {

        for (Producto pro : lista) {
            if (pro.getCodigo().equals(p.getCodigo())) {
                return false;
            }
        }

        lista.add(p);
        historial.push("Registrado: " + p.getCodigo() + " - " + p.getNombre());
        arbol.insertar(p);

        return true;
    }

    public Producto buscarProducto(String codigo) {
        for (Producto p : lista) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

    public void mostrarProductos() {
        for (Producto p : lista) {
            System.out.println(p);
        }
    }

    public void ordenarPorNombre() {
        Collections.sort(lista, Comparator.comparing(Producto::getNombre));
        mostrarProductos();
    }

    public void ordenarPorPrecio() {
        Collections.sort(lista, Comparator.comparing(Producto::getPrecio));
        mostrarProductos();
    }

    public void ordenarPorStock() {
        Collections.sort(lista, Comparator.comparing(Producto::getStock));
        mostrarProductos();
    }

    public void venderProducto(String codigo, int cantidad) {
        for (Producto p : lista) {
            if (p.getCodigo().equals(codigo)) {

                if (p.getStock() >= cantidad) {
                    p.setStock(p.getStock() - cantidad);
                    colaVentas.add(p);
                    historial.push("Venta: " + p.getNombre());
                    System.out.println("Venta realizada");
                } else {
                    System.out.println("Stock insuficiente");
                }
                return;
            }
        }
        System.out.println("Producto no encontrado");
    }

    public void mostrarHistorial() {
        for (String h : historial) {
            System.out.println(h);
        }
    }

    public void guardarArchivo() {
        try {
            FileWriter archivo = new FileWriter("reporte.txt", true);

            for (Producto p : lista) {
                archivo.write(p.toString() + "\n");
            }

            archivo.close();
            System.out.println("Reporte guardado");

        } catch (IOException e) {
            System.out.println("Error al guardar");
        }
    }

    public int sumaStock(int indice) {
        if (indice >= lista.size()) {
            return 0;
        }
        return lista.get(indice).getStock() + sumaStock(indice + 1);
    }
}
