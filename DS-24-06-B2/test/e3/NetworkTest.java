package e3;

import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NetworkTest {

    Map networkMap = new Map();
    ListMatrix networkMatriz = new ListMatrix();
    TopicOfInterest topic1 = new TopicOfInterest("Gatos");
    TopicOfInterest topic2 = new TopicOfInterest("Perros");
    TopicOfInterest topic3 = new TopicOfInterest("Conejos");
    TopicOfInterest topic4 = new TopicOfInterest("Hamsters");
    List<TopicOfInterest> Topics1 = new LinkedList<>();//topic 1 y 2
    List<TopicOfInterest> Topics2 = new LinkedList<>();//topic 2
    List<TopicOfInterest> Topics3 = new LinkedList<>();//topic 3
    List<TopicOfInterest> Topics4 = new LinkedList<>();//topic 4
    List<TopicOfInterest> Topics5 = new LinkedList<>();//topic 2,3,4
    List<TopicOfInterest> Topics6 = new LinkedList<>();//topic 6


    @Test
    void AltayBajaUsuarios() {
        Topics1.add(topic1); //Topic 1: topic 1 y 2
        Topics1.add(topic2);
        Topics2.add(topic2);
        Topics3.add(topic3);
        Topics4.add(topic4);
        Topics5.add(topic2);
        Topics5.add(topic3);
        Topics5.add(topic4);

        //Map
        //Añadir Usuario
        Network.addUser("Brais", Topics1, networkMap);
        Network.addUser("Raul", Topics2, networkMap);
        Network.addUser("Pablo", Topics3, networkMap);
        Network.addUser("Juan", Topics4, networkMap);
        assertEquals(Topics1, Network.getTemasUsuario("Brais", networkMap));
        assertEquals(Topics2, Network.getTemasUsuario("Raul", networkMap));
        assertEquals(Topics3, Network.getTemasUsuario("Pablo", networkMap));
        assertEquals(Topics4, Network.getTemasUsuario("Juan", networkMap));

        //Eliminar Usuarios
        Network.DeleteUser("Brais", networkMap);
        assertEquals(Topics5, Network.TotalTopics(networkMap));//Topics de Raul,Juan y Pedro
        Network.DeleteUser("Raul", networkMap);
        Network.DeleteUser("Juan", networkMap);
        Network.DeleteUser("Pablo", networkMap);
        assertThrows(IllegalArgumentException.class, () -> Network.TotalTopics(networkMap));//Lista vacia no hay elementos por lo que lanza excepcion

        //Matriz

        //Añadir Usuario
        Network.addUser("Brais", Topics1, networkMatriz);
        Network.addUser("Raul", Topics2, networkMatriz);
        Network.addUser("Juan", Topics3, networkMatriz);
        Network.addUser("Pablo", Topics4, networkMatriz);
        assertEquals(Topics1, Network.getTemasUsuario("Brais", networkMatriz));
        assertEquals(Topics2, Network.getTemasUsuario("Raul", networkMatriz));
        assertEquals(Topics3, Network.getTemasUsuario("Juan", networkMatriz));
        assertEquals(Topics4, Network.getTemasUsuario("Pablo", networkMatriz));

        //EliminarUsuario
        Network.DeleteUser("Brais", networkMatriz);
        assertEquals(Topics5, Network.TotalTopics(networkMatriz));//Topics de Raul,Juan y Pedro
        Network.DeleteUser("Raul", networkMatriz);
        Network.DeleteUser("Juan", networkMatriz);
        Network.DeleteUser("Pablo", networkMatriz);
        assertThrows(IllegalArgumentException.class, () -> Network.TotalTopics(networkMatriz));//Lista vacia no hay elementos por lo que lanza excepcion


    }

    @Test
    void ModificaryObtenerTemasUsuario() {
        Topics1.add(topic1); //Topic 1: topic 1 y 2
        Topics1.add(topic2);
        Topics6.add(topic1);
        Topics6.add(topic2);
        Topics6.add(topic3);
        Topics6.add(topic4);
        //Map
        Network.addUser("Brais", Topics1, networkMap);
        assertEquals(Topics1, Network.getTemasUsuario("Brais", networkMap));
        Network.AnadirTemaUsuario("Brais", networkMap, topic3);
        Network.AnadirTemaUsuario("Brais", networkMap, topic4);
        assertEquals(Topics6, Network.getTemasUsuario("Brais", networkMap));
        Network.EliminarTemaUsuario("Brais", networkMap, topic4);
        Network.EliminarTemaUsuario("Brais", networkMap, topic3);
        assertEquals(Topics1, Network.getTemasUsuario("Brais", networkMap));
        Network.DeleteUser("Brais", networkMap);

        //Matriz
        Network.addUser("Brais", Topics1, networkMatriz);
        assertEquals(Topics1, Network.getTemasUsuario("Brais", networkMatriz));
        Network.AnadirTemaUsuario("Brais", networkMatriz, topic3);
        Network.AnadirTemaUsuario("Brais", networkMatriz, topic4);
        assertEquals(Topics6, Network.getTemasUsuario("Brais", networkMatriz));
        Network.EliminarTemaUsuario("Brais", networkMatriz, topic4);
        Network.EliminarTemaUsuario("Brais", networkMatriz, topic3);
        assertEquals(Topics1, Network.getTemasUsuario("Brais", networkMatriz));
        Network.DeleteUser("Brais", networkMatriz);

    }

    @Test
    void EncontarUsuariosInteresadosEnUnTema() {
        Topics1.add(topic1); //Topic 1: topic 1 y 2
        Topics1.add(topic2);
        Topics2.add(topic2);
        Topics4.add(topic4);
        //Map
        Network.addUser("Brais", Topics1, networkMap);
        Network.addUser("Raul", Topics2, networkMap);
        List<String> RaulYBrais = new LinkedList<>();//Lista con los temas en comun de Brais y Raul
        List<String> Vacia = new LinkedList<>();//Lista Vacia
        RaulYBrais.add("Raul");
        RaulYBrais.add("Brais");
        assertEquals(RaulYBrais, Network.getUsersInterestedInATopic(networkMap, topic2));
        assertEquals(Vacia, Network.getUsersInterestedInATopic(networkMap, topic4));
        Network.DeleteUser("Brais", networkMap);
        Network.DeleteUser("Raul", networkMap);

        //Matriz
        Network.addUser("Raul", Topics1, networkMatriz);
        Network.addUser("Brais", Topics2, networkMatriz);
        assertEquals(RaulYBrais, Network.getUsersInterestedInATopic(networkMatriz, topic2));
        assertEquals(Vacia, Network.getUsersInterestedInATopic(networkMatriz, topic4));
        Network.DeleteUser("Brais", networkMatriz);
        Network.DeleteUser("Raul", networkMatriz);

    }

    @Test
    void BuscarTemasenComunDosUsuariosYObtenerListaUsuariosYTemas() {
        Topics1.add(topic1); //Topic 1: topic 1 y 2
        Topics1.add(topic2);
        Topics2.add(topic2);
        Topics3.add(topic3);

        Network.addUser("Antonio", Topics1, networkMap);
        Network.addUser("Raul", Topics2, networkMap);
        assertEquals(Topics2, Network.TopicsInCommon(networkMap, "Antonio", "Raul"));
        Network.addUser("Puyol", Topics3, networkMap);
        List<TopicOfInterest> VaciaTopics = new LinkedList<>();//Lista Vacia
        assertEquals(VaciaTopics, Network.TopicsInCommon(networkMap, "Puyol", "Raul"));
        assertEquals("""
                Raul [Perros]\s
                Antonio [Gatos, Perros]\s
                Puyol [Conejos]""", Network.GetUserAndTopics(networkMap));

        //Matriz
        Network.addUser("Antonio", Topics1, networkMatriz);
        Network.addUser("Raul", Topics2, networkMatriz);
        assertEquals(Topics2, Network.TopicsInCommon(networkMatriz, "Antonio", "Raul"));
        Network.addUser("Puyol", Topics3, networkMatriz);
        assertEquals(VaciaTopics, Network.TopicsInCommon(networkMatriz, "Puyol", "Raul"));
        assertEquals("""
                Raul [Perros]\s
                Antonio [Gatos, Perros]\s
                Puyol [Conejos]""", Network.GetUserAndTopics(networkMap));

    }
}