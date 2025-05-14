# 🧠 BackendEntrevistasInformes – Evaluación IA de Candidatos

Este proyecto forma parte de Eval-IA, un sistema inteligente para la evaluación automatizada de candidatos mediante entrevistas técnicas y generación de informes con IA.

---

## 🚀 Funcionalidades principales

### 📝 Generación de informes
- El sistema genera automáticamente un **informe de evaluación** por cada entrevista realizada.
- El informe es redactado por IA (GPT) y se guarda directamente en la tabla `usuario`.

### 🧠 Recomendación de candidatos
Dos formas de recomendar candidatos entrevistados, basadas en sus informes previos:

1. **Por filtros estructurados**
   - Se selecciona una **categoría** y un **nivel tecnológico**
   - La IA analiza los informes existentes y devuelve los IDs de los más adecuados

2. **Por pregunta libre**
   - El reclutador escribe un mensaje como:  
     *"Busco perfil backend con experiencia en Java y microservicios"*
   - La IA responde con los usuarios más compatibles

---

## 🛠 Tecnologías

- Java 17
- Spring Boot
- Spring AI (OpenAI GPT)
- JPA/Hibernate
- MySQL
- Lombok
