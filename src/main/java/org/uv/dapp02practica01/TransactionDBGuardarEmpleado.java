/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.dapp02practica01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class TransactionDBGuardarEmpleado extends TransactionDB<PojoEmpleado> {

    public TransactionDBGuardarEmpleado(PojoEmpleado pojo) {
        super(pojo);
    }

    @Override
    public boolean execute(Connection con) {
        try {
            String sql = "insert into empleadotemporal (nombre, direccion, telefono)  values(?,?,?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, pojo.getNombre());
            pstm.setString(2, pojo.getDireccion());
            pstm.setString(3, pojo.getTelefono());
            pstm.execute();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
