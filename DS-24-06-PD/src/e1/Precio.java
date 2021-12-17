package e1;

import java.util.List;
import java.util.stream.Collectors;

public class Precio implements Comparaciones{

    private final float precio;

    public Precio(float precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Precio precio1 = (Precio) o;
        return precio == precio1.precio;
    }


    private boolean precioComparador(Object other) {
        Precio otherPrecio = (Precio) other;
        return (this.precio <= otherPrecio.precio);
    }


    @Override
    public List<Billetes> filtrado(List<Billetes> billetes, Comparaciones propiedades) {
        return billetes.stream().filter(billetess -> billetess.getPrecio().precioComparador(propiedades)).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "" + precio;
    }
}
