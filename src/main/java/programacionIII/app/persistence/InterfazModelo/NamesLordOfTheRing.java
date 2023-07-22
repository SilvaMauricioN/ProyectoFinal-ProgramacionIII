package programacionIII.app.persistence.InterfazModelo;

import programacionIII.app.model.Raza;

public interface NamesLordOfTheRing {
    String  nombreAleatorio();
    Raza obtenerRazaPersonaje(String nombrePersonaje);
}
