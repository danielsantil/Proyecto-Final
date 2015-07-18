/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

/**
 *
 * @author LILY
 * @param <T>
 */
public interface InterfazLista<T>{

	public void Adicionar(T objeto) ;
	
	public void Insertar(T objeto, int pos) throws Exception ;
	
	public void Eliminar(int pos) throws Exception;
	
	public T Obtener(int pos) throws Exception;  
	
	public boolean EsVacia();
	
	public int Longitud();
	
	public int Buscar(T x);
		
}
