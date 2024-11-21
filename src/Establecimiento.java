/**
 * Clase establecimiento para controlar el acceso
 * @author cristian
 * @version 1.0
 */
public class Establecimiento {

    //variables de los establecimientos
    private boolean puertaVacia = true;
    private Entradas entradas;
    private Intentos intentos;

    /**
     * Constructor de la clase
     * @param entradas las entradas
     * @param intentos los intentos
     */
    public Establecimiento(Entradas entradas, Intentos intentos) {
        this.entradas = entradas;
        this.intentos = intentos;
    }

    /**
     * Metodo para la sincronización de hilos para entrar en el establecimiento
     * @param entradas las entradas
     * @param intentos los intentos
     * @throws InterruptedException lanzamos una excepcion por si pasa algo en la ejecución de hilos
     */
    public synchronized void entrarEstablecimiento(Entradas entradas, Intentos intentos) throws InterruptedException {
        //si la puerta está ocupada, se espera
        if (!puertaVacia) {
            intentos.incrementoIntentos();
            wait();
        } else {
            /*
              Explicacion:
              1. si no lo está, se establece a falso y se comprueba el numero de entradas e intentos
              2. si el numero de entradas ya se vendieron, sacamos un mensaje por pantalla
              3. si el numero de intentos es de 5, se saca otro mensaje por pantalla
              4. si no es ninguna, se compra una entrada
             */
            puertaVacia = false;
            if (checkMaxEntradas(entradas.getEntradas())) {
                System.out.println("Me voy con las manos vacías ya que no hay entradas");
                Thread.sleep(300);
            } else if (checkIntentos(intentos.getIntentos())) {
                System.out.println("Me voy a hacer fan de kanyeWest");
                Thread.sleep(300);
            } else {
                entradas.disminuirEntradas();
                System.out.println("Bienvenido al establecimiento" +
                        "\nAquí tiene su entrada" + "\nEntradas disponibles: " +
                        entradas.getEntradas() + "/" + 50);
                Thread.sleep(300);
            }

        }
        //una vez se compra una entrada, se establece la puerta como vacía y se notifica a todos
        puertaVacia = true;
        notifyAll();
    }

    /**
     * Metodo para comprobar si ya se vendieron todas las entradas
     * @param entrada el numero de entradas
     * @return true o false dependiendo de si se vendieron todas
     */
    public boolean checkMaxEntradas(int entrada) {
        return entrada < 1;
    }

    /**
     * Metodo para comprobar el numero de intentos
     * @param intentos los intentos
     * @return true o false dependiendo de si los intentos son 5
     */
    public boolean checkIntentos(int intentos) {
        return intentos == 5;
    }


}
