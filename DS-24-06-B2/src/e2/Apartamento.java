package e2;


import java.util.Objects;

public class Apartamento implements Comparable<Apartamento> {
    private final int numReferencia;
    private final int precioBase;
    private final int precioGaraje;
    private final int tam;
    private final int codigoPostal;
    private final int numHabitaciones;
    private final int numBanos;


    public int getPreciobase() {
        return precioBase;
    }

    public int getPreciogaraje() {
        return precioGaraje;
    }

    public int getNumhabitaciones() {
        return numHabitaciones;
    }

    public int getNumbanos() {
        return numBanos;
    }

    public Apartamento(int numreferencias, int preciobases, int preciogarajes, int tams, int codigopostals, int numhabitaciones, int numbanos){

        if(numreferencias>0) {
            this.numReferencia = numreferencias;
        }
        else{
            throw new IllegalArgumentException();
        }
        if(preciobases > 0 && preciogarajes > 0 && tams > 0 && numhabitaciones >= 1 &&  numbanos >= 1 ) {
            this.precioBase = preciobases;
            this.precioGaraje = preciogarajes;
            this.tam = tams;
            this.numHabitaciones = numhabitaciones;
            this.numBanos = numbanos;
        } else{
            throw new IllegalArgumentException();
        }if(0<codigopostals && codigopostals<99999){
            this.codigoPostal=codigopostals;
        }
        else {
            throw new IllegalArgumentException();
        }

    }


    @Override
    public int compareTo(Apartamento apartamentos){
        return Integer.compare(this.numReferencia, apartamentos.numReferencia);

    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartamento that = (Apartamento) o;
        return precioBase == that.precioBase && precioGaraje == that.precioGaraje && tam == that.tam && codigoPostal == that.codigoPostal && numHabitaciones == that.numHabitaciones && numBanos == that.numBanos;
    }

    public int hashCode() {
        int hash=7;
        hash = 53 * hash + Objects.hashCode(this.codigoPostal);
        hash = 53 * hash + Objects.hashCode(this.numBanos);
        hash = 53 * hash + Objects.hashCode(this.precioGaraje);
        hash = 53 * hash + Objects.hashCode(this.numHabitaciones);
        hash = 53 * hash + Objects.hashCode(this.precioBase);
        hash = 53 * hash + Objects.hashCode(this.tam);
        return hash;
    }
}