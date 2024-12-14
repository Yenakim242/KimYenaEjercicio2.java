import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class KimYenaMain {
    private static ArrayList<KimYenaEvent> events = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            String option = scanner.nextLine();
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

    private static void showMenu() {
        System.out.println("\nBienvenido a Event Planner. Seleccione una opción: ");
        System.out.println("[1] Añadir evento");
        System.out.println("[2] Borrar evento");
        System.out.println("[3] Listar eventos");
        System.out.println("[4] Marcar/desmarcar tarea completada");
        System.out.println("[5] Salir");
    }

    private static void addEvent() {
        System.out.println("Ingrese el título del evento: ");
        String title = scanner.nextLine();

        System.out.println("Ingrese la fecha (AAAA-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        System.out.println("Ingrese la prioridad (HIGH, MEDIUM, LOW): ");
        KimYenaEvent.Priority priority = KimYenaEvent.Priority.valueOf(scanner.nextLine().toUpperCase());
        KimYenaEvent event = new KimYenaEvent(title, date, priority);

        System.out.println("¿Desea agregar tareas al evento? (s/n): ");
        if (scanner.nextLine().equalsIgnoreCase("s")){
            while (true) {
                System.out.println("Ingrese la descripción de la tarea (o escriba 'salir' para terminar): ");
                String taskDescription = scanner.nextLine();
                if (taskDescription.equalsIgnoreCase("salir")) break;
                event.addTask(new KimYenaEventTask(taskDescription));
            }
        }
        events.add(event);
        System.out.println("Evento agregado exitosamente");
    }
    private static void deleteEvent() {
        System.out.println("Ingrese el título del evento a borrar.");
        String title = scanner.nextLine();
        events.removeIf(event -> event.getTitle().equals(title));
        System.out.println("Evento borarrado.");
    }

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

    private static void  toggleTaskCompletion() {
        System.out.println("Ingrese el título del evento: ");
        String title = scanner.nextLine();
        KimYenaEvent event = events.stream().filter(e -> e.getTitle().equals(title)).findFirst().orElse(null);
        
        if (event == null){
            System.out.println("Evento no encontrado.");
            return;
        }

        System.out.println("Tareas del evento: ");
        ArrayList<KimYenaEventTask> tasks = event.getTasks();
        for (int i = 0; i < tasks.size(); i++) {
            System.out.printf("[%d] %s\n", i + 1, tasks.get(i));
        }
        System.out.println("Seleccione el número de la tarea para cambiar su estado: ");
        int taskIndex = Integer.parseInt(scanner.nextLine()) -1;

        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            tasks.get(taskIndex).toggleCompletion();
            System.out.println("Estado de la tarea actualizado.");
        } else {
            System.out.println("Número de tarea inválido.");
        }
    }
}