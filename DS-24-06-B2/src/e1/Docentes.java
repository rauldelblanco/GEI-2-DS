package e1;

public class Docentes extends Integrantes{

    private final Asignatura asignatura;

    public Docentes(String nombres, String apellidos, int edades, int horocruxes, Asignatura asignaturas) {
        super(nombres, apellidos, edades, horocruxes);
        this.asignatura=asignaturas;
    }

    public enum Asignatura{Defensa,Transformaciones,Pociones,Herbologia,Historia}

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public double getRecompensas() {
        if (asignatura == Asignatura.Defensa){
            return  (50 * getHorrocruxes()) * 0.75;
        }else{
            return (50*getHorrocruxes());
        }
    }

    public int getSueldo(){
        if (asignatura == Asignatura.Historia){
            return 500;
        } else {
            if (asignatura == Asignatura.Transformaciones){
                return 400;
            } else {
                if (asignatura == Asignatura.Defensa){
                    return 500;
                }else {
                    if (asignatura == Asignatura.Herbologia){
                        return 250;
                    }else {
                        if (asignatura == Asignatura.Pociones){
                            return 350;
                        } else {
                            return 0;
                        }
                    }
                }
            }
        }
    }

}