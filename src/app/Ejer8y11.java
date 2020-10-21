package app;
import java.io.*;

public class Ejer8y11 {
    //Copia arquivos binarios
    public static void copiarArchivoBinario(File f, String destino){
        File copia = new File(destino);
        try(FileInputStream in = new FileInputStream(f); FileOutputStream out = new FileOutputStream(copia)){
            int i;
            byte[] buffer = new byte[100];
            while((i = in.read(buffer)) != -1){
                //out.write(i);
                out.write(buffer, 0, i);
            }
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    //zip 5,6MB
    //Sen buffer, 3047 miliseg
    //Con buffer 1000, 116 miliseg
    // Con buffer 100, 160 mseg
    // Con buffer 500, 119 mseg

    //foto oso 18,1kB
    //Sen buffer, 42 mseg
    //Con buffer 1000, 2 mseg
    //Con buffer 100, 2 mseg
    //Con buffer 500, 2 mseg

    //Canto máis grande sexa o ficheiro, máis compensará aumentar o tamaño do buffer.
    //(Se o arquivo é relativamente pequeno un buffer de gran tamaño non supón unha mellora da eficiencia)


    public static void copiarBinarioBuffer(File f, String destino){
        File copia = new File(destino);
        int i;
        try(FileInputStream in = new FileInputStream(f); FileOutputStream out = new FileOutputStream(copia)){
            try(BufferedInputStream bufIn = new BufferedInputStream(in); BufferedOutputStream bufOut = new BufferedOutputStream(out)){
                while((i = bufIn.read())!=-1){
                    bufOut.write(i);
                }
            }
        }catch(IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    //Arquivo mp3 85.4MB
    //Con BufferedStream, 23756 mseg    ---por defecto, buffer de 8192B (8kB)

    //Con FileStream ( funcion copiarArchivoBinario() )
    //Con buffer[10], 25370 mseg
    //Con buffer[100], 24717 mseg
    //Con buffer[1000], 19118 mseg
}