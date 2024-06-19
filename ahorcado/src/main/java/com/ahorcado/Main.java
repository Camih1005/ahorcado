package com.ahorcado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

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
                    break;
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
        int intentos = 3;

        int tamañoObj = objetos.size();
        int numeroAleatorio = random.nextInt(tamañoObj);
        String palabra = objetos.get(numeroAleatorio);
        int tamañoPalabra = palabra.length();
        System.out.println("Escribe una letra:\n");

        StringBuilder palabraConGuiones = new StringBuilder();
        for (int i = 0; i < tamañoPalabra; i++) {
            palabraConGuiones.append("_");
        }

        while (intentos > 0) {
            System.out.println("Palabra: " + palabraConGuiones.toString());
            System.out.println("Intentos restantes: " + intentos);
            System.out.print("Introduce una letra: ");
            char letra = scc.nextLine().charAt(0);

            boolean letraEncontrada = false;
            for (int i = 0; i < palabra.length(); i++) {
                if (palabra.charAt(i) == letra) {
                    palabraConGuiones.setCharAt(i, letra);
                    letraEncontrada = true;
                }
            }

            if (!letraEncontrada) {
                intentos--;
                System.out.println("Letra incorrecta. Intentos restantes: " + intentos);
            }
            else if(letra > 1){
                System.out.println("no se pueden mas de 2 letras");
            }
            else {
                System.out.println("¡Has acertado!");
            }

            if (palabraConGuiones.indexOf("_") == -1) {
                System.out.println("¡Felicidades! Has adivinado la palabra: " + palabra);
                return;
            }
        }

        System.out.println("Has perdido. La palabra era: " + palabra);
    }
}
