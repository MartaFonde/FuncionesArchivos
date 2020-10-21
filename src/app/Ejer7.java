package app;

import java.io.*;
import java.util.*;

public class Ejer7 {

    List<String> lista;
    
    public Ejer7(){
        lista = new ArrayList<String>();
    }

    public void menu(File f, char opcion) {

        listaLineas(f);

        switch (opcion) {
            case 'n':
                int numPalabras = 0;
                for (String l : lista) {
                    Scanner sc2 = new Scanner(l);
                    while (sc2.hasNext()) {
                        sc2.next(); // Sen isto non para de contar
                        numPalabras++;
                    }
                    sc2.close();
                }
                System.out.println("Número filas: " + lista.size());
                System.out.println("Número palabras: " + numPalabras);
                break;
            case 'A':
                Collections.sort(lista);
                nuevoArchivo(f, "ordenA", "txt");
                break;
            case 'D':
                Collections.sort(lista, Collections.reverseOrder());
                nuevoArchivo(f, "ordenD", "txt");
                break;
            case 'a':
                Collections.sort(lista, String.CASE_INSENSITIVE_ORDER);
                nuevoArchivo(f, "orden_a", "txt");
                break;
            case 'd':
                Comparator<String> cmpDescNoSensibleCaso = new ComparatorDescNoSensibleCaso();
                Collections.sort(lista, cmpDescNoSensibleCaso);
                nuevoArchivo(f, "orden_d", "txt");
                break;
        }
    }

    public void listaLineas(File f){
        String linea;

        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNext()) {
                linea = sc.nextLine();
                lista.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void nuevoArchivo(File f, String nombreFich, String ext) {
        try (PrintWriter pw = new PrintWriter(
                new File(f.getAbsolutePath().replace(f.getName(), nombreFich + "." + ext)))) { 
            for (int i = 0; i < lista.size(); i++) {
                pw.println(lista.get(i));
            }
        } catch (IOException e) {
            System.out.println("Error de escritura: " + e.getMessage());
        }

    }
}
