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
import modelo.Propietario;

/**
 *
 * @author chemo
 */
public class PropietarioDAO
{

    public static boolean agregarPropietario(Propietario propietario)
    {
        String sql = "INSERT INTO Propietario (id_propietario, nombre, telefono) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, propietario.getId_propietario());
            pstmt.setString(2, propietario.getNombre());
            pstmt.setString(3, propietario.getTelefono());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e)
        {
            e.printStackTrace();
            System.err.println("Error al agregar el vendedor: " + e.getMessage());
            return false;
        }
    }

    public static List<Propietario> listarPropietario()
    {
        List<Propietario> propietarios = new ArrayList<>();
        String sql = "SELECT * FROM Propietario";

        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql))
        {

            while (rs.next())
            {
                Propietario propietario = new Propietario(
                        rs.getInt("id_propietario"),
                        rs.getString("nombre"),
                        rs.getString("telefono")
                );
                propietarios.add(propietario);
            }

        } catch (SQLException e)
        {
            System.err.println("Error al listar los productos: " + e.getMessage());
        }
        return propietarios;
    }

    public void eliminarPropietario(long codigoPropietario)
    {
        String sql = "DELETE FROM Propietario WHERE id_propietario = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setLong(1, codigoPropietario);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0)
            {
                System.out.println("Propietario eliminado con éxito.");
            } else
            {
                System.out.println("No se encontró el propietario con el código especificado.");
            }
        } catch (SQLException e)
        {
            System.err.println("Error al eliminar el propietario: " + e.getMessage());
        }
    }

    public boolean modificarPropietario(Propietario propietario)
    {
        String sql = "UPDATE Propietario SET nombre = ?, telefono = ? WHERE id_propietario = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, propietario.getNombre());
            pstmt.setString(2, propietario.getTelefono());
            pstmt.setInt(3, propietario.getId_propietario()); // Aquí asignas el ID correctamente

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e)
        {
            System.err.println("Error al modificar el propietario: " + e.getMessage());
            return false;
        }
    }
    
    public List<Propietario> obtenerTodosLosPropitarios()
    {
        List<Propietario> propietarios = new ArrayList<>();
        String sql = "SELECT id_propietario, nombre, telefono FROM Propietario";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery())
        {
            while (rs.next())
            {
                Propietario propietario = new Propietario();
                
                propietario.setId_propietario(rs.getInt("id_propietario"));
                propietario.setNombre(rs.getString("nombre"));
                propietario.setTelefono(rs.getString("telefono"));
                propietarios.add(propietario);
            }
        } catch (SQLException e)
        {
            System.err.println("Error al obtener los propietarios: " + e.getMessage());
        }
        return propietarios;
    }

}
