# CHECKLIST FINAL DE ENTREGA – Evaluación Parcial N°2 (DSY1106)

## 1) Backend y calidad técnica
- [x] Proyecto Maven multi-módulo funcional.
- [x] `mvn clean verify` en verde (BUILD SUCCESS).
- [x] Cobertura JaCoCo unificada generada.
- [x] Reporte agregado disponible en:
  - `report-aggregate/target/site/jacoco-aggregate/index.html`
- [x] Limpieza previa de entrega ejecutada:
  - `mvn clean`

---

## 2) Documentación obligatoria (PDF)
> Sugerencia: convertir los `.md` de `docs/` a PDF antes de comprimir.

- [x] Documento: **Análisis de Patrones y Arquetipos**
  - Fuente: `docs/analisis-patrones-arquetipos.md`
  - PDF esperado: `docs/analisis-patrones-arquetipos.pdf`
- [x] Documento: **Plan de Branching**
  - Fuente: `docs/plan-branching.md`
  - PDF esperado: `docs/plan-branching.pdf`

---

## 3) Frontend (validar según rúbrica)
- [ ] Incluir carpeta frontend en la entrega.
- [ ] Verificar presencia de `frontend/package.json`.
- [ ] Incluir `frontend/README.md` con:
  - [ ] requisitos
  - [ ] instalación (`npm install`)
  - [ ] ejecución (`npm run ...`)
  - [ ] pruebas/uso básico

---

## 4) Arquetipos Maven
- [ ] Incluir código/fuente de arquetipos usados (si aplica por pauta docente).
- [ ] Incluir guía rápida de uso del arquetipo (`README.md`) en su carpeta.

---

## 5) Enlaces de repositorio
- [x] Archivo de enlaces creado: `repositorios.txt`
- [ ] Reemplazar placeholders por URLs reales de GitHub.
- [ ] Verificar accesibilidad (público o permisos al docente).

---

## 6) Evidencias para informe/defensa
- [x] Guardar captura principal de cobertura unificada (ej: `image_b4b2dd.png`).
- [ ] Adjuntar capturas de:
  - [ ] BUILD SUCCESS del reactor
  - [ ] cobertura total (Instructions / Branches)
  - [ ] historial o PRs de branching/merges

---

## 7) Empaquetado final
- [ ] Confirmar que NO existan carpetas `target/` (tras `mvn clean`).
- [ ] Confirmar inclusión de documentos PDF requeridos.
- [ ] Comprimir como `.zip` o `.rar` con nombre solicitado por el docente.
- [ ] Verificar apertura del comprimido en otro equipo antes de subir.

---

## Comandos de apoyo
```bash
mvn clean verify
mvn clean
```

Abrir reporte unificado:
```bat
start report-aggregate\target\site\jacoco-aggregate\index.html
