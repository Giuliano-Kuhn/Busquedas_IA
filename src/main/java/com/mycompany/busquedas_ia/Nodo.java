package com.mycompany.busquedas_ia;

public class Nodo {
    public int distancia;
    public Nodo der;
    public Nodo izq;
    public int heuristica;

    public Nodo(int distancia, Nodo der, Nodo izq) {
        this.distancia = distancia;
        this.der = der;
        this.izq = izq;
    }
    
}
