/**
 * Clase para comprobar los intentos
 */
public class Intentos {

    //variable de intentos a 0
    private int intentos = 0;

    /**
     * metodo para incrementar los intentos
     */
    public synchronized void incrementoIntentos() {
        intentos++;
    }

    /**
     * metodo para devolver los intentos
     * @return los intentos
     */
    public synchronized int getIntentos() {
        return intentos;
    }


}
