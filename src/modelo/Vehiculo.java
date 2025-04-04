/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author chemo
 */
public class Vehiculo
{

    private int id_vehiculo;
    private String placa;
    private String marca;
    private String modelo;
    private int año;
    private int id_propietario;
    private String rutaImagen;

    public Vehiculo()
    {
    }

    public Vehiculo(int id_vehiculo, String placa, String marca,String modelo, int año, int id_propietario, String rutaImagen)
    {
        this.id_vehiculo = id_vehiculo;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.id_propietario = id_propietario;
        this.rutaImagen = rutaImagen;
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
     * @return the placa
     */
    public String getPlaca()
    {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa)
    {
        this.placa = placa;
    }

    /**
     * @return the modelo
     */
    public String getModelo()
    {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

    /**
     * @return the año
     */
    public int getAño()
    {
        return año;
    }

    /**
     * @param año the año to set
     */
    public void setAño(int año)
    {
        this.año = año;
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

    public String getRutaImagen()
    {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen)
    {
        this.rutaImagen = rutaImagen;
    }

    /**
     * @return the marca
     */
    public String getMarca()
    {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca)
    {
        this.marca = marca;
    }

}
