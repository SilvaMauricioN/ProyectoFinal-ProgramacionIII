package programacionIII.app.persistence;

import org.junit.Before;
import org.junit.Test;
import programacionIII.app.model.DAO.JugadorDAO;
import programacionIII.app.model.DAO.PersonajeDAO;
import programacionIII.app.persistence.InterfazModelo.Registro;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RegistroImplTest {
    private Registro registro;
    private String ruta = "C:\\Programacion III\\MiniJuego\\src\\test\\java\\programacionIII\\app\\persistence\\HistorialTest.json";


    @Before
    public void setUp() {
        // Configura la instancia de JsonFileManager con el archivo de prueba
        registro = new RegistroImpl(ruta);
    }

    @Test
    public void leerDatosTest() {
        List<JugadorDAO> listaJugadorHistorial = registro.leerDatos();
        JugadorDAO jugadorDAO = new JugadorDAO("MAQUINA");
        PersonajeDAO personajeDAO = new PersonajeDAO("ÉOWYN","Rau","26/04/1561","HUMANO",7,4,8,8,7,86,30.43);
        List<PersonajeDAO> listaPersonajes = new ArrayList<>();
        listaPersonajes.add(personajeDAO);
        jugadorDAO.setFecha("2023-07-21 17:03:26");
        jugadorDAO.setListaPersonajes(listaPersonajes);

        List<JugadorDAO> listaEsperada = new ArrayList<>();
        listaEsperada.add(jugadorDAO);

        for (JugadorDAO jugadorEsperado : listaEsperada) {
            assertTrue(listaJugadorHistorial.contains(jugadorEsperado));
        }

    }

    @Test
    public void escribirDatosTest() {
        JugadorDAO jugadorDAO = new JugadorDAO("Nicolas");
        PersonajeDAO personajeDAO = new PersonajeDAO("Legolas","Lego","21/05/1361","ELFO",7,4,8,8,7,86,30.43);
        List<PersonajeDAO> listaPersonajes = new ArrayList<>();
        listaPersonajes.add(personajeDAO);
        jugadorDAO.setFecha("2023-07-21 19:20:26");
        jugadorDAO.setListaPersonajes(listaPersonajes);

        List<JugadorDAO> listaJugadoresActual = registro.leerDatos();
        listaJugadoresActual.add(jugadorDAO);

        registro.escribirDatos(listaJugadoresActual);

        assertEquals(listaJugadoresActual, registro.leerDatos());
    }

    @Test
    public void eliminarDatosTest() {
        String ruta = "C:\\Programacion III\\MiniJuego\\src\\test\\java\\programacionIII\\app\\persistence\\HistorialTestEliminar.json";
        Registro registro2 = new RegistroImpl(ruta);
        String msg = registro2.eliminarDatos();
        assertEquals("Contenido del archivo borrado exitosamente.",msg);
    }

    @Test
    public void eliminarDatosTest2() {
        String ruta = "C:\\Programacion III\\MiniJuego\\src\\test\\java\\programacionIII\\app\\persistence\\HistorialTestEliminarVacio.json";
        Registro registro3 = new RegistroImpl(ruta);
        String msg = registro3.eliminarDatos();

        assertEquals("No existe Historial para Borrar",msg);
    }
}