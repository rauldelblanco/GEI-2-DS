package e2;

import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.List;

public class OrdenJerarquico implements Dependencias {

    private final List<Tareas> TareasTotales;
    private final ArrayDeque<Tareas> cola;

    public OrdenJerarquico() {
        TareasTotales = new LinkedList<>();
        cola = new ArrayDeque<>();
    }

    private void  AnadirTareasLista(Tareas tareas){
        int contador=0;

        do {
            if (TareasTotales.isEmpty()) {
                TareasTotales.add(tareas);
                return;
            } else {
                Tareas tareas1 = TareasTotales.get(contador);
                if (tareas1.getTareas() >= tareas.getTareas()) {
                    TareasTotales.add(contador, tareas);
                    return;
                }
                contador++;
            }
        } while (contador < TareasTotales.size());
        TareasTotales.add(tareas);
    }

    private void ActualizarTareasLista(char padre, char hijo){

        for (Tareas aux : TareasTotales){
            if (aux.getTareas() == padre){
                aux.setAdyacente(hijo);
            }
        }

    }

    private boolean isInTheList(char tarea){

        for (Tareas tareas : TareasTotales){
            if (tareas.getTareas() == tarea){
                return false;
            }
        }
        return true;

    }

    private boolean isHuerfano(char tarea){

        for (Tareas aux : TareasTotales){
            for (char aux2 : aux.getAdyacente()){
                if (aux2 == tarea){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void addTareas(String tareas){

        char padre, hijo;
        boolean existepadre;
        List<Character> auxiliar = new LinkedList<>();
        String[] tareasIndividuales = tareas.split("\n");

        for (String tareasIndividuale : tareasIndividuales) { //Primera parte del rellenado de la lista (Metemos los padres que tienen hijos)
            padre = tareasIndividuale.charAt(0);
            hijo = tareasIndividuale.charAt(5);
            existepadre = false;

            for (Tareas aux : TareasTotales){
                if (aux.getTareas() == padre) {
                    existepadre = true;
                    break;
                }
            }

            if (existepadre){
                ActualizarTareasLista(padre, hijo);
            } else {
                Tareas tarea = new Tareas(padre);
                tarea.setAdyacente(hijo);
                AnadirTareasLista(tarea);
            }

        }

        for (Tareas aux : TareasTotales){
            for (char aux2 : aux.getAdyacente()){
                if (isInTheList(aux2)){
                    auxiliar.add(aux2);
                }
            }
        }

        for (Character aux : auxiliar){//Todos los padres se encuentran en la lista (junto a sus hijos) (Lista)
            if (isInTheList(aux)) {
                Tareas tarea = new Tareas(aux);
                AnadirTareasLista(tarea);
            }
        }

        for (Tareas aux : TareasTotales){
            if (isHuerfano(aux.getTareas())){
                aux.setRaiz(true);
            }
        }


    }

    @Override
    public String RealizarTareas() {

        Tareas u, w = null;
        StringBuilder orden = new StringBuilder();

        for (Tareas aux1 : TareasTotales){
            if(aux1.isRaiz()){
                aux1.setDisponible(false); //Cojo las raices de la lista y hago que ya no estén disponibles
                cola.add(aux1);//Añado estas raices a la cola
            }
        }

        while (!cola.isEmpty()){

            u = cola.removeFirst(); //Elimino el primer elemento de la cola

            for (int i = 0; i < u.getAdyacente().size() ; i++){ // Recorro la lista de tareas adyacentes a la tarea que estaba en el primer puesto de la cola
                for (Tareas aux : TareasTotales){ //Recorro toda la lista de tareas para encontrar la tarea adyacente
                    if (aux.getTareas() == u.getAdyacente().get(i)){
                        w = aux;
                    }
                }

                if(w != null && w.isDisponible()){//Al haber encontrado la tarea adyacente, hago que deje de estar disponible y la añado en la lista
                    w.setDisponible(false); //Creo que aquí habría que hacer que dejase de estar disponible en la lista de tareas, pero ns como hacerlo
                    cola.add(w);
                }

            }
            orden.append(u.getTareas()).append(" ");
        }

        return orden.toString().trim();
    }

}
