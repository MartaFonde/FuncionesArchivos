package app;

import java.io.*;
import java.util.*;

public class Ejer345 {
    // 3. Conta o número de ocorrencias do caracter no ficheiro
    public static int numOcurrencias(File f, char caracter) {
        int i;
        int n = 0;
        try (FileReader fichIn = new FileReader(f)) {
            while ((i = fichIn.read()) != -1) { // Mentres quede algún caracter sigue
                if ((char) i == caracter) {
                    n++;
                }
            }
        } catch (final IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return n;
    }

    // 4. Atopa o caracter máis usado
    public static ArrayList<Character> charMasUsado(File f) {
        int max = 0;
        int i;
        HashMap<Character, Integer> numChar = new HashMap<Character, Integer>(); // (KEY, VALUE)
        ArrayList<Character> caractMasUsado = new ArrayList<Character>();

        try (FileReader fichIn = new FileReader(f)) {
            while ((i = fichIn.read()) != -1) {
                if (!numChar.containsKey((char) i)) {
                    numChar.put((char) i, 1);
                } else {
                    numChar.replace((char) i, numChar.get((char) i) + 1);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        for (Integer j : numChar.values()) {
            if (j >= max) {
                max = j;
            }
        }
        for (Character caracter : numChar.keySet()) {
            if (numChar.get(caracter) == max) {
                caractMasUsado.add(caracter);
            }
        }
        return caractMasUsado;
    }

    // 5. Mostra as liñas onde aparece unha cadea de texto xunto co número de liña
    // na que aparece.
    public static void lineaCadena(File f, String cadena) {
        int numLinea = 0;
        String linea;

        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNext()) {
                numLinea++;
                linea = sc.nextLine();
                if (linea.contains(cadena)) { // posicion donde empieza la cadena .indexOf()
                    System.out.println(numLinea + " " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}