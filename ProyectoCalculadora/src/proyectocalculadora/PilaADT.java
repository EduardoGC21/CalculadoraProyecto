/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectocalculadora;

/**
 * Interface que contiene las funciones de la clase PilaA
 * @author Eduardo Garcia, Regina Sanz, Emilia Hernandez, Manuel McCadden
 */
public interface PilaADT <T> {
    /**
     * Metodo que agrega datos a pilas
     * @param T dato tipo T
     */
    public void push(T dato);
    
    /**
     * Metodo que elemina el ultimo elemento agregado de la pila
     * @param dato Tipo T
     */
    public T pop();
    
    /**
     * Metodo que devuelve el ultimo elemento agregado de la pila
     * @param dato Tipo T
     */
    public T peek();
    
    /**
     * Metodo que revisa si la pila esta vacia 
     * @param dato Tipo T
     */
    public boolean isEmpty();
    
}
