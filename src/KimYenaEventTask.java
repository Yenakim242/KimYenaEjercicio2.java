public class KimYenaEventTask{
    // Descripción de la tarea
    private String text;
    // Estado de la tarea
    private boolean isCompleted;

    // Constructor de la clase EventTask
    public KimYenaEventTask(String text){
        this.text = text;
        this.isCompleted = false; // Por defecto, no está completada
    }

    // Método para obtener el estado de la tarea
    public boolean isCompleted() {
        return isCompleted;
    }

    // Marca o desmarca la tarea como completada.
    public void toggleCompletion() {
        isCompleted = !isCompleted;
    }

    @Override
    public String toString() {
        return String.format("Tarea: %s [Estado: %s]", text, isCompleted ? "Completada" : "Pendiente");
    }
}