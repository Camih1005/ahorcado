package com.ahorcado;

public class vdf {
    public static void main(String[] args) {
        String palabraAdivinar = "java";
        StringBuilder palabraConGuiones = new StringBuilder();

        // Inicializar con guiones bajos
        for (int i = 0; i < palabraAdivinar.length(); i++) {
            palabraConGuiones.append("_");
        }

        System.out.println("Palabra inicial: " + palabraConGuiones.toString());

        // Simular adivinar letras
        char letraAdivinada = 'a';  // Supongamos que el usuario adivinó 'a'

        for (int i = 0; i < palabraAdivinar.length(); i++) {
            if (palabraAdivinar.charAt(i) == letraAdivinada) {
                palabraConGuiones.setCharAt(i, letraAdivinada);
            }
        }

        System.out.println("Palabra después de adivinar 'a': " + palabraConGuiones.toString());

        // Simular adivinar otra letra
        letraAdivinada = 'j';  // Supongamos que el usuario adivinó 'j'

        for (int i = 0; i < palabraAdivinar.length(); i++) {
            if (palabraAdivinar.charAt(i) == letraAdivinada) {
                palabraConGuiones.setCharAt(i, letraAdivinada);
            }
        }

        System.out.println("Palabra después de adivinar 'j': " + palabraConGuiones.toString());
    }
}

