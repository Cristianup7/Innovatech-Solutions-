# Análisis de Patrones y Arquetipos  
**Evaluación Parcial N°2 – DSY1106 Desarrollo Fullstack III**  

## 1. Objetivo del documento
Este documento justifica los patrones de diseño, decisiones arquitectónicas y uso de arquetipos aplicados en la solución backend Fullstack, con foco en mantenibilidad, eficiencia y escalabilidad.

---

## 2. Contexto de la solución
La solución se construyó sobre una arquitectura de microservicios con Maven multi-módulo, separando dominios de negocio e infraestructura:

- **businessdomain**
  - `customer`
  - `product`
  - `projects-service`
- **infraestructuredomain**
  - `apigateway`
  - `eurekaServer`
  - `keycloakadapter`
  - `springBootAdmin`
- **report-aggregate**
  - módulo dedicado al reporte unificado de cobertura JaCoCo

Esta separación permite que cada componente evolucione con bajo acoplamiento y responsabilidades claras.

---

## 3. Patrones de diseño aplicados

## 3.1 Patrón MVC (Model–View–Controller) en servicios REST
**Dónde se aplica:** módulos `customer`, `product`, `projects-service`.  

**Evidencia técnica:**
- `controller/` contiene controladores REST.
- `entities/` define el modelo de datos.
- `repository/` encapsula acceso a persistencia.

**Beneficio:**
- Separación de responsabilidades.
- Mayor mantenibilidad de endpoints.
- Facilita pruebas unitarias por capa.

---

## 3.2 Patrón Repository
**Dónde se aplica:** repositorios JPA en los microservicios de negocio.

**Evidencia técnica:**
- Interfaces de repositorio en `repository/`.
- Delegación de operaciones CRUD a Spring Data.

**Beneficio:**
- Abstracción de persistencia.
- Menor acoplamiento con proveedor de base de datos.
- Mejora testabilidad y reemplazo de implementación.

---

## 3.3 Patrón Gateway / BFF (Backend for Frontend)
**Dónde se aplica:** `infraestructuredomain/apigateway`.

**Evidencia técnica:**
- Enrutamiento centralizado y filtros.
- Autenticación/pre-filtrado en capa gateway.
- Punto único de entrada para clientes.

**Beneficio:**
- Seguridad centralizada.
- Simplificación del frontend (una puerta de acceso).
- Escalado independiente entre frontend y microservicios internos.

---

## 3.4 Patrón Discovery Server
**Dónde se aplica:** `infraestructuredomain/eurekaServer`.

**Evidencia técnica:**
- Registro de instancias de servicios.
- Descubrimiento dinámico para comunicación interna.

**Beneficio:**
- Elasticidad y tolerancia a cambios de red/despliegue.
- Escalabilidad horizontal con menor configuración manual.

---

## 4. Arquetipos y estructura Maven multi-módulo

## 4.1 Rol de Maven multi-módulo
Se utilizó una estructura padre con submódulos para:
- Construcción unificada.
- Gestión central de versiones/dependencias.
- Estandarización de plugins (compiler, pruebas, cobertura).

**Resultado operacional:** build completo del reactor en verde (`BUILD SUCCESS`) en todos los módulos configurados.

## 4.2 Estandarización de proyectos
Cada microservicio mantiene estructura homogénea:
- `src/main/java` por paquetes (`controller`, `entities`, `repository`, etc.)
- `src/test/java` para pruebas automáticas
- `application.properties` por servicio

Esto actúa como “arquetipo organizacional” para crear nuevos servicios con convención consistente.

---

## 5. Escalabilidad y eficiencia del backend

## 5.1 Escalabilidad
- Separación por microservicios permite escalar componentes de forma independiente.
- Discovery con Eureka evita dependencias rígidas entre hosts/puertos.
- API Gateway favorece control de tráfico y seguridad en un único punto.

## 5.2 Eficiencia de desarrollo y operación
- Maven multi-módulo reduce fricción de integración.
- Cobertura de pruebas unificada permite detectar regresiones temprano.
- Estructura por capas y patrones conocidos acelera mantenimiento del equipo.

---

## 6. Calidad técnica y cobertura (JaCoCo)
Se implementó cobertura unificada con JaCoCo en reporte agregado:
- Reporte consolidado en `report-aggregate/target/site/jacoco-aggregate/index.html`.
- Coberturas destacadas verificadas en módulos clave:
  - `customer`: sobre 80% de instrucciones.
  - `projects-service`: cobertura alta sobre objetivo de rúbrica.

Esto respalda la calidad de pruebas y la confiabilidad del backend.

---

## 7. Conclusión
La solución cumple los criterios de arquitectura backend fullstack al combinar:
- Patrones de diseño (MVC, Repository, Gateway/BFF, Discovery),
- Estructura Maven multi-módulo,
- Cobertura de código unificada.

La combinación mejora mantenibilidad, escalabilidad y capacidad de evolución del sistema, alineándose con los objetivos técnicos de la evaluación.
