package e2;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayDeque;

public class DependenciaDebil implements Dependencias{

    private final List<Tareas> TareasTotales;
    private ArrayDeque<Tareas> pila;

    public DependenciaDebil() {
        TareasTotales = new LinkedList<>();
        pila = new ArrayDeque<>();
    }

    private ArrayDeque<Tareas> OrdenarPila(ArrayDeque<Tareas> pila){
        ArrayDeque<Tareas> pilaaux = new ArrayDeque<>();
        while( !pila.isEmpty() ) {
            Tareas s1 = pila.pop();
            while (!pilaaux.isEmpty() && (pilaaux.peek().getTareas() < s1.getTareas())) {
                pila.push(pilaaux.pop());
            }
            pilaaux.push(s1);
        }
        return pilaaux;
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

        for (Character aux : auxiliar){
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

        Tareas cima, w;
        StringBuilder orden = new StringBuilder();

        for(Tareas aux : TareasTotales){
            if (aux.isRaiz()){
                aux.setDisponible(false);
                pila.add(aux);
            }
        }

        while (!pila.isEmpty()){

            pila = OrdenarPila(pila);

            cima = pila.getFirst();

            for (int i = 0; i < cima.getAdyacente().size(); i++){
                for (Tareas aux : TareasTotales){
                    if (cima.getAdyacente().get(i) == aux.getTareas() && aux.isDisponible()){
                        aux.setDisponible(false);
                        pila.add(aux);
                    }
                }
            }

            w = pila.removeFirst();
            orden.append(w.getTareas()).append(" ");

        }

        return orden.toString().trim();
    }
}
