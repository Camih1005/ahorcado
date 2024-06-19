package com.ahorcado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

    static ArrayList<String> objetos = new ArrayList<>(Arrays.asList("televisor", "celular", "camara", "portatil", "microfono", "cargador", "ventilador"));

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            mostrarMenu();
            int opcionMain = sc.nextInt();
            sc.nextLine();

            switch (opcionMain) {
                case 1:
                    System.out.println("\t¡Has ingresado al juego!");
                    jugarAhorcado();
                    return;
                case 2:
                    System.out.println("Saliendo del juego...");
                    sc.close(); 
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, ingresa 1 o 2.");
                    break;
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("------------------------------");
        System.out.println("Bienvenidos al juego el ahorcado");
        System.out.println("--------------------------------");
        System.out.println(" 1. Jugar");
        System.out.println(" 2. Salir");
        System.out.println("Elige una opción: ");
    }

    public static void jugarAhorcado() {
        Scanner scc = new Scanner(System.in);
        System.out.println("\n\tREGLAS DEL JUEGO\n\n");
        System.out.println("1. Tienes 3 intentos de equivocacion\n");
        System.out.println("2. Ya no hay mas reglas\n");
        System.out.println("*-*-*-*JUGANDO*-*-*-*");

        Random random = new Random();
        
        ArrayList <Character> letrasAdivinadas = new ArrayList<>();
        ArrayList <Character> letrasIncorrectas = new ArrayList<>();

        int tamañoObj = objetos.size();
        int numeroAleatorio = random.nextInt(tamañoObj);
        String palabra = objetos.get(numeroAleatorio);
        int tamañoPalabra = palabra.length();
        System.out.print("Escribe una letra:\n");
        for (int i = 0; i < tamañoPalabra; i++) {
            System.out.print("_ ");
            System.out.print(" ");
        }
        System.out.println();
        System.out.println(palabra);
        char letra = scc.nextLine().charAt(0);
        
        while (true) {
            if(palabra.indexOf(letra) >= 0){
                System.out.println("gay");
                
                
            }else{
                System.out.println("nada");
            }
        }
    }
}
