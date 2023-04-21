import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

interface TempObserver {

    void update(float temperatura);
}

class Termometro {
    List<TempObserver> observers = new ArrayList<>();
    private float temperatura;

    void start(){
        while (true) {
            temperatura = ThreadLocalRandom.current().nextFloat()*50;
            System.out.println("Temperatura: " + temperatura);

            notifyObservers();

            try { Thread.sleep(1000); } catch (Exception ignored) { }
        }
    }

    public void addObserver(TempObserver obs) {
        observers.add(obs);
    }

    private void notifyObservers() {
        for (var obs : observers) {
            obs.update(temperatura);
        }
    }
}

class Termostato implements TempObserver{
    String lugar;
    float maximo;


    public Termostato(String lugar, float maximo) {
        this.lugar = lugar;
        this.maximo = maximo;
    }

    public void update(float temperatura) {
        if (temperatura > maximo) {
            abrir();
        } else {
            cerrar();
        }
    }

    void abrir(){
        System.out.println("Termostato [" + lugar + "] abierto");
    }
    void cerrar(){
        System.out.println("Termostato [" + lugar + "] cerrado");
    }
}

public class Main {
    public static void main(String[] args) {
        Termometro termometro = new Termometro();

        Termostato t1 = new Termostato("cocina", 30);
        Termostato t2 = new Termostato("salon", 20);
        Termostato t3 = new Termostato("habitacion", 26);

        termometro.addObserver(t1);
        termometro.addObserver(t2);
        termometro.addObserver(t3);

        termometro.start();
    }
}