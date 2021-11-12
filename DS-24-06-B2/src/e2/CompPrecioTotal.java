package e2;

import java.util.Comparator;

public class CompPrecioTotal implements Comparator<Apartamento> {

    @Override
    public int compare(Apartamento o1, Apartamento o2) {
        return Integer.compare((o1.getPreciobase()+ o1.getPreciogaraje()), (o2.getPreciobase()+o2.getPreciogaraje()));
    }
}