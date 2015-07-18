/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

/**
 *
 * @author LILY
 */
public class NodoSE<T> {
	
	private T dato;
	private NodoSE <T> siguiente;
	
	public NodoSE(T dato)
	{
            this.dato = dato;
            siguiente = null;
	}

	public T getDato() {
            return dato;
	}

	public void setDato(T dato) {
            this.dato = dato;
	}

	public NodoSE getSiguiente() {
            return siguiente;
	}

	public void setSiguiente(NodoSE siguiente) {
            this.siguiente = siguiente;
	}
	
}
