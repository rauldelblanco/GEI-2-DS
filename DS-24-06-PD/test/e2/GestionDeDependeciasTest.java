package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestionDeDependeciasTest {

    OrdenJerarquico jerarquico = new OrdenJerarquico();
    DependenciaFuerte fuerte = new DependenciaFuerte();
    DependenciaDebil debil = new DependenciaDebil();

    String tareas = """
            C -> A
            C -> F
            A -> B
            A -> D
            B -> E
            D -> E
            F -> E
            G -> F
            G -> H
            F -> J
            H -> J
            """;


    @Test
    public void OrdenJerarquicoTest(){
        GestionDeDependecias.AnadirTareas(jerarquico,tareas);
        assertEquals("C G A F H B D E J",GestionDeDependecias.OrdenarDependencias(jerarquico));
    }
    @Test
    public void DependenciaFuerteTest(){
        GestionDeDependecias.AnadirTareas(fuerte,tareas);
        assertEquals("C A B D G F E H J",GestionDeDependecias.OrdenarDependencias(fuerte));
    }


    @Test
    public void DependenciaDebilTest(){
        GestionDeDependecias.AnadirTareas(debil,tareas);
        assertEquals("C A B D E F G H J",GestionDeDependecias.OrdenarDependencias(debil));
    }


}