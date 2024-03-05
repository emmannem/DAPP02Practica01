/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.dapp02practica01;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "venta_idventa_seq")
    @SequenceGenerator(name = "venta_idventa_seq",
            sequenceName = "venta_idventa_seq",
            allocationSize = 1,
            initialValue = 1)
    @Column(name = "idventa")
    private long idventa;

    @Column(name = "cliente")
    private String cliente;
    @Column(name = "fechaventa")
    private Date fechaventa;
    @Column(name = "total")
    private double total;

    //@OneToMany(mappedBy = "venta")
    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleVenta> detalleVenta;

    public Venta() {
        detalleVenta = new ArrayList<>();
    }

    /**
     * @return the detalleVenta
     */
    public List<DetalleVenta> getDetalleVenta() {
        return detalleVenta;
    }

    /**
     * @param detalleVenta the detalleVenta to set
     */
    public void setDetalleVenta(List<DetalleVenta> detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    /**
     * @return the idventa
     */
    public long getIdventa() {
        return idventa;
    }

    /**
     * @param idventa the idventa to set
     */
    public void setIdventa(long idventa) {
        this.idventa = idventa;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the fechaventa
     */
    public Date getFechaventa() {
        return fechaventa;
    }

    /**
     * @param fechaventa the fechaventa to set
     */
    public void setFechaventa(Date fechaventa) {
        this.fechaventa = fechaventa;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

}
