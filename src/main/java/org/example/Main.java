package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] asientos = new String[5][5];
        mostrarAsientos(rellenarAsientos(asientos));
        menu(asientos);
    }
    public static int validarInt(){
        Scanner teclado = new Scanner(System.in);
        try {
            int ans = teclado.nextInt();
            return ans;
        }catch (Exception e){
            System.out.println("Ingrese un número");
            return -1;
        }
    }
    public static void menu(String[][] asientos){
        Scanner teclado = new Scanner(System.in);
        int ans = 0;

        do {
            System.out.println("Que desea hacer: ");
            System.out.println("[1] Ver asientos disponibles");
            System.out.println("[2] Comprar/reservar asiento");
            System.out.println("[3] Salir del programa");
            ans = validarInt();
        }while (ans==-1);
        llamarMetodos(ans,asientos);
        menu(asientos);
    }
    public static void llamarMetodos(int ans, String[][] asientos){
        switch (ans){
            case 1:
                mostrarAsientos(asientos);
                break;
            case 2:
                System.out.println("Que asiento desea comprar");
                comprarAsiento(asientos);
                break;
            case 3:
                mostrarAsientos(asientos);
                System.out.println("Saliendo del programa...");
                System.exit(0);
                break;
            default:
                System.out.println("Ingrese un número valido");
        }
    }
    public static String[][] rellenarAsientos(String[][] asientos){
        char letra = 'a';
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                asientos[i][j] = j +1+ String.valueOf(letra);
            }
            letra++;
        }return asientos;
    }
    public static void mostrarAsientos(String[][] asientos){
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                System.out.print("|"+asientos[i][j]+"|");
            }
            System.out.println();
        }
    }
    public static String pedirRespuesta(){
        Scanner teclado = new Scanner(System.in);
        return teclado.next();
    }
    public static String[][] comprarAsiento(String[][] asientos){
        String respuesta = pedirRespuesta();
        if (respuesta.equals("--")){
            System.out.println("Ingrese un asiento válido");
            return asientos;
        }else{
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                if (respuesta.equals(asientos[i][j])){
                    asientos[i][j]="--";
                    return asientos;
                }}

            }
        }
        System.out.println("Ingrese un asiento válido");
        return asientos;
    }
}