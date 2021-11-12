package e1;

public class Residentes extends Integrantes {
    private final Criaturas criaturas;
    private final Casa casa;


    public enum Criaturas{
        Estudiante,
        Fantasmas
    }

    public enum Casa{
        Gryffindor,
        Hufflepuff,
        Ravenclaw,
        Slytherin
    }

    public Casa getCasa() {
        return casa;
    }

    public Criaturas getCriaturas(){
        return criaturas;
    }


    public double getRecompensas() {
        if(this.criaturas==Criaturas.Fantasmas){
            return getHorrocruxes() * 80;
        } else {
            if(criaturas==Criaturas.Estudiante){
                if(this.casa==Casa.Slytherin){
                    return (getHorrocruxes() * 90) * 0.75;
                }
                else{
                    return getHorrocruxes() * 90;
                }
            } else {
                return 0;
            }
        }
    }

    public Residentes(String nombres, String apellidos, int edad,Criaturas criatura, Casa casas, int horocruxes){
        super(nombres,apellidos,edad,horocruxes);
        this.criaturas=criatura;
        this.casa=casas;
    }



}