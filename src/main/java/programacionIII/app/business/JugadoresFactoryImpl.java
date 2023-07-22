package programacionIII.app.business;

import programacionIII.app.business.InterfazModelo.JugadorFactory;
import programacionIII.app.business.InterfazModelo.PersonajesFactory;
import programacionIII.app.model.Jugador;
import java.util.Scanner;

public class JugadoresFactoryImpl implements JugadorFactory{
    private final PersonajesFactory personajesFactory = new PersonajesFactoryImpl();
    private final DataController dataController = new DataController();
    Scanner scanner = new Scanner(System.in);
    @Override
    public Jugador crearJugador(){
        String nombre = nombreJugador();
        Jugador jugador = new Jugador();
        jugador.setNombre(nombre);
        jugador.setListaPersonajes(personajesFactory.personajesAleatorio());

        return jugador;
    }
    @Override
    public Jugador crearJugadorMaquina(){
        Jugador jugador = new Jugador();
        jugador.setNombre("MAQUINA");
        jugador.setListaPersonajes(personajesFactory.personajesAleatorio());
        return jugador;
    }
    @Override
    public Jugador crearJugadorPernajesPersonalizados(){
        String nombre = nombreJugador();
        Jugador jugador = new Jugador();

        jugador.setNombre(nombre);
        jugador.setListaPersonajes(dataController.personajesPersonlizados());
        return jugador;
    }
    @Override
    public String nombreJugador(){
        System.out.println("Ingrese su Nombre: ");

        String nombre = scanner.nextLine();
        while (nombre.isEmpty() || nombre.matches(".*\\d.*")){
            System.out.println("Ingrese un Nombre Valido, sin numeros!!!");
            nombre = scanner.nextLine();
        }
        return nombre;
    }
}
