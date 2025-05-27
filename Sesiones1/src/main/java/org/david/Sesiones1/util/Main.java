package org.david.Sesiones1.util;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Intentando conectar a la base de datos...");
        try (Connection conn = Conexion.getConnection()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("Conexión exitosa a la base de datos.");
                System.out.println("URL: " + conn.getMetaData().getURL());
                System.out.println("Usuario: " + conn.getMetaData().getUserName());
                System.out.println("Base de datos: " + conn.getCatalog());
            }
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos:");
            System.err.println("Mensaje: " + e.getMessage());
            System.err.println("Código de error SQL: " + e.getSQLState());
            e.printStackTrace();
        }
    }
}
