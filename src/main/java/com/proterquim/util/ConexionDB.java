/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proterquim.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {

    private static final String URL =
        "jdbc:mysql://localhost:3306/proterquim_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "Jacobog#2417"; // o tu contraseña

    public static Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("✅ Conexión exitosa a la BD");
            return con;
        } catch (Exception e) {
            System.out.println("❌ Error en conexión BD");
            e.printStackTrace();
            return null;
        }   
    }
    public static void main(String[] args) {
    Connection c = getConexion();
    System.out.println("Conexion desde main: " + c);
}

}


