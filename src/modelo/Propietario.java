/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author chemo
 */
public class Propietario
{
    private int id_propietario;
    private String nombre;
    private String telefono;

    public Propietario()
    {
    }

    public Propietario(int id_propietario, String nombre, String telefono)
    {
        this.id_propietario = id_propietario;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    /**
     * @return the id_propietario
     */
    public int getId_propietario()
    {
        return id_propietario;
    }

    /**
     * @param id_propietario the id_propietario to set
     */
    public void setId_propietario(int id_propietario)
    {
        this.id_propietario = id_propietario;
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
     * @return the telefono
     */
    public String getTelefono()
    {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }
    
    
}
