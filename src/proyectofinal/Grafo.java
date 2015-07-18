
package proyectofinal;

/**
 *
 * @author LILY
 * @param <T>
 */
public class Grafo<T> implements InterfazGrafo<T> {
    
    private ListaSE<T> lista;
    private ListaSE<ListaSE<Integer>> adyacencia;
    
    
    public Grafo() {
        lista =  new ListaSE<T>();
        adyacencia = new ListaSE<ListaSE<Integer>>();
    }

    protected int PosicionDelVertice(T v) throws Exception {
        for(int i = 0; i < lista.Longitud(); i++) 
            if (lista.Obtener(i).equals(v))
                return i;
        return -1;
    }
     
    @Override
    public boolean EsVacio() {
        return lista.EsVacia();
    }

    @Override
    public int NumeroDeVertices() {
        return lista.Longitud();
    }

    @Override
    public int NumeroDeArcos() throws Exception {
        int c = 0;
        for(int i = 0; i < lista.Longitud(); i++) 
            c += adyacencia.Obtener(i).Longitud();
        return c/2;
    }

    @Override
    public boolean EstaElVertice(T v) throws Exception {
        return PosicionDelVertice(v) != -1;
    }

    @Override
    public boolean EstaElArco(T v1, T v2) throws Exception {
        int p1 = PosicionDelVertice(v1);
        int p2 = PosicionDelVertice(v2);
        if ((p1 != -1)&&(p2 != -1))
        {
            ListaSE<Integer> adyac = adyacencia.Obtener(p1);
            for(int i = 0; i < adyac.Longitud(); i++)
                if (adyac.Obtener(i).equals(p2))
                    return true;
           
        }
        return false;
    }

    @Override
    public void InsertarVertice(T v) throws Exception {
        if(!EstaElVertice(v))
        {
            lista.Adicionar(v);
	adyacencia.Adicionar(new ListaSE<Integer>());
        }
    }
    /*******/

    @Override
    public void EliminarVertice(T v) throws Exception {
        int p = PosicionDelVertice(v);
        if (p != -1)
        {
            ListaSE<Integer> adyac = adyacencia.Obtener(p);
            for(int i = 0; i < adyac.Longitud(); i++)
                EliminarArco(v, lista.Obtener(adyac.Obtener(i)));
            adyacencia.Eliminar(p);
            lista.Eliminar(p);
            
            int aux;
            
            for(int i = 0; i < adyacencia.Longitud(); i++)
            {
                adyac = adyacencia.Obtener(i);
                for(int j = 0; j < adyac.Longitud(); j++) {
                    aux = adyac.Obtener(j);
                    if(aux > p) {
                       adyac.Eliminar(j);
                       if(!adyac.EsVacia())
                         adyac.Insertar(aux-1, j);
                       else
                         adyac.Adicionar(aux-1);
                    }
                }
            }
        }
        else    
            throw new IllegalArgumentException();
    }
    
    @Override
    public void InsertarArco(T v1, T v2) throws Exception //Daniel, método de Liango
    {
        int p1 = PosicionDelVertice(v1);
        int p2 = PosicionDelVertice(v2);
        if ((p1 != -1)&&(p2 != -1)&&(!EstaElArco(v1,v2)))
        {
            ListaSE<Integer> adyac = adyacencia.Obtener(p1);
            adyac.Adicionar(p2);
            if( p1 != p2 )
            {
                adyac = adyacencia.Obtener(p2);
                adyac.Adicionar(p1);
            }
        }
        else    
            throw new IllegalArgumentException();
    }

//    @Override
//    public void EliminarVertice(T v) throws Exception {
//        int p = PosicionDelVertice(v);
//        if (p != -1)
//        {
//            ListaSE<Integer> adyac = adyacencia.Obtener(p);
//            for(int i = 0; i < lista.Longitud(); i++)
//                EliminarArco(v, lista.Obtener(i));
//            adyacencia.Eliminar(p);
//            lista.Eliminar(p);
//            
//            int aux;
//            
//            for(int i = 0; i < adyacencia.Longitud(); i++)
//            {
//                adyac = adyacencia.Obtener(i);
//                for(int j = 0; j < adyac.Longitud(); j++) {
//                    aux = adyac.Obtener(0);
//                    adyac.Eliminar(0);
//                    if(aux > p) {
//                        adyac.Adicionar(aux-1);
//                    }
//                    else{
//                        adyac.Adicionar(aux);
//                    }
//                }
//            }
//        }
//        else    
//            throw new IllegalArgumentException();
//    }

    @Override
    public void EliminarArco(T v1, T v2) throws Exception {
        int p1 = PosicionDelVertice(v1);
        int p2 = PosicionDelVertice(v2);
        if ((p1 != -1)&&(p2 != -1)&&(EstaElArco(v1,v2)))
        {
            ListaSE<Integer> adyac = adyacencia.Obtener(p1);
            for(int i = 0; i < adyac.Longitud(); i++)
                if(adyac.Obtener(i) == p2)
                    adyac.Eliminar(i);
            
            adyac = adyacencia.Obtener(p2);
            for(int i = 0; i < adyac.Longitud(); i++)
                if(adyac.Obtener(i) == p1)
                    adyac.Eliminar(i);
        }
        else    
            throw new IllegalArgumentException();
    }

    @Override
    public void ReemplazarVertice(T v1, T v2) throws Exception {
        int p = PosicionDelVertice(v1);
        if(p != -1) {
            lista.Eliminar(p);
            if(!lista.EsVacia())
                lista.Insertar(v2, p);
            else
                lista.Adicionar(v2);
        }
        else 
            throw new IllegalArgumentException();
    }


/*Esta es otra forma de implementar ALoAncho sin colas la otra verla en la 
    implementación de matrix de adyacencia */
    
    @Override
    public ListaSE<T> ALoAncho() throws Exception {
        int p = 0;
        if(p != -1) {
          ListaSE<T> result = new ListaSE<T>();
          ListaSE<Integer> aux = new ListaSE<Integer>();
          boolean[] visitado = new boolean[lista.Longitud()];
          aux.Adicionar(p);
          result.Adicionar(lista.Obtener(0));   
          visitado[p] = true;
          for(int k = 0; k < lista.Longitud(); k++)
          { 
             for(int i = 0; i < aux.Longitud(); i++) {
               ListaSE<Integer> adyac = adyacencia.Obtener(aux.Obtener(i)); 
               for(int j = 0; j < adyac.Longitud(); j++)
               {
                  if(!visitado[adyac.Obtener(j)])
                  {
                     aux.Adicionar(adyac.Obtener(j));
                     result.Adicionar(lista.Obtener(adyac.Obtener(j)));
                     visitado[adyac.Obtener(j)] = true;
                  }
               }
             }
             if(!visitado[k]) 
             {
               aux.Adicionar(k);
               result.Adicionar(lista.Obtener(k));
               visitado[k] = true;
             }
           }
       
           return result;
        }
        throw new IllegalArgumentException();
    }
    
    @Override
    public InterfazGrafo<T> Copiar() throws Exception {
        Grafo<T> g = new Grafo<T>();
        for(int i = 0; i < lista.Longitud(); i++) 
           g.lista.Adicionar(lista.Obtener(i));
        
        ListaSE<Integer> aux;   
        for(int i = 0; i < lista.Longitud(); i++) 
        {
            aux = new ListaSE<Integer>();
           ListaSE<Integer> adyac = adyacencia.Obtener(aux.Obtener(i));
           
           for(int j = 0; j < adyac.Longitud(); j++) 
              aux.Adicionar(adyac.Obtener(j));
           g.adyacencia.Adicionar(aux);
        }
        return g;
    }

    @Override
     public ListaSE<T> EnProfundidad() throws Exception {
        ListaSE<T> visitados = new ListaSE<T>();
        for(int i=0;i<lista.Longitud();i++)
            if(visitados.Buscar(lista.Obtener(i))==-1)
                visitados=BuscarPorProfundidad(lista.Obtener(i),visitados);
        return visitados;
    }
     
    private  ListaSE<T> BuscarPorProfundidad(T x,ListaSE<T> visitados) throws Exception{
        if(visitados.Buscar(x)==-1)
            visitados.Adicionar(x);
        for(int i=0;i<Adyacentes(x).Longitud();i++)
            if(visitados.Buscar(Adyacentes(x).Obtener(i))==-1)
             visitados=BuscarPorProfundidad(Adyacentes(x).Obtener(i),visitados);
        return visitados;
    }

    @Override
    public boolean EsConexo() throws Exception {
        ListaSE<T> visitados = new ListaSE<T>();
        visitados = BuscarPorProfundidad(lista.Obtener(0),visitados);
        return visitados.Longitud()==lista.Longitud();
    }

    @Override
    public ListaSE<T> MenorCamino(T v1, T v2) {
        return null;
    }
    
    public int Buscar(T x){
    	
        return lista.Buscar(x);
  
    }

    @Override
    public ListaSE<T> Adyacentes(T v) throws Exception {
        ListaSE<T> result = new ListaSE<T>();
        ListaSE<Integer> adyacentes = adyacencia.Obtener(PosicionDelVertice(v));
        for(int i=0;i<adyacentes.Longitud();i++)
            result.Adicionar(lista.Obtener(adyacentes.Obtener(i)));
        return result;
    }
    
    public void MostrarGrafo() throws Exception //Daniel
    {
        for (int i=0; i<lista.Longitud(); i++)
        {
            System.out.println(lista.Obtener(i).toString());
            
            if(adyacencia.Obtener(i).Longitud()>0)
            {
                System.out.println("  Almacenes adyacentes: ");
            
                for(int j=0; j<adyacencia.Obtener(i).Longitud(); j++)
                {
                    String msg=lista.Obtener(adyacencia.Obtener(i).Obtener(j)).toString();
                    System.out.println("\t" + msg);
                }
            }
            else
                System.out.println("  No tiene almacenes adyacentes");
        }
    }
}