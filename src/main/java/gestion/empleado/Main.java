package gestion.empleado;

import gestion.empleado.interfaces.EvaluacionDesempeno;
import gestion.empleado.models.Desarrollador;
import gestion.empleado.models.Empleado;
import gestion.empleado.models.Gerente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int contadorID = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Empleado> empleados = new ArrayList<>();

        Empleado empleado1 = new Desarrollador(1, "Juan", "Desarrollo", 2000, List.of("Java", "Python"));
        Empleado empleado2 = new Gerente(2, "Maria", "Gerencia", 3000, new ArrayList<>());
        ((Gerente) empleado2).getEquipo().add(new Desarrollador(3, "Pedro", "Desarrollo", 2500, List.of("C++", "JavaScript")));

        empleados.add(empleado1);
        empleados.add(empleado2);

        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    ingresarEmpleado(scanner, empleados);
                    break;
                case "2":
                    mostrarEmpleados(empleados);
                    break;
                case "3":
                    calcularBonificaciones(empleados);
                    break;
                case "4":
                    evaluarDesempeno(empleados);
                    break;
                case "5":
                    System.out.println("Saliendo del programa...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Ingresar datos de empleado");
        System.out.println("2. Mostrar detalles de empleados");
        System.out.println("3. Calcular bonificaciones");
        System.out.println("4. Evaluar desempeño de empleados");
        System.out.println("5. Salir del programa");
        System.out.println("Ingrese su opción: ");
    }

    private static void ingresarEmpleado(Scanner scanner, List<Empleado> empleados) {
        System.out.println("Ingrese el tipo de empleado (D para Desarrollador, G para Gerente): ");
        String tipo = scanner.nextLine().toUpperCase();
        switch (tipo) {
            case "D":
                Empleado desarrollador = crearDesarrollador(scanner);
                empleados.add(desarrollador);
                break;
            case "G":
                Empleado gerente = crearGerente(scanner);
                empleados.add(gerente);
                break;
            default:
                System.out.println("Tipo de empleado no válido.");
                break;
        }
    }

    private static Desarrollador crearDesarrollador(Scanner scanner) {
        System.out.println("Ingrese el nombre del desarrollador: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el departamento: ");
        String departamento = scanner.nextLine();
        System.out.println("Ingrese el salario: ");
        double salario = Double.parseDouble(scanner.nextLine());
        System.out.println("Ingrese los lenguajes separados por coma: ");
        String lenguajesInput = scanner.nextLine();
        List<String> lenguajes = List.of(lenguajesInput.split(","));
        int id = ++contadorID;
        return new Desarrollador(id, nombre, departamento, salario, lenguajes);
    }


    private static Gerente crearGerente(Scanner scanner) {
        System.out.println("Ingrese el nombre del gerente: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el departamento: ");
        String departamento = scanner.nextLine();
        System.out.println("Ingrese el salario: ");
        double salario = Double.parseDouble(scanner.nextLine());
        // Asignar automáticamente un ID único
        int id = ++contadorID;
        return new Gerente(id, nombre, departamento, salario, new ArrayList<>());
    }


    private static void mostrarEmpleados(List<Empleado> empleados) {
        System.out.println("Detalles de empleados:");
        for (Empleado empleado : empleados) {
            empleado.mostrarDetalles();
            System.out.println("-------------------------------------");
        }
    }

    private static void calcularBonificaciones(List<Empleado> empleados) {
        System.out.println("Calculando bonificaciones...");
        for (Empleado empleado : empleados) {
            System.out.println("Bono de " + empleado.getNombre() + ": " + empleado.calcularBono());
        }
    }

    private static void evaluarDesempeno(List<Empleado> empleados) {
        System.out.println("Evaluación del desempeño:");
        for (Empleado empleado : empleados) {
            if (empleado instanceof EvaluacionDesempeno) {
                System.out.println("Desempeño de " + empleado.getNombre() + ": " + ((EvaluacionDesempeno) empleado).evaluarDesempeno());
            } else {
                System.out.println("No se puede evaluar el desempeño de " + empleado.getNombre());
            }
        }
    }
}
