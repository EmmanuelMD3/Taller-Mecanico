/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author chemo
 */
public class Empleado
{

    private int id_empleado;
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
    private double sueldo;

    public Empleado()
    {
    }

    public Empleado(int id_empleado, String nombre, String apellido, String correo, String contraseña)
    {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public Empleado(int id_empleado, String nombre, String apellido, String correo, String contrasena, double sueldo)
    {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contrasena;
        this.sueldo = sueldo;
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
     * @return the nombre
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * @return the correo
     */
    public String getCorreo()
    {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo)
    {
        this.correo = correo;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña()
    {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña)
    {
        this.contraseña = contraseña;
    }

    /**
     * @return the apellido
     */
    public String getApellido()
    {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }

    /**
     * @return the sueldo
     */
    public double getSueldo()
    {
        return sueldo;
    }

    /**
     * @param sueldo the sueldo to set
     */
    public void setSueldo(double sueldo)
    {
        this.sueldo = sueldo;
    }

}
