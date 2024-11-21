public class Establecimiento {

    private boolean puertaVacia = true;
    private Entradas entradas;
    private Intentos intentos;

    public Establecimiento(Entradas entradas, Intentos intentos) {
        this.entradas = entradas;
        this.intentos = intentos;
    }

    public synchronized void entrarEstablecimiento(Entradas entradas,Intentos intentos) throws InterruptedException {
        if(!puertaVacia) {
            wait();
            intentos.incrementoIntentos();
        }
        else{
            puertaVacia = false;
            entradas.disminuirEntradas();
            System.out.println("Bienvenido al establecimiento" +
                    "\nAquí tiene su entrada" + "\nEntradas disponibles: " +
                    entradas.getEntradas() + "/" + 50);
        }
        puertaVacia = true;
        notifyAll();
    }




}
