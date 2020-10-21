package app;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejer6 {
    // Divide fichero en función dun número de n caracteres (cada ficheiro xerado
    // posúe n caracteres)
    public static void divCharFichero(File f, int numChar) {
        int cont = 1;
        int i;
        char[] buffer = new char[numChar];

        try (FileReader fichIn = new FileReader(f)) {
            while ((i = fichIn.read(buffer)) != -1) {
                try(FileWriter fichOut = new FileWriter(new File(nuevoFichero(f, "DivChar"+cont,"txt")))){
                    fichOut.write(new String(buffer, 0, i));
                    cont++;
                } catch (IOException e){
                    System.out.println("Error de escritura"+e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error de lectura: " + e.getMessage());
        }
    }

    // Divide ficheiro en funcion dun número l de liñas
    public static ArrayList<File> divLineaFichero(ArrayList<File> colec, File f, int numLineas) { //Para unir param  e devolve 
        int num = 0;
        int cont = 1;

        try (Scanner sc = new Scanner(f)){
            while(sc.hasNext()){
                try(PrintWriter pw = new PrintWriter(new File(nuevoFichero(f, "DivLinea" + cont, "txt")))){    
                    while (num < numLineas) {
                        if(sc.hasNextLine()){
                            pw.println(sc.nextLine());
                        }
                        num++;
                    }
                    colec.add(f);
                    cont++;
                    num = 0;                    
                } catch(IOException e){
                    System.out.println("Error de escritura: "+e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error de lectura: " + e.getMessage());
        } 
        return colec;
    }

    // Une colección de ficheiros
    public static void unionFich(ArrayList<File> colec, File fichSalida) {
        for (File f : colec) {
            try (Scanner sc = new Scanner(f); PrintWriter pw = new PrintWriter(new FileWriter(fichSalida, false))) {
                while (sc.hasNext()) {
                    pw.println(sc.nextLine());
                }
            } catch (IOException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public static String nuevoFichero(File f, String nombre, String extension) {
        String ruta = f.getAbsolutePath();
        return ruta.substring(0, ruta.lastIndexOf(f.getName())) + nombre + "."+extension; // coller o ficheiro.getName() e o que
                                                                                  // quede (ou non) será extension
    }
}