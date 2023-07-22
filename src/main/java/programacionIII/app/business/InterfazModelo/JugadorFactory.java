package programacionIII.app.business.InterfazModelo;

import programacionIII.app.model.Jugador;

public interface JugadorFactory {
    Jugador crearJugador();
    Jugador crearJugadorMaquina();
    Jugador crearJugadorPernajesPersonalizados();
    String nombreJugador();
}
