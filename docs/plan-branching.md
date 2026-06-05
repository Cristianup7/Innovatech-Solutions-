# Plan de Branching y Gestión de Cambios (Git)  
**Evaluación Parcial N°2 – DSY1106 Desarrollo Fullstack III**

## 1. Objetivo
Definir la estrategia de branching utilizada para organizar el trabajo del equipo, controlar integraciones y resolver conflictos de forma segura y trazable.

---

## 2. Estrategia adoptada
Se propone una estrategia inspirada en **GitFlow simplificado**, con foco académico/práctico.

## 2.1 Ramas principales
- **main**
  - Rama estable.
  - Contiene solo versiones validadas para entrega.
- **develop**
  - Rama de integración continua del equipo.
  - Recibe features ya revisadas.

## 2.2 Ramas de trabajo
- **feature/\***  
  Ejemplo: `feature/customer-tests-fix`, `feature/jacoco-aggregate`.
  - Implementación de funcionalidades o mejoras puntuales.
- **hotfix/\***  
  Ejemplo: `hotfix/customer-delete-test`.
  - Correcciones urgentes de defectos críticos detectados en validación.

---

## 3. Flujo de trabajo recomendado

1. Crear rama desde `develop`:
   - `git checkout develop`
   - `git pull`
   - `git checkout -b feature/nombre-cambio`

2. Implementar cambios atómicos y realizar commits con mensajes claros:
   - `git add .`
   - `git commit -m "fix(customer): estabiliza test delete_shouldReturnOk"`

3. Sincronizar con remoto y abrir Pull Request hacia `develop`.

4. Revisar cambios (code review), resolver observaciones y aprobar merge.

5. Una vez validado el sprint/entrega:
   - merge de `develop` a `main`
   - tag de versión académica (opcional): `v1.0-eval2`

---

## 4. Gestión de conflictos

## 4.1 Causas típicas observadas
- Cambios concurrentes en `pom.xml` raíz.
- Edición paralela de tests y controladores en `customer`.
- Ajustes de plugins/versiones en varios módulos.

## 4.2 Procedimiento aplicado
1. Actualizar rama local contra `develop`.
2. Resolver conflictos manualmente priorizando:
   - consistencia de dependencias,
   - compilación del reactor,
   - estabilidad de tests.
3. Validar con:
   - `mvn clean verify`
4. Confirmar merge solo si el build está en verde.

---

## 5. Evidencias esperadas de merge
Para la entrega se recomienda adjuntar capturas de:
- Historial de ramas en GitHub/Git Graph.
- Pull Requests cerrados con revisión.
- Commits de resolución de conflictos.
- Último commit/tag en `main` previo al empaquetado.

---

## 6. Convenciones de commits sugeridas
Formato recomendado:
- `feat(scope): descripción`
- `fix(scope): descripción`
- `test(scope): descripción`
- `docs(scope): descripción`
- `chore(scope): descripción`

Ejemplos:
- `fix(customer): agrega spring-boot-starter-test en pom`
- `test(customer): corrige delete_shouldReturnOk`
- `build(parent): integra modulo report-aggregate`

---

## 7. Beneficios de esta estrategia
- Reduce riesgos al integrar cambios.
- Mejora trazabilidad de decisiones técnicas.
- Facilita defensa oral (explicar quién cambió qué, cuándo y por qué).
- Asegura una rama final (`main`) limpia y estable para evaluación.

---

## 8. Conclusión
La estrategia de branching basada en `main` + `develop` + ramas `feature/hotfix` permite una gestión ordenada del proyecto fullstack, facilita resolución de conflictos y respalda la calidad técnica exigida por la rúbrica.
