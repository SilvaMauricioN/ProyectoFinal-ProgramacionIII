package programacionIII.app.business;

import com.github.javafaker.Faker;
import programacionIII.app.business.InterfazModelo.PersonajesFactory;
import programacionIII.app.model.*;
import programacionIII.app.model.personajes.*;
import programacionIII.app.persistence.NamesLordOfTheRingImpl;
import java.time.LocalDate;
import java.util.*;

public class PersonajesFactoryImpl implements PersonajesFactory {
    private final Faker faker = new Faker();
    private final NamesLordOfTheRingImpl namesLordOfTheRing = new NamesLordOfTheRingImpl();
    private final Random random = new Random();
    @Override
    public List<Personaje> personajesAleatorio() {
        List<Personaje> listaPersonajesAleatorios = new ArrayList<>();
        for(int i = 0; i<3; i++){
            String nombreAleatorio;
            boolean nombreControl;

            do{
                nombreAleatorio = namesLordOfTheRing.nombreAleatorio();
                nombreControl = false;

                for(Personaje p:listaPersonajesAleatorios){
                    if(nombreAleatorio.toUpperCase().equals(p.getNombre())){
                        nombreControl = true;
                        break;
                    }
                }
            }while (nombreControl);

            Raza raza = namesLordOfTheRing.obtenerRazaPersonaje(nombreAleatorio);
            LocalDate fechaNacimiento = fechaNacimientoAleatoria();
            int velocidad = numeroAleatorio(raza.getVelocidadMin(),raza.getVelocidadMax());
            int destreza = numeroAleatorio(raza.getDestrezaMin(), raza.getDestrazaMax());
            int fuerza = numeroAleatorio(raza.getFuerzaMin(),raza.getFuerzaMax());
            int nivel = numeroAleatorio(raza.getNivelMin(),raza.getNivelMax());
            int armadura = numeroAleatorio(raza.getArmaduraMin(), raza.getArmaduraMax());
            int edad = numeroAleatorio(raza.getEdadMin(),raza.getEdadMax());

            Personaje personaje = crearPersonaje(nombreAleatorio, fechaNacimiento, raza, velocidad, destreza, fuerza, nivel, armadura, edad);
            listaPersonajesAleatorios.add(personaje);
        }
        return listaPersonajesAleatorios;
    }
    @Override
    public Personaje crearPersonaje(String nombreAleatorio, LocalDate fechaNacimiento, Raza raza, int velocidad, int destreza, int fuerza, int nivel, int armadura, int edad){
        Personaje personaje;
        switch (raza) {
            case ELFO:
                personaje = new Elfo(nombreAleatorio,fechaNacimiento,raza,velocidad,destreza,fuerza,nivel,armadura,edad);
                break;
            case HUMANO:
                personaje = new Humano(nombreAleatorio,fechaNacimiento,raza,velocidad,destreza,fuerza,nivel,armadura,edad);
                break;
            case ORCO:
                personaje = new Orco(nombreAleatorio,fechaNacimiento,raza,velocidad,destreza,fuerza,nivel,armadura,edad);
                break;
            case BESTIA:
                personaje = new Bestia(nombreAleatorio,fechaNacimiento,raza,velocidad,destreza,fuerza,nivel,armadura,edad);
                break;
            case ENANO:
                personaje = new Enano(nombreAleatorio,fechaNacimiento,raza,velocidad,destreza,fuerza,nivel,armadura,edad);
                break;
            case HOBBIT:
                personaje = new Hobbit(nombreAleatorio,fechaNacimiento,raza,velocidad,destreza,fuerza,nivel,armadura,edad);
                break;
            case MAGO:
                personaje = new Mago(nombreAleatorio,fechaNacimiento,raza,velocidad,destreza,fuerza,nivel,armadura,edad);
                break;
            case MAIAR:
                personaje = new Maiar(nombreAleatorio,fechaNacimiento,raza,velocidad,destreza,fuerza,nivel,armadura,edad);
                break;
            default:
                throw new IllegalArgumentException("Raza no válida: " + raza);
        }
        String apodo = faker.name().lastName();
        personaje.setApodo(apodo);
        return personaje;
    }

    //Genero un valor aleatorio entre un rango determinado
    private int numeroAleatorio(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
    //Genero fecha de nacimiento aleatoria
    public LocalDate fechaNacimientoAleatoria(){
        int yearInicial = 578;
        int  yearFinal = 3018;

        int year = random.nextInt(yearFinal - yearInicial + 1 ) + yearInicial;
        int mes = random.nextInt(12) + 1;
        int dia = random.nextInt(28) + 1;
        return LocalDate.of(year,mes,dia);
    }



}
