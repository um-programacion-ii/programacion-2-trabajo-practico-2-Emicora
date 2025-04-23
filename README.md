[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/tc38IXJF)
# 📚 Trabajo Práctico: Sistema de Gestión de Biblioteca Digital (Java 21+)

## 📌 Objetivo General

Desarrollar un sistema de gestión de biblioteca digital que implemente los cinco principios SOLID, programación orientada a objetos, y conceptos avanzados de Java. El sistema deberá manejar diferentes tipos de recursos digitales, préstamos, reservas, y notificaciones en tiempo real.

## 👨‍🎓 Información del Alumno
- **Nombre y Apellido**: Emiliano Coratolo

## 📋 Requisitos Adicionales

### Documentación del Sistema
Como parte del trabajo práctico, deberás incluir en este README una guía de uso que explique:

1. **Cómo funciona el sistema**:
   - Descripción general de la arquitectura
   - Explicación de los componentes principales
   - Flujo de trabajo del sistema

2. **Cómo ponerlo en funcionamiento**:
   - Deberás incluir las instrucciones detalladas de puesta en marcha
   - Explicar los requisitos previos necesarios
   - Describir el proceso de compilación
   - Detallar cómo ejecutar la aplicación

3. **Cómo probar cada aspecto desarrollado**:
   - Deberás proporcionar ejemplos de uso para cada funcionalidad implementada
   - Incluir casos de prueba que demuestren el funcionamiento del sistema
   - Describir flujos de trabajo completos que muestren la interacción entre diferentes componentes

La guía debe ser clara, concisa y permitir a cualquier usuario entender y probar el sistema. Se valorará especialmente:
- La claridad de las instrucciones
- La completitud de la documentación
- La organización de la información
- La inclusión de ejemplos prácticos

### Prueba de Funcionalidades

#### 1. Gestión de Recursos
- **Agregar Libro**: 
  - Proceso para agregar un nuevo libro al sistema
  - Verificación de que el libro se agregó correctamente
  - Validación de los datos ingresados

- **Buscar Recurso**:
  - Proceso de búsqueda de recursos
  - Verificación de resultados de búsqueda
  - Manejo de casos donde no se encuentran resultados

- **Listar Recursos**:
  - Visualización de todos los recursos
  - Filtrado por diferentes criterios
  - Ordenamiento de resultados

#### 2. Gestión de Usuarios
- **Registrar Usuario**:
  - Proceso de registro de nuevos usuarios
  - Validación de datos del usuario
  - Verificación del registro exitoso

- **Buscar Usuario**:
  - Proceso de búsqueda de usuarios
  - Visualización de información del usuario
  - Manejo de usuarios no encontrados

#### 3. Préstamos
- **Realizar Préstamo**:
  - Proceso completo de préstamo
  - Verificación de disponibilidad
  - Actualización de estados

- **Devolver Recurso**:
  - Proceso de devolución
  - Actualización de estados
  - Liberación del recurso

#### 4. Reservas
- **Realizar Reserva**:
  - Proceso de reserva de recursos
  - Gestión de cola de reservas
  - Notificación de disponibilidad

#### 5. Reportes
- **Ver Reportes**:
  - Generación de diferentes tipos de reportes
  - Visualización de estadísticas
  - Exportación de datos

#### 6. Alertas
- **Verificar Alertas**:
  - Sistema de notificaciones
  - Diferentes tipos de alertas
  - Gestión de recordatorios

### Ejemplos de Prueba
1. **Flujo Completo de Préstamo**:
   - Registrar un usuario
   - Agregar un libro
   - Realizar un préstamo
   - Verificar el estado del recurso
   - Devolver el recurso
   - Verificar la actualización del estado

2. **Sistema de Reservas**:
   - Registrar dos usuarios
   - Agregar un libro
   - Realizar una reserva con cada usuario
   - Verificar la cola de reservas
   - Procesar las reservas

3. **Alertas y Notificaciones**:
   - Realizar un préstamo
   - Esperar a que se acerque la fecha de vencimiento
   - Verificar las alertas generadas
   - Probar la renovación del préstamo

## 🧩 Tecnologías y Herramientas

- Java 21+ (LTS)
- Git y GitHub
- GitHub Projects
- GitHub Issues
- GitHub Pull Requests

## 📘 Etapas del Trabajo

### Etapa 1: Diseño Base y Principios SOLID
- **SRP**: 
  - Crear clase `Usuario` con atributos básicos (nombre, ID, email)
  - Crear clase `RecursoDigital` como clase base abstracta
  - Implementar clase `GestorUsuarios` separada de `GestorRecursos`
  - Cada clase debe tener una única responsabilidad clara
  - Implementar clase `Consola` para manejar la interacción con el usuario

- **OCP**: 
  - Diseñar interfaz `RecursoDigital` con métodos comunes
  - Implementar clases concretas `Libro`, `Revista`, `Audiolibro`
  - Usar herencia para extender funcionalidad sin modificar código existente
  - Ejemplo: agregar nuevo tipo de recurso sin cambiar clases existentes
  - Implementar menú de consola extensible para nuevos tipos de recursos

- **LSP**: 
  - Asegurar que todas las subclases de `RecursoDigital` puedan usarse donde se espera `RecursoDigital`
  - Implementar métodos comunes en la clase base
  - Validar que el comportamiento sea consistente en todas las subclases
  - Crear métodos de visualización en consola para todos los tipos de recursos

- **ISP**: 
  - Crear interfaz `Prestable` para recursos que se pueden prestar
  - Crear interfaz `Renovable` para recursos que permiten renovación
  - Implementar solo las interfaces necesarias en cada clase
  - Diseñar menús de consola específicos para cada tipo de operación

- **DIP**: 
  - Crear interfaz `ServicioNotificaciones`
  - Implementar `ServicioNotificacionesEmail` y `ServicioNotificacionesSMS`
  - Usar inyección de dependencias en las clases que necesitan notificaciones
  - Implementar visualización de notificaciones en consola

### Etapa 2: Gestión de Recursos y Colecciones
- Implementar colecciones:
  - Usar `ArrayList<RecursoDigital>` para almacenar recursos
  - Usar `Map<String, Usuario>` para gestionar usuarios
  - Implementar métodos de búsqueda básicos
  - Crear menú de consola para gestión de recursos

- Crear servicios de búsqueda:
  - Implementar búsqueda por título usando Streams
  - Implementar filtrado por categoría
  - Crear comparadores personalizados para ordenamiento
  - Diseñar interfaz de consola para búsquedas con filtros

- Sistema de categorización:
  - Crear enum `CategoriaRecurso`
  - Implementar método de asignación de categorías
  - Crear búsqueda por categoría
  - Mostrar categorías disponibles en consola

- Manejo de excepciones:
  - Crear `RecursoNoDisponibleException`
  - Crear `UsuarioNoEncontradoException`
  - Implementar manejo adecuado de excepciones en los servicios
  - Mostrar mensajes de error amigables en consola

### Etapa 3: Sistema de Préstamos y Reservas
- Implementar sistema de préstamos:
  - Crear clase `Prestamo` con atributos básicos
  - Implementar lógica de préstamo y devolución
  - Manejar estados de los recursos (disponible, prestado, reservado)
  - Diseñar menú de consola para préstamos

- Sistema de reservas:
  - Crear clase `Reserva` con atributos necesarios
  - Implementar cola de reservas usando `BlockingQueue`
  - Manejar prioridad de reservas
  - Mostrar estado de reservas en consola

- Notificaciones:
  - Implementar sistema básico de notificaciones
  - Crear diferentes tipos de notificaciones
  - Usar `ExecutorService` para enviar notificaciones
  - Mostrar notificaciones en consola

- Concurrencia:
  - Implementar sincronización en operaciones de préstamo
  - Usar `synchronized` donde sea necesario
  - Manejar condiciones de carrera
  - Mostrar estado de operaciones concurrentes en consola

### Etapa 4: Reportes y Análisis
- Generar reportes básicos:
  - Implementar reporte de recursos más prestados
  - Crear reporte de usuarios más activos
  - Generar estadísticas de uso por categoría
  - Diseñar visualización de reportes en consola

- Sistema de alertas:
  - Implementar alertas por vencimiento de préstamos:
    - Crear clase `AlertaVencimiento` que monitorea fechas de devolución
    - Implementar lógica de recordatorios (1 día antes, día del vencimiento)
    - Mostrar alertas en consola con formato destacado
    - Permitir renovación desde la alerta
  
  - Crear notificaciones de disponibilidad:
    - Implementar `AlertaDisponibilidad` para recursos reservados
    - Notificar cuando un recurso reservado está disponible
    - Mostrar lista de recursos disponibles en consola
    - Permitir préstamo inmediato desde la notificación
  
  - Manejar recordatorios automáticos:
    - Implementar sistema de recordatorios periódicos
    - Crear diferentes niveles de urgencia (info, warning, error)
    - Mostrar historial de alertas en consola
    - Permitir configuración de preferencias de notificación

- Concurrencia en reportes:
  - Implementar generación de reportes en segundo plano
  - Usar `ExecutorService` para tareas asíncronas
  - Manejar concurrencia en acceso a datos
  - Mostrar progreso de generación de reportes en consola

## 📋 Detalle de Implementación

### 1. Estructura Base
```java
// Interfaces principales
public interface RecursoDigital {
    String getIdentificador();
    EstadoRecurso getEstado();
    void actualizarEstado(EstadoRecurso estado);
}

public interface Prestable {
    boolean estaDisponible();
    LocalDateTime getFechaDevolucion();
    void prestar(Usuario usuario);
}

public interface Notificable {
    void enviarNotificacion(String mensaje);
    List<Notificacion> getNotificacionesPendientes();
}

// Clase base abstracta
public abstract class RecursoBase implements RecursoDigital, Prestable {
    // Implementación común
}
```

### 2. Gestión de Biblioteca
```java
public class GestorBiblioteca {
    private final Map<String, RecursoDigital> recursos;
    private final List<Prestamo> prestamos;
    private final ExecutorService notificador;
    // Implementación de gestión
}
```

### 3. Sistema de Préstamos
```java
public class SistemaPrestamos {
    private final BlockingQueue<SolicitudPrestamo> colaSolicitudes;
    private final ExecutorService procesadorPrestamos;
    // Implementación de préstamos
}
```

## ✅ Entrega y Flujo de Trabajo con GitHub

1. **Configuración del Repositorio**
   - Proteger la rama `main`
   - Crear template de Issues y Pull Requests

2. **Project Kanban**
   - `To Do`
   - `In Progress`
   - `Code Review`
   - `Done`

3. **Milestones**
   - Etapa 1: Diseño Base
   - Etapa 2: Gestión de Recursos
   - Etapa 3: Sistema de Préstamos
   - Etapa 4: Reportes

4. **Issues y Pull Requests**
   - Crear Issues detallados para cada funcionalidad
   - Asociar cada Issue a un Milestone
   - Implementar en ramas feature
   - Revisar código antes de merge

## 📝 Ejemplo de Issue

### Título
Implementar sistema de préstamos concurrente

### Descripción
Crear el sistema de préstamos que utilice hilos y el patrón productor-consumidor para procesar solicitudes de préstamo en tiempo real.

#### Requisitos
- Implementar `BlockingQueue` para solicitudes de préstamo
- Crear procesador de solicitudes usando `ExecutorService`
- Implementar sistema de notificaciones
- Asegurar thread-safety en operaciones de préstamo

#### Criterios de Aceptación
- [ ] Sistema procesa préstamos concurrentemente
- [ ] Manejo adecuado de excepciones
- [ ] Documentación de diseño

### Labels
- `enhancement`
- `concurrency`

## ✅ Requisitos para la Entrega

- ✅ Implementación completa de todas las etapas
- ✅ Código bien documentado
- ✅ Todos los Issues cerrados
- ✅ Todos los Milestones completados
- ✅ Pull Requests revisados y aprobados
- ✅ Project actualizado

> ⏰ **Fecha de vencimiento**: 23/04/2025 a las 13:00 hs

## 📚 Recursos Adicionales

- Documentación oficial de Java 21
- Guías de estilo de código
- Ejemplos de implementación concurrente
- Patrones de diseño aplicados

## 📝 Consideraciones Éticas

### Uso de Inteligencia Artificial
El uso de herramientas de IA en este trabajo práctico debe seguir las siguientes pautas:

1. **Transparencia**
   - Documentar claramente qué partes del código fueron generadas con IA
   - Explicar las modificaciones realizadas al código generado
   - Mantener un registro de las herramientas utilizadas

2. **Aprendizaje**
   - La IA debe usarse como herramienta de aprendizaje, no como reemplazo
   - Comprender y ser capaz de explicar el código generado
   - Utilizar la IA para mejorar la comprensión de conceptos

3. **Integridad Académica**
   - El trabajo final debe reflejar tu aprendizaje y comprensión personal
   - No se permite la presentación de código generado sin comprensión
   - Debes poder explicar y defender cualquier parte del código

4. **Responsabilidad**
   - Verificar la corrección y seguridad del código generado
   - Asegurar que el código cumple con los requisitos del proyecto
   - Mantener la calidad y estándares de código establecidos

5. **Desarrollo Individual**
   - La IA puede usarse para facilitar tu proceso de aprendizaje
   - Documentar tu proceso de desarrollo y decisiones tomadas
   - Mantener un registro de tu progreso y aprendizaje

### Consecuencias del Uso Inadecuado
El uso inadecuado de IA puede resultar en:
- Calificación reducida o nula
- Sanciones académicas
- Pérdida de oportunidades de aprendizaje
- Impacto negativo en tu desarrollo profesional

## 📝 Licencia

Este trabajo es parte del curso de Programación Avanzada de Ingeniería en Informática. Uso educativo únicamente.

# Sistema de Gestión de Biblioteca Digital

## Documentación del Sistema

### 1. Descripción general de la arquitectura
El sistema sigue un diseño modular basado en principios SOLID:

- **Modelo**  
  - `Usuario`, `RecursoDigital` (subclases: `Libro`, `Audiolibro`, `Historieta`), `Prestamo`, `Reserva`.  
- **Servicios / Lógica de negocio**  
  - `GestorUsuarios`, `GestorRecursos`, `GestorPrestamos`, `GestorReservas`.  
- **Notificaciones y Alertas**  
  - `ServicioNotificacionesEmail`, `ServicioNotificacionesSMS`, `ServicioNotificacionPrestamos`.  
  - `AlertaVencimiento`, `AlertaDisponibilidad`, `HistorialAlertas`.  
- **Interfaz**  
  - `Consola.java`: menús y flujo de interacción.  
- **Asincronía**  
  - `ScheduledExecutorService` para alertas de vencimiento cada 10 segundos.  
  - `ExecutorService` para generación asíncrona de reportes con progreso.  

### 2. Explicación de los componentes principales

| Componente                 | Responsabilidad                                                |
| -------------------------- | -------------------------------------------------------------- |
| `Usuario`                  | Datos del usuario y validaciones.                              |
| `RecursoDigital`           | Modelo base de recursos; subclases gestionan atributos específicos. |
| `GestorUsuarios`           | Registro y búsqueda de usuarios.                               |
| `GestorRecursos`           | Alta, listado y búsqueda (título, categoría) de recursos.      |
| `GestorPrestamos`          | Lógica de préstamos, devoluciones y notificaciones.            |
| `GestorReservas`           | Cola de reservas y alerta de disponibilidad automática.        |
| `AlertaVencimiento`        | Recordatorios automáticos (INFO, WARNING, ERROR).              |
| `AlertaDisponibilidad`     | Notificaciones cuando un recurso reservado se libera.          |
| `HistorialAlertas`         | Registro en memoria de todas las alertas generadas.            |
| `Reportes`                 | Reportes de recursos más prestados, usuarios activos, por categoría. |
| `Consola`                  | Interfaz de usuario: menús, lectura de entrada y salida.       |

### 3. Flujo de trabajo del sistema

1. **Arranque** (`main`):  
   - Instancia gestores, servicios y consola.  
   - Programa alerta de vencimiento cada 10 s.  
   - Lanza `Consola.iniciar()`.  
2. **Menú Principal**:  
   - Registrar usuario, agregar recursos, préstamos, devoluciones, reservas.  
   - Listados, búsquedas, reportes, alertas y salida.  
3. **Operación**:  
   - `Consola` captura datos, invoca el `Gestor*` correspondiente.  
   - El gestor valida, actualiza estados y dispara notificaciones/alertas.  
4. **Alertas**:  
   - `ScheduledExecutorService` ejecuta `AlertaVencimiento` periódicamente en background.  
   - `AlertaDisponibilidad` se dispara tras cada devolución si hay reservas.  
5. **Reportes**:  
   - Opción “Generar Reportes Asíncronos” envía tarea a un `ExecutorService`.  
   - Muestra progreso (0 %, 33 %, 66 %, 100 %) mientras usa los métodos de `Reportes`.  

---

## Cómo ponerlo en funcionamiento

### Requisitos previos
- **JDK 21+** instalado y configurado.  
- **IDE** (IntelliJ, Eclipse) o editor de texto.  

### Compilación con `javac`

git clone git@github.com:um-programacion-ii/programacion-2-trabajo-practico-2-Emicora.git
cd programacion-2-trabajo-practico-2-Emicora/BibliotecaDigital
javac -d out $(find src -name "*.java")

## Ejecución

cd out
java Project.Consola


## Prueba de funcionalidades

1.Gestión de Recursos

### Agregar Libro

- Elige opción 2.  
- Tipo 1 → ingresa ID, título, autor, páginas.  
- Verifica mensaje “Libro agregado correctamente.”

### Buscar Recurso

- Opción 8 → filtro “a” (título) o “b” (categoría).  
- Verifica resultados y manejo de “no encontrado.”

### Listar Recursos

- Opción 7 muestra todos los recursos actuales.

2.Gestión de Usuarios

### Registrar Usuario

- Opción 1 → datos de nombre, ID, email, teléfono.  
- Valida duplicados e inválidos.

### Buscar Usuario

- Opción 9 → ingresa ID → muestra datos o mensaje de error.

3.Préstamos

### Realizar Préstamo

- Opción 3 → ID usuario y recurso.  
- Verifica disponibilidad y notifica (email/SMS).

### Devolver Recurso

- Opción 4 → ID recurso → cambia a “disponible” y procesa reservas.

4.Reservas

### Realizar Reserva

- Opción 5 → ID usuario y recurso.  
- Estado pasa a “reservado” y se encola.

### Notificación de Disponibilidad

- Tras devolución de recurso reservado → alerta automática.

5.Reportes

### Generar Reportes Asíncronos

- Opción 12 → muestra progreso y resultados de tres reportes.

6.Alertas

### Alertas de Vencimiento

- Se ejecutan cada 10 s.  
- Muestran prefijo `[INFO]`, `[WARNING]`, `[ERROR]`.

### Historial de Alertas

- Opción 14 muestra todas las alertas registradas.


## Ejemplos de flujo

### Flujo de Préstamo

1 → crear usuario U1
2 → agregar libro L1
3 → prestar L1 a U1  → OK
7 → listar recursos  → L1 prestado
4 → devolver L1      → OK y procesa reservas
7 → listar recursos  → L1 disponible

### Sistema de Reservas

1 → crear usuarios U2, U3
2 → agregar libro L2
5 → reservar L2 por U2
5 → reservar L2 por U3
4 → devolver L2 → alerta a U2
4 → devolver L2 → alerta a U3

### Alertas y Renovación

Prestar L3 a U1
Esperar 10 s → alerta [WARNING] o [ERROR]
14 → ver historial → alerta registrada

## Simuladores de situaciones

En la carpeta simuladores se encuentra una serie de clases que simulan diversas situaciones para observar el flujo del codigo.

Las situaciones simuladas son:

- 1: SimuladorConcurrente muestra que pasa si dos hilos intentan realizar un prestamo al mismo tiempo.
- 2: SimuladorDisponibilidad muestra como funciona la alerta de disponibilidad.
- 3: SimuladorPrestamoFallido muestra que aparece cuando se intenta prestar un recurso no disponible.
- 4: SimuladorReportes muestra la generacion de recursos.
- 5: SimuladorVencimiento muestra como funciona la alerta de vencimiento y la posibilidad de renovacion.