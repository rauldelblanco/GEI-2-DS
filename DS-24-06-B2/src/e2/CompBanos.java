package e2;

import java.util.Comparator;

public class CompBanos implements Comparator<Apartamento> {

    @Override
    public int compare(Apartamento o1, Apartamento o2) {
        return Integer.compare(o1.getNumbanos(), o2.getNumbanos());
    }
}