import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Tarea {
    String descripcion;
    boolean completada;

    public Tarea(String descripcion) {
        this.descripcion = descripcion;
        this.completada = false;
    }

    @Override
    public String toString() {
        return (completada ? "[X] " : "[ ] ") + descripcion;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Tarea> listaTareas = new ArrayList<>();
        boolean activo = true;

        while (activo) {
            System.out.println("\n--- GESTOR DE TAREAS ---");
            System.out.println("1. Añadir una tarea");
            System.out.println("2. Ver tareas pendientes");
            System.out.println("3. Marcar una tarea como completada");
            System.out.println("4. Eliminar una tarea");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            String opcion = scanner.nextLine();

            if (opcion.equals("1")) {
                System.out.print("Introduce la descripción de la tarea: ");
                String desc = scanner.nextLine();
                listaTareas.add(new Tarea(desc));
                System.out.println("Tarea añadida con éxito.");

            } else if (opcion.equals("2")) {
                System.out.println("\n--- TAREAS PENDIENTES ---");
                boolean hayPendientes = false;
                for (int i = 0; i < listaTareas.size(); i++) {
                    if (!listaTareas.get(i).completada) {
                        System.out.println((i + 1) + ". " + listaTareas.get(i));
                        hayPendientes = true;
                    }
                }
                if (!hayPendientes) {
                    System.out.println("No tienes tareas pendientes.");
                }

            } else if (opcion.equals("3")) {
                mostrarTodasLasTareas(listaTareas);
                if (!listaTareas.isEmpty()) {
                    System.out.print("Introduce el número de la tarea a completar: ");
                    try {
                        int indice = Integer.parseInt(scanner.nextLine()) - 1;
                        if (indice >= 0 && indice < listaTareas.size()) {
                            listaTareas.get(indice).completada = true;
                            System.out.println("Tarea marcada como completada.");
                        } else {
                            System.out.println("Número de tarea inválido.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Por favor, introduce un número válido.");
                    }
                }

            } else if (opcion.equals("4")) {
                mostrarTodasLasTareas(listaTareas);
                if (!listaTareas.isEmpty()) {
                    System.out.print("Introduce el número de la tarea a eliminar: ");
                    try {
                        int indice = Integer.parseInt(scanner.nextLine()) - 1;
                        if (indice >= 0 && indice < listaTareas.size()) {
                            listaTareas.remove(indice);
                            System.out.println("Tarea eliminada.");
                        } else {
                            System.out.println("Número de tarea inválido.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Por favor, introduce un número válido.");
                    }
                }

            } else if (opcion.equals("5")) {
                activo = false;
                System.out.println("Saliendo del gestor de tareas. ¡Hasta pronto!");

            } else {
                System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
        scanner.close();
    }

    private static void mostrarTodasLasTareas(List<Tarea> tareas) {
        if (tareas.isEmpty()) {
            System.out.println("La lista de tareas está vacía.");
        } else {
            System.out.println("\n--- TODAS LAS TAREAS ---");
            for (int i = 0; i < tareas.size(); i++) {
                System.out.println((i + 1) + ". " + tareas.get(i));
            }
        }
    }
}