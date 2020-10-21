package app;

import java.util.Comparator;

public class ComparatorDescNoSensibleCaso implements Comparator<String> {

    @Override
    public int compare(String fila1, String fila2) {
        int r = fila1.toLowerCase().compareTo(fila2.toLowerCase()); // "a" compareTo("b") --> -1 --> a precede a b. Se
                                                                    // cambiamos o sgno, b colocase antes ca a
        return -r;
    }

}