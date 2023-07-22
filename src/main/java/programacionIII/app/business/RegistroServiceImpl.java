package programacionIII.app.business;

import programacionIII.app.business.InterfazModelo.RegistroService;
import programacionIII.app.model.Jugador;
import programacionIII.app.model.DAO.JugadorDAO;
import programacionIII.app.model.Personaje;
import programacionIII.app.model.DAO.PersonajeDAO;
import programacionIII.app.persistence.RegistroImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class RegistroServiceImpl implements RegistroService {
    private final String ruta ="C:\\Programacion III\\MiniJuego\\src\\main\\java\\programacionIII\\app\\persistence\\Historial.json";
    private final RegistroImpl registro = new RegistroImpl(ruta);
    @Override
    public void guardaPartida(Jugador ganador){
        JugadorDAO jugadorDAO = new JugadorDAO();
        List<Personaje> personajeLista = ganador.getListaPersonajes();
        List<PersonajeDAO> personajeDAOLista = new ArrayList<>();

        LocalDateTime fechaActual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaActualString = fechaActual.format(formatter);

        for(Personaje p: personajeLista){
            PersonajeDAO personajeDAO = new PersonajeDAO();

            personajeDAO.setNombre(p.getNombre());
            personajeDAO.setApodo(p.getApodo());

            String fecha = p.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            personajeDAO.setFecha(fecha);

            String raza = p.getRaza().name();
            personajeDAO.setRaza(raza);
            personajeDAO.setVelocidad(p.getVelocidad());
            personajeDAO.setDestreza(p.getDestreza());
            personajeDAO.setFuerza(p.getFuerza());
            personajeDAO.setNivel(p.getNivel());
            personajeDAO.setArmadura(p.getArmadura());
            personajeDAO.setEdad(p.getEdad());
            personajeDAO.setSalud(p.getSalud());

            personajeDAOLista.add(personajeDAO);
        }
        jugadorDAO.setNombre(ganador.getNombre());
        jugadorDAO.setFecha(fechaActualString);
        jugadorDAO.setListaPersonajes(personajeDAOLista);

        List<JugadorDAO> listaActualizada = registro.leerDatos();
        listaActualizada.add(jugadorDAO);

        registro.escribirDatos(listaActualizada);
    }

    @Override
    public void verHistorial(){
        List<JugadorDAO> listaJugadorDAO= registro.leerDatos();

        if(!listaJugadorDAO.isEmpty()){
            for(JugadorDAO jugador: listaJugadorDAO){
                System.out.println("Historial Victorias");
                System.out.println();
                System.out.println("Ganador: " + jugador.getNombre());

                for(PersonajeDAO personaje: jugador.getListaPersonajes()){
                    System.out.println("Personajes Sobrevivientes: " + personaje.toString());
                }
            }
        }else{
            System.out.print("\u001B[36m");//color celeste
            System.out.println("!!!!No Existe Historial!!!!");
            System.out.print("\u001B[0m");
        }
    }

    @Override
    public void borrarHistorial(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Estas Seguro de Borrar el Historial? SI/NO");

        while(true){
            String opcion = scanner.next();
            if (opcion.equalsIgnoreCase("SI")){

                String msg = registro.eliminarDatos();
                System.out.print("\u001B[32m");//color verde
                System.out.println(msg);
                System.out.print("\u001B[0m");
                break;
            } else if (opcion.equalsIgnoreCase("NO")) {
                System.out.print("\u001B[36m");//color celeste
                System.out.println("Regresando al Menu Principal");
                System.out.println();
                System.out.print("\u001B[0m");

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }else{
                System.out.print("\u001B[31m");//color rojo
                System.out.println("Ingrese 'SI' o 'NO' !!!! ");
                System.out.println();
                System.out.print("\u001B[0m");
            }
        }
    }

}
