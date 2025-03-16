/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import BD.Conexion;
import modelo.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author chemo
 */
public class AdministradorDAO
{

    public static boolean agregarAdministrador(Administrador administrador)
    {
        String sql = "INSERT INTO Administrador (nombre, correo, contrasena) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, administrador.getNombre());
            pstmt.setString(2, administrador.getCorreo());
            pstmt.setString(3, administrador.getContraseña());
            
            pstmt.executeUpdate();  
            return true;
        } catch (SQLException e)
        {
            e.printStackTrace();
            System.err.println("Error al agregar el vendedor: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args)
    {
        Administrador admin = new Administrador("Saul", "Saul@gnail.com", "4321");
        boolean registro = false;
        registro = agregarAdministrador(admin);
        if (registro == false)
        {
            System.out.println("No se agrego");
        }
        else
        {
            System.out.println("Se agrego correctamente");
        }
       
    }
}
