package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RuletaRusa {
    private List<Integer> tambor;
    private int bala;
    private int pocisionActual;
    private Random random;

    public RuletaRusa() {
        tambor = new ArrayList<>();
        random =  new Random();
        tambor.add(0);
        tambor.add(1);
        tambor.add(2);
        tambor.add(3);
        tambor.add(4);
        tambor.add(5);
        pocisionActual=0;
        bala=random.nextInt(6);
    }

    public List<Integer> getTambor() {
        return tambor;
    }

    public void setTambor(List<Integer> tambor) {
        this.tambor = tambor;
    }

    public int getBala() {
        return bala;
    }

    public void setBala(int bala) {
        this.bala = bala;
    }

    public int getPocisionActual() {
        return pocisionActual;
    }

    public void setPocisionActual(int pocisionActual) {
        this.pocisionActual = pocisionActual;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public boolean disparar() {
        boolean muerte = (pocisionActual == bala);
        pocisionActual = (pocisionActual + 1) % tambor.size();
        return muerte;
    }

    public void reiniciarJuego(){
        bala= random.nextInt(6);
        pocisionActual=0;
    }
}