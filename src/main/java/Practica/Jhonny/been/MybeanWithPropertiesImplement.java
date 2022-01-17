package Practica.Jhonny.been;

public class MybeanWithPropertiesImplement implements MybeanWithProperties{

private String nombre;
    private String apellido;


    public MybeanWithPropertiesImplement(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String function() {
        return nombre + "-" + apellido;
    }
}
