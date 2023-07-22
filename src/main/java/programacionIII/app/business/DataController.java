package programacionIII.app.business;

import programacionIII.app.model.Personaje;
import programacionIII.app.model.Raza;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DataController {
    private final Scanner scanner = new Scanner(System.in);
    private final PersonajesFactoryImpl PersonajeFactory = new PersonajesFactoryImpl();
    private static final int valorMaximo = 10;
    private static final int edadMaxima = 300;
    private static final int destrezaMaxima = 5;
    private final String[] RazaNombres = {"Bestia", "Elfo", "Enano", "Hobbit", "Humano", "Mago", "Maiar", "Orco"};
    private final String[] posicion = {"PRIMER","SEGUNDO","TERCER"};

    public List <Personaje> personajesPersonlizados(){
        List<Personaje> listaPersonajesPersonalizados = new ArrayList<>();

        for (int i=0; i<3; i++){
            Personaje personaje;
            System.out.println("Ingrese los Datos de su "+ posicion[i]+" Personaje: ");
            personaje = ObtenerDatosUsuario();

            listaPersonajesPersonalizados.add(personaje);

        }
        return listaPersonajesPersonalizados;
    }
    private Personaje ObtenerDatosUsuario(){

        Raza raza = SeleccionarRaza();

        LocalDate fechaNacimiento = PersonajeFactory.fechaNacimientoAleatoria();

        String nombre = ControlNombre();

        int edad = ControlDatoEntero("Edad",edadMaxima);

        int velocidad = ControlDatoEntero("Velocidad", valorMaximo);

        int destreza = ControlDatoEntero("Destreza",destrezaMaxima);

        int fuerza = ControlDatoEntero("Fuerza", valorMaximo);

        int nivel = ControlDatoEntero("Nivel",valorMaximo);

        int armadura = ControlDatoEntero("Resistencia de Armadura",valorMaximo);

        return PersonajeFactory.crearPersonaje(nombre,fechaNacimiento,raza,velocidad,destreza,fuerza,nivel,armadura,edad);
    }

    private Raza SeleccionarRaza(){
        while(true){
            System.out.println("Raza de su Personaje!!!");
            for (int i=0; i < RazaNombres.length;i++) {
                System.out.println((i + 1) + ") " + RazaNombres[i]);
            }
            try{
                int opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= RazaNombres.length) {
                    return obtenerRaza(opcion);

                } else {
                    System.out.print("\u001B[31m");//color rojo
                    System.out.println("!!!Debe ingresar un número entre 1 y " + RazaNombres.length + " !!!");
                    System.out.println();
                    System.out.print("\u001B[0m");
                }
            }catch (InputMismatchException e){
                System.out.print("\u001B[31m");//color rojo
                System.out.println("!!!Debe ingresar un número entero!!!");
                System.out.println();
                System.out.print("\u001B[0m");
                scanner.nextLine();
            }
        }
    }
    private String ControlNombre(){
        System.out.println("Nombre: ");
        scanner.nextLine();
        String nombre = scanner.nextLine();
        while (nombre.isEmpty() || nombre.matches(".*\\d.*")){
            System.out.print("\u001B[31m");//color rojo
            System.out.println("Ingrese un Nombre Valido, sin numeros!!!");
            System.out.println();
            System.out.print("\u001B[0m");
            nombre = scanner.nextLine();
        }
        return nombre;
    }
    private int ControlDatoEntero(String atributos, int valorMaximo){
        while(true){
            System.out.println(atributos + ":" );
            try{
                int num = scanner.nextInt();
                if (num >= 1 && num <= valorMaximo) {
                    return num;
                } else {
                    System.out.print("\u001B[31m");//color rojo
                    System.out.println("!!!Debe ingresar un número entre 1 y " + valorMaximo + " !!!");
                    System.out.println();
                    System.out.print("\u001B[0m");
                }
            }catch (InputMismatchException e){
                System.out.print("\u001B[31m");//color rojo
                System.out.println("!!!Debe ingresar un número entero, de 1 y " + valorMaximo + " !!!");
                System.out.println();
                System.out.print("\u001B[0m");
                scanner.nextLine();
            }
        }
    }
    private Raza obtenerRaza(int opcion){
        Raza raza;
        switch (opcion) {
            case 1:
                raza = Raza.BESTIA;
                break;
            case 2:
                raza = Raza.ELFO;
                break;
            case 3:
                raza = Raza.ENANO;
                break;
            case 4:
                raza = Raza.HOBBIT;
                break;
            case 5:
                raza = Raza.HUMANO;
                break;
            case 6:
                raza = Raza.MAGO;
                break;
            case 7:
                raza = Raza.MAIAR;
                break;
            case 8:
                raza = Raza.ORCO;
                break;
            default:
                throw new IllegalArgumentException("Raza no válida!!!");
        }
        return raza;
    }
}
