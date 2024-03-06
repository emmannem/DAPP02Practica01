/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.dapp02practica01;

import java.util.List;

/**
 *
 * @author LENOVO
 * @param <T>
 */
public interface IDAO<T> {

    public boolean create(T p);

    public boolean update(T p);

    public boolean delete(T p);

    public T readByID(long id);

    public List<T> readAll();
}
