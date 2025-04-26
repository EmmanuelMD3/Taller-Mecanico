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

    public int insertarMantenimiento(Mantenimiento mantenimiento)
    {
        String sql = "INSERT INTO Mantenimiento (descripcion, fecha, id_vehiculo, id_empleado, costo_mano_obra, total_mantenimiento) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {

            pstmt.setString(1, mantenimiento.getDescripccion());
            pstmt.setDate(2, new java.sql.Date(mantenimiento.getFecha().getTime()));
            pstmt.setInt(3, mantenimiento.getId_vehiculo());
            pstmt.setInt(4, mantenimiento.getId_empleado());
            pstmt.setDouble(5, mantenimiento.getCostoManoObra());
            pstmt.setDouble(6, mantenimiento.getTotal());

            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next())
            {
                return rs.getInt(1);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return -1;
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
                        rs.getInt("id_empleado"),
                        rs.getDouble("costo_mano_obra"), 
                        rs.getDouble("total_mantenimiento") 
                );
                mantenimientos.add(mantenimiento);
            }

        } catch (SQLException e)
        {
            System.err.println("Error al listar los mantenimientos: " + e.getMessage());
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
                        rs.getInt("id_empleado"),
                        rs.getDouble("costo_mano_obra"), 
                        rs.getDouble("total_mantenimiento") 
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
        String sql = "UPDATE mantenimiento SET descripcion = ?, fecha = ?, id_vehiculo = ?, id_empleado = ?, costo_mano_obra = ?, total_mantenimiento = ? WHERE id_mantenimiento = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setString(1, mantenimiento.getDescripccion());
            pstmt.setDate(2, new java.sql.Date(mantenimiento.getFecha().getTime()));
            pstmt.setInt(3, mantenimiento.getId_vehiculo());
            pstmt.setInt(4, mantenimiento.getId_empleado());
            pstmt.setDouble(5, mantenimiento.getCostoManoObra());        
            pstmt.setDouble(6, mantenimiento.getTotal());                
            pstmt.setInt(7, mantenimiento.getId_mantenimiento());

            int filasActualizadas = pstmt.executeUpdate();
            return filasActualizadas > 0;

        } catch (SQLException e)
        {
            System.out.println("Error al modificar el mantenimiento: " + e.getMessage());
            return false;
        }
    }

    public static List<Object[]> listarMantenimiento1()
    {
        List<Object[]> lista = new ArrayList<>();

        String sql = """
        SELECT m.id_mantenimiento, m.descripcion, m.fecha,
               v.placa AS placa_vehiculo,
               e.nombre AS nombre_empleado
        FROM Mantenimiento m
        JOIN Vehiculo v ON m.id_vehiculo = v.id_vehiculo
        JOIN Empleado e ON m.id_empleado = e.id_empleado
    """;

        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next())
            {
                Object[] fila =
                {
                    rs.getInt("id_mantenimiento"),
                    rs.getString("descripcion"),
                    rs.getDate("fecha"),
                    rs.getString("placa_vehiculo"),
                    rs.getString("nombre_empleado")

                };
                lista.add(fila);
            }
        } catch (SQLException e)
        {
            System.err.println("Error al listar los mantenimientos: " + e.getMessage());
        }

        return lista;
    }

}
