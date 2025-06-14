# 💸 Gestor de Gastos

Aplicación web desarrollada con **Spring Boot**, **MySQL** y **JWT**, diseñada para llevar un control de gastos personales con categorías, usuarios autenticados y futuras funcionalidades estadísticas.

## 🧱 Tecnologías usadas

- Java 17
- Spring Boot
- Spring Security + JWT
- JPA/Hibernate
- MySQL
- Lombok
- Postman (para pruebas)

## 📦 Estructura del proyecto

```
com.juanjojmnz.gestorgastos
├── controller       // Controladores REST (expuestos al cliente)
├── service          // Interfaces de servicios (lógica de negocio)
│   └── impl         // Implementaciones concretas de los servicios
├── repository       // Interfaces que extienden JpaRepository
├── entity           // Entidades JPA (@Entity)
├── dto              // Objetos de transferencia de datos (Data Transfer Objects)
├── security         // Seguridad: JWT, filtros, configuración de Spring Security
├── mapper           // Conversores entre entidades y DTOs
└── config           // Configuraciones generales (CORS, beans, etc.)
```

## ✅ Funcionalidades

### 🔐 Autenticación con JWT

- Registro de usuario: `POST /auth/register`
- Login: `POST /auth/login` → Devuelve token JWT
- Protección de rutas con filtro `JwtFilter`

### 📄 Gestión de gastos

- Crear, listar, actualizar y eliminar gastos
- Cada gasto tiene:
  - Descripción
  - Monto
  - Fecha
  - Categoría (relación ManyToOne)

### 🗂 Gestión de categorías

- CRUD de categorías:
  - `GET /categorias`
  - `POST /categorias`
  - `PUT /categorias/{id}`
  - `DELETE /categorias/{id}`

### 🔍 Filtros y consultas

- Filtrar gastos por categoría: `GET /gastos/categoria/{idCategoria}`

### 📊 Estadísticas (🛠 en desarrollo)

- Resumen mensual
- Gastos por categoría
- Datos listos para gráficos (pie/bar)

## 🔧 Configuración

### 1. Base de datos MySQL

Crea una base de datos llamada `gestorgastos` y actualiza tu archivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gestorgastos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```

Configura los campos necesarios en el archivo application-local.properties

```properties
# Database
spring.datasource.url=jdbc:mysql://localhost:3306/nombre_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

# JWT
jwt.secret=tu_jwt_secret_key
jwt.expiration=86400000
```

### 2. Ejecutar

```bash
./mvnw spring-boot:run
```

### 3. Probar con Postman

- Realiza login (`/auth/login`)
- Copia el token JWT
- Añade el token a cada petición protegida:
  - Header: `Authorization: Bearer TU_TOKEN`

## 🛣️ Roadmap

- [ ] Enviar avisos por correo (Spring Mail)
- [ ] Exportar gastos a PDF o Excel
- [ ] Filtrado avanzado y búsqueda
- [ ] Interfaz gráfica
- [ ] API REST para consumo desde móvil

## 🙋 Autor

Proyecto desarrollado por [Juan José Jiménez Gil](https://github.com/JuanjoJmnz), 2025

## 📄 Licencia

Este proyecto está licenciado bajo los términos de la licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.

## Para más

¡Si te ha gustado mi proyecto, dame una estrella o sígueme por GitHub!
