Este proyecto implementa una solución de software orientada a objetos para el registro, validación y análisis estadístico de estudiantes y sus calificaciones en la asignatura de Algoritmos y Lógica de Programación. La misma lógica de negocio ha sido desarrollada en dos entornos distintos: C++ y Java, garantizando la paridad funcional.

¿Qué hacen los códigos? 
Ambos programas ejecutan de forma secuencial las siguientes operaciones en consola:

Captura y Registro Automatizado: El sistema solicita dinámicamente los datos de identidad (Cédula, Nombre, Apellido) para un mínimo de 5 estudiantes.

Filtro de Entrada Mecanizado: Al ingresar cada una de las 3 notas, el programa intercepta el flujo para evaluar que el valor se encuentre en el rango cerrado de 0.00 a 10.00. Si la nota es inválida o se introduce texto por error, el sistema limpia el búfer y exige la entrada correcta antes de continuar.

Procesamiento en Tiempo Real: Al recibir las notas, el objeto calcula de forma interna el promedio exacto y evalúa la condición de aprobación (si el promedio es mayor o igual a 7.00 el estado se fija como Aprobado, de lo contrario como Reprobado).

Generación de Reportes: Imprime un listado tabular limpio y alineado con la información completa de todos los alumnos guardados en memoria.

Auditoría Estadística: Al cerrar el flujo, despliega contadores globales con el total exacto de alumnos que lograron aprobar y cuántos reprobaron la unidad académica.

Arquitectura y Componentes del Código
Módulo C++ (Cpp/main.cpp)
Clase Estudiante: Concentra los atributos privados para cumplir el aislamiento de datos (encapsulamiento). Cuenta con un constructor parametrizado que dispara las subrutinas privadas de cálculo (calcularPromedio y determinarEstado), además de sus respectivos métodos de acceso público (getters y setters).

Colección Dinámica: Utiliza std::vector<Estudiante> para almacenar los objetos en memoria de manera contigua y segura.

Control de Formato: Emplea las librerías <vector> e <iomanip> (setw, fixed, setprecision) para dar una presentación limpia y profesional a las tablas en la terminal.

Módulo Java (Java/)
Para respetar la modularidad nativa de Java, el diseño se divide de la siguiente manera:

Estudiante.java (Clase Entidad): Define la estructura del objeto. Contiene el constructor, el encapsulamiento estricto mediante propiedades private y la lógica interna que automatiza los cambios de estado académico cuando se invoca un método set en las calificaciones.

Main.java (Clase de Control): Maneja la interfaz de usuario en consola. Utiliza un ArrayList<Estudiante> para la gestión de la colección y centraliza la captura de datos mediante la clase Scanner, apoyándose en hasNextDouble() para evitar fallos críticos ante entradas de tipo de datos incorrectas.
