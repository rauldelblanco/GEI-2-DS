package e2;

import java.util.LinkedList;
import java.util.List;

public class Tareas {

    //Patron Estrategia: Dependecias va a ser el rol de estrategia y los tipos de dependencias van a
    //jugar los roles de estrategias concretas

    /*Cada tipo de dependecia ordena las tareas de una forma distinta, todas estas clases heredan de la interfaz
    dependencias la funcion que ordena las dependencias y añade las tareas a la lista de tareas para ser ordenada.
    En la clase gestion de dependencias simplemente elegimos el tipo de ordenacion que queremos usar.
     */
    private final char Tareas;
    private boolean disponible;
    private boolean raiz;
    private final List<Character> adyacente;

    public Tareas(char tarea) {

        this.Tareas = tarea;
        this.disponible = true;
        this.adyacente = new LinkedList<>();
        this.raiz = false;

    }

    public List<Character> getAdyacente() {
        return adyacente;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public char getTareas() {
        return Tareas;
    }

    public void setRaiz(boolean raiz) {
        this.raiz = raiz;
    }

    public void setAdyacente(char adyacente) {
        this.adyacente.add(adyacente);
    }

    public boolean isRaiz() {
        return raiz;
    }
}