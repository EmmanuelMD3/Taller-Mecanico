/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.Conexion;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Asistencia;

/**
 *
 * @author chemo
 */
public class AsistenciaDAO
{

    public boolean insertarAsistencia(Asistencia asistencia)
    {
        String sql = "INSERT INTO Asistencia (id_empleado, fecha_entrada) VALUES (?, ?)";

        try (Connection con = Conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql))
        {
            ps.setInt(1, asistencia.getId_empleado());

            Timestamp timestampEntrada = new Timestamp(asistencia.getFehca_entrada().getTime());
            ps.setTimestamp(2, timestampEntrada);

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public List<Asistencia> listarAsistencias()
    {
        List<Asistencia> lista = new ArrayList<>();

        String sql = "SELECT * FROM Asistencia ORDER BY fecha_entrada DESC";

        try (Connection con = Conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery())
        {

            while (rs.next())
            {
                Asistencia asistencia = new Asistencia();
                asistencia.setId_registro(rs.getInt("id_registro"));
                asistencia.setId_empleado(rs.getInt("id_empleado"));
                asistencia.setFehca_entrada(rs.getTimestamp("fecha_entrada")); 
                lista.add(asistencia);
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return lista;
    }

    public List<Object[]> listarAsistenciasConNombre()
    {
        List<Object[]> lista = new ArrayList<>();

        String sql = "SELECT a.id_registro, e.nombre, a.fecha_entrada "
                + "FROM Asistencia a "
                + "JOIN Empleado e ON a.id_empleado = e.id_empleado "
                + "ORDER BY a.fecha_entrada DESC";

        try (Connection con = Conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery())
        {

            while (rs.next())
            {
                int id = rs.getInt("id_registro");
                String nombre = rs.getString("nombre");
                Timestamp entrada = rs.getTimestamp("fecha_entrada");

                lista.add(new Object[]
                {
                    id, nombre, entrada
                });
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return lista;
    }

}
