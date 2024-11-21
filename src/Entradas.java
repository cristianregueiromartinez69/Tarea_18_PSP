public class Entradas {

    private int entradas = 50;

    private final int MIN_ENTRADAS = 0;

    public synchronized void disminuirEntradas(){
        entradas--;
    }

    public synchronized int getEntradas(){
        return entradas;
    }

    public synchronized int getMinEntradas(){
        return MIN_ENTRADAS;
    }
}
