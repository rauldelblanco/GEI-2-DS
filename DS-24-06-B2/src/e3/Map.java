package e3;
import java.util.*;

public class Map implements NetworkManager {

    private final HashMap<String, List<TopicOfInterest>> Users;

    public Map(){
        this.Users=new HashMap<>();
    }

    public void addUser(String user, List<TopicOfInterest> topicsOfInterest) {
        Users.put(user,topicsOfInterest);
    }

    public void removeUser(String User){
        if(!Users.isEmpty()) {
            Users.remove(User);
        }
    }

    public void addInterest(String user, TopicOfInterest topicOfInterest){
        if(!Users.isEmpty()) {
            List<TopicOfInterest>lista1 = Users.get(user);
            Users.get(user).add(topicOfInterest);
            Users.replace(user, lista1);
        }
        else {
            throw new IllegalArgumentException();
        }
    }


    public void removeInterest(String user, TopicOfInterest topicOfInterest) {
        if(!Users.isEmpty()) {
            List<TopicOfInterest> topics = Users.get(user);
            topics.remove(topicOfInterest);
            Users.replace(user, topics);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public List<String> getUsers() {
        List<String> UsersList= new LinkedList<>();
        if(!Users.isEmpty()) {
            for (java.util.Map.Entry<String, List<TopicOfInterest>> Usuario : Users.entrySet()) {
                UsersList.add(Usuario.getKey());
            }
            return UsersList;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public List<TopicOfInterest> getInterests(){
        List<TopicOfInterest> TopicList= new LinkedList<>();
        List <TopicOfInterest> TopicArray;
        if(!Users.isEmpty()) {
            for (java.util.Map.Entry<String, List<TopicOfInterest>> Usuario : Users.entrySet()) {
                TopicArray=Usuario.getValue();
                TopicList.addAll(TopicArray);
            }
            return TopicList;
        }
        else{
            throw new IllegalArgumentException();
        }
    }


    public List<TopicOfInterest> getInterestsUser(String user) {
        List<TopicOfInterest> TopicList;
        if(!Users.isEmpty()) {
            TopicList=Users.get(user);
            return TopicList;
        }
        else{
            throw new IllegalArgumentException();
        }
    }
}