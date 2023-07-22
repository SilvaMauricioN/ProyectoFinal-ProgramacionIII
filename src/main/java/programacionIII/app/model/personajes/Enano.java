package programacionIII.app.model.personajes;

import programacionIII.app.model.Personaje;
import programacionIII.app.model.Raza;

import java.time.LocalDate;

public class Enano extends Personaje {
    public Enano(String nombre, LocalDate fecha, Raza raza, int velocidad, int destreza, int fuerza, int nivel, int armadura, int edad) {
        super(nombre, fecha, raza, velocidad, destreza, fuerza, nivel, armadura, edad);
    }

    @Override
    public double danioProvocado() {
        double a = this.valorAtaque() * this.efectividadDisparo();
        double b = a - this.efectividadDisparo();
        double c = b / 500;
        double valor = ((c * 100) * 1.15);

        return (Math.round(valor * 100.0) / 100.0);
    }
}
