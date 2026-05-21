package Java;

import java.util.ArrayList;
import java.util.Scanner;

// ======================= CLASE MAIN =======================
public class Main {

    public static void main(String[] academico) {

        Scanner entrada = new Scanner(System.in);
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();

        final int MIN_ESTUDIANTES = 5;

        System.out.println("=== SISTEMA DE CONTROL DE CALIFICACIONES (JAVA) ===");

        // Registro de estudiantes
        for (int i = 0; i < MIN_ESTUDIANTES; i++) {

            System.out.println("\nRegistro del Estudiante #" + (i + 1));

            System.out.print("  Cédula: ");
            String cedula = entrada.next();

            System.out.print("  Nombre: ");
            String nombre = entrada.next();

            System.out.print("  Apellido: ");
            String apellido = entrada.next();

            // Validación de notas
            double n1 = solicitarNotaValidada(entrada, "Nota 1");
            double n2 = solicitarNotaValidada(entrada, "Nota 2");
            double n3 = solicitarNotaValidada(entrada, "Nota 3");

            // Crear objeto estudiante
            Estudiante estudiante = new Estudiante(
                    cedula,
                    nombre,
                    apellido,
                    n1,
                    n2,
                    n3
            );

            listaEstudiantes.add(estudiante);
        }

        // Mostrar listado
        System.out.println("\n============================================ LISTADO COMPLETO ============================================");

        System.out.printf(
                "%-12s %-15s %-15s %-8s %-8s %-8s %-10s %-12s%n",
                "Cédula",
                "Nombre",
                "Apellido",
                "Nota 1",
                "Nota 2",
                "Nota 3",
                "Promedio",
                "Estado"
        );

        System.out.println("----------------------------------------------------------------------------------------------------------");

        int aprobados = 0;
        int reprobados = 0;

        for (Estudiante est : listaEstudiantes) {

            est.mostrarInformacion();

            if (est.getEstado().equals("Aprobado")) {
                aprobados++;
            } else {
                reprobados++;
            }
        }

        System.out.println("----------------------------------------------------------------------------------------------------------");

        // Estadísticas finales
        System.out.println("\n=== ESTADÍSTICAS GENERALES ===");
        System.out.println("Total Estudiantes Aprobados:  " + aprobados);
        System.out.println("Total Estudiantes Reprobados: " + reprobados);
        System.out.println("==============================");

        entrada.close();
    }

    // Método para validar notas
    private static double solicitarNotaValidada(Scanner sc, String identificadorNota) {

        double nota;

        while (true) {

            System.out.print("  Ingrese la " + identificadorNota + " (0 - 10): ");

            if (sc.hasNextDouble()) {

                nota = sc.nextDouble();

                if (nota >= 0.0 && nota <= 10.0) {
                    return nota;
                }

            } else {
                sc.next(); // limpiar buffer
            }

            System.out.println("  [Error] Nota inválida o fuera de rango (0-10). Intente de nuevo.");
        }
    }
}

// ======================= CLASE ESTUDIANTE =======================
class Estudiante {

    // Atributos
    private String cedula;
    private String nombre;
    private String apellido;

    private double nota1;
    private double nota2;
    private double nota3;

    // Constructor
    public Estudiante(
            String cedula,
            String nombre,
            String apellido,
            double nota1,
            double nota2,
            double nota3
    ) {

        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;

        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    // Método para calcular promedio
    public double calcularPromedio() {

        return (nota1 + nota2 + nota3) / 3;
    }

    // Método para obtener estado
    public String getEstado() {

        if (calcularPromedio() >= 7) {
            return "Aprobado";
        } else {
            return "Reprobado";
        }
    }

    // Mostrar información
    public void mostrarInformacion() {

        System.out.printf(
                "%-12s %-15s %-15s %-8.2f %-8.2f %-8.2f %-10.2f %-12s%n",
                cedula,
                nombre,
                apellido,
                nota1,
                nota2,
                nota3,
                calcularPromedio(),
                getEstado()
        );
    }
}