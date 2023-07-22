package programacionIII.app.model.DAO;

import programacionIII.app.model.Personaje;
import programacionIII.app.model.Raza;

import java.time.LocalDate;
import java.util.Objects;

public class PersonajeDAO {
    private String nombre, apodo;
    private String fecha;
    private String raza;
    private int velocidad, destreza, fuerza, nivel, armadura, edad;
    private double salud;
    public PersonajeDAO(){}
    public PersonajeDAO(String nombre, String apodo, String fecha, String raza, int velocidad, int destreza, int fuerza, int nivel, int armadura, int edad, double salud) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.fecha = fecha;
        this.raza = raza;
        this.velocidad = velocidad;
        this.destreza = destreza;
        this.fuerza = fuerza;
        this.nivel = nivel;
        this.armadura = armadura;
        this.edad = edad;
        this.salud = salud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalud() {
        return salud;
    }
    @Override
    public boolean equals(Object personaje){
        if(this == personaje) return true;
        if(personaje == null || this.getClass() != personaje.getClass()) return false;

        PersonajeDAO personajeControl =(PersonajeDAO) personaje;

        return Objects.equals(this.nombre, personajeControl.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.nombre);
    }

    public void setSalud(double salud) {
        this.salud = salud;
    }
    public String toString() {
        return "Nombre: " + nombre.toUpperCase() +
                ", Apodo: " + apodo.toUpperCase() +
                ", Fecha: " + fecha +
                ", Raza: " + raza +
                ", Velocidad: " + velocidad +
                ", Destreza: " + destreza +
                ", Fuerza: " + fuerza +
                ", Nivel: " + nivel +
                ", Armadura: " + armadura +
                ", Edad: " + edad +
                ", Salud: " + this.getSalud() ;
    }


}
