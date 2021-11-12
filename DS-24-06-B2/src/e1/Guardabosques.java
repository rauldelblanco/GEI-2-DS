package e1;

public class Guardabosques extends Integrantes{

    private final boolean nocturnidad;

    public Guardabosques(String nombres, String apellidos, int edades, int horocruxes,boolean nocturnidad) {
        super(nombres, apellidos, edades, horocruxes);
        this.nocturnidad=nocturnidad;
    }

    public double getRecompensas() {
        return  (75 * getHorrocruxes());
    }

    public int getSueldo(){
        if(nocturnidad){
            return 180;
        }
        else{
            return 170;
        }
    }
}