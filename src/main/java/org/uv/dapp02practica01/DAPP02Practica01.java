/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.uv.dapp02practica01;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class DAPP02Practica01 {

    private static Scanner scanner = new Scanner(System.in);
    private static DAOVenta dao = new DAOVenta();

    public static void main(String[] args) {

        boolean salir = false;
        int opcion;

        while (!salir) {
            System.out.println("OPCIONES");
            System.out.println("1. Guardar Venta");
            System.out.println("2. Buscar Venta");
            System.out.println("3. Ver Ventas");
            System.out.println("4. Modificar Venta");
            System.out.println("5. Eliminar Venta");
            System.out.println("6. Salir");

            try {
                System.out.println("Ingrese una opción");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        crearVenta();
                        break;
                    case 2:
                        //buscarVenta()
                        break;
                    case 3:
                        //verVentas()
                        break;
                    case 4:
                        //modificarVenta()
                        break;
                    case 5:
                        //eliminarVenta()
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            } catch (Exception ex) {
                Logger.getLogger(DAPP02Practica01.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private static void crearVenta() {
        Venta venta = new Venta();
        System.out.println("GUARDAR VENTA");
        System.out.print("Ingrese el nombre del cliente: ");
        venta.setCliente(scanner.next());

        System.out.print("Ingrese la fecha de la venta (yyyy-mm-dd): ");
        Date fechaVenta = java.sql.Date.valueOf(scanner.next());
        venta.setFechaventa((java.sql.Date) fechaVenta);

        System.out.print("Ingrese el total de la venta: ");
        venta.setTotal(scanner.nextDouble());

        boolean continuar = true;
        while (continuar) {
            DetalleVenta detalle = new DetalleVenta();

            System.out.println("AGREGAR DETALLE DE VENTA");
            System.out.print("Ingrese el nombre del producto: ");
            String producto = scanner.next();
            detalle.setProducto(producto);

            System.out.print("Ingrese la cantidad: ");
            double cantidad = scanner.nextDouble();
            detalle.setCantidad(cantidad);

            System.out.print("Ingrese el precio: ");
            double precio = scanner.nextDouble();
            detalle.setPrecio(precio);

            venta.getDetalleVenta().add(detalle);

            System.out.print("¿Desea agregar otro detalle de venta? (S/N): ");
            String respuesta = scanner.next();
            continuar = respuesta.equalsIgnoreCase("S");
        }

        boolean res = dao.create(venta);
        if (res) {
            System.out.println("Se guardo...");
        }

    }
}
