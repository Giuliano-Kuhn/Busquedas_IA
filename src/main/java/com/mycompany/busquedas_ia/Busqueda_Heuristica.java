package com.mycompany.busquedas_ia;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Busqueda_Heuristica {
    boolean Encontrado;
    int Posicion_Inicial;
    int Posicion_Objetivo;
    Arbol Arbol;

    public Busqueda_Heuristica(int Posicion_Inicial, int Posicion_Objetivo, Arbol Arbol) {
        this.Posicion_Inicial = Posicion_Inicial;
        this.Posicion_Objetivo = Posicion_Objetivo;
        this.Arbol = Arbol;
        Encontrado = Busqueda_Heuristica();
    }
    
    public boolean Busqueda_Heuristica() {
        PriorityQueue<Nodo> pq = new PriorityQueue<>(new Comparator<Nodo>() {
            @Override
            public int compare(Nodo o1, Nodo o2) {
                return Integer.compare(o1.heuristica,o2.heuristica);
            }
        });
        int HeuR = calcularHeuristica(Arbol.raiz);
        AsignarHeristica(Arbol.raiz, HeuR);
        pq.add(Arbol.raiz);  // Añadimos el nodo raíz

        while (!pq.isEmpty()) {
            int heu_izq;
            int heu_der;
            Nodo aux = pq.poll();  // Sacamos el nodo con la menor heurística

            if (aux.izq != null) {  // Añadimos los vecinos a la cola de prioridad si no son nulos
                heu_izq = calcularHeuristica(aux.izq);
                AsignarHeristica(aux.izq, heu_izq);
                if (heu_izq == 0) {
                    Encontrado = true;
                    System.out.println("OBJETIVO ENCONTRADO EN: "+ aux.izq.distancia);
                    break;
                }
            }
            if (aux.der != null) {
                heu_der = calcularHeuristica(aux.der);
                AsignarHeristica(aux.der, heu_der);
                if (heu_der == 0) {
                    Encontrado = true;
                    System.out.println("OBJETIVO ENCONTRADO EN: "+ aux.der.distancia);
                    break;
                }
            }
            
            if (aux.izq != null && aux.der != null){
                if(aux.izq.heuristica >= aux.der.heuristica){
                pq.add(aux.izq);
                pq.add(aux.der);
                }else{ 
                pq.add(aux.der);
                pq.add(aux.izq);}
            }else if(aux.der == null){
                pq.add(aux.izq);
            }else if(aux.izq ==null){
                pq.add(aux.der);
            }   
        }
        return Encontrado;
    }

    // Función heurística basada en la distancia al objetivo
    public int calcularHeuristica(Nodo nodo) {
        return Math.abs(nodo.distancia - Posicion_Objetivo);
    }

    private void AsignarHeristica(Nodo nodo, int h) {
        nodo.heuristica = h;
        System.out.println("nodo: "+ nodo.distancia + " tiene la Heuristica de: " + h);
    }
}

