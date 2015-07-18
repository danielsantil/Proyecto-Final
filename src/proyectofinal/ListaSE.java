/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

/**
 *
 * @author 
 * @param <T>
 */

public class ListaSE<T> implements InterfazLista<T>
{
    private NodoSE<T> cabeza;
        
        public NodoSE<T> getCabeza() {
            return cabeza;
        }

	public ListaSE() {
            cabeza = null;
	}

        @Override
	public boolean EsVacia() {
            return cabeza == null;
	}

        @Override
	public int Longitud() {
		if (cabeza == null)
			return 0;
		NodoSE<T> cursor = cabeza;
		int cont = 0;
		while (cursor != null) {
			cont++;
			cursor = cursor.getSiguiente();
		}
		return cont;
	}

        @Override
	public void Adicionar(T objeto) {
		NodoSE<T> nuevo = new NodoSE<T>(objeto);
		if (EsVacia())
			cabeza = nuevo;
		else {
			NodoSE<T> cursor = cabeza;
			while (cursor.getSiguiente() != null)
				cursor = cursor.getSiguiente();
			cursor.setSiguiente(nuevo);
		}
	}

        @Override
	public void Eliminar(int pos) throws Exception {
		if (EsVacia())
			throw new Exception("Lista vacia");
		if (pos < 0 || pos >= Longitud())
			throw new Exception("Posición fuera de rango.");
		if (pos == 0)
			cabeza = cabeza.getSiguiente();
		else {
			NodoSE<T> cursor = cabeza;
			int cont = 0;
			while (cont++ < pos - 1) {
				cursor = cursor.getSiguiente();
			}
			cursor.setSiguiente(cursor.getSiguiente().getSiguiente());
		}

	}

        @Override
	public void Insertar(T objeto, int pos) throws Exception {
		if (pos < 0 || pos >= Longitud())
			throw new Exception("Posición fuera de rango");
		NodoSE<T> nuevo = new NodoSE<T>(objeto);
		if (pos == 0) {
			nuevo.setSiguiente(cabeza);
			cabeza = nuevo;
		} else {
			NodoSE<T> cursor = cabeza;
			int cont = 0;
			while (cont++ < pos - 1)
				cursor = cursor.getSiguiente();
			nuevo.setSiguiente(cursor.getSiguiente());
			cursor.setSiguiente(nuevo);
		}
	}

        @Override
	public T Obtener(int pos) throws Exception {
		if (pos < 0 || pos >= Longitud())
			throw new Exception("Posición fuera de rango");
		NodoSE<T> cursor = cabeza;
		int cont = 0;
		while (cont++ < pos) {
			cursor = cursor.getSiguiente();
		}
		return cursor.getDato();
	}

        @Override
	public int Buscar(T x) {
		NodoSE<T> cursor = cabeza;
		int value = 0;
		while (cursor != null) {
			if(cursor.getDato().equals(x))
				return value;  
                        cursor = cursor.getSiguiente();
		}
		return -1;
	}
}