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
public class ProyectoFinal
{

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception
    {
        Grafo<Almacen> Almacenes=new Grafo<>();
        Time t1;
        t1 = new Time(12, 50, 5);
        Time t2;
        t2 = new Time(8, 20, 0);
        
        Almacen a1=new Almacen("SD", "Sto Dgo", t1);
        Almacen a2=new Almacen("ST", "Santiago", t2);
        
        Almacenes.InsertarVertice(a1);
        Almacenes.InsertarVertice(a2);
        Almacenes.InsertarArco(a1, a1);
        Almacenes.InsertarArco(a2, a2);
        Almacenes.InsertarArco(a1, a2);
        
        System.out.println("Almacenes:");
        Almacenes.MostrarGrafo();
        System.out.println();
    }
    
}
