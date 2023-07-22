package programacionIII.app.business.InterfazModelo;

import programacionIII.app.model.Jugador;

public interface RegistroService {
    void guardaPartida(Jugador ganador);
    void verHistorial();
    void borrarHistorial();
}
