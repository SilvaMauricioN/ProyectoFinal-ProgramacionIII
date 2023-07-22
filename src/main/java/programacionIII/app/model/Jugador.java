package programacionIII.app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Jugador {
    private String nombre;
    private List<Personaje> listaPersonajes = new ArrayList<>();


    public String getNombre() {
        return nombre.toUpperCase();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Personaje> getListaPersonajes() {
        return listaPersonajes;
    }

    public void setListaPersonajes(List <Personaje> listaPersonaje) {
        this.listaPersonajes = listaPersonaje;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner("\n");
        result.add("Nombre Del Jugador: " + this.nombre.toUpperCase() + "\n");
        result.add("Personajes:");
        for (Personaje personaje : this.listaPersonajes) {
            result.add(personaje.toString());
        }
        result.add("\n");
        return result.toString();
    }
}
