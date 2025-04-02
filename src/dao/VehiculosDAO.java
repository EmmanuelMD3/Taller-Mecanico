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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import modelo.Propietario;

/**
 *
 * @author chemo
 */
public class VehiculosDAO
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
}
