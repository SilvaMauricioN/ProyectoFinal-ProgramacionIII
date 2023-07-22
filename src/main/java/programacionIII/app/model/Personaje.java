package programacionIII.app.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public abstract class Personaje {
    private String nombre, apodo;
    private LocalDate fecha;
    private Raza raza;
    private int velocidad,destreza,fuerza,nivel,armadura,edad;
    private double salud=100;

    public Personaje(String nombre, LocalDate fecha, Raza raza, int velocidad, int destreza, int fuerza, int nivel, int armadura, int edad) {
        this.nombre = nombre.toUpperCase();
        this.fecha = fecha;
        this.raza = raza;
        this.velocidad = velocidad;
        this.destreza = destreza;
        this.fuerza = fuerza;
        this.nivel = nivel;
        this.armadura = armadura;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre.toUpperCase();
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApodo() {
        return this.apodo;
    }
    public void setApodo(String apodo) {
        this.apodo = apodo;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public Raza getRaza() {
        return raza;
    }
    public void setRaza(Raza raza) {
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
        return (Math.round(this.salud * 100.0) / 100.0);
    }
    public void setSalud(double salud) {
        this.salud = salud;
    }
    //Métodos
    public int poderDisparo(){
        return this.destreza * this.fuerza * this.nivel;
    }
    public float efectividadDisparo(){
        Random random = new Random();
        int numeroAleatorio = random.nextInt(61) + 40;
        return  (float) numeroAleatorio / 100;
    }

    public float valorAtaque(){
        float valor = this.poderDisparo() * this.efectividadDisparo();

        return (float) (Math.round(valor * 100.0) / 100.0);
    }
    public int poderDefensa(){
        return this.armadura * this.velocidad;
    }
    public void actualizarSalud(double danio){
        this.salud = (this.salud - danio);
        if (this.salud < 0) {
            this.salud = 0;
        }
    }
    public abstract double danioProvocado();

    @Override
    public boolean equals(Object personaje){
        if(this == personaje) return true;
        if(personaje == null || this.getClass() != personaje.getClass()) return false;

        Personaje personajeControl =(Personaje) personaje;

        return Objects.equals(this.nombre, personajeControl.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.nombre);
    }
    @Override
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