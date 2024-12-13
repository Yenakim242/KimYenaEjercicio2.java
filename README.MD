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



