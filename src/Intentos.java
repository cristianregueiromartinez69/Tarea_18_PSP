public class Intentos {

    private int intentos = 0;
    private final int MAX_INTENTOS = 5;

    public synchronized void incrementoIntentos() {
        intentos++;
    }

    public synchronized int getIntentos() {
        return intentos;
    }

    public int getMaxIntentos(){
        return MAX_INTENTOS;
    }
}
