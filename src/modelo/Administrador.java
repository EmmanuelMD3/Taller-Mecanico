/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author chemo
 */
public class Administrador
{
    private int id_administrador;
    private String nombre;
    private String correo;
    private String contraseña;

    public Administrador()
    {
    }

    public Administrador(String nombre, String correo, String contraseña)
    {
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    /**
     * @return the id_administrador
     */
    public int getId_administrador()
    {
        return id_administrador;
    }

    /**
     * @param id_administrador the id_administrador to set
     */
    public void setId_administrador(int id_administrador)
    {
        this.id_administrador = id_administrador;
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
    
    
     
            
}
