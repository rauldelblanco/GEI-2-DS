package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColegioTest {

    private final Colegio colegio = new Colegio();

    @Test
    void  testResultado () {

        Residentes residentes1 = new Residentes("Hermione", "Granger", 18, Residentes.Criaturas.Estudiante, Residentes.Casa.Gryffindor, 3);
        Residentes residentes2 = new Residentes("Barón", "Sanguinario", 321, Residentes.Criaturas.Fantasmas, Residentes.Casa.Slytherin, 2);
        Residentes residentes3 = new Residentes("Draco", "Malfoy", 33, Residentes.Criaturas.Estudiante, Residentes.Casa.Slytherin, 3);
        Guardabosques guardabosques1 = new Guardabosques("Rubeus", "Hagrid", 74, 2, true);
        Guardabosques guardabosques2 = new Guardabosques("Rubeus", "Hagrid Jr", 43, 1, false);
        Docentes docentes1 = new Docentes("Minerva", "McGonagall", 47, 1, Docentes.Asignatura.Transformaciones);
        Docentes docentes2 = new Docentes("Severus", "Snape", 47, 2, Docentes.Asignatura.Defensa);
        Docentes docentes3 = new Docentes("Horace", "Slughorn", 68, 3, Docentes.Asignatura.Pociones);
        Docentes docentes4 = new Docentes("Cuthbert", "Binns", 72, 0, Docentes.Asignatura.Historia);
        Docentes docentes5 = new Docentes("Pomona", "Sprout", 54, 1, Docentes.Asignatura.Herbologia);
        Docentes docentes6 = new Docentes("Severus", "Snape", 47, 2, Docentes.Asignatura.Pociones);

        Conserjes conserjes1 = new Conserjes("Argus", "Filch", 32, 0, true);
        Conserjes conserjes2 = new Conserjes("Argus", "Filch Sr", 84, 0, false);

        colegio.addIntegrante(residentes1);
        colegio.addIntegrante(residentes2);
        colegio.addIntegrante(residentes3);
        colegio.addIntegrante(guardabosques1);
        colegio.addIntegrante(guardabosques2);
        colegio.addIntegrante(docentes1);
        colegio.addIntegrante(docentes2);
        colegio.addIntegrante(docentes3);
        colegio.addIntegrante(docentes4);
        colegio.addIntegrante(docentes5);
        colegio.addIntegrante(conserjes1);
        colegio.addIntegrante(conserjes2);

        assertEquals("""
                Hermione Granger (Estudiante de Gryffindor, 3 horrocruxes): 270.0 galeones
                Barón Sanguinario (Fantasma de Slytherin, 2 horrocruxes): 160.0 galeones
                Draco Malfoy (Estudiante de Slytherin, 3 horrocruxes): 202.5 galeones
                Rubeus Hagrid (Guardabosques, 2 horrocruxes): 150.0 galeones
                Rubeus Hagrid Jr (Guardabosques, 1 horrocruxes): 75.0 galeones
                Minerva McGonagall (Docente de Transformaciones, 1 horrocruxes): 50.0 galeones
                Severus Snape (Docente de Defensa, 2 horrocruxes): 75.0 galeones
                Horace Slughorn (Docente de Pociones, 3 horrocruxes): 150.0 galeones
                Cuthbert Binns (Docente de Historia, 0 horrocruxes): 0.0 galeones
                Pomona Sprout (Docente de Herbologia, 1 horrocruxes): 50.0 galeones
                Argus Filch (Conserje, 0 horrocruxes): 0.0 galeones
                Argus Filch Sr (Conserje, 0 horrocruxes): 0.0 galeones
                La recompensa total del Colegio Hogwarts es de 1182.5 galeones""", colegio.imprimirRecompensas(colegio.getIntegranteslist()));

        assertEquals("""
                Rubeus Hagrid (Guardabosques): 180 galeones
                Rubeus Hagrid Jr (Guardabosques): 170 galeones
                Minerva McGonagall (Docente de Transformaciones): 400 galeones
                Severus Snape (Docente de Defensa): 500 galeones
                Horace Slughorn (Docente de Pociones): 350 galeones
                Cuthbert Binns (Docente de Historia): 500 galeones
                Pomona Sprout (Docente de Herbologia): 250 galeones
                Argus Filch (Conserje): 160 galeones
                Argus Filch Sr (Conserje): 150 galeones
                El gasto de Hogwarts en personal es de 2660 galeones""", colegio.imprimirSalarios(colegio.getIntegranteslist()));

        colegio.cleanLists();

        colegio.addIntegrante(docentes3);

        assertThrows(IllegalArgumentException.class, () -> colegio.addIntegrante(docentes6));
    }
}