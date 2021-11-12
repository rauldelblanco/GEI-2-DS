package e2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Alquiler{

    private final List<Apartamento> apartamentoList = new ArrayList<>();
    private Comparator<Apartamento> comparator = null;
    public void setComparator(Comparator<Apartamento> comparator){
        this.comparator=comparator;
    }

    public List<Apartamento> getApartamentoList() {
        return apartamentoList;
    }

    public Comparator<Apartamento> getComparator() {
        return comparator;
    }
}