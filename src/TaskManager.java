import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    private final ArrayList<String> tasks = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println("\nGestor de Tareas:");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Ver tareas");
            System.out.println("3. Eliminar tarea");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer

            switch (option) {
                case 1 -> addTask();
                case 2 -> showTasks();
                case 3 -> removeTask();
                case 4 -> {
                    System.out.println("Saliendo del gestor...");
                    return;
                }
                default -> System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }

    private void addTask() {
        System.out.print("Escribe la nueva tarea: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Tarea agregada.");
    }

    private void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No hay tareas.");
            return;
        }
        System.out.println("Lista de tareas:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private void removeTask() {
        showTasks();
        if (tasks.isEmpty()) return;

        System.out.print("Número de la tarea a eliminar: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index > 0 && index <= tasks.size()) {
            tasks.remove(index - 1);
            System.out.println("Tarea eliminada.");
        } else {
            System.out.println("Número no válido.");
        }
    }
}
