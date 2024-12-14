import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

// Main para gestionar el flujo del programa
public class KimYenaMain {
    // Lista de eventos para almacenar los datos
    private static ArrayList<KimYenaEvent> events = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Método principal para gestionar el menú y las opciones del programa
    public static void main(String[] args) {
        while (true) {
            // Mostrar menú al usuario
            showMenu();
            String option = scanner.nextLine();
            // Ejecutar la funcionalidad correspondiente según la opción seleccionada
            switch (option) {
                case "1":
                    addEvent();
                    break;
                case "2":
                    deleteEvent();
                    break;
                case "3":
                    listEvents();
                    break;
                case "4":
                    toggleTaskCompletion();
                    break;
                case "5":
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    // Método para mostrar el menú de opciones para usuarios
    private static void showMenu() {
        System.out.println("\nBienvenido a Event Planner. Seleccione una opción: ");
        System.out.println("[1] Añadir evento");
        System.out.println("[2] Borrar evento");
        System.out.println("[3] Listar eventos");
        System.out.println("[4] Marcar/desmarcar tarea completada");
        System.out.println("[5] Salir");
    }

    // Método para agregar un nuevo evento
    private static void addEvent() {
        System.out.println("Ingrese el título del evento: ");
        String title = scanner.nextLine();

        System.out.println("Ingrese la fecha (AAAA-MM-DD): ");
        // Convierte la entrada a LocalDate
        LocalDate date = LocalDate.parse(scanner.nextLine());

        System.out.println("Ingrese la prioridad (HIGH, MEDIUM, LOW): ");
        KimYenaEvent.Priority priority = KimYenaEvent.Priority.valueOf(scanner.nextLine().toUpperCase());

        // Crea el evento
        KimYenaEvent event = new KimYenaEvent(title, date, priority);

        // Preguntar si se desean agregar al evento
        System.out.println("¿Desea agregar tareas al evento? (s/n): ");
        if (scanner.nextLine().equalsIgnoreCase("s")) {
            while (true) {
                System.out.println("Ingrese la descripción de la tarea (o escriba 'salir' para terminar): ");
                String taskDescription = scanner.nextLine();
                // break para salir del bucle si el usuario escribe 'salir'
                // event.addTask para agregar la tarea al evento
                if (taskDescription.equalsIgnoreCase("salir")) break;
                event.addTask(new KimYenaEventTask(taskDescription));
            }
        }
        // Añade el evento a la lista
        events.add(event);
        System.out.println("Evento agregado exitosamente");
    }

    // Método para borrar un evento por título
    private static void deleteEvent() {
        System.out.println("Ingrese el título del evento a borrar.");
        String title = scanner.nextLine();
        // events.removeIf para eliminar el evento si coincide el título
        events.removeIf(event -> event.getTitle().equals(title));
        System.out.println("Evento borarrado.");
    }

    // Método para listar los eventos existentes
    private static void listEvents() {
        if (events.isEmpty()) {
            System.out.println("No hay eventos registrados.");
        } else {
            for (KimYenaEvent event : events) {
                // Imprime el resume del evento
                System.out.println(event);
                // Imprime las tareas del evento
                System.out.println("Tareas: ");
                for (KimYenaEventTask task : event.getTasks()) {
                    System.out.println("- " + task);
                }
                System.out.println();
            }
        }
    }

    // Método para alternar el estado de una tarea de un evento
    private static void toggleTaskCompletion() {
        System.out.println("Ingrese el título del evento: ");
        String title = scanner.nextLine();

        // Buscar el evento con el título dado
        // orElse para devolver null si no se encuentra
        KimYenaEvent event = events.stream().filter(e -> e.getTitle().equals(title)).findFirst().orElse(null);

        if (event == null) {
            System.out.println("Evento no encontrado.");
            return;
        }

        // Mostrar las tareas del evento
        System.out.println("Tareas del evento: ");
        ArrayList<KimYenaEventTask> tasks = event.getTasks();
        for (int i = 0; i < tasks.size(); i++) {
            System.out.printf("[%d] %s\n", i + 1, tasks.get(i));
        }
        // Pedir al usuario que seleccione la tarea a alternar
        // int taskIndex para convertir el estado de la tarea
        System.out.println("Seleccione el número de la tarea para cambiar su estado: ");
        int taskIndex = Integer.parseInt(scanner.nextLine()) - 1;

        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            // tasks.get alterna el estado de la tarea
            tasks.get(taskIndex).toggleCompletion();
            System.out.println("Estado de la tarea actualizado.");
        } else {
            System.out.println("Número de tarea inválido.");
        }
    }
}