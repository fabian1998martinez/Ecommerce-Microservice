Ecommerce-Microservice
El proyecto "Ecommerce-Microservice" es un sistema de comercio electrónico basado en microservicios que ofrece una arquitectura distribuida y modularizada para facilitar el desarrollo, despliegue y mantenimiento de aplicaciones de comercio electrónico.

Características
Arquitectura basada en microservicios: La aplicación está dividida en varios microservicios independientes, cada uno responsable de una funcionalidad específica del sistema.
Escalabilidad: Los microservicios pueden ser escalados individualmente según sea necesario para manejar diferentes cargas de trabajo.
Modularidad: Cada microservicio se centra en una tarea específica, lo que facilita la modificación, actualización o reemplazo de componentes individuales sin afectar al resto del sistema.
Independencia tecnológica: Los microservicios pueden estar implementados con diferentes tecnologías según los requisitos específicos de cada componente.
Integración continua y entrega continua (CI/CD): El proyecto incluye pipelines de CI/CD para automatizar las pruebas, la integración y el despliegue de los microservicios en diferentes entornos.
Componentes
El proyecto está compuesto por los siguientes microservicios:

Autenticación: Gestiona la autenticación y autorización de usuarios.
Catálogo de productos: Proporciona funciones para la gestión de productos, como la creación, edición y eliminación de productos.
Carrito de compras: Permite a los usuarios agregar y eliminar productos de su carrito de compras.
Gestión de pedidos: Gestiona la creación, actualización y seguimiento de pedidos realizados por los usuarios.
Gestión de usuarios: Administra la información de los usuarios, como su perfil, dirección de envío, historial de pedidos, etc.
Requisitos previos
Java JDK 11
Maven
Docker y Docker Compose
Instalación y configuración
Clona el repositorio de GitHub:
bash
Copy code
git clone https://github.com/tu-usuario/ecommerce-microservice.git
Accede al directorio del proyecto:
bash
Copy code
cd ecommerce-microservice
Construye y empaqueta los microservicios:
go
Copy code
mvn clean package
Inicia los servicios utilizando Docker Compose:
Copy code
docker-compose up
Accede a la aplicación desde tu navegador web:
arduino
Copy code
http://localhost:8080
Contribuciones
¡Las contribuciones son bienvenidas! Si deseas contribuir al proyecto, sigue estos pasos:

Haz un fork del repositorio.
Crea una nueva rama para tu contribución.
Realiza los cambios necesarios y realiza un commit con un mensaje descriptivo.
Envía un pull request para que tus cambios sean revisados.
