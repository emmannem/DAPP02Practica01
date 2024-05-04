/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.dapp02practica01;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author LENOVO
 */
public class DAOVenta implements IDAO<Venta> {

    @Override
    public boolean create(Venta p) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tran = null;
        try {
            tran = session.beginTransaction();
            session.save(p);
            for (DetalleVenta det : p.getDetalleVenta()) {

                session.save(det);
            }
            tran.commit();
            System.out.println("Se guardó la venta con el ID: " + p.getIdventa());
            return true;
        } catch (Exception ex) {
            if (tran != null) {
                tran.rollback();
            }
            Logger.getLogger(DAOVenta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public boolean update(Venta p) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tran = null;
        try {
            tran = session.beginTransaction();
            session.update(p);
            for (DetalleVenta det : p.getDetalleVenta()) {
                session.update(det);
            }
            tran.commit();
            System.out.println("Se actualizó la venta con el ID: " + p.getIdventa());
            return true;
        } catch (Exception ex) {
            if (tran != null) {
                tran.rollback();
            }
            Logger.getLogger(DAOVenta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public boolean delete(Venta p) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tran = null;
        try {
            tran = session.beginTransaction();
            session.delete(p);
            tran.commit();
            System.out.println("Se eliminó la venta con el ID: " + p.getIdventa());
            return true;
        } catch (Exception ex) {
            if (tran != null) {
                tran.rollback();

            }
            Logger.getLogger(DAOVenta.class
                    .getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Venta readByID(long id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tran = null;
        Venta venta = null;
        try {
            tran = session.beginTransaction();
            venta = session.get(Venta.class, id);
            tran.commit();
        } catch (Exception ex) {
            if (tran != null) {
                tran.rollback();

            }
            Logger.getLogger(DAOVenta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return venta;
    }

    @Override
    public List<Venta> readAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tran = null;
        List<Venta> ventas = null;
        try {
            tran = session.beginTransaction();
            ventas = session.createQuery("FROM Venta", Venta.class).list();
            tran.commit();
        } catch (Exception ex) {
            if (tran != null) {
                tran.rollback();

            }
            Logger.getLogger(DAOVenta.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return ventas;
    }

}
