/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.uv.dapp02practica01;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.Date;
import java.util.List;
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
                        guardarVenta();
                        break;
                    case 2:
                        buscarVenta();
                        break;
                    case 3:
                        //verVentas()
                        break;
                    case 4:
                        modificarVenta();
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

    private static void guardarVenta() {
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
            detalle.setProducto(scanner.next());

            System.out.print("Ingrese la cantidad: ");
            detalle.setCantidad(scanner.nextDouble());

            System.out.print("Ingrese el precio: ");
            detalle.setPrecio(scanner.nextDouble());

            detalle.setVenta(venta);
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

    private static void modificarVenta() {
        System.out.println("MODIFICAR VENTA");
        System.out.print("Ingrese el ID de la venta que desea modificar: ");
        int idVenta = scanner.nextInt();
        Venta venta = dao.readByID(idVenta);
        if (venta != null) {
            System.out.print("Ingrese el nuevo nombre del cliente: ");
            venta.setCliente(scanner.next());

            System.out.print("Ingrese la nueva fecha de la venta (yyyy-mm-dd): ");
            Date fechaVenta = java.sql.Date.valueOf(scanner.next());
            venta.setFechaventa((java.sql.Date) fechaVenta);

            System.out.print("Ingrese el nuevo total de la venta: ");
            venta.setTotal(scanner.nextDouble());

            boolean resultado = dao.update(venta);
            if (resultado) {
                System.out.println("La venta ha sido modificada con éxito.");
            } else {
                System.out.println("Error al modificar la venta.");
            }
        } else {
            System.out.println("No se encontró ninguna venta con ese ID.");
        }
    }

    private static void buscarVenta() {
        System.out.println("BUSCAR VENTA");
        System.out.print("Ingrese el ID de la venta a buscar: ");
        int idVenta = scanner.nextInt();
        Venta ventaEncontrada = dao.readByID(idVenta);
        if (ventaEncontrada != null) {
            System.out.println("Venta encontrada:");
            System.out.println("ID: " + ventaEncontrada.getIdventa());
            System.out.println("Cliente: " + ventaEncontrada.getCliente());
            System.out.println("Fecha de Venta: " + ventaEncontrada.getFechaventa());
            System.out.println("Total: " + ventaEncontrada.getTotal());

            if (!ventaEncontrada.getDetalleVenta().isEmpty()) {
                System.out.println("Detalle de Venta:");
                for (DetalleVenta detalle : ventaEncontrada.getDetalleVenta()) {
                    System.out.println("Producto: " + detalle.getProducto());
                    System.out.println("Cantidad: " + detalle.getCantidad());
                    System.out.println("Precio: " + detalle.getPrecio());
                }
            } else {
                System.out.println("No hay detalles de venta para esta venta.");
            }
        } else {
            System.out.println("Venta no encontrada.");
        }
    }
}
