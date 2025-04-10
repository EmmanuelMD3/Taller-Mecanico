/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Mantenimiento;


/**
 *
 * @author chemo
 */
public class MantenimientoDAO
{

    public boolean insertarMantenimiento(Mantenimiento mantenimiento)
    {
        String sql = "INSERT INTO Mantenimiento (descripcion, fecha, id_vehiculo, id_empleado) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, mantenimiento.getDescripccion());
            pstmt.setDate(2, new java.sql.Date(mantenimiento.getFecha().getTime()));
            pstmt.setInt(3, mantenimiento.getId_vehiculo());
            pstmt.setInt(4, mantenimiento.getId_empleado());

            int filasInsertadas = pstmt.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException e)
        {
            System.out.println("Error al insertar el mantenimiento.");
            e.printStackTrace(); 
            return false;
        }
    }
}
