package e1;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Fecha implements Comparaciones{

    private final LocalDateTime fecha;


    public Fecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fecha fecha1 = (Fecha) o;
        return Objects.equals(fecha, fecha1.fecha);
    }


    public List<Billetes> filtrado(List<Billetes> billetes, Comparaciones propiedad) {
        return billetes.stream().filter(billetess -> billetess.getFecha().equals(propiedad)).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "" + fecha;
    }

}
