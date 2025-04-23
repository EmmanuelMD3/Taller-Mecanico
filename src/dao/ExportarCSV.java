/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.Conexion;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 *
 * @author chemo
 */
public class ExportarCSV
{

    public boolean exportarACSV(String query, String archivoDestino) throws IOException
    {
        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query); PrintWriter csvWriter = new PrintWriter(new FileWriter(archivoDestino)))
        {

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();

            for (int i = 1; i <= columnas; i++)
            {
                csvWriter.print(rsmd.getColumnName(i));
                if (i < columnas)
                {
                    csvWriter.print(",");
                }
            }
            csvWriter.println();

            while (rs.next())
            {
                for (int i = 1; i <= columnas; i++)
                {
                    csvWriter.print(rs.getString(i));
                    if (i < columnas)
                    {
                        csvWriter.print(",");
                    }
                }
                csvWriter.println();
            }

            System.out.println("Exportacion completada a: " + archivoDestino);
            return true;

        } catch (SQLException | IOException e)
        {
            System.out.println("Error al exportar a CSV.");
            e.printStackTrace();
            return false;
        }
    }

    public boolean exportarPropietariosACSV(String query, String archivoDestino)
    {
        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query); PrintWriter csvWriter = new PrintWriter(new FileWriter(archivoDestino)))
        {

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();

            for (int i = 1; i <= columnas; i++)
            {
                csvWriter.print(rsmd.getColumnName(i));
                if (i < columnas)
                {
                    csvWriter.print(",");
                }
            }
            csvWriter.println();

            while (rs.next())
            {
                for (int i = 1; i <= columnas; i++)
                {
                    String valor = rs.getString(i);
                    if (valor == null)
                    {
                        valor = "";
                    }
                    csvWriter.print(valor);
                    if (i < columnas)
                    {
                        csvWriter.print(",");
                    }
                }
                csvWriter.println();
            }

            System.out.println("Exportacion completada a: " + archivoDestino);
            return true;

        } catch (SQLException | IOException e)
        {
            System.out.println("Error al exportar los propietarios a CSV.");
            e.printStackTrace();
            return false;
        }
    }

    public boolean exportarVehiculosACSV(String query, String archivoDestino)
    {
        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query); PrintWriter csvWriter = new PrintWriter(new FileWriter(archivoDestino)))
        {

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();

            for (int i = 1; i <= columnas; i++)
            {
                csvWriter.print(rsmd.getColumnName(i));
                if (i < columnas)
                {
                    csvWriter.print(",");
                }
            }
            csvWriter.println();

            while (rs.next())
            {
                for (int i = 1; i <= columnas; i++)
                {
                    String valor = rs.getString(i);
                    if (valor == null)
                    {
                        valor = "";
                    }
                    csvWriter.print(valor);
                    if (i < columnas)
                    {
                        csvWriter.print(",");
                    }
                }
                csvWriter.println();
            }

            System.out.println("Exportacion completada a: " + archivoDestino);
            return true;

        } catch (SQLException | IOException e)
        {
            System.out.println("Error al exportar los vehículos a CSV.");
            e.printStackTrace();
            return false;
        }
    }

    public boolean exportarMantenimientosACSV(String query, String archivoDestino)
    {
        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query); PrintWriter csvWriter = new PrintWriter(new FileWriter(archivoDestino)))
        {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();

            for (int i = 1; i <= columnas; i++)
            {
                csvWriter.print(rsmd.getColumnName(i));
                if (i < columnas)
                {
                    csvWriter.print(",");
                }
            }
            csvWriter.println();

            while (rs.next())
            {
                for (int i = 1; i <= columnas; i++)
                {
                    String valor = rs.getString(i);
                    if (valor == null)
                    {
                        valor = "";
                    }
                    csvWriter.print(valor);
                    if (i < columnas)
                    {
                        csvWriter.print(",");
                    }
                }
                csvWriter.println();
            }

            System.out.println("Exportacion completada a: " + archivoDestino);
            return true;

        } catch (SQLException | IOException e)
        {
            System.out.println("Error al exportar los mantenimientos a CSV.");
            e.printStackTrace();
            return false;
        }
    }

    public boolean exportarAsistenciasACSV(String query, String archivoDestino)
    {
        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query); PrintWriter csvWriter = new PrintWriter(new FileWriter(archivoDestino)))
        {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();

            for (int i = 1; i <= columnas; i++)
            {
                csvWriter.print(rsmd.getColumnName(i));
                if (i < columnas)
                {
                    csvWriter.print(",");
                }
            }
            csvWriter.println();

            while (rs.next())
            {
                for (int i = 1; i <= columnas; i++)
                {
                    String valor = rs.getString(i);
                    if (valor == null)
                    {
                        valor = "";  
                    }
                    csvWriter.print(valor);
                    if (i < columnas)
                    {
                        csvWriter.print(",");
                    }
                }
                csvWriter.println();
            }

            System.out.println("Exportacion completada a: " + archivoDestino);
            return true;

        } catch (SQLException | IOException e)
        {
            System.out.println("Error al exportar las asistencias a CSV.");
            e.printStackTrace();
            return false;
        }
    }
}
