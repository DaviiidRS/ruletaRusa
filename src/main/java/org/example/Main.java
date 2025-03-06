package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int op, jugadores2;
        System.out.print("Digite la cantidad de jugadores: ");
        jugadores2=teclado.nextInt();
        List<String> jugadores = new ArrayList<>();

        for (int i=1;i<=jugadores2;i++){
            System.out.print("Escribe tu nombre: ");
            jugadores.add(teclado.next());
        }

        RuletaRusa p1 = new RuletaRusa();
        int turno=0;

        do {
            System.out.println("Turno de " + jugadores.get(turno));
            System.out.println("1. Disparar.");
            System.out.println("2. Salir");
            System.out.print("Selecciona una opcion: ");
            op= teclado.nextInt();
            switch (op){
                case 1:
                    if (p1.disparar()){
                        System.out.println(jugadores.get(turno)+" ha muerto :( ");
                        jugadores.remove(turno);
                        if (jugadores.size()==1){
                            break;
                        }
                        p1.reiniciarJuego();
                        System.out.println("Arma recargada. Inicio de nueva ronda.");
                        System.out.println("Jugadores vivos: " + jugadores);
                        turno=turno%jugadores.size();
                    } else {
                        System.out.println(jugadores.get(turno)+" ha sobrevivido :)");
                        turno=(turno+1)%jugadores.size();
                    }
                    break;
                case 2:
                    System.out.println(jugadores.get(turno) + " ha saltado turno.");
                    turno = (turno + 1) % jugadores.size();
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (jugadores.size() > 1);
        System.out.println("El ganador es " + jugadores.get(0));
    }
}