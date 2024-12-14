##Ejercicio #2 Event Planner

LSINNOVA Events es una agencia especializada en la planificación y organización de eventos corporativos, sociales y artísticos. En LSINNOVA, la clave del éxito está en una cuidadosa planificación y en el control detallado de cada uno de los eventos que organizan para sus clientes.

Como parte de su expansión, LSINNOVA ha decidido desarrollar una aplicación de consola que permita gestionar de forma sencilla los eventos y sus tareas asociadas. Esta aplicación será utilizada por los empleados para registrar nuevos eventos, supervisar las tareas de cada uno de ellos y asegurarse de que todo se ejecute según lo planeado.

En este contexto, el equipo de desarrollo de LSINNOVA ha recibido el encargo de crear una primera versión funcional de la aplicación Event Planner utilizando Java y la consola.

Al iniciarse la aplicación se mostrará el siguiente menú. El menú se mostrará mientras que el usuario no seleccione la opción [4 ] Salir. Si el usuario escoge cualquier otro valor (incluido un valor no numérico), le indicaremos que esta opción no existe y le volveremos a mostrar el menú.

Bienvenido a Event Planner. Seleccione una opción
[1] Añadir evento: permite al usuario introducir obligatoriamente sus datos básicos (title, date, priority). Opcionalmente permítele introducir las tareas del evento. Cuando haya acabado regresa al menú
NOTA: Revisa los apartados de ayuda para saber como crear un tipo LocalDate  a partir de un día, un mes y un año...y poder comprobar que esa fecha existe.
[2] Borrar evento: permite al usuario introducir el title del evento. Por simplicidad supón que para poder borrar un evento el texto introducido por el usuario debe coincidir exactamente con el título de uno de los eventos. Confirma al usuario si la acción ha podido realizarse. Regresa al menú.
[3] Listar eventos: muestra los eventos registrados (usa método toString de Event)
[4] Marcar/desmarcar tarea de un evento como completada: permite al usuario introducir el title del evento sobre el que interactuar. Por simplicidad supón que el texto introducido por el usuario debe coincidir exactamente con el titulo de uno de los eventos. Si el titulo del evento existe, lista sus tareas (usa método toString de EventTask) y el usuario indica la tarea sobre la que quiere interactuar. Informa al usuario de la acción realizada. Regresa al menú
[5] Salir: se terminará el programa.


## Explicación de este proyecto
1. Clase KimYenaEventTask
    · Propósito: Representar las tareas asociadas a un evento.
    · Atributos
        - description: Texto descriptivo de la tarea
        - isCompleted: Estado de completitud de la tarea
    · Métodos
        - toggleCompletion(): Cambia el estado de la tarea (completada/no completada).
        - isCompleted(): Reotrna el estado actual de la tarea.
        - toString(): Representa la tarea en formato texto.
    · Conceptos
        - Encapsulación: Atributos privados con acceso mediante métodos públicos.
        - Métodos auxiliares: Evitar duplicación de código.

2. Clase KimYenaEvent
    · Propósito: Gestionar los eventos y sus tareas asociadas.
    · Atributos:
        - title: Nombre del evento.
        - date: Fecha del evento (LocalDate).
        - priority: Prioridad del evento (enum Priority).
        - tasks: Lista de tareas asociadas (ArrayList<KimYenaEventTask>).
   · Métodos
        - addTask(KimYenaEventTask task): añade una tarea al evento.
        - getTasks(): Retorna la lista de tareas.
        - toString(): Representa el evento en formato texto, incluyendo el progreso de tareas.
    · Conceptos
        - Enumeración: Uso de enum Priority para manejar prioridades.
        - Streams: Contar tareas completadas con expresiones lambda.
        - Encapsulación: Métodos para gestionar tareas.

3. Clase KimYenaMain
    · Propósito: Controlar el flujo principal del programa, mostrando el menú e interactuando con el usuario.
    · Atributos
        - events: Lista global de eventos (ArrayList<KimYenaEvent>).
        - scanner: Instancia para capturar entradas del usuario.
    · Métodos
        - showMenu(): Presenta el menú principal.
        - addEvent(): Añade un evento tras solicitar datos al usuario.
        - deleteEvent(): Muestra los eventos existentes.
        - toggleTaskCompletion(): Permite marcar o desmarcar tareas de un evento.
    · Conceptos
        - while(true) para mostrar el menú.
        - Manejo de excepciones: Validación de entradas y errores comunes.
        - Uso de enumeraciones: Priority.valueOf() para convertir texto a un valor del enum.



