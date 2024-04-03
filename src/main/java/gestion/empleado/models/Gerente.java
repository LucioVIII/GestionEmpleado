package gestion.empleado.models;

import gestion.empleado.interfaces.EvaluacionDesempeno;
import lombok.Data;

import java.util.List;

@Data
public class Gerente extends Empleado implements EvaluacionDesempeno {
    private List<Empleado> equipo;

    public Gerente(int id, String nombre, String departamento, double salario, List<Empleado> equipo) {
        super(id, nombre, departamento, salario);
        this.equipo = equipo;
    }

    @Override
    public double calcularBono() {
        return salario * 0.1 * equipo.size();
    }

    @Override
    public void mostrarDetalles() {
        super.mostrarDetalles();
        System.out.println("Equipo a cargo: ");
        for (Empleado emp : equipo) {
            emp.mostrarDetalles();
        }
    }

    @Override
    public String evaluarDesempeno() {
        if (equipo.size() >= 5) {
            return "Buen desempeño";
        } else {
            return "Regular desempeño";
        }
    }
}
