# 📄 Curriculum Vitae - API REST & Web App

Proyecto web interactivo y API REST para la gestión y consulta del Curriculum Vitae profesional de **Valeria Pérez Loya**, desarrollado con **Spring Boot**, **PostgreSQL** y desplegado en la plataforma **Render**.

---

## 👤 Información General

* **Nombre:** Valeria Pérez Loya
* **Perfil:** Técnico en Programación | Estudiante de Tecnologías de la Información
* **GitHub:** [Valeria-Perez-d6](https://github.com/Valeria-Perez-d6)
* **Correo:** vp120052006@gmail.com
* **Ubicación:** Chihuahua, Chih.

🎓 Educación
Universidad Tecnológica de Chihuahua (UTCH) (2024 - Actualidad)
Tecnologías de la Información
Centro de Bachillerato Tecnológico Industrial y Servicios No. 122 (CBTis 122) (2021 - 2024)
Técnico en Programación

🛠️ Habilidades Técnicas
* Lenguajes y Frameworks: Python, HTML5, CSS3, JavaScript, React, React Native, Java, Spring Boot.
* Bases de Datos: MySQL, PostgreSQL.
* Herramientas de Diseño: Figma (Prototipado UI/UX).
* Idiomas: Inglés B1 (Intermedio).

---

## 🚀 Tecnologías Utilizadas

* **Backend:** Java, Spring Boot (Spring Web, Spring Data JPA)
* **Frontend:** HTML5, CSS3, JavaScript (Fetch API)
* **Base de Datos:** PostgreSQL / MySQL
* **Despliegue:** Render

---

## 🔗 Enlaces del Proyecto

* **Interfaz Web (Frontend):** https://curriculum-java-uoy0.onrender.com/
* **API REST (Endpoints):** https://curriculum-java-uoy0.onrender.com/api

---

## 📌 Endpoints de la API

| Método | Ruta | Descripción |
| :--- | :--- | :--- |
| `GET` | `/api` | Obtiene la información completa del CV |
| `GET` | `/api?buscar=Valeria` | Consulta de la API con parámetro de filtro |
| `POST` | `/api` | Registra/crea una nueva entrada de información |
| `PUT` | `/api` | Actualiza la información existente del CV |
| `DELETE` | `/api` | Elimina la información del CV |

---

## 📡 Instrucciones para Consumir la API

La API REST responde y acepta datos en formato **JSON**. La URL base para realizar peticiones es:
`https://curriculum-java-uoy0.onrender.com/api`

### 1. Obtener la información del CV (`GET`)

#### Desde JavaScript (Fetch API):
```javascript
fetch('[https://curriculum-java-uoy0.onrender.com/api](https://curriculum-java-uoy0.onrender.com/api)')
  .then(response => response.json())
  .then(data => console.log(data))
  .catch(error => console.error('Error:', error));

#### Desde la terminal
curl -X GET [https://curriculum-java-uoy0.onrender.com/api](https://curriculum-java-uoy0.onrender.com/api)

--------

#### Desde Postman
1. Selecciona el método GET.
2. Ingresa la URL: https://curriculum-java-uoy0.onrender.com/api
3. Haz clic en Send.

--------

#### Registrar o crear informacion (Desde JavaScript en Fetch API)

fetch('[https://curriculum-java-uoy0.onrender.com/api](https://curriculum-java-uoy0.onrender.com/api)', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json'
  },
  body: JSON.stringify({
    nombre: "Valeria Pérez Loya",
    puesto: "Desarrolladora Full Stack",
    correo: "vp120052006@gmail.com",
    perfil: "Estudiante de TI con experiencia en desarrollo web y Java."
  })
})
  .then(response => response.json())
  .then(data => console.log('Guardado:', data));


#### Desde la terminal

curl -X POST [https://curriculum-java-uoy0.onrender.com/api](https://curriculum-java-uoy0.onrender.com/api) \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Valeria Pérez Loya",
    "puesto": "Desarrolladora Full Stack",
    "correo": "vp120052006@gmail.com"
  }'

----------

#### Actualizar informacion (PUT) Desde JavaScript en Fetch API

fetch('[https://curriculum-java-uoy0.onrender.com/api](https://curriculum-java-uoy0.onrender.com/api)', {
  method: 'PUT',
  headers: {
    'Content-Type': 'application/json'
  },
  body: JSON.stringify({
    nombre: "Valeria Pérez Loya",
    puesto: "Ingeniera de Software"
  })
})
  .then(response => response.json())
  .then(data => console.log('Actualizado:', data));

#### Desde la terminal

curl -X PUT [https://curriculum-java-uoy0.onrender.com/api](https://curriculum-java-uoy0.onrender.com/api) \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Valeria Pérez Loya",
    "puesto": "Ingeniera de Software"
  }'

--------

#### Eliminar Informacion (DELETE) Deste JavaScript (Fetch API)

fetch('[https://curriculum-java-uoy0.onrender.com/api](https://curriculum-java-uoy0.onrender.com/api)', {
  method: 'DELETE'
})
  .then(response => console.log('Registro eliminado'))
  .catch(error => console.error('Error:', error));

#### Desde la terminal 

curl -X DELETE [https://curriculum-java-uoy0.onrender.com/api](https://curriculum-java-uoy0.onrender.com/api)

--------

#### Ejecucion local

Para clonar el repositorio: git clone [https://github.com/Valeria-Perez-d6/curriculum-java.git](https://github.com/Valeria-Perez-d6/curriculum-java.git)
cd curriculum-java

#### Ejecutar la aplicación: ./mvnw spring-boot:run
