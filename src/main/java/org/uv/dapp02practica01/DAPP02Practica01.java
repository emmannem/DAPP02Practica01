/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.uv.dapp02practica01;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class DAPP02Practica01 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();

        Venta ven = new Venta();
        ven.setCliente("José");
        ven.setTotal(100.00);
        ven.setFechaventa(new java.sql.Date(new Date().getTime()));

        Transaction tran = session.beginTransaction();
        session.save(ven);
        for (int i = 0; i < 5; i++) {
            DetalleVenta det = new DetalleVenta();
            det.setPrecio(10.00);
            det.setProducto("Producto " + (i + 1));
            det.setCantidad(10.00);
            det.setVenta(ven);
            // ven.getDetalleVenta().add(det);
            session.save(det);

        }

        tran.commit();
        System.out.println("Se guardo con el ID: " + ven.getIdventa());

    }
}
