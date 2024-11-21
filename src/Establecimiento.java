public class Establecimiento {

    private boolean puertaVacia = true;
    private Entradas entradas;
    private Intentos intentos;

    public Establecimiento(Entradas entradas) {
        this.entradas = entradas;
    }

    public synchronized void entrarEstablecimiento(Intentos intentos) throws InterruptedException {
        if(!puertaVacia) {
            wait();
        }
        else{
            puertaVacia = true;
            entradas.disminuirEntradas();
            System.out.println("Bienvenido al establecimiento" +
                    "\nAquí tiene su entrada" + "\nEntradas disponibles: " +
                    entradas.getEntradas() + "/" + 50);
        }
        puertaVacia = false;
        notifyAll();
    }


}
