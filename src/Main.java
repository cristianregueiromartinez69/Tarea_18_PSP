public class Main {
    public static void main(String[] args) {

        Intentos intentos = new Intentos();
        Entradas entradas = new Entradas();
        Establecimiento establecimiento = new Establecimiento(entradas, intentos);

        for(int i = 0; i < 200; i++){
            new Thread(new Hilo(establecimiento, entradas, intentos)).start();
        }
    }


}


/**
 * Datos:
 * 1. 200 alumnos
 * 2. 50 entradas
 * 3. Una única puerta para entrar, solo 1 persona en establecimiento
 * 4. Maximo de 5 intentos de entrar por la puerta
 * 5. tras 5 intentos si no entran, se van
 * 6. si consigue acceder -> 50 entradas, coges 1 y te vas
 * 7. No hay entradas -> Me voy
 */