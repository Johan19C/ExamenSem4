/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.examen;

import java.util.Scanner;

/**
 *
 * @author Johan
 */
public class InventarioProducto {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GestionarProductos gp = new GestionarProductos();

        int opcion;

        do {

            System.out.println("\n==== MENU ====");
            System.out.println("1. Registrar producto");
            System.out.println("2. Buscar producto");
            System.out.println("3. Mostrar productos");
            System.out.println("4. Ordenar por nombre");
            System.out.println("5. Ordenar por precio");
            System.out.println("6. Ordenar por stock");
            System.out.println("7. Suma total de productos");
            System.out.println("8. Mostrar Arbol");
            System.out.println("9. Guardar archivo");
            System.out.println("10. Ver Historial");
            System.out.println("11. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese codigo: ");
                    String codigo = scanner.nextLine();

                    System.out.println("Ingrese Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.println("Ingrese Categoria: ");
                    String categoria = scanner.nextLine();

                    System.out.println("Ingrese precio: ");
                    double precio = scanner.nextDouble();

                    System.out.println("Ingrese Stock: ");
                    int stock = scanner.nextInt();

                    if (nombre.isEmpty()) {
                        System.out.println("Ingresar nombre");
                        break;
                    }
                    if (precio <= 0) {
                        System.out.println("precio no valido ");
                        break;
                    }

                    if (stock < 0) {
                        System.out.println("Stock no valido");
                        break;
                    }
                    Producto p = new Producto(codigo, nombre, categoria, precio, stock);

                    if (gp.registrarProducto(p)) {
                        System.out.println("Producto Registrado");

                    } else {
                        System.out.println("Codigo repetido");
                    }
                    break;
                case 2:

                    System.out.println("Ingrese el codigo: ");
                    String cod = scanner.nextLine();

                    Producto encontrado = gp.buscarProducto(cod);

                    if (encontrado != null) {
                        System.out.println(encontrado);
                    } else {
                        System.out.println("No se encontro");
                    }
                    break;
                case 3:
                    gp.mostrarProductos();
                    break;
                case 4:
                    gp.ordenarPorNombre();
                    break;
                case 5:
                    gp.ordenarPorPrecio();
                    break;
                case 6:
                    gp.ordenarPorStock();
                    break;
                case 7:
                    System.out.println("Total Suma del Stock: " + gp.sumaStock(0));
                    break;
                case 8:
                    gp.arbol.mostrarOrden();
                    break;
                case 9:
                    gp.guardarArchivo();
                    break;
                case 10:
                    gp.mostrarHistorial();
                    break;
                case 11:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Opcion Invalida");
            }

        } while (opcion != 0);

    }

}
