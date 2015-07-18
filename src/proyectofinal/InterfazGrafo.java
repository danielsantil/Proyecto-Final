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
public interface InterfazGrafo<T> {
    boolean EsVacio();
    int NumeroDeVertices();
    int NumeroDeArcos() throws Exception;
    boolean EstaElVertice(T v) throws Exception;
    boolean EstaElArco(T v1, T v2) throws Exception;
    void InsertarVertice(T v)throws Exception;
    void InsertarArco(T v1, T v2) throws Exception;
    void EliminarVertice(T v) throws Exception;
    void EliminarArco(T v1, T v2) throws Exception;
    void ReemplazarVertice(T v1, T v2) throws Exception;
    ListaSE<T> Adyacentes(T v) throws Exception;
    ListaSE<T> ALoAncho() throws Exception;
    ListaSE<T> EnProfundidad() throws Exception;
    boolean EsConexo() throws Exception;
    ListaSE<T> MenorCamino(T v1, T v2);
    InterfazGrafo<T> Copiar() throws Exception;
}
