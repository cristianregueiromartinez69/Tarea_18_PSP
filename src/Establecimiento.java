public class Establecimiento {

    private boolean puertaVacia = true;
    private Entradas entradas;
    private Intentos intentos;

    public Establecimiento(Entradas entradas, Intentos intentos) {
        this.entradas = entradas;
        this.intentos = intentos;
    }

    public synchronized void entrarEstablecimiento(Entradas entradas, Intentos intentos) throws InterruptedException {
        if (!puertaVacia) {
            wait();
            intentos.incrementoIntentos();
        } else {
            puertaVacia = false;
            if (checkMaxEntradas(entradas.getEntradas())) {
                System.out.println("Me voy con las manos vacías ya que no hay entradas");
            } else if (checkIntentos(intentos.getIntentos())) {
                System.out.println("Me voy a hacer fan de kanyeWest");
            } else {
                entradas.disminuirEntradas();
                System.out.println("Bienvenido al establecimiento" +
                        "\nAquí tiene su entrada" + "\nEntradas disponibles: " +
                        entradas.getEntradas() + "/" + 50);
            }

        }
        puertaVacia = true;
        notifyAll();
    }

    public boolean checkMaxEntradas(int entrada) {
        return entrada < 1;
    }

    public boolean checkIntentos(int intentos) {
        return intentos == 5;
    }


}
