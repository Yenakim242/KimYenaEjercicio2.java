import java.time.LocalDate;
import java.util.ArrayList;

// Para un evento con título, fecha, prioridad y tareas asociadas
public class KimYenaEvent{

    // Título del evento
    private String title;
    // Fecha del evento
    private LocalDate date;
    // Prioridad del evento
    private Priority priority;
    //Lista de tareas asociadas
    private ArrayList<KimYenaEventTask> tasks;

    // Constructor de la clase Event
    public KimYenaEvent(String title, LocalDate date, Priority priority) {
        this.title = title;
        this.date = date;
        this.priority = priority;
        this.tasks = new ArrayList<>();
    }

    // Agregar una tarea del evento
    public void addTask(KimYenaEventTask task) {
        tasks.add(task);
    }

    // Sobrescribe el método toString para el evento en formato legible
    @Override
    public String toString() {
        // Usa streams para filtrar tareas completadas
        // filter para verificar si la tarea está completada
        // count() para contar las tareas completadas
        long completedTasks = tasks.stream().filter(task -> task.isCompleted()).count();
        return String.format("Evento: %s, Fecha: %s, Prioridad: %s, Tareas completadas: %d/%d", title, date, priority, completedTasks, tasks.size());
    }

    // Métodos getter para obtener información del evento
    public String getTitle() {
        return title;
    }

    public ArrayList<KimYenaEventTask> getTasks() {
        return tasks;
    }

    // Enum para definir la prioridad de los eventos
    public enum Priority {
        HIGH, MEDIUM, LOW
    }
}