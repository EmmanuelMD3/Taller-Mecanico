/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Ganancia;

/**
 *
 * @author chemo
 */
public class GananciaDAO
{

    public static boolean insertarGanancia(Ganancia ganancia)
    {
        String sql = "INSERT INTO ganancia (id_empleado, fecha_inicio, fecha_fin, total_generado) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setInt(1, ganancia.getId_empleado());
            pstmt.setDate(2, new java.sql.Date(ganancia.getFecha_inicio().getTime()));
            pstmt.setDate(3, new java.sql.Date(ganancia.getFecha_fin().getTime()));
            pstmt.setDouble(4, ganancia.getTotal_generado());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e)
        {
            System.err.println("Error al insertar ganancia: " + e.getMessage());
            return false;
        }
    }

    public static List<Ganancia> listarGanancias()
    {
        List<Ganancia> listaGanancias = new ArrayList<>();
        String sql = "SELECT * FROM ganancia";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery())
        {

            while (rs.next())
            {
                Ganancia ganancia = new Ganancia(
                        rs.getInt("id_ganancia"),
                        rs.getInt("id_empleado"),
                        rs.getDate("fecha_inicio"),
                        rs.getDate("fecha_fin"),
                        rs.getDouble("total_generado")
                );

                listaGanancias.add(ganancia);
            }

        } catch (SQLException e)
        {
            System.err.println("Error al listar ganancias: " + e.getMessage());
        }

        return listaGanancias;
    }

    public static double calcularTotalGanado(int idEmpleado, java.sql.Date fechaInicio, java.sql.Date fechaFin)
    {
        String sql = """
        SELECT SUM(m.costo_mano_obra + IFNULL(mat.total_materiales, 0)) AS total
        FROM mantenimiento m
        LEFT JOIN (
            SELECT id_mantenimiento, SUM(precio_unitario) AS total_materiales
            FROM material
            GROUP BY id_mantenimiento
        ) mat ON m.id_mantenimiento = mat.id_mantenimiento
        WHERE m.id_empleado = ? AND m.fecha BETWEEN ? AND ?
    """;

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setInt(1, idEmpleado);
            pstmt.setDate(2, fechaInicio);
            pstmt.setDate(3, fechaFin);

            try (ResultSet rs = pstmt.executeQuery())
            {
                if (rs.next())
                {
                    return rs.getDouble("total");
                }
            }

        } catch (SQLException e)
        {
            System.err.println("Error al calcular total generado (mano de obra + materiales): " + e.getMessage());
        }

        return 0.0;
    }

    public static boolean existeGananciaParaEmpleado(int idEmpleado, java.sql.Date fechaInicio, java.sql.Date fechaFin)
    {
        String sql = "SELECT COUNT(*) AS total FROM ganancia WHERE id_empleado = ? AND fecha_inicio = ? AND fecha_fin = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setInt(1, idEmpleado);
            pstmt.setDate(2, fechaInicio);
            pstmt.setDate(3, fechaFin);

            try (ResultSet rs = pstmt.executeQuery())
            {
                if (rs.next())
                {
                    int total = rs.getInt("total");
                    return total > 0; 
                }
            }

        } catch (SQLException e)
        {
            System.err.println("Error al verificar existencia de ganancia: " + e.getMessage());
        }

        return false;
    }

    public static boolean actualizarGanancia(int idEmpleado, java.sql.Date fechaInicio, java.sql.Date fechaFin, double nuevoTotal)
    {
        String sql = "UPDATE ganancia SET total_generado = ? WHERE id_empleado = ? AND fecha_inicio = ? AND fecha_fin = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setDouble(1, nuevoTotal);
            pstmt.setInt(2, idEmpleado);
            pstmt.setDate(3, fechaInicio);
            pstmt.setDate(4, fechaFin);

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e)
        {
            System.err.println("Error al actualizar ganancia: " + e.getMessage());
            return false;
        }
    }

}
