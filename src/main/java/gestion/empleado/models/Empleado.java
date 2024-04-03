package gestion.empleado.models;

import lombok.*;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Empleado {
    protected int id;
    protected String nombre;
    protected String departamento;
    protected double salario;

    public abstract double calcularBono();

    public void mostrarDetalles() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Departamento: " + departamento);
        System.out.println("Salario: " + salario);
    }
}
