package com.mycompany.busquedas_ia;

public class Busqueda_Exhaustiva {
    boolean Encontrado;
    int Posicion_Inicial;
    int Posicion_Objetivo;
    Arbol Arbol;

    public Busqueda_Exhaustiva(int Posicion_Inicial, int Posicion_Objetivo, Arbol Arbol) {
        this.Posicion_Inicial = Posicion_Inicial;
        this.Posicion_Objetivo = Posicion_Objetivo;
        this.Arbol = Arbol;
        Encontrado = Busqueda_Izq();
        
        if(!Encontrado){
        Busqueda_Der();
        }
        
    }
    
        
    public boolean Busqueda_Izq(){
        Nodo aux = Arbol.raiz;
        boolean Respuesta = false;
        while(aux != null){
            System.out.println("Posicion de aux: "+aux.distancia +"  Posicion Objetivo: "+Posicion_Objetivo);
            if (aux.distancia == Posicion_Objetivo) {
                System.out.println("Objetivo alcanzado");
                System.out.println("Posicion encontrada en la RAMA IZQUIERDA");
                Respuesta = true;
                break;
            }
                aux = aux.izq;
        }
        
      return Respuesta;  
    }
    
    public boolean Busqueda_Der(){
        Nodo aux = Arbol.raiz;
        boolean Respuesta = false;
        while(aux != null){
            System.out.println("Posicion de aux: "+aux.distancia +"  Posicion Objetivo: "+Posicion_Objetivo);
            if (aux.distancia == Posicion_Objetivo) {
                System.out.println("Objetivo alcanzado");
                System.out.println("Posicion encontrada en la RAMA DERECHA");
                Respuesta = true;
                break;
            }
                aux = aux.der;
        }
      return Respuesta;  
    }
    
    
    
    
    
    
    
    
    

}
