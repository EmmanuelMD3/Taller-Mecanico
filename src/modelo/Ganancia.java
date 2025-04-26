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
public class Ganancia
{

    private int id_ganancia;
    private int id_empleado;
    private Date fecha_inicio;
    private Date fecha_fin;
    private double total_generado;

    public Ganancia(int id_ganancia, int id_empleado, Date fecha_inicio, Date fecha_fin, double total_generado)
    {
        this.id_ganancia = id_ganancia;
        this.id_empleado = id_empleado;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.total_generado = total_generado;
    }

    public Ganancia(int id_empleado, Date fecha_inicio, Date fecha_fin, double total_generado)
    {
        this.id_empleado = id_empleado;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.total_generado = total_generado;
    }

    public int getId_ganancia()
    {
        return id_ganancia;
    }

    public void setId_ganancia(int id_ganancia)
    {
        this.id_ganancia = id_ganancia;
    }

    public int getId_empleado()
    {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado)
    {
        this.id_empleado = id_empleado;
    }

    public Date getFecha_inicio()
    {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio)
    {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin()
    {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin)
    {
        this.fecha_fin = fecha_fin;
    }

    public double getTotal_generado()
    {
        return total_generado;
    }

    public void setTotal_generado(double total_generado)
    {
        this.total_generado = total_generado;
    }
}
