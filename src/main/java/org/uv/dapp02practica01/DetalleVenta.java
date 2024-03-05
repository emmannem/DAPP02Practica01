/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.dapp02practica01;

import javax.persistence.*;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "detalleventa")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "detalleventa_idventa_seq")
    @SequenceGenerator(name = "detalleventa_idventa_seq",
            sequenceName = "detalleventa_idventa_seq",
            allocationSize = 1,
            initialValue = 1)
    @Column(name = "idlinea")
    private long idlinea;
    @Column(name = "cantidad")
    private double cantidad;
    @Column(name = "precio")
    private double precio;
    @Column(name = "producto")
    private String producto;

    @ManyToOne
    @JoinColumn(name = "idventa")
    private Venta venta;

    /**
     * @return the venta
     */
    public Venta getVenta() {
        return venta;
    }

    /**
     * @param venta the venta to set
     */
    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    /**
     * @return the idlinea
     */
    public long getIdlinea() {
        return idlinea;
    }

    /**
     * @param idlinea the idlinea to set
     */
    public void setIdlinea(long idlinea) {
        this.idlinea = idlinea;
    }

    /**
     * @return the cantidad
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the producto
     */
    public String getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }
}
