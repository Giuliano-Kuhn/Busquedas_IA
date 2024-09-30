package com.mycompany.busquedas_ia;


public class Arbol {
    Nodo raiz;

    public Arbol(int distancia) {
        raiz = new Nodo(distancia, null, null);
    }
    
    
    public void Armar_Rama_Izq(int veces){
            int distancia = 0;
        for (int i = 0; i < veces; i++) {
            Nodo n = new Nodo(distancia, null, null);
            Nodo aux = raiz;
                while(aux.izq!= null){
                    aux = aux.izq;   
                }
            distancia--;
            n.distancia = distancia;
            aux.izq = n;
        }
    }
    
    
    
    
    public void Armar_Rama_Der(int veces){
            int distancia = 0;
        for (int i = 0; i < veces; i++) {
            Nodo n = new Nodo(distancia, null, null);
            Nodo aux = raiz;
                while(aux.der!= null){
                    aux = aux.der;   
                }
            distancia++;
            n.distancia = distancia;
            aux.der = n;
        }
    }
    
    
    public void recorrer(Nodo n){
        if (n != null) {
            recorrer(n.izq);
            System.out.println(n.distancia);
            recorrer(n.der);
        }
    }
}
