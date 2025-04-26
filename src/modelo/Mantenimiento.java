/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author chemo
 */
public class Mantenimiento
{

    private int id_mantenimiento;
    private String descripccion;
    private Date fecha;
    private int id_vehiculo;
    private int id_empleado;
    private double costoManoObra;
    private double total;

    public Mantenimiento()
    {
    }

    public Mantenimiento(int id_mantenimiento, String descripccion, Date fecha,
            int id_vehiculo, int id_empleado, double costoManoObra, double total)
    {
        this.id_mantenimiento = id_mantenimiento;
        this.descripccion = descripccion;
        this.fecha = fecha;
        this.id_vehiculo = id_vehiculo;
        this.id_empleado = id_empleado;
        this.costoManoObra = costoManoObra;
        this.total = total;
    }

    // Constructor básico (por si aún lo usas en otras partes)
    public Mantenimiento(int id_mantenimiento, String descripccion, Date fecha,
            int id_vehiculo, int id_empleado)
    {
        this.id_mantenimiento = id_mantenimiento;
        this.descripccion = descripccion;
        this.fecha = fecha;
        this.id_vehiculo = id_vehiculo;
        this.id_empleado = id_empleado;
    }

    /**
     * @return the id_mantenimiento
     */
    public int getId_mantenimiento()
    {
        return id_mantenimiento;
    }

    /**
     * @param id_mantenimiento the id_mantenimiento to set
     */
    public void setId_mantenimiento(int id_mantenimiento)
    {
        this.id_mantenimiento = id_mantenimiento;
    }

    /**
     * @return the descripccion
     */
    public String getDescripccion()
    {
        return descripccion;
    }

    /**
     * @param descripccion the descripccion to set
     */
    public void setDescripccion(String descripccion)
    {
        this.descripccion = descripccion;
    }

    /**
     * @return the fecha
     */
    public Date getFecha()
    {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }

    /**
     * @return the id_vehiculo
     */
    public int getId_vehiculo()
    {
        return id_vehiculo;
    }

    /**
     * @param id_vehiculo the id_vehiculo to set
     */
    public void setId_vehiculo(int id_vehiculo)
    {
        this.id_vehiculo = id_vehiculo;
    }

    /**
     * @return the id_empleado
     */
    public int getId_empleado()
    {
        return id_empleado;
    }

    /**
     * @param id_empleado the id_empleado to set
     */
    public void setId_empleado(int id_empleado)
    {
        this.id_empleado = id_empleado;
    }

    /**
     * @return the costoManoObra
     */
    public double getCostoManoObra()
    {
        return costoManoObra;
    }

    /**
     * @param costoManoObra the costoManoObra to set
     */
    public void setCostoManoObra(double costoManoObra)
    {
        this.costoManoObra = costoManoObra;
    }

    /**
     * @return the total
     */
    public double getTotal()
    {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total)
    {
        this.total = total;
    }
}
