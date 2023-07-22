package programacionIII.app.business;

import programacionIII.app.model.Jugador;
import programacionIII.app.model.Personaje;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class GameService {
    private final RegistroServiceImpl registroService = new RegistroServiceImpl();

    public void comenzarJuego(Jugador jugador, Jugador maquina){
        presentacionJugadres(jugador,maquina);
        enfrentamientoPersonajes(jugador,maquina);
    }
    private void presentacionJugadres(Jugador jugadorUno,Jugador maquina){
        int tiempoEspeara = 3;
        String msg = "INICIALIZANDO PARTIDA  ";
        msgEspera(msg,tiempoEspeara);

        String msg2 = "CARGANDO SUS PERSONAJES: ";
        msgEspera(msg2,tiempoEspeara);
        System.out.println(jugadorUno.toString() );

        String msg3 = "CARGANDO PERSONAJES RIVAL: ";
        msgEspera(msg3,tiempoEspeara);
        System.out.println(maquina.toString() );
    }
    private void enfrentamientoPersonajes(Jugador jugadorUno, Jugador maquina){
        List <Personaje> listaPJJugadorUno = jugadorUno.getListaPersonajes();
        List <Personaje> listaPJmaquina = maquina.getListaPersonajes();
        int contador = 1;

        while (!listaPJJugadorUno.isEmpty() && !listaPJmaquina.isEmpty()){
            System.out.print("\u001B[36m");//color celeste
            System.out.println("COMIENZO RONDA NUMERO " + contador);
            System.out.print("\u001B[0m");
            System.out.println();
            //numero aleatorio para seleccionar un personaje
            int personajeJugadorNum = numeroAleatorio(listaPJJugadorUno.size());
            int personajeMaquinaNum = numeroAleatorio(listaPJmaquina.size());
            //elegir de manera aleatoria quie ataca primero
            boolean primerAtaque = numeroAleatorio(2) == 0;
            Personaje atacante;
            Personaje defensor;

            if(primerAtaque){
                atacante = listaPJJugadorUno.get(personajeJugadorNum);
                defensor = listaPJmaquina.get(personajeMaquinaNum);
            }else{
                atacante = listaPJmaquina.get(personajeMaquinaNum);
                defensor = listaPJJugadorUno.get(personajeJugadorNum);
            }
            msgPersonajesElegidos(defensor,atacante,primerAtaque,jugadorUno,maquina);
            System.out.print("\u001B[0m");
            System.out.println();
            msgEspera("COMIENZA EN ",3);

            realizarRonda(defensor,atacante,listaPJJugadorUno,listaPJmaquina);

            contador++;
        }
        mostrarGanador(listaPJJugadorUno,jugadorUno,maquina);
    }
    private void realizarRonda(Personaje defensor, Personaje atacante, List<Personaje> listaPJJugadorUno, List<Personaje> listaPJmaquina){
        int contador = 1;

        while(contador <= 8){
            statusBatalla(defensor,atacante);

            if (defensor.getSalud() <= 0) {
                ganadorRonda(defensor, atacante);

                Iterator<Personaje> iteratorPJJugador = listaPJJugadorUno.iterator();
                while (iteratorPJJugador.hasNext()) {
                    Personaje p = iteratorPJJugador.next();
                    if (p.equals(defensor)) {
                        iteratorPJJugador.remove();
                        break;
                    }
                }
                Iterator<Personaje> iteratorPJMaquina = listaPJmaquina.iterator();
                while (iteratorPJMaquina.hasNext()) {
                    Personaje p = iteratorPJMaquina.next();
                    if (p.equals(defensor)) {
                        iteratorPJMaquina.remove();
                        break;
                    }
                }
                break;
            }
            Personaje cambioRol = atacante;
            atacante = defensor;
            defensor = cambioRol;

            contador ++;
        }
    }
    private void ganadorRonda(Personaje defensor, Personaje atacante){
        System.out.print("\u001B[31m");//color rojo
        System.out.println("!!!! " + defensor.getNombre() + " PIERDE !!!!");
        System.out.print("\u001B[32m");//color verde
        System.out.println("!!!! " + atacante.getNombre() + " GANADOR DEL ENFRENTAMIENTO !!!!");
        Bonus(atacante);
        System.out.print("\u001B[32m");//color verde
        System.out.println("!!!! " + atacante.getNombre() + " RECIBE UN 20% MAS DE SALUD, SALUD AL "+ atacante.getSalud() + "  !!!!");
        System.out.print("\u001B[0m");//color standar
        System.out.println();
    }
    private void msgPersonajesElegidos(Personaje defensor, Personaje atacante, boolean primerAtaque,Jugador jugadorUno, Jugador maquina){
        if(primerAtaque){
            System.out.println("SE ENFRENTARAN: \u001B[34m" + atacante.getNombre()+ "\u001B[0m DEL JUGADOR \u001B[34m" + jugadorUno.getNombre() + "\u001B[0m");
            System.out.println("CONTRA: \u001B[34m" + defensor.getNombre() + "\u001B[0m DEL JUGADOR \u001B[34m" + maquina.getNombre() + "\u001B[0m");
        }else{
            System.out.println("SE ENFRENTARAN: \u001B[34m" + atacante.getNombre()+ "\u001B[0m DEL JUGADOR \u001B[34m" + maquina.getNombre() + "\u001B[0m");
            System.out.println("CONTRA: \u001B[34m" + defensor.getNombre() + "\u001B[0m DEL JUGADOR \u001B[34m" + jugadorUno.getNombre() + "\u001B[0m");
        }
    }
    private void statusBatalla(Personaje defensor, Personaje atacante){
        System.out.println(atacante.getNombre() + " Ataca a " + defensor.getNombre());
        double danio = atacante.danioProvocado();
        System.out.println("Daño provocado " + danio);
        defensor.actualizarSalud(danio);
        System.out.println("La salud de " + defensor.getNombre() + " Queda a: " +  defensor.getSalud() );
        System.out.println();
    }
    private static void msgEspera(String msg, int esperar){
        for (int i = esperar; i > 0; i--) {
            System.out.print(msg + i + " \r");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private int numeroAleatorio(int num) {
        Random random = new Random();
        return random.nextInt(num);
    }
    private void Bonus(Personaje personaje){
        double saludActual = personaje.getSalud();
        double bonusSalud = saludActual + (saludActual * 0.2);

        if(bonusSalud > 100){
            personaje.setSalud(100);
        }else{
            personaje.setSalud(bonusSalud);
        }
    }
    private void mostrarGanador(List<Personaje> listaPJJugadorUno, Jugador jugadorUno, Jugador maquina){
        if (listaPJJugadorUno.isEmpty()) {
            System.out.println("!!!! GANADOR DE LA BATALLA Y DEL ANILLO ÚNICO " + maquina.getNombre() + " !!!!");
            System.out.println("!!!! PERSONAJES SOBREVIVIENTES !!!!");
            System.out.println(maquina);
            registroService.guardaPartida(maquina);
        } else {
            System.out.println("!!!! GANADOR DE LA BATALLA Y DEL ANILLO ÚNICO " + jugadorUno.getNombre() + " !!!!");
            System.out.println("PERSONAJES SOBREVIVIENTES");
            System.out.println(jugadorUno);
            registroService.guardaPartida(jugadorUno);
        }
    }
}
