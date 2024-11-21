public class Entradas {

    private int entradas = 50;

    public synchronized void aumentarEntradas(){
        entradas++;
    }

    public synchronized void disminuirEntradas(){
        entradas--;
    }

    public synchronized int getEntradas(){
        return entradas;
    }
}
