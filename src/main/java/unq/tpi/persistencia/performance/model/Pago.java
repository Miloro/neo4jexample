package unq.tpi.persistencia.performance.model;

public class Pago
{
    private String nombre;
    private String titulo;
    private double monto;

    public Pago(){}

    public Pago(String nombre, String titulo, double monto) {
        this.nombre = nombre;
        this.titulo = titulo;
        this.monto  = monto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
