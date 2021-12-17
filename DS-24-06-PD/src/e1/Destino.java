package e1;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Destino implements Comparaciones{

    private final String destino;

    public Destino(String destino) {
        this.destino = destino;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destino destino1 = (Destino) o;
        return Objects.equals(destino, destino1.destino);
    }

    @Override
    public List<Billetes> filtrado(List<Billetes> billetes, Comparaciones propiedades) {
        return billetes.stream().filter(billetess -> billetess.getDestino().equals(propiedades)).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "" + destino;
    }
}
