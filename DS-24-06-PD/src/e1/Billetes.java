package e1;

import java.util.Objects;

public final class Billetes {

    private final Origen origen;
    private final Destino destino;
    private final  Precio precio;
    private final Fecha fecha;

    public Billetes(Origen origen, Destino destino, Precio precio, Fecha fecha) {
        this.origen = origen;
        this.destino = destino;
        this.precio = precio;
        this.fecha = fecha;
    }

    public Origen getOrigen() {
        return origen;
    }

    public Destino getDestino() {
        return destino;
    }

    public Precio getPrecio() {
        return precio;
    }

    public Fecha getFecha() {
        return fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Billetes billetes = (Billetes) o;
        return Objects.equals(origen, billetes.origen) && Objects.equals(destino, billetes.destino) && Objects.equals(precio, billetes.precio) && Objects.equals(fecha, billetes.fecha);
    }

    @Override
    public String toString() {
        return "Billete: " + origen.toString() + " " + destino.toString() + " " + precio.toString() + " " + fecha.toString() ;
    }
}
