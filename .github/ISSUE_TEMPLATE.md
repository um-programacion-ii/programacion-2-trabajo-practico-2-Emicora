
**Título**  
<!-- Breve y conciso -->  
Implementar sistema de préstamos concurrente

---

**Descripción**  
<!-- Explica en detalle qué hay que hacer y por qué es importante -->  
Crear el sistema de préstamos que utilice hilos y el patrón productor-consumidor para procesar solicitudes de préstamo en tiempo real.

---

**Requisitos**  
<!-- Lista las funcionalidades o pasos necesarios -->  
- [ ] Implementar `BlockingQueue` para solicitudes de préstamo  
- [ ] Crear procesador de solicitudes usando `ExecutorService`  
- [ ] Implementar sistema de notificaciones  
- [ ] Asegurar thread‑safety en operaciones de préstamo  

---

**Criterios de Aceptación**  
<!-- Define cómo saber que esto está hecho correctamente -->  
- [ ] El sistema procesa préstamos concurrentemente sin bloqueos  
- [ ] Manejo adecuado de excepciones en caso de fallo  
- [ ] Documentación de diseño incluida y actualizada  

---

**Labels**  
<!-- Ajusta según corresponda -->  
- enhancement  
- concurrency  

