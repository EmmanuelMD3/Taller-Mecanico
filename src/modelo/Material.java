/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author chemo
 */
public class Material
{

    private int id_material;
    private String nombre;
    private double precio_unitario;
    private int id_mantenimiento;

    public Material(String nombre, double precio_unitario, int id_mantenimiento)
    {
        this.nombre = nombre;
        this.precio_unitario = precio_unitario;
        this.id_mantenimiento = id_mantenimiento;
    }

    public Material(int id_material, String nombre, double precio_unitario, int id_mantenimiento)
    {
        this.id_material = id_material;
        this.nombre = nombre;
        this.precio_unitario = precio_unitario;
        this.id_mantenimiento = id_mantenimiento;
    }

    public Material(int id_material, String nombre, double precio_unitario)
    {
        this.id_material = id_material;
        this.nombre = nombre;
        this.precio_unitario = precio_unitario;
    }

    public int getId_material()
    {
        return id_material;
    }

    public void setId_material(int id_material)
    {
        this.id_material = id_material;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public double getPrecio_unitario()
    {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario)
    {
        this.precio_unitario = precio_unitario;
    }

    public int getId_mantenimiento()
    {
        return id_mantenimiento;
    }

    public void setId_mantenimiento(int id_mantenimiento)
    {
        this.id_mantenimiento = id_mantenimiento;
    }
}
