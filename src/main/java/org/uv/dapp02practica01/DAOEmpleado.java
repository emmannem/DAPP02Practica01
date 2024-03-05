/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.dapp02practica01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class DAOEmpleado implements IDAO<PojoEmpleado> {

    private Connection connection;

    public DAOEmpleado() {
        connection = ConexionDB.getInstance().getConnection();
    }

    @Override
    public boolean create(PojoEmpleado p) {
        try ( PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO empleadotemporal (nombre, direccion, telefono) VALUES (?, ?, ?)")) {
            statement.setString(1, p.getNombre());
            statement.setString(2, p.getDireccion());
            statement.setString(3, p.getTelefono());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean update(PojoEmpleado p) {
        try (PreparedStatement statement = connection.prepareStatement(
                "UPDATE empleadotemporal SET nombre=?, direccion=?, telefono=? WHERE id=?")) {
            statement.setString(1, p.getNombre());
            statement.setString(2, p.getDireccion());
            statement.setString(3, p.getTelefono());
            statement.setInt(4, p.getId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(PojoEmpleado p) {
        try (PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM empleadotemporal WHERE id=?")) {
            statement.setInt(1, p.getId());

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public PojoEmpleado readByID(int id) {
        PojoEmpleado empleado = null;
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM empleadotemporal WHERE id=?")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                empleado = new PojoEmpleado();
                empleado.setId(resultSet.getInt("id"));
                empleado.setNombre(resultSet.getString("nombre"));
                empleado.setDireccion(resultSet.getString("direccion"));
                empleado.setTelefono(resultSet.getString("telefono"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empleado;
    }

    @Override
    public List<PojoEmpleado> readAll() {
        List<PojoEmpleado> empleados = new ArrayList<>();
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(
                "SELECT * FROM empleadotemporal")) {
            while (resultSet.next()) {
                PojoEmpleado empleado = new PojoEmpleado();
                empleado.setId(resultSet.getInt("id"));
                empleado.setNombre(resultSet.getString("nombre"));
                empleado.setDireccion(resultSet.getString("direccion"));
                empleado.setTelefono(resultSet.getString("telefono"));
                empleados.add(empleado);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empleados;
    }

}
