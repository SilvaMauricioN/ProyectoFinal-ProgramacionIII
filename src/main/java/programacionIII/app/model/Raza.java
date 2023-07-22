package programacionIII.app.model;

public enum Raza {

    MAIAR(8,10,4,5,8,10,8,10,8,10,100,3000),
    MAGO(7,9,4,5,6,8,6,8,6,8,100,2000),
    ELFO(7,9,4,5,6,8,8,9,6,8,100,1000),
    ENANO(5,7,3,4,7,9,7,8,8,10,100,250),
    ORCO(4,6,2,3,6,8,6,7,4,7,20,80),
    BESTIA(4,7,3,4,6,9,6,8,4,7,30,500),
    HUMANO(6,8,4,5,6,8,7,9,6,8,20,100),
    HOBBIT(3,5,1,3,4,6,4,7,5,7,30,110);
    private final int velocidadMin, velocidadMax;
    private final int destrezaMin, destrazaMax;
    private final int fuerzaMin, fuerzaMax;
    private final int  nivelMin, nivelMax;
    private final int armaduraMin, armaduraMax;
    private final int edadMin, edadMax;

    Raza(int velocidadMin, int velocidadMax, int destrezaMin, int destrazaMax, int fuerzaMin, int fuerzaMax, int nivelMin, int nivelMax, int armaduraMin, int armaduraMax, int edadMin, int edadMax) {
        this.velocidadMin = velocidadMin;
        this.velocidadMax = velocidadMax;
        this.destrezaMin = destrezaMin;
        this.destrazaMax = destrazaMax;
        this.fuerzaMin = fuerzaMin;
        this.fuerzaMax = fuerzaMax;
        this.nivelMin = nivelMin;
        this.nivelMax = nivelMax;
        this.armaduraMin = armaduraMin;
        this.armaduraMax = armaduraMax;
        this.edadMin = edadMin;
        this.edadMax = edadMax;
    }

    public int getVelocidadMin() {
        return velocidadMin;
    }
    public int getVelocidadMax() {
        return velocidadMax;
    }

    public int getDestrezaMin() {
        return destrezaMin;
    }

    public int getDestrazaMax() {
        return destrazaMax;
    }

    public int getFuerzaMin() {
        return fuerzaMin;
    }

    public int getFuerzaMax() {
        return fuerzaMax;
    }

    public int getNivelMin() {
        return nivelMin;
    }

    public int getNivelMax() {
        return nivelMax;
    }

    public int getArmaduraMin() {
        return armaduraMin;
    }

    public int getArmaduraMax() {
        return armaduraMax;
    }
    public int getEdadMin() {
        return edadMin;
    }

    public int getEdadMax() {
        return edadMax;
    }

}
