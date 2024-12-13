import java.time.LocalDate;
import java.util.ArrayList;

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

    @Override
    public String toString() {
        long completedTask = tasks.stream().filter(task -> task.isCompleted).count();
        return String.format("Evento: %s, Fecha: %s, Prioridad: %s, Tareas completadas: %d/%d", title, date, priority, completedTask, tasks.size());
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<KimYenaEventTask> getTasks() {
        return tasks;
    }
}