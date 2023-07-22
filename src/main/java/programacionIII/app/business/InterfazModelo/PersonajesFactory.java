package programacionIII.app.business.InterfazModelo;

import programacionIII.app.model.Personaje;
import programacionIII.app.model.Raza;

import java.time.LocalDate;
import java.util.List;

public interface PersonajesFactory {

    List<Personaje> personajesAleatorio();
    Personaje crearPersonaje(String nombreAleatorio, LocalDate fechaNacimiento, Raza raza, int velocidad, int destreza, int fuerza, int nivel, int armadura, int edad);
}
