# Ecommerce-Microservice

El proyecto "Ecommerce-Microservice" es un sistema de comercio electrónico basado en microservicios que ofrece una arquitectura distribuida y modularizada para facilitar el desarrollo, despliegue y mantenimiento de aplicaciones de comercio electrónico.

## Características

- Arquitectura basada en microservicios: La aplicación está dividida en varios microservicios independientes, cada uno responsable de una funcionalidad específica del sistema.
- Escalabilidad: Los microservicios pueden ser escalados individualmente según sea necesario para manejar diferentes cargas de trabajo.
- Modularidad: Cada microservicio se centra en una tarea específica, lo que facilita la modificación, actualización o reemplazo de componentes individuales sin afectar al resto del sistema.
- Independencia tecnológica: Los microservicios pueden estar implementados con diferentes tecnologías según los requisitos específicos de cada componente.
- Integración continua y entrega continua (CI/CD): El proyecto incluye pipelines de CI/CD para automatizar las pruebas, la integración y el despliegue de los microservicios en diferentes entornos.

## Componentes

El proyecto está compuesto por los siguientes microservicios:

1. **Autenticación**: Gestiona la autenticación y autorización de usuarios.
2. **Catálogo de productos**: Proporciona funciones para la gestión de productos, como la creación, edición y eliminación de productos.
3. **Carrito de compras**: Permite a los usuarios agregar y eliminar productos de su carrito de compras.
4. **Gestión de pedidos**: Gestiona la creación, actualización y seguimiento de pedidos realizados por los usuarios.
5. **Gestión de usuarios**: Administra la información de los usuarios, como su perfil, dirección de envío, historial de pedidos, etc.

## Requisitos previos

- Java JDK 17
- Maven
- Docker y Docker Compose

## Instalación y configuración

1. Clona el repositorio de GitHub:
 *git clone https://github.com/tu-usuario/ecommerce-microservice.git


2. Accede al directorio del proyecto:
   *cd ecommerce-microservice

3. Construye y empaqueta los microservicios:
    *mvn clean package

4. Inicia los servicios utilizando Docker Compose:
    *docker-compose up

5. Accede a la aplicación desde tu navegador web:
   http://localhost:8080


## Contribuciones

¡Las contribuciones son bienvenidas! Si deseas contribuir al proyecto, sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama para tu contribución.
3. Realiza los cambios necesarios y realiza un commit con un mensaje descriptivo.
4. Envía un pull request para que tus cambios sean revisados.

## Licencia

Este proyecto está bajo la [Licencia MIT](LICENSE).

