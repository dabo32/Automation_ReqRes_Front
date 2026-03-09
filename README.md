# SauceDemo Automation Project - Screenplay BDD

Este proyecto contiene la automatización de flujos críticos del sitio web [SauceDemo](https://www.saucedemo.com/),
desarrollada como parte del proceso de evaluación técnica para el rol de **Analista de Frontend / Automation Engineer**
en **BDG**.

---

## 🚀 Tecnologías y Patrones

El framework fue construido bajo los estándares de la industria, utilizando un stack robusto para asegurar escalabilidad
y mantenibilidad:

* **Lenguaje:** Java 17+
* **Gestor de Dependencias:** Gradle
* **Framework de Automatización:** Serenity BDD
* **Patrón de Diseño:** Screenplay Pattern (Actores, Tareas, Preguntas, Interacciones)
* **BDD:** Cucumber con Gherkin en inglés
* **Aserciones:** Hamcrest
* **Reportes:** Serenity Report (con capturas de pantalla automáticas)

---

## 📂 Estructura del Proyecto

Siguiendo el arquetipo de **Screenplay**, el código se organiza de la siguiente manera para separar responsabilidades:

```plaintext
src/test/java/com/saucedemo/automation
 ├── tasks           # Lógica de acciones complejas (Login, AddToCart, etc.)
 ├── questions       # Verificaciones y aserciones del estado de la UI
 ├── userinterfaces  # Mapeo de elementos web (Targets/Locators)
 ├── interactions    # Acciones personalizadas de bajo nivel
 ├── runners         # Ejecutores de los escenarios de Cucumber
 └── stepdefinitions # Puentes entre Gherkin y el código Java

src/test/resources
 ├── features        # Escenarios de prueba en Gherkin
 └── serenity.properties # Configuración del framework y credenciales de prueba
```

---

## 📝 Escenarios Automatizados

Se cubrieron satisfactoriamente los 5 casos requeridos por el reto técnico:

* **Successful Login:** Validación de acceso exitoso con credenciales válidas.
* **Failed Login:** Validación de mensajes de error con credenciales inválidas.
* **Add Product:** Proceso de añadir un ítem específico y validación del contador del carrito.
* **Complete Purchase:** Flujo completo de checkout desde el carrito hasta la confirmación.
* **Multiple Products Workflow:** Flujo dinámico que añade 3 productos, elimina uno específico y finaliza la compra.

---

## 🛠️ Ejecución de Pruebas

Para ejecutar todas las pruebas y generar el reporte detallado, utiliza el siguiente comando en la terminal:

```powershell
./gradlew clean test aggregate