package programacionIII.app.persistence;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import programacionIII.app.model.DAO.JugadorDAO;
import programacionIII.app.persistence.InterfazModelo.Registro;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegistroImpl implements Registro {
    private final ObjectMapper mapper;
    private final File archivo;

    public RegistroImpl(String ruta){
        mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        archivo = new File(ruta);
    }

    //convierte un json en una lista de JugadorDAO
    @Override
    public List<JugadorDAO> leerDatos(){
        try {
            if(archivo.exists() && archivo.length() > 0){
                return mapper.readValue(archivo, new TypeReference<List<JugadorDAO>>() {});
            }else{
                return new ArrayList<>();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void escribirDatos(List<JugadorDAO> jugadorDAO){
        try {
            mapper.writeValue(archivo, jugadorDAO);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // remplazo la lista de JugadoresDAO por una lista vacia
    @Override
    public String eliminarDatos(){

        if (archivo.length() == 3){
            return "No existe Historial para Borrar";
        }else{
            try {
                List<JugadorDAO> listaVacia = new ArrayList<>();
                mapper.writeValue(archivo, listaVacia);
                return "Contenido del archivo borrado exitosamente.";
            } catch (IOException e) {
                throw new RuntimeException("Error al borrar el contenido del archivo JSON: " + e.getMessage(), e);
            }
        }
    }
}
