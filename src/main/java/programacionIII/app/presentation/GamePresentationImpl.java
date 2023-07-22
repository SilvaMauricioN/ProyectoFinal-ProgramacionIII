package programacionIII.app.presentation;

import programacionIII.app.business.GameService;
import programacionIII.app.business.JugadoresFactoryImpl;
import programacionIII.app.business.RegistroServiceImpl;
import programacionIII.app.model.Jugador;
import programacionIII.app.presentation.InterfazModelo.GamePresentation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GamePresentationImpl implements GamePresentation {
    private final GameService gameService = new GameService();
    private final JugadoresFactoryImpl jugadoresFactory = new JugadoresFactoryImpl();
    private final RegistroServiceImpl registroService = new RegistroServiceImpl();

    public void Menu(){
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("¿Ingrese una opcion: ");
            System.out.println("1. Partida Aleatoria");
            System.out.println("2. Partida Personajes Personalizados");
            System.out.println("3. Historial Partidas");
            System.out.println("4. Borrar Historial");
            System.out.println("5. Salir");

            int opcion;

            try{
                opcion = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.print("\u001B[31m");//color rojo
                System.out.println("Debe ingresar un número entero entre 1 y 5");
                System.out.println();
                System.out.print("\u001B[0m");
                scanner.nextLine();
                continue;
            }

            if(opcion == 1){
                partidaAleatoria();
            }else if(opcion == 2){
                partidaPersonalizada();
            } else if (opcion == 3) {
                leerArchivo();
            }else if(opcion == 4){
                borrarArchivo();
            } else if (opcion == 5) {
                break;
            }else{
                System.out.print("\u001B[31m");//color rojo
                System.out.println("Opcion no valida, ingrese un valor entre 1 y 5");
                System.out.println();
                System.out.print("\u001B[0m");
            }
        }
    }

    private void partidaAleatoria(){
        Jugador jugadorUno = jugadoresFactory.crearJugador();
        Jugador maquina = jugadoresFactory.crearJugadorMaquina();
        gameService.comenzarJuego(jugadorUno,maquina);
    }
    private void partidaPersonalizada(){
        Jugador jugadorUno = jugadoresFactory.crearJugadorPernajesPersonalizados();
        Jugador maquina = jugadoresFactory.crearJugadorMaquina();
        gameService.comenzarJuego(jugadorUno,maquina);
    }
    private void leerArchivo(){
        registroService.verHistorial();
    }
    private void borrarArchivo(){
        registroService.borrarHistorial();
    }
}
