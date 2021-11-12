package e1;

public class Conserjes extends Integrantes{

    private final boolean nocturnidad;

    public Conserjes(String nombres, String apellidos, int edades, int horocruxes,boolean nocturnidad) {
        super(nombres, apellidos, edades, horocruxes);
        this.nocturnidad=nocturnidad;
    }

    public double getRecompensas() {
        return (65 * getHorrocruxes());

    }

    public int getSueldo(){
        if(nocturnidad){
            return  160;
        }
        else{
            return  150;
        }
    }
}
