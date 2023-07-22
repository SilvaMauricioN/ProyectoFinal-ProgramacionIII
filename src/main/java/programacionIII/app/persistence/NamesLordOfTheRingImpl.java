package programacionIII.app.persistence;

import com.github.javafaker.Faker;
import com.github.javafaker.LordOfTheRings;
import programacionIII.app.model.Raza;
import programacionIII.app.persistence.InterfazModelo.NamesLordOfTheRing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NamesLordOfTheRingImpl implements NamesLordOfTheRing {
    //api que genera nombres aleatorio del señor de los anillos
    private final Faker faker = new Faker();
    @Override
    public String  nombreAleatorio(){
        return faker.lordOfTheRings().character();
    }
    //metodo para obtener la raza apartir de su nombre
    @Override
    public Raza obtenerRazaPersonaje(String nombrePersonaje) {
        Raza raza;
        Map<Raza, ArrayList<String>> razaPersonajes = new HashMap<Raza,ArrayList<String>>() {{
            put(Raza.HOBBIT, new ArrayList<String>() {{
                add("Frodo Baggins");
                add("Samwise Gamgee");
                add("Meriadoc Brandybuck");
                add("Peregrin Took");
                add("Bilbo Baggins");
                add("Gollum");
            }});

            put(Raza.MAGO, new ArrayList<String>() {{
                add("Gandalf the Grey");
                add("Tom Bombadil");
                add("Saruman the White");
                add("Glorfindel");
            }});

            put(Raza.HUMANO, new ArrayList<String>() {{
                add("Aragorn");
                add("Boromir");
                add("Éomer");
                add("Théoden");
                add("Éowyn");
                add("Faramir");
                add("Denethor");
                add("Beregond");
                add("Barliman Butterbur");
                add("Gríma Wormtongue");
            }});

            put(Raza.ELFO, new ArrayList<String>() {{
                add("Legolas");
                add("Elrond");
                add("Arwen Evenstar");
                add("Galadriel");
            }});

            put(Raza.ENANO, new ArrayList<String>() {{
                add("Gimli");
            }});

            put(Raza.MAIAR, new ArrayList<String>() {{
                add("Sauron");
            }});

            put(Raza.BESTIA, new ArrayList<String>() {{
                add("Treebeard");
                add("Quickbeam");
                add("Shadowfax");
                add("Shelob");
            }});
        }};

        for (Map.Entry<Raza, ArrayList<String>> mapa : razaPersonajes.entrySet()) {
            raza = mapa.getKey();
            ArrayList<String> personajes = mapa.getValue();

            if (personajes.contains(nombrePersonaje)) {
                return raza;
            }
        }
        return Raza.HUMANO;
    }
}
