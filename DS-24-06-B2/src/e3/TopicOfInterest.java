package e3;

import java.util.Objects;

public class TopicOfInterest {
    private final String TopicOfInterest;

    public TopicOfInterest(String TopicOfInterest){
        this.TopicOfInterest=TopicOfInterest;
    }

    @Override
    public String toString() {
        return TopicOfInterest ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopicOfInterest topic = (TopicOfInterest) o;
        return Objects.equals(TopicOfInterest, topic.TopicOfInterest);
    }

}