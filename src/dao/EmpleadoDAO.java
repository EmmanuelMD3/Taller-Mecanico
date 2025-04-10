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
import modelo.Empleado;

/**
 *
 * @author chemo
 */
public class EmpleadoDAO
{

    public boolean insertarEmpleado(Empleado empleado)
    {
        String sql = "INSERT INTO Empleado (nombre, apellido, correo, contrasena) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, empleado.getNombre());
            pstmt.setString(2, empleado.getApellido());
            pstmt.setString(3, empleado.getCorreo());
            pstmt.setString(4, empleado.getContraseña());

            int filasInsertadas = pstmt.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException e)
        {
            System.out.println("Error al insertar los empleados");
            return false;
        }
    }

    public boolean actualizarEmpleado(Empleado empleado)
    {
        String sql = "UPDATE Empleado SET nombre = ?, apellido = ?, correo = ?, contrasena = ? WHERE id_empleado = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, empleado.getNombre());
            pstmt.setString(2, empleado.getApellido());
            pstmt.setString(3, empleado.getCorreo());
            pstmt.setString(4, empleado.getContraseña());
            pstmt.setInt(5, empleado.getId_empleado());

            int filasActualizadas = pstmt.executeUpdate();
            return filasActualizadas > 0;
        } catch (SQLException e)
        {
            System.out.println("Error al modificar el empleado");
            return false;
        }
    }

    public static List<Empleado> listarEmpleados()
    {
        List<Empleado> listaEmpleados = new ArrayList<>();
        String sql = "SELECT * FROM Empleado";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery())
        {

            while (rs.next())
            {
                Empleado empleado = new Empleado(
                        rs.getInt("id_empleado"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("correo"),
                        rs.getString("contrasena")
                );

                listaEmpleados.add(empleado);
            }

        } catch (SQLException e)
        {
            System.err.println("Error al listar empleados: " + e.getMessage());
        }
        return listaEmpleados;
    }

    public void eliminarEmpleado(long idEmpleado)
    {
        String sql = "DELETE FROM Empleado WHERE id_empleado = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setLong(1, idEmpleado);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0)
            {
                System.out.println("Empleado eliminado con éxito.");
            } else
            {
                System.out.println("No se encontró el Empleado con el ID especificado.");
            }
        } catch (SQLException e)
        {
            System.err.println("Error al eliminar el Empleado: " + e.getMessage());
        }
    }

    public List<Empleado> obtenerTodosLosEmpleados()
    {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT id_empleado, nombre, apellido, correo FROM Empleado";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery())
        {
            while (rs.next())
            {
                Empleado empleado = new Empleado();

                empleado.setId_empleado(rs.getInt("id_empleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setCorreo(rs.getString("correo"));
                empleados.add(empleado);
            }
        } catch (SQLException e)
        {
            System.err.println("Error al obtener los propietarios: " + e.getMessage());
        }
        return empleados;
    }

    public int obtenerIdPorNombre(String nombre)
    {
        int idEmpleado = -1;
        String query = "SELECT id_empleado FROM Empleado WHERE nombre = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement stmt = conn.prepareStatement(query))
        {

            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();

            if (rs.next())
            {
                idEmpleado = rs.getInt("id_empleado");
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return idEmpleado;
    }

    public String obtenerNombrePorId(int idEmpleado)
    {
        String sql = "SELECT nombre FROM Empleado WHERE id_empleado = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, idEmpleado);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
            {
                return rs.getString("nombre");
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

 

}
