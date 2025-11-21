🏢 API DE GESTIÓN DE FRANQUICIAS (Prueba Tecnica Backend)

📋 DESCRIPCIÓN
API REST completa para la gestión integral de franquicias, sucursales y productos. 
Permite crear franquicias, agregar sucursales, gestionar productos y generar reportes 
de stock en tiempo real.

🚀 TECNOLOGÍAS UTILIZADAS

🔧 BACKEND
• ☕ Java 17 - Lenguaje de programación
• 🌱 Spring Boot 3.5.8 - Framework principal
• 🗄️ Spring Data JPA - Persistencia de datos
• ✅ Spring Validation - Validación de datos
• 🌐 Spring Web - API REST

🗃️ BASE DE DATOS
• 🐬 MySQL - Base de datos relacional
• 💾 H2 Database - Base de datos en memoria para desarrollo

📚 DOCUMENTACIÓN
• 📖 SpringDoc OpenAPI 3 - Documentación automática de API
• 🎨 Swagger UI - Interfaz gráfica para testing

☁️ INFRAESTRUCTURA
• 🖥️ VPS Personal de José Pino - Mi servidor virtual para despliegue
• 🌩️ Base de datos MySQL alojada en la nube
• 📦 Maven - Gestión de dependencias y build

🐳 Contenerización

- **Docker** - Contenerización de la aplicación
- **Docker Compose** - Orquestación de servicios

EJECUTAR CON DOCKER:
docker run -p 8080:8080 api-franquicias


📊 ESTRUCTURA DE LA API

🏢 ENTIDADES PRINCIPALES
• Franquicias - Empresas principales
• Sucursales - Locales de cada franquicia
• Productos - Artículos ofrecidos en sucursales

🔗 ENDPOINTS DISPONIBLES

🏢 FRANQUICIAS
GET    /api/franquicias                 📋 Listar todas las franquicias
POST   /api/franquicias                 ➕ Crear nueva franquicia
PATCH  /api/franquicias/{id}/nombre     ✏️ Actualizar nombre de franquicia
POST   /api/franquicias/{id}/sucursales 🏪 Agregar sucursal a franquicia
GET    /api/franquicias/{id}/mstock     📊 Productos con máximo stock por sucursal

🏪 SUCURSALES
POST   /api/sucursales/{id}/productos   📦 Agregar producto a sucursal
DELETE /api/sucursales/{sucursalId}/productos/{productoId} 🗑️ Eliminar producto

📦 PRODUCTOS
PUT    /api/productos/{id}/stock        📈 Actualizar stock de producto

🛠 CARACTERÍSTICAS TÉCNICAS

✅ VALIDACIONES
• Validación automática con @Valid
• Manejo centralizado de excepciones
• Respuestas de error estandarizadas

📚 DOCUMENTACIÓN
• Documentación automática con Swagger
• Disponible en: http://localhost:8080/swagger-ui.html
• Especificación OpenAPI: http://localhost:8080/v3/api-docs

🏗️ PATRONES DE DISEÑO
• Arquitectura en capas (Controller-Service-Repository)
• Patrón Mapper para conversión DTO-Entity
• Inyección de dependencias

🚀 INSTALACIÓN Y EJECUCIÓN

📋 PRERREQUISITOS
• Java 17
• Maven 3.6+
• MySQL 8.0+

🛠️ PASOS PARA EJECUTAR
1. Clonar el repositorio
2. Configurar base de datos en application.properties
3. Ejecutar: mvn spring-boot:run
4. Acceder a: http://localhost:8080

☁️ CONFIGURACIÓN VPS
• VPS Personal de José Pino utilizado para hosting
• Base de datos MySQL alojada en la nube
• Configuración segura y escalable

📝 EJEMPLOS DE USO

➕ CREAR FRANQUICIA
curl -X POST http://localhost:8080/api/franquicias \
  -H "Content-Type: application/json" \
  -d '{"nombreFanquicia": "Mi Franquicia"}'

🏪 AGREGAR SUCURSAL
curl -X POST http://localhost:8080/api/franquicias/1/sucursales \
  -H "Content-Type: application/json" \
  -d '{"nombreSucursal": "Sucursal Centro"}'

📦 ACTUALIZAR STOCK
curl -X PUT http://localhost:8080/api/productos/1/stock \
  -H "Content-Type: application/json" \
  -d '{"stock": 150}'

🔮 FUTURAS MEJORAS
• Autenticación y autorización
• Paginación en endpoints de listado
• Cache de consultas frecuentes
• Métricas y monitoreo

👨‍💻 DESARROLLADO POR
José Pino
Desarrollador Backend - Spring Boot Specialist

💡 NOTA: Esta API está diseñada con las mejores prácticas de desarrollo REST 
y preparada para entornos de producción.