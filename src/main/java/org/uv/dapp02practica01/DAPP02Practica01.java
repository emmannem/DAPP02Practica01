/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.uv.dapp02practica01;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class DAPP02Practica01 {

    public static void main(String[] args) {
        // ConexionDB con = ConexionDB.getInstance();

        SessionFactory sf = HibernateUtil.getSessionFactory();
//        PojoEmpleado empleado = new PojoEmpleado();
//        empleado.setNombre("José Martínez");
//        empleado.setDireccion("AV. 111");
//        empleado.setTelefono("999");
//
        Session session = sf.getCurrentSession();
//        Transaction tran = session.beginTransaction();
//        session.save(empleado);
//        tran.commit();

          Transaction tran = session.beginTransaction();
          PojoEmpleado emp1 = session.get(PojoEmpleado.class, 1);
          PojoEmpleado emp2 = session.load(PojoEmpleado.class, 1);
          
          tran.commit();
          if (emp2!=null) {
              System.out.println("Nombre "+ emp2.getNombre());
        } else {
              System.out.println("No encontro");
          }
          
//        System.out.println("Se guardo con el ID: " + empleado.getId());

//        PojoEmpleado empleado = new PojoEmpleado();
//        empleado.setNombre("José Emmanuel");
//        empleado.setDireccion("AV. 00");
//        empleado.setTelefono("54321109876");
//
//        DAOEmpleado dao = new DAOEmpleado();
//        boolean res = dao.create(empleado);
//        if (res) {
//            System.out.println("Se guardo...");
//        }
//        Scanner scanner = new Scanner(System.in);
//        DAOEmpleado daoEmpleado = new DAOEmpleado();
//
//        int opcion;
//        do {
//            System.out.println("Menú:");
//            System.out.println("1. Crear empleado");
//            System.out.println("2. Actualizar empleado");
//            System.out.println("3. Eliminar empleado");
//            System.out.println("4. Buscar empleado por ID");
//            System.out.println("5. Listar todos los empleados");
//            System.out.println("0. Salir");
//            System.out.print("Ingrese su opción: ");
//            opcion = scanner.nextInt();
//
//            switch (opcion) {
//                case 1:
//                    crearEmpleado(scanner, daoEmpleado);
//                    break;
//                case 2:
//                    actualizarEmpleado(scanner, daoEmpleado);
//                    break;
//                case 3:
//                    eliminarEmpleado(scanner, daoEmpleado);
//                    break;
//                case 4:
//                    buscarEmpleadoPorID(scanner, daoEmpleado);
//                    break;
//                case 5:
//                    listarEmpleados(daoEmpleado);
//                    break;
//                case 0:
//                    System.out.println("Saliendo del programa...");
//                    break;
//                default:
//                    System.out.println("Opción no válida. Intente de nuevo.");
//            }
//        } while (opcion != 0);
//
//        scanner.close();
    }

//    private static void crearEmpleado(Scanner scanner, DAOEmpleado daoEmpleado) {
//        System.out.println("Ingrese el nombre del empleado:");
//        String nombre = scanner.next();
//        System.out.println("Ingrese la dirección del empleado:");
//        String direccion = scanner.next();
//        System.out.println("Ingrese el teléfono del empleado:");
//        String telefono = scanner.next();
//
//        PojoEmpleado nuevoEmpleado = new PojoEmpleado();
//        nuevoEmpleado.setNombre(nombre);
//        nuevoEmpleado.setDireccion(direccion);
//        nuevoEmpleado.setTelefono(telefono);
//
//        boolean exito = daoEmpleado.create(nuevoEmpleado);
//        if (exito) {
//            System.out.println("Empleado creado exitosamente.");
//        } else {
//            System.out.println("Error al crear el empleado.");
//        }
//    }
//
//    private static void actualizarEmpleado(Scanner scanner, DAOEmpleado daoEmpleado) {
//        System.out.println("Ingrese el ID del empleado que desea actualizar:");
//        int id = scanner.nextInt();
//        PojoEmpleado empleadoExistente = daoEmpleado.readByID(id);
//
//        if (empleadoExistente != null) {
//            System.out.println("Ingrese el nuevo nombre del empleado:");
//            String nombre = scanner.next();
//            System.out.println("Ingrese la nueva dirección del empleado:");
//            String direccion = scanner.next();
//            System.out.println("Ingrese el nuevo teléfono del empleado:");
//            String telefono = scanner.next();
//
//            empleadoExistente.setNombre(nombre);
//            empleadoExistente.setDireccion(direccion);
//            empleadoExistente.setTelefono(telefono);
//
//            boolean exito = daoEmpleado.update(empleadoExistente);
//            if (exito) {
//                System.out.println("Empleado actualizado exitosamente.");
//            } else {
//                System.out.println("Error al actualizar el empleado.");
//            }
//        } else {
//            System.out.println("Empleado no encontrado.");
//        }
//    }
//
//    private static void eliminarEmpleado(Scanner scanner, DAOEmpleado daoEmpleado) {
//        System.out.println("Ingrese el ID del empleado que desea eliminar:");
//        int id = scanner.nextInt();
//        PojoEmpleado empleadoExistente = daoEmpleado.readByID(id);
//
//        if (empleadoExistente != null) {
//            boolean exito = daoEmpleado.delete(empleadoExistente);
//            if (exito) {
//                System.out.println("Empleado eliminado exitosamente.");
//            } else {
//                System.out.println("Error al eliminar el empleado.");
//            }
//        } else {
//            System.out.println("Empleado no encontrado.");
//        }
//    }
//
//    private static void buscarEmpleadoPorID(Scanner scanner, DAOEmpleado daoEmpleado) {
//        System.out.println("Ingrese el ID del empleado que desea buscar:");
//        int id = scanner.nextInt();
//        PojoEmpleado empleado = daoEmpleado.readByID(id);
//
//        if (empleado != null) {
//            System.out.println("Empleado encontrado:");
//            System.out.println("ID: " + empleado.getId());
//            System.out.println("Nombre: " + empleado.getNombre());
//            System.out.println("Dirección: " + empleado.getDireccion());
//            System.out.println("Teléfono: " + empleado.getTelefono());
//        } else {
//            System.out.println("Empleado no encontrado.");
//        }
//    }
//
//    private static void listarEmpleados(DAOEmpleado daoEmpleado) {
//        List<PojoEmpleado> empleados = daoEmpleado.readAll();
//
//        if (!empleados.isEmpty()) {
//            System.out.println("Lista de empleados:");
//            for (PojoEmpleado empleado : empleados) {
//                System.out.println("ID: " + empleado.getId());
//                System.out.println("Nombre: " + empleado.getNombre());
//                System.out.println("Dirección: " + empleado.getDireccion());
//                System.out.println("Teléfono: " + empleado.getTelefono());
//                System.out.println("--------------------");
//            }
//        } else {
//            System.out.println("No hay empleados registrados.");
//        }
//    }
}
