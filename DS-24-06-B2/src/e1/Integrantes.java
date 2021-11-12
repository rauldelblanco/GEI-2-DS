package e1;

public abstract class Integrantes{

    private final int horrocruxes;
    private final int edad;
    private final String nombre;
    private final String apellido;

    public Integrantes(String nombres, String apellidos, int edades, int horocruxes) {
        this.nombre=nombres;
        this.apellido=apellidos;
        this.edad=edades;
        this.horrocruxes=horocruxes;
    }

    public int getHorrocruxes() {
        return horrocruxes;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

}