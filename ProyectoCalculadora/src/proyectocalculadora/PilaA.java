/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocalculadora;

/**
 * Clase que contiene todas las funciones de la pila
 * @author Eduardo Garcia, Regina Sanz, Emilia Hernandez, Manuel McCadden
 */
public class PilaA <T> implements PilaADT <T>{
    private T[] pila;
    private int tope;
    private final int MAX=100;

    public PilaA() {
        tope=-1;
        pila = (T[]) new Object[MAX];
    }
    
    public PilaA(int max) {
        tope=-1;
        pila = (T[]) new Object[max];
    }
    
    /**
     * Metodo que nos dice si la pila esta vacia
     * @return
     * <ul>
     * <li> True si la pila esta vacia </li>
     * <li> False si la pila no esta vacia </li>
     * </ul>
     */
    
    public boolean isEmpty(){
        return tope == -1;
    }
    
    /**
     * Metodo que agrega un elemento a la pila
     * @param T dato tip T
     * @see expande
     */
    public void push(T dato){
        if(tope == pila.length-1){
            expande();
        }
        tope++;
        pila[tope]=dato;
    }
    
    /**
     * Metodo que hace mas grande la pila
     */
    private void expande(){
        T[] masGrande = (T[]) new Object[pila.length * 2];
        
        for(int i=0; i<=tope; i++){
            masGrande[i] = pila[i];
        }
        pila = masGrande;
       
    }
    
   
    /**
     * Metodo que quita el ultimo elemento agregado a la pila
     * @return 
     * <ul>
     * <li> Elemento tipo T si la pila no esta vacia </li>
     * <li> ExcepcionColeccionVacia si la pila esta vacia </li>
     * </ul>
     */
    public T pop(){
        if(isEmpty()){
            throw new ExcepcionColeccionVacia("la pila no tiene elementos");//regresa el main pero con el mensaje de error
        }//si se activa el throw saca del metodo
        
        T eliminado = pila[tope];
        pila[tope] = null;
        tope--;  
        return eliminado;
    }
    
    /**
     * Metodo que devuelve el ultimo elemento agregado a la pila
     * @return 
     * <ul>
     * <li> Elemento tipo T si la pila no esta vacia </li>
     * <li> ExcepcionColeccionVacia si la pila esta vacia </li>
     * </ul>
     */
    public T peek(){
        if(isEmpty()){
            throw new ExcepcionColeccionVacia("la pila no tiene elementos");//regresa el main pero con el mensaje de error
        }//si se activa el throw saca del metodo
        
        return pila[tope];
    }
    
    /**
     * Metodo que imprime los elementos de una pila
     * @return String que tiene todos los elementos de la pila
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        for(int i =0; i <= tope; i++)
            sb.append(pila[i]).append(" ");
        return sb.toString();
    }
}
