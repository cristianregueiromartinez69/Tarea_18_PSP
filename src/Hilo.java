public class Hilo implements Runnable {

    private Establecimiento estable;
    private Entradas entrada;
    private Intentos intentos;


    public Hilo(Establecimiento estable, Entradas entrada, Intentos intentos) {
        this.estable = estable;
        this.entrada = entrada;
        this.intentos = intentos;
    }

    @Override
    public void run() {
        try{
            estable.entrarEstablecimiento(entrada, intentos);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Ups, ha ocurrido un error al coger entradas, nos quedamos sin ver a taylor swift");
        }
    }


}
