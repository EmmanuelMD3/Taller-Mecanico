/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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

    public static List<Mantenimiento> listarMantenimiento()
    {
        List<Mantenimiento> mantenimientos = new ArrayList<>();
        String sql = "SELECT * FROM Mantenimiento";

        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql))
        {

            while (rs.next())
            {
                Mantenimiento mantenimiento = new Mantenimiento(
                        rs.getInt("id_mantenimiento"),
                        rs.getString("descripcion"),
                        rs.getDate("fecha"),
                        rs.getInt("id_vehiculo"),
                        rs.getInt("id_empleado")
                );
                mantenimientos.add(mantenimiento);
            }

        } catch (SQLException e)
        {
            System.err.println("Error al listar los mantenientos: " + e.getMessage());
        }
        return mantenimientos;
    }
    
    public List<Mantenimiento> listarMantenimientoFiltro()
    {
        List<Mantenimiento> mantenimientos = new ArrayList<>();
        String sql = "SELECT * FROM Mantenimiento";

        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql))
        {

            while (rs.next())
            {
                Mantenimiento mantenimiento = new Mantenimiento(
                        rs.getInt("id_mantenimiento"),
                        rs.getString("descripcion"),
                        rs.getDate("fecha"),
                        rs.getInt("id_vehiculo"),
                        rs.getInt("id_empleado")
                );
                mantenimientos.add(mantenimiento);
            }

        } catch (SQLException e)
        {
            System.err.println("Error al listar los mantenientos: " + e.getMessage());
        }
        return mantenimientos;
    }

    public void eliminarMantenimiento(long codigoMantenimiento)
    {
        String sql = "DELETE FROM Mantenimiento WHERE id_mantenimiento = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setLong(1, codigoMantenimiento);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0)
            {
                System.out.println("Mantenimiento eliminado con éxito.");
            } else
            {
                System.out.println("No se encontró el mantenimiento con el código especificado.");
            }
        } catch (SQLException e)
        {
            System.err.println("Error al eliminar el mantenimiento: " + e.getMessage());
        }
    }

    public boolean modificarMantenimiento(Mantenimiento mantenimiento)
    {
        String sql = "UPDATE Mantenimiento SET descripcion = ?, fecha = ?, id_vehiculo = ?, id_empleado = ? WHERE id_mantenimiento = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setString(1, mantenimiento.getDescripccion());
            pstmt.setDate(2, new java.sql.Date(mantenimiento.getFecha().getTime()));
            pstmt.setInt(3, mantenimiento.getId_vehiculo());
            pstmt.setInt(4, mantenimiento.getId_empleado());
            pstmt.setInt(5, mantenimiento.getId_mantenimiento());

            int filasActualizadas = pstmt.executeUpdate();
            return filasActualizadas > 0;
        } catch (SQLException e)
        {
            System.out.println("Error al modificar el mantenmiento" + e.toString());
            return false;
        }
    }
}
