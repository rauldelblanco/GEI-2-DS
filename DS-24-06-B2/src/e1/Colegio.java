package e1;

import java.util.ArrayList;

public class Colegio{

    private final ArrayList<Integrantes> Integranteslist = new ArrayList<>();

    public ArrayList<Integrantes> getIntegranteslist() {
        return Integranteslist;
    }

    public void addIntegrante(Integrantes Integrante){
        if(!Integranteslist.isEmpty()) {
            for (Integrantes intengrante1 : Integranteslist) {
                if (Integrante instanceof Docentes && intengrante1 instanceof Docentes && ((Docentes) Integrante).getAsignatura() == ((Docentes) intengrante1).getAsignatura()) {
                    throw new IllegalArgumentException();
                }
            }
        }
        Integranteslist.add(Integrante);
    }

    public void cleanLists(){
        Integranteslist.clear();
    }

    public String imprimirRecompensas(ArrayList<Integrantes> Integranteslist){
        StringBuilder info = new StringBuilder();
        if(!Integranteslist.isEmpty()){
            double gasto = 0;
            for(Integrantes integrantes : Integranteslist){
                if(integrantes instanceof Docentes ){
                    gasto += ((Docentes)integrantes).getRecompensas();
                    info.append(integrantes.getNombre()).append(" ").append(integrantes.getApellido()).append(" (Docente de ").append(((Docentes) integrantes).getAsignatura()).append(", ").append(integrantes.getHorrocruxes()).append(" horrocruxes): ").append(((Docentes)integrantes).getRecompensas()).append(" galeones\n");
                }
                else if(integrantes instanceof Guardabosques){
                    gasto += ((Guardabosques)integrantes).getRecompensas();
                    info.append(integrantes.getNombre()).append(" ").append(integrantes.getApellido()).append(" (Guardabosques, ").append(integrantes.getHorrocruxes()).append(" horrocruxes): ").append(((Guardabosques)integrantes).getRecompensas()).append(" galeones\n");
                }
                else if(integrantes instanceof Conserjes){
                    gasto += ((Conserjes)integrantes).getRecompensas();
                    info.append(integrantes.getNombre()).append(" ").append(integrantes.getApellido()).append(" (Conserje, ").append(integrantes.getHorrocruxes()).append(" horrocruxes): ").append(((Conserjes)integrantes).getRecompensas()).append(" galeones\n");
                }
                else if(integrantes instanceof Residentes && ((Residentes) integrantes).getCriaturas().equals(Residentes.Criaturas.Estudiante)){
                    gasto += ((Residentes)integrantes).getRecompensas();
                    info.append(integrantes.getNombre()).append(" ").append(integrantes.getApellido()).append(" (Estudiante de ").append(((Residentes) integrantes).getCasa()).append(", ").append(integrantes.getHorrocruxes()).append(" horrocruxes): ").append(((Residentes)integrantes).getRecompensas()).append(" galeones\n");
                }
                else if(integrantes instanceof Residentes && ((Residentes) integrantes).getCriaturas().equals(Residentes.Criaturas.Fantasmas)){
                    gasto += ((Residentes)integrantes).getRecompensas();
                    info.append(integrantes.getNombre()).append(" ").append(integrantes.getApellido()).append(" (Fantasma de ").append(((Residentes) integrantes).getCasa()).append(", ").append(integrantes.getHorrocruxes()).append(" horrocruxes): ").append(((Residentes)integrantes).getRecompensas()).append(" galeones\n");
                }
            }
            info.append("La recompensa total del Colegio Hogwarts es de ").append(gasto).append(" galeones");
        }

        return info.toString().trim();
    }

    public String imprimirSalarios(ArrayList<Integrantes> integranteslist){
        StringBuilder info = new StringBuilder();
        if(!integranteslist.isEmpty()){
            int gasto = 0;
            for(Integrantes integrantes : integranteslist){

                if(integrantes instanceof Docentes){
                    gasto += ((Docentes)integrantes).getSueldo();
                    info.append(integrantes.getNombre()).append(" ").append(integrantes.getApellido()).append(" (Docente de ").append(((Docentes) integrantes).getAsignatura()).append("): ").append(((Docentes)integrantes).getSueldo()).append(" galeones\n");
                }
                else if(integrantes instanceof Guardabosques){
                    gasto += ((Guardabosques)integrantes).getSueldo();
                    info.append(integrantes.getNombre()).append(" ").append(integrantes.getApellido()).append(" (Guardabosques): ").append(((Guardabosques)integrantes).getSueldo()).append(" galeones\n");
                }
                else if(integrantes instanceof Conserjes) {
                    gasto += ((Conserjes)integrantes).getSueldo();
                    info.append(integrantes.getNombre()).append(" ").append(integrantes.getApellido()).append(" (Conserje): ").append(((Conserjes)integrantes).getSueldo()).append(" galeones\n");
                }

            }
            info.append("El gasto de Hogwarts en personal es de ").append(gasto).append(" galeones");
        }

        return info.toString().trim();
    }

}
