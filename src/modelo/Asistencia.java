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
public class Asistencia
{
    private int id_registro;
    private int id_empleado;
    private Date fehca_entrada;
    private Date fecha_salida;

    public Asistencia()
    {
    }

    public Asistencia(int id_registro, int id_empleado, Date fehca_entrada, Date fecha_salida)
    {
        this.id_registro = id_registro;
        this.id_empleado = id_empleado;
        this.fehca_entrada = fehca_entrada;
        this.fecha_salida = fecha_salida;
    }

    /**
     * @return the id_registro
     */
    public int getId_registro()
    {
        return id_registro;
    }

    /**
     * @param id_registro the id_registro to set
     */
    public void setId_registro(int id_registro)
    {
        this.id_registro = id_registro;
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
     * @return the fehca_entrada
     */
    public Date getFehca_entrada()
    {
        return fehca_entrada;
    }

    /**
     * @param fehca_entrada the fehca_entrada to set
     */
    public void setFehca_entrada(Date fehca_entrada)
    {
        this.fehca_entrada = fehca_entrada;
    }

    /**
     * @return the fecha_salida
     */
    public Date getFecha_salida()
    {
        return fecha_salida;
    }

    /**
     * @param fecha_salida the fecha_salida to set
     */
    public void setFecha_salida(Date fecha_salida)
    {
        this.fecha_salida = fecha_salida;
    }
    
    
}
