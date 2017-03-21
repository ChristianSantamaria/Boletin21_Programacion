/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin21;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author christian
 */
public class Boletin21 {

    /**
     * @param args the command line arguments
     */
    public static void engadir(String nomFich, ArrayList<String> lista) {
        PrintWriter engado = null;
        FileWriter fich;
        try {
            engado = new PrintWriter(new FileWriter(nomFich, true));
            for (int i = 0; i < lista.size(); i++) {
                engado.print(lista.get(i) + "\n");
            }
            engado.println("\n");
        } catch (IOException ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            engado.close();
        }

    }

    public static void main(String[] args) {
        ArrayList<String> listaNomes = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba una frase:");
        String frase = sc.nextLine();

        String matriz[] = frase.split(" ");

        for (int i = 0; i < (matriz.length - 1); i++) {
            for (int j = i + 1; j < matriz.length; j++) {
                if (matriz[i].compareToIgnoreCase(matriz[j]) > 0) {
                    
                    String variableauxiliar = matriz[i];
                    matriz[i] = matriz[j];
                    matriz[j] = variableauxiliar;

                }
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            listaNomes.add(matriz[i]);
        }
        Collections.sort(listaNomes);
        engadir("ArchivoPalabras.txt", listaNomes);
    }

}
