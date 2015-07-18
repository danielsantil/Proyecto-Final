/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.sql.Time;

/**
 *
 * @author Daniel
 */
public class Almacen
{
    private String ID;
    private String ciudad;
    private Time horaDeApertura;

    public Almacen(String ID, String ciudad, Time horaDeApertura) //Daniel
    {
        this.ID = ID;
        this.ciudad = ciudad;
        this.horaDeApertura = horaDeApertura;
    }

    public String getID()
    {
        return ID;
    }

    public String getCiudad()
    {
        return ciudad;
    }

    public Time getHoraDeApertura()
    {
        return horaDeApertura;
    }

    @Override
    public String toString()
    {
        return "ID: " + ID + ". " + ciudad + ". Hora de apertura: " + horaDeApertura;
    }
    
}
