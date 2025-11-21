# pruebadevbackend

# API de Gestión de Franquicias
📋 Descripción del Proyecto
API REST para la gestión completa de franquicias, sucursales y productos. Permite crear franquicias, agregar sucursales, gestionar productos y generar reportes de stock.

🚀 Tecnologías Utilizadas
Backend
Java 17 - Lenguaje de programación

Spring Boot 3.5.8 - Framework principal

Spring Data JPA - Persistencia de datos

Spring Validation - Validación de datos

Spring Web - API REST

Base de Datos
MySQL - Base de datos relacional


Documentación
SpringDoc OpenAPI 3 - Documentación automática de API

Swagger UI - Interfaz gráfica para testing

Infraestructura
VPS - Servidor virtual para despliegue

Maven - Gestión de dependencias y build

📊 Estructura de la API
Entidades Principales
Franquicias - Empresas principales

Sucursales - Locales de cada franquicia

Productos - Artículos ofrecidos en sucursales

🔗 Endpoints Disponibles
Franquicias
GET /api/franquicias - Listar todas las franquicias

POST /api/franquicias - Crear nueva franquicia

PATCH /api/franquicias/{id}/nombre - Actualizar nombre de franquicia

POST /api/franquicias/{id}/sucursales - Agregar sucursal a franquicia

GET /api/franquicias/{id}/mstock - Productos con máximo stock por sucursal

Sucursales
POST /api/sucursales/{id}/productos - Agregar producto a sucursal

DELETE /api/sucursales/{sucursalId}/productos/{productoId} - Eliminar producto de sucursal

Productos
PUT /api/productos/{id}/stock - Actualizar stock de producto

🛠 Características Técnicas
Validaciones
Validación automática con @Valid

Documentación
Documentación automática con Swagger

Disponible en: http://localhost:8080/swagger-ui.html

Especificación OpenAPI: http://localhost:8080/v3/api-docs

Patrones de Diseño
Arquitectura en capas (Controller-Service-Repository)

Patrón Mapper para conversión DTO-Entity

Inyección de dependencias

🚀 Instalación y Ejecución
Prerrequisitos
Java 17

Maven 3.6+

MySQL 8.0+

Pasos para ejecutar
Clonar el repositorio

Configurar base de datos en application.properties

Ejecutar: mvn spring-boot:run

Acceder a: http://localhost:8080

