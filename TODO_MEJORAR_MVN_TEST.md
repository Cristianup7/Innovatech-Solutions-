# Mejora para que `mvn test` funcione más limpio (Eureka + Jakarta Validation)

## Problema observado
- Los tests cargan Spring Boot, pero durante la inicialización aparecen fallos de conexión a **Eureka**:
  - `Connection refused: http://localhost:8761/eureka/...`
- En algunos logs aparece:
  - `jakarta.validation.NoProviderFoundException` (falta proveedor tipo Hibernate Validator)

## Plan mínimo (recomendado)
1) Desactivar Eureka durante tests (o evitar que los clientes intenten registrarse/fetch-registry en tests)
   - Opción A: usar un `application-test.properties` (Spring profiles) con:
     - `eureka.client.register-with-eureka=false`
     - `eureka.client.fetch-registry=false`
   - Opción B: en tests setear propiedades con `@TestPropertySource(properties = ...)`.
2) Asegurar proveedor Jakarta Validation
   - Agregar dependencia `org.hibernate.validator:hibernate-validator` o incluir `spring-boot-starter-validation`.

## Evidencia
- `infraestructuredomain/eurekaServer/src/main/resources/application.properties` ya tiene `eureka.client.register-with-eureka=false`.
- Pero en módulos clientes:
  - `businessdomain/customer/src/main/resources/application.properties` define `eureka.client.register-with-eureka=true` y `fetch-registry=true`.
- Esto provoca que durante `mvn test` intenten conectar a Eureka aunque el servidor no está levantado.

## Próximos pasos
- Insertar configuración para tests en cada módulo que tenga `@SpringBootTest`.
- Re-ejecutar `mvn test` desde el root y verificar que los logs de Eureka/Validation desaparecen o al menos no rompen el test.

