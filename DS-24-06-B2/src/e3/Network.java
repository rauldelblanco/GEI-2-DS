package e3;

import java.util.LinkedList;
import java.util.List;

public class Network {


    public static void addUser(String user, List<TopicOfInterest> topicsOfInterest, NetworkManager Network) {
        Network.addUser(user,topicsOfInterest);
    }

    public static void DeleteUser(String user,NetworkManager Network){
        Network.removeUser(user);
    }

    public static void AnadirTemaUsuario(String user,NetworkManager Network,TopicOfInterest topic){
        Network.addInterest(user,topic);
    }

    public static void EliminarTemaUsuario(String user,NetworkManager Network,TopicOfInterest topic){
        Network.removeInterest(user,topic);
    }

    public static List<TopicOfInterest> getTemasUsuario(String user, NetworkManager Network){
        return Network.getInterestsUser(user);
    }

    public static List<String> getUsersInterestedInATopic(NetworkManager Network,TopicOfInterest topic){
        List<String> Usuarios = Network.getUsers();
        List<String> UsuariosInteresados = new LinkedList<>();
        for(String usuario : Usuarios){
            List<TopicOfInterest> topics = Network.getInterestsUser(usuario);
            for(TopicOfInterest Topic : topics){
                if(Topic==topic){
                    UsuariosInteresados.add(usuario);
                    break;
                }
            }
        }
        return UsuariosInteresados;
    }

    public static List<TopicOfInterest> TopicsInCommon(NetworkManager Network,String user1,String user2){
        List<TopicOfInterest> lista1 = Network.getInterestsUser(user1);
        List<TopicOfInterest> lista2 = Network.getInterestsUser(user2);
        List<TopicOfInterest> listafinal= new LinkedList<>();
        for(TopicOfInterest topic1 : lista1){
            for(TopicOfInterest topic2: lista2){
                if(topic1==topic2){
                    listafinal.add(topic1);
                }
            }
        }
        return listafinal;
    }

    public static List<TopicOfInterest> TotalTopics(NetworkManager Network){
        return Network.getInterests();
    }

    public static String GetUserAndTopics(NetworkManager Network){
        List<String> usuarios = Network.getUsers();
        List <TopicOfInterest> topics;
        StringBuilder Info = new StringBuilder();
        for(String usuario : usuarios){
            topics = Network.getInterestsUser(usuario);
            Info.append(usuario).append(" ").append(topics.toString()).append(" \n");
        }
        return Info.toString().trim();
    }


}