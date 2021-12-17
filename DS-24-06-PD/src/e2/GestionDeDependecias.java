package e2;

public class GestionDeDependecias {

    public static void AnadirTareas(Dependencias dependencias,String tarea){
        dependencias.addTareas(tarea);
    }

    public static String OrdenarDependencias(Dependencias dependencia){
        return dependencia.RealizarTareas();
    }

}
