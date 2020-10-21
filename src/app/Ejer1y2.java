package app;

import java.io.*;

public class Ejer1y2 {
    // 1. Mostra, de forma separada, os ficheiros e directorios que posúe un dir.
    public static void contenido(File f, boolean fichero) {
        File[] c = f.listFiles();   //utilizar o ARRAY, non directamente f.listFiles(), para que non recorra todo f.listFiles() nos if
        for (int i = 0; i < c.length; i++) {
            if (fichero && c[i].isFile()) {
                System.out.println(c[i]);
            }
            if (!fichero && c[i].isDirectory()) {
                System.out.println(c[i]);
            }
        }
    }

    // 2. Emular o comando "dir / s / b directorio" de MSDos ou "find directorio" en Linux.
    public static void tree(File f){
        for(int i = 0; i < f.list().length; i++){
            System.out.println(f.listFiles()[i]);
            if(f.listFiles()[i].isDirectory()){
                tree(f.listFiles()[i]);
            }
        }     
    }

    public static void main(String[] args) throws Exception {
        //String ruta = System.getProperty();
        // File f = new File("C:\\Windows\\System32");
        // System.out.println("Ficheros:");
        // contenido(f, true);
        // System.out.println("\nDirectorios:");
        //contenido(f, false);
        // File f = new File("/home/pc/Escritorio/Bol7_Ejer10"); 
        // tree(f);
    }
}