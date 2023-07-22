package programacionIII.app.model.personajes;

import programacionIII.app.model.Personaje;
import programacionIII.app.model.Raza;
import java.time.LocalDate;


public class Humano extends Personaje {

    public Humano(String nombre, LocalDate fecha, Raza raza, int velocidad, int destreza, int fuerza, int nivel, int armadura, int edad){
        super(nombre,fecha,raza,velocidad,destreza,fuerza,nivel,armadura,edad);
    }
    @Override
    public double danioProvocado() {
        double valor = (( (   this.valorAtaque() * this.efectividadDisparo()  ) - this.poderDefensa() ) / 500) * 100;
        return (Math.round(valor * 100.0) / 100.0);
    }
}
