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
import javax.swing.JOptionPane;
import modelo.Material;

/**
 *
 * @author chemo
 */
public class MaterialDAO
{

    public static void insertarMaterial(Material material)
    {
        String sql = "INSERT INTO Material (nombre, precio_unitario, id_mantenimiento) VALUES (?, ?, ?)";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setString(1, material.getNombre());
            pstmt.setDouble(2, material.getPrecio_unitario());
            pstmt.setInt(3, material.getId_mantenimiento());
            pstmt.executeUpdate();

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static List<Material> obtenerMaterialesPorMantenimiento(int idMantenimiento)
    {
        List<Material> materiales = new ArrayList<>();
        String sql = "SELECT * FROM material WHERE id_mantenimiento = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setInt(1, idMantenimiento);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next())
            {
                Material material = new Material(
                        rs.getInt("id_material"),
                        rs.getString("nombre"),
                        rs.getDouble("precio_unitario"),
                        rs.getInt("id_mantenimiento")
                );
                materiales.add(material);
            }

        } catch (SQLException e)
        {
            System.err.println("Error al obtener materiales: " + e.getMessage());
        }

        return materiales;
    }

    public static void actualizarMaterial(Material material)
    {
        String sql = "UPDATE material SET nombre = ?, precio_unitario = ? WHERE id_material = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setString(1, material.getNombre());
            pstmt.setDouble(2, material.getPrecio_unitario());
            pstmt.setInt(3, material.getId_material());

            pstmt.executeUpdate();

        } catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error al actualizar material: " + e.getMessage());
        }
    }

}
