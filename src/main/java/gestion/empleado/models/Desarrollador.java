package gestion.empleado.models;

import java.util.List;

public class Desarrollador extends Empleado {
    private List<String> lenguajes;

    public Desarrollador(int id, String nombre, String departamento, double salario, List<String> lenguajes) {
        super(id, nombre, departamento, salario);
        this.lenguajes = lenguajes;
    }

    @Override
    public double calcularBono() {
        return lenguajes.size() > 0 ? salario * 0.1 * lenguajes.size() : 0;
    }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Lenguajes: " + lenguajes);
    }
}
