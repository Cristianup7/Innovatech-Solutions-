# TODO - PaymentChain (Evaluación 2)

## Objetivo
Cumplir con el enunciado:
- Frontend empaquetado NPM (React/Angular/Vue)
- Backend: BFF + 2 microservicios (Projects y RRHH) como módulos Maven
- Persistencia con JPA en los 2 microservicios
- Versionamiento GitHub con ramas y evidencia de merges/resolución de conflictos
- Al menos 3 patrones de diseño + unit tests

## Plan de implementación (paso a paso)

1. [ ] Crear módulos Maven nuevos en el monorepo:
   - [ ] `bff/`
   - [ ] `projects-service/`
   - [ ] `hr-service/`
2. [ ] Actualizar `paymentchainparent/pom.xml` para incluir los 3 nuevos módulos.
3. [ ] Implementar BFF:
   - [ ] Controller `DashboardController`
   - [ ] Client WebClient hacia `projects-service` y `hr-service`
   - [ ] Patron: Facade (BFF agrega datos)
   - [ ] Unit tests para service/client (Mockito)
4. [ ] Implementar `projects-service` con JPA:
   - [ ] Entidad `Project`
   - [ ] `ProjectRepository` (JpaRepository)
   - [ ] `ProjectService`
   - [ ] Controller REST
   - [ ] Patron: Strategy (reglas/validación del proyecto)
   - [ ] Unit tests (Mockito)
5. [ ] Implementar `hr-service` con JPA:
   - [ ] Entidad `Employee` (o `HumanResource`)
   - [ ] `HrRepository` (JpaRepository)
   - [ ] `HrService`
   - [ ] Controller REST
   - [ ] Patron: Adapter (mapeo DTO↔Entidad / adaptación para BFF)
   - [ ] Unit tests (Mockito)
6. [ ] Backend configuración:
   - [ ] `application.properties` por módulo (puerto, nombre app, eureka, h2 config)
   - [ ] dependencias Maven necesarias
7. [ ] Frontend NPM:
   - [ ] Crear módulo `frontend/` con React
   - [ ] `package.json` estándar NPM
   - [ ] componente que consuma `/api/dashboard` del BFF
   - [ ] Unit test básico (Jest/Vitest)
8. [ ] Ajustes (opcional): rutas/apigateway si corresponde.
9. [ ] Ejecutar tests y build:
   - [ ] `mvn test` (root y módulos)
   - [ ] `npm test` + `npm run build` (frontend)
10. [ ] Preparar GitHub evidence:
   - [ ] Crear ramas por feature
   - [ ] Abrir PRs
   - [ ] Verificar que los merges queden evidenciados

## Registro
- Creado: 2026-06-04

