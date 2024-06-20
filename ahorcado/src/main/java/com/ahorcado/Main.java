package com.ahorcado;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static ArrayList<String> objetos = new ArrayList<>(Arrays.asList("televisor", "celular", "camara", "portatil", "microfono", "cargador", "ventilador"));

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Main mn = new Main();

        while (true) {
            String opcionMain;
            mostrarMenu();
            opcionMain = mn.leerdato(sc,"Digite una opcion: ");
            switch (opcionMain) {
                case "1":
                    System.out.println("\t¡Has ingresado al juego!");
                    jugarAhorcado(sc);
                    break;
                case "2":
                    System.out.println("HASTA NUNCA...");
                    sc.close();
                    return;
                default:
                    System.out.println("\t\t\nOpción no válida. Por favor, ingresa 1 o 2.\t\n");
                    continue;
            }
        }
    }

    private String leerdato(Scanner sc,String msg){
        String opcionMain = "";
        try {
            System.out.print(msg);
            opcionMain = sc.nextLine();   
       } catch (Exception e) {
           System.out.println(e);
       }
       
        return opcionMain;
    }

    public static void menuSalida(){
        System.out.println("    )          (                      (                           )   \n" + //
                        " ( /(   (      )\\ )  *   )    (       )\\ )             (       ( /(   \n" + //
                        " )\\())  )\\    (()/(` )  /(    )\\     (()/(    (   (    )\\ )    )\\())  \n" + //
                        "((_)\\((((_)(   /(_))( )(_))((((_)(    /(_))   )\\  )\\  (()/(   ((_)\\   \n" + //
                        " _((_))\\ _ )\\ (_)) (_(_())  )\\ _ )\\  (_))  _ ((_)((_)  /(_))_   ((_)  \n" + //
                        "| || |(_)_\\(_)/ __||_   _|  (_)_\\(_) | |  | | | || __|(_)) __| / _ \\  \n" + //
                        "| __ | / _ \\  \\__ \\  | |     / _ \\   | |__| |_| || _|   | (_ || (_) | \n" + //
                        "|_||_|/_/ \\_\\ |___/  |_|    /_/ \\_\\  |____|\\___/ |___|   \\___| \\___/ ");
    }

    public static void mostrarMenu() {
        
        System.out.println(" _______         _______ _______ _______ _______ _______ _______ _       _______ \n" + //
                    "(  ___  |\\     /(  ___  (  ____ (  ____ (  ___  (       (  ____ ( \\     (  ___  )\n" + //
                    "| (   ) | )   ( | (   ) | (    )| (    \\| (   ) | () () | (    \\| (     | (   ) |\n" + //
                    "| (___) | (___) | |   | | (____)| |     | (___) | || || | (__   | |     | |   | |\n" + //
                    "|  ___  |  ___  | |   | |     __| |     |  ___  | |(_)| |  __)  | |     | |   | |\n" + //
                    "| (   ) | (   ) | |   | | (\\ (  | |     | (   ) | |   | | (     | |     | |   | |\n" + //
                    "| )   ( | )   ( | (___) | ) \\ \\_| (____/| )   ( | )   ( | (____/| (____/| (___) |\n" + //
                    "|/     \\|/     \\(_______|/   \\__(_______|/     \\|/     \\(_______(_______(_______)");
                    System.out.println("\n--------------------------------------------------------------------------------\n");
                    System.out.println("\t*****************************************************");
                    System.out.println("\t*                     AHORCADO                      *");
                    System.out.println("\t*****************************************************");
                    System.out.println("\t*                                                   *");
                    System.out.println("\t*  1. Jugar                                         *");
                    System.out.println("\t*  2. Salir                                         *");
                    System.out.println("\t*                                                   *");
                    System.out.println("\t*****************************************************\n");
                    
    }

    public static void jugarAhorcado(Scanner scc) {
        
      System.out.println("\n\t****************************************************");
      System.out.println("\t*                REGLAS DEL JUEGO                   *");
      System.out.println("\t*****************************************************");
      System.out.println("\t*                                                   *");
      System.out.println("\t*  - El juego trata sobre productos tecnológicos    *");
      System.out.println("\t*  - Tienes 3 intentos para adivinar la palabra.    *");
      System.out.println("\t*                                                   *");
      System.out.println("\t*****************************************************");
      System.out.println("\n\t*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");

        Random random = new Random();
        int intentos = 3;
        int tamañoObj = objetos.size();
        int numeroAleatorio = random.nextInt(tamañoObj);
        String palabra = objetos.get(numeroAleatorio);
        int tamañoPalabra = palabra.length();



        StringBuilder palabraConGuiones = new StringBuilder();
        for (int i = 0; i < tamañoPalabra; i++) {
            palabraConGuiones.append("_");
        }

        while (intentos > 0) {
            System.out.println("\tPalabra: " + palabraConGuiones.toString());
            System.out.println("\tIntentos restantes: " + intentos);
            System.out.print("\tIntroduce una letra: \n\n");
            System.out.print("\t********************\n");
            char letra = scc.nextLine().toLowerCase().charAt(0);
            boolean letraEncontrada = false;

            for (int i = 0; i < palabra.length(); i++) {
                if (palabra.charAt(i) == letra) {
                    palabraConGuiones.setCharAt(i, letra);
                    letraEncontrada = true;
                }
            }



            if (!letraEncontrada) {
                intentos--;
                System.out.println("\tLetra incorrecta. Intentos restantes: " + intentos);
            }
            else if(String.valueOf(letra).length() > 1){
                System.out.println("\tno se pueden mas de 2 letras");
                 
                continue;
            }
          
            else {
                System.out.println("\t¡Has acertado!");
            }
            
            if (palabraConGuiones.indexOf("_") == -1) {
                System.out.println("\t¡Felicidades! Has adivinado la palabra: " + palabra);
                System.out.println("Quieres jugar de nuevo? elije el numero \n 1. Si \n 2. No");
                try {
                    letra  = scc.nextLine().charAt(0);
                } catch (Exception e) {
                    System.out.println("Error" + e);
                    }
                 
                if(String.valueOf(letra).equals("1")){
                    mostrarMenu();
                    return;
                }
                else if(!String.valueOf(letra).equals("1")){
                    menuSalida();
                    intentos = 0;
                    continue;
                }
            }
        }


        //System.out.println("\tHas perdido. La palabra era: " + palabra);
    }


}
