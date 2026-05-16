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
import java.util.Stack;

/**
 *
 * @author Johan
 */
public class GestionarProductos {

    ArrayList<Producto> lista = new ArrayList<>();
    Stack<String> historial = new Stack<>();
    ArbolBinario arbol = new ArbolBinario();

    //Registrar Productos
    public boolean registrarProducto(Producto p) {
        for (Producto pro : lista) {
            if (pro.getCodigo().equals(p.getCodigo())) {
                return false;
            }
        }
        lista.add(p);
        historial.push("Registrado: "+ p.getNombre());
        arbol.insertar(p);

        return true;
    }
    
    public void mostrarHistorial(){
        for(String h : historial){
            System.out.println(h);
        }
        
    }

    public Producto buscarProducto(String codigo) {

        for (Producto p : lista) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;

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

    public void mostrarProductos() {
        for (Producto p : lista) {
            System.out.println(p);
        }
    }

    public void guardarArchivo() {
        try {
            FileWriter archivo = new FileWriter("reporte.txt");
            for (Producto p : lista) {
                archivo.write(p.toString() + "\n");
            }
            archivo.close();
            
            System.out.println("Reporte Guardado");
            
        }catch (IOException e){
            System.out.println("Error al guardar");
        }
    }
    
    public int sumaStock(int indice){
         if(indice >= lista.size()){
             return 0;
         }
         return lista.get(indice).getStock() + sumaStock(indice +1);
    }
}
