package e3;

import java.util.LinkedList;
import java.util.List;

public class ListMatrix implements NetworkManager{

    private final TopicOfInterest[][] Users;


    public ListMatrix(){
        this.Users = new TopicOfInterest[3000][3000] ;
    }


    @Override
    public void addUser(String user, List<TopicOfInterest> topicsOfInterest) {
        for(int i=0;i<3000;i++){
            if(Users[i][0]==null) {
                Users[i][0] = new TopicOfInterest(user);
                for(int j=1;j<topicsOfInterest.size()+1;j++){
                    Users[i][j]=topicsOfInterest.get(j-1);
                }
                break;
            }
        }

    }

    @Override
    public void removeUser(String user) {
        if(Users[0][0]==null){
            throw new IllegalArgumentException();
        }
        else {
            for (int i = 0; i < 3000; i++) {
                if(Users[i][0] != null) {
                    if (Users[i][0].equals(new TopicOfInterest(user))) {
                        for (int i2 = i + 1; i2 < 3000; i2++) {
                            for (int j = 0; j < 3000; j++) {
                                if(Users[i2][j]==null){
                                    Users[i][j]=null;
                                }
                                Users[i][j] = Users[i2][j];

                            }
                            i++;
                        }
                    }
                }
            }

        }
    }

    @Override
    public void addInterest(String user, TopicOfInterest topicOfInterest) {
        if (Users[0][0] == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3000; i++) {
            if (Users[i][0] != null) {
                if (Users[i][0].equals(new TopicOfInterest(user))) {
                    for (int j = 0; j < 3000; j++) {
                        if (Users[i][j] == null) {
                            Users[i][j] = topicOfInterest;
                            break;
                        }
                    }
                }

            }
        }
    }

    @Override
    public void removeInterest(String user, TopicOfInterest topicOfInterest) {
        for(int i=0;i<3000;i++){
            if(Users[i][0] != null) {
                if (Users[i][0].equals(new TopicOfInterest(user))) {
                    for (int j = 0; j < 3000; j++) {
                        if (Users[i][j] == topicOfInterest) {
                            for (int j2 = j + 1; j2 < 3000; j2++) {
                                if (Users[i][j + 1] == null) {
                                    Users[i][j] = null;
                                } else {
                                    Users[i][j] = Users[i][j2];
                                }
                            }
                        }

                    }

                }
            }
        }
    }

    @Override
    public List<String> getUsers() {
        List<String> Usuarios = new LinkedList<>();
        if(Users[0][0]==null){
            throw new IllegalArgumentException();
        }
        else{
            for(int i=0;i<3000;i++){
                if(Users[i][0]!=null){
                    Usuarios.add(Users[i][0].toString());
                }
            }
            return Usuarios;
        }
    }

    @Override
    public List<TopicOfInterest> getInterests() {
        List<TopicOfInterest> topics= new LinkedList<>();
        if(Users[0][0]==null){
            throw new IllegalArgumentException();
        }
        else {
            for (int i = 0; i < 3000; i++) {
                if (Users[i][0] != null) {
                    for (int j = 1; j < 3000; j++) {
                        if (Users[i][j] != null) {
                            topics.add(Users[i][j]);
                        }
                    }
                }
            }
            return topics;
        }
    }

    @Override
    public List<TopicOfInterest> getInterestsUser(String user) {
        List<TopicOfInterest> topics = new LinkedList<>();
        for (int i = 0; i<3000; i++){
            if(Users[i][0].equals(new TopicOfInterest(user))){
                for (int j=1;j<3000;j++){
                    if(Users[i][j]!=null){
                        topics.add(Users[i][j]);
                    }
                }
                break;
            }
        }
        return topics;
    }


}