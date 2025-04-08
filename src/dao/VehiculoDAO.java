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
import java.util.ArrayList;
import java.util.List;
import modelo.Propietario;
import modelo.Vehiculo;

/**
 *
 * @author chemo
 */
public class VehiculoDAO
{

    public List<Propietario> obtenerTodosLosPropietarios()
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

    public boolean insertarVehiculo(Vehiculo vehiculo)
    {
        String sql = "INSERT INTO Vehiculo (placa, marca, modelo, anio, id_propietario, ruta_imagen) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setString(1, vehiculo.getPlaca());
            pstmt.setString(2, vehiculo.getMarca());
            pstmt.setString(3, vehiculo.getModelo());
            pstmt.setInt(4, vehiculo.getAño());
            pstmt.setInt(5, vehiculo.getId_propietario());
            pstmt.setString(6, vehiculo.getRutaImagen());

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e)
        {
            System.err.println("Error al insertar el vehículo: " + e.getMessage());
            return false;
        }
    }

    public static List<Vehiculo> listarVehiculos()
    {
        List<Vehiculo> listaVehiculos = new ArrayList<>();
        String sql = "SELECT * FROM Vehiculo";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery())
        {

            while (rs.next())
            {
                Vehiculo vehiculo = new Vehiculo(
                        rs.getInt("id_vehiculo"),
                        rs.getString("placa"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("anio"),
                        rs.getInt("id_propietario"),
                        rs.getString("ruta_imagen")
                );

                listaVehiculos.add(vehiculo);
            }

        } catch (SQLException e)
        {
            System.err.println("Error al listar vehículos: " + e.getMessage());
        }

        return listaVehiculos;
    }

    public void eliminarVehiculo(long codigoVehiculo)
    {
        String sql = "DELETE FROM Vehiculo WHERE id_vehiculo = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setLong(1, codigoVehiculo);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0)
            {
                System.out.println("Vehiculo eliminado con éxito.");
            } else
            {
                System.out.println("No se encontró el Vehiculo con el código especificado.");
            }
        } catch (SQLException e)
        {
            System.err.println("Error al eliminar el Vehiculo: " + e.getMessage());
        }
    }

    public boolean modificarVehiculo(Vehiculo vehiculo)
    {
        String sql = "UPDATE Vehiculo SET placa = ?, marca = ?, modelo = ?, anio = ?, id_propietario = ?, ruta_imagen = ? WHERE id_vehiculo = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, vehiculo.getPlaca());
            pstmt.setString(2, vehiculo.getMarca());
            pstmt.setString(3, vehiculo.getModelo());
            pstmt.setInt(4, vehiculo.getAño());
            pstmt.setInt(5, vehiculo.getId_propietario());
            pstmt.setString(6, vehiculo.getRutaImagen());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e)
        {
            System.err.println("Error al modificar el vehiculo: " + e.getMessage());
            return false;
        }
    }

}
