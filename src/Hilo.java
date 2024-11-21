/**
 * clase con el hilo de la aplicación
 * @author criatian
 * @version 1.0
 */
public class Hilo implements Runnable {

    //variables para el hilo
    private Establecimiento estable;
    private Entradas entrada;
    private Intentos intentos;


    /**
     * Constructor de la clase
     * @param estable el establecimiento
     * @param entrada las entradas
     * @param intentos los intentos
     */
    public Hilo(Establecimiento estable, Entradas entrada, Intentos intentos) {
        this.estable = estable;
        this.entrada = entrada;
        this.intentos = intentos;
    }

    /**
     * metodo que va a ejecutar le hilo
     */
    @Override
    public void run() {
        try{
            //llamamos al metodo para entrar en el establecimiento
            estable.entrarEstablecimiento(entrada, intentos);
        } catch (InterruptedException e) {
            System.out.println("Ups, ha ocurrido un error al coger entradas, nos quedamos sin ver a taylor swift");
        }
    }


}
