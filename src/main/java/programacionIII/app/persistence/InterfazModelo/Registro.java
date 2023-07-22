package programacionIII.app.persistence.InterfazModelo;

import programacionIII.app.model.DAO.JugadorDAO;

import java.util.List;

public interface Registro {
    List<JugadorDAO> leerDatos();
    void escribirDatos(List<JugadorDAO> jugadorDAO);
    String eliminarDatos();
}
