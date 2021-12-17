package e1;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Origen implements Comparaciones{

    private final String Origen;


    public Origen(String origen) {
        Origen = origen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Origen origen = (Origen) o;
        return Origen.equals(origen.Origen);
    }

    @Override
    public List<Billetes> filtrado(List<Billetes> billetes, Comparaciones propiedad) {
        return billetes.stream().filter(billetess -> billetess.getOrigen().equals(propiedad)).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "" + Origen;
    }
}
