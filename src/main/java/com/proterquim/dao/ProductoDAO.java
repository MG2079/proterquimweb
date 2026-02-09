/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proterquim.dao;

import com.proterquim.modelo.Producto;
import com.proterquim.util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    // =========================
    // CREATE
    // =========================
    public boolean insertarProducto(Producto producto) {

        String sql = "INSERT INTO producto (nombre, descripcion, precio, id_categoria, id_proveedor) "
                   + "VALUES (?, ?, ?, ?, ?)";

        Connection con = ConexionDB.getConexion();

        if (con == null) {
            System.out.println("❌ Conexión NULL en insertarProducto()");
            return false;
        }

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getIdCategoria());
            ps.setInt(5, producto.getIdProveedor());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar producto");
            e.printStackTrace();
            return false;
        }
    }

    // =========================
    // READ
    // =========================
    public List<Producto> listarProductos() {

        List<Producto> lista = new ArrayList<>();

        String sql = "SELECT id_producto, nombre, descripcion, precio, id_categoria, id_proveedor "
                   + "FROM producto";

        Connection con = ConexionDB.getConexion();

        if (con == null) {
            System.out.println("❌ Conexión NULL en listarProductos()");
            return lista;
        }

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Producto producto = new Producto();

                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setIdCategoria(rs.getInt("id_categoria"));
                producto.setIdProveedor(rs.getInt("id_proveedor"));

                lista.add(producto);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al listar productos");
            e.printStackTrace();
        }

        return lista;
    }

    // =========================
    // UPDATE
    // =========================
    public boolean actualizarProducto(Producto producto) {

        String sql = "UPDATE producto SET nombre = ?, descripcion = ?, precio = ?, "
                   + "id_categoria = ?, id_proveedor = ? "
                   + "WHERE id_producto = ?";

        Connection con = ConexionDB.getConexion();

        if (con == null) {
            System.out.println("❌ Conexión NULL en actualizarProducto()");
            return false;
        }

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getIdCategoria());
            ps.setInt(5, producto.getIdProveedor());
            ps.setInt(6, producto.getIdProducto());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar producto");
            e.printStackTrace();
            return false;
        }
    }

    // =========================
    // DELETE
    // =========================
    public boolean eliminarProducto(int idProducto) {

        String sql = "DELETE FROM producto WHERE id_producto = ?";

        Connection con = ConexionDB.getConexion();

        if (con == null) {
            System.out.println("❌ Conexión NULL en eliminarProducto()");
            return false;
        }

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idProducto);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar producto");
            e.printStackTrace();
            return false;
        }
    }
}





