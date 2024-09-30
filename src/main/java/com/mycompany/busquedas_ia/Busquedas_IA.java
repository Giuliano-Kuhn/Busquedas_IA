package com.mycompany.busquedas_ia;

import java.util.Scanner;

public class Busquedas_IA {

    public static void main(String[] args) {
        int tipo_busqueda;
        int Posicion_Inicial = 0;
        int Posicion_Objetivo = 0;
        int Limite_Habitual = 5;
        Arbol arbol = new Arbol(0);
        arbol.Armar_Rama_Izq(Limite_Habitual);
        arbol.Armar_Rama_Der(Limite_Habitual);
        arbol.recorrer(arbol.raiz);

        
        Scanner Menu1 = new Scanner(System.in);
        Scanner Pos = new Scanner(System.in);
        int opcion;
        int bus;
        
        do {   
            System.out.println("Menú:");
            System.out.println("1. Definir Posicion Objetivo");
            System.out.println("2. Busqueda Exahustiva");
            System.out.println("3. Busqueda Heuristica");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = Menu1.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Posicion Objetivo: ");
                    Posicion_Objetivo = Pos.nextInt();
                    System.out.println(Posicion_Objetivo);
                    break;
                case 2:
                    System.out.println("Se llama a Busqueda Exaustiva");
                    Busqueda_Exhaustiva BEX = new Busqueda_Exhaustiva(Posicion_Inicial ,Posicion_Objetivo, arbol);
                    break;
                case 3:
                    System.out.println("Se llama a Busqueda Heuristica");
                    Busqueda_Heuristica BHE = new Busqueda_Heuristica(Posicion_Inicial, Posicion_Objetivo, arbol);
                    break;
                    
                case 0:
                    System.out.println("Saliendo del menú...");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
            }

            System.out.println();
        } while (opcion != 0);

        Menu1.close();
        
        

    }
}
