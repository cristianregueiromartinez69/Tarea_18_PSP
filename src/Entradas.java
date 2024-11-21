/**
 * Clase para comprobar el numero de entradas
 * @author cristian
 * @version 1.0
 */
public class Entradas {

    //variable del numero de entradas disponibles
    private int entradas = 50;

    /**
     * metodo para restar entradas
     */
    public synchronized void disminuirEntradas(){
        entradas--;
    }

    /**
     * metodo para devolver las entradas
     * @return el numero de entradas
     */
    public synchronized int getEntradas(){
        return entradas;
    }


}
