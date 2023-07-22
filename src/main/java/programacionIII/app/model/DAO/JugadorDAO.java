package programacionIII.app.model.DAO;

import com.fasterxml.jackson.annotation.JsonSetter;
import programacionIII.app.model.Personaje;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JugadorDAO {
    private String nombre;
    private String fecha;
    private List<PersonajeDAO> listaPersonajes = new ArrayList<>();
    public JugadorDAO() {
    }
    public JugadorDAO(String nombre) {
        this.nombre = nombre;
    }
    public JugadorDAO(String nombre, String fecha, List<PersonajeDAO> listaPersonajes) {
        this.nombre = nombre;
        this.fecha = fecha;
        setListaPersonajes(listaPersonajes);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public List<PersonajeDAO> getListaPersonajes() {
        return listaPersonajes;
    }
    @JsonSetter("listaPersonajes")
    public void setListaPersonajes(List<PersonajeDAO> listaPersonajes) {
        this.listaPersonajes = (listaPersonajes != null) ? listaPersonajes : new ArrayList<>();
    }
    @Override
    public boolean equals(Object jugador){
        if(this == jugador) return true;
        if(jugador == null || this.getClass() != jugador.getClass()) return false;

        JugadorDAO jugadorControl =(JugadorDAO) jugador;

        return Objects.equals(this.nombre, jugadorControl.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.nombre);
    }
}
