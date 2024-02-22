<h1>Backend de Administración de Jugadores con Spring Boot y Java 21</h1>

<p>Este proyecto backend implementa un sistema de administración de jugadores utilizando Spring Boot y Java 21. A continuación, se detallan las características principales, las bibliotecas utilizadas y las buenas prácticas de programación implementadas.</p>

<h2>Características Principales</h2>
<ul>
    <li><strong>Gestión de Jugadores:</strong> El backend proporciona operaciones CRUD (Crear, Leer, Actualizar, Eliminar) para administrar jugadores.</li>
    <li><strong>Validación de Datos:</strong> Se utilizan anotaciones de validación de Spring Boot para garantizar la integridad de los datos de entrada.</li>
    <li><strong>Persistencia de Datos:</strong> Se emplea Spring Data JPA y MySQL para almacenar y recuperar datos relacionados con los jugadores.</li>
    <li><strong>Documentación API:</strong> Se utiliza Springdoc OpenAPI para generar documentación automática de la API.</li>
    <li><strong>Mapeo de Objetos:</strong> MapStruct se utiliza para mapear entre DTOs y entidades de jugador.</li>
    <li><strong>Pruebas Unitarias:</strong> Se implementan pruebas unitarias con Mockito y JUnit 5 para garantizar la robustez del código.</li>
    <li><strong>Contenedor de Imágenes:</strong> Se utiliza Paketo Buildpacks para construir imágenes de contenedor.</li>
    <li><strong>Control de Versiones:</strong> Se utilizó GitHub y GitFlow para el control de versiones y el flujo de trabajo.</li>
    <li><strong>CI/CD:</strong> Se implementó CI/CD con GitHub Actions y SonarCloud para garantizar la calidad del código.</li>
</ul>

<h2>Librerías Utilizadas</h2>
<ul>
    <li><strong>Spring Boot:</strong> Marco de desarrollo para la creación de aplicaciones basadas en Spring.</li>
    <li><strong>Spring Data JPA:</strong> Acceso a datos utilizando el estándar de JPA.</li>
    <li><strong>Springdoc OpenAPI:</strong> Generación automática de documentación OpenAPI.</li>
    <li><strong>MapStruct:</strong> Biblioteca de mapeo de objetos Java.</li>
    <li><strong>MySQL Connector:</strong> Controlador JDBC para MySQL.</li>
    <li><strong>Mockito:</strong> Marco de prueba para realizar pruebas unitarias con mocks.</li>
    <li><strong>JUnit 5:</strong> Marco de prueba para escribir y ejecutar pruebas unitarias en Java.</li>
</ul>

<h2>Buenas Prácticas de Programación</h2>
<ul>
    <li><strong>Manejo de Excepciones:</strong> Se implementa un manejo adecuado de excepciones y errores para mejorar la robustez del sistema.</li>
    <li><strong>Validación de Datos:</strong> Se aplican anotaciones de validación para garantizar la calidad de los datos recibidos.</li>
    <li><strong>Inyección de Dependencias:</strong> Se utiliza la inyección de dependencias de Spring para lograr un código más modular y fácilmente testeable.</li>
    <li><strong>Uso de DTOs:</strong> Se emplean objetos de transferencia de datos (DTOs) para separar las capas de presentación y persistencia.</li>
    <li><strong>Logging:</strong> Se implementa un registro adecuado utilizando SLF4J para facilitar el diagnóstico de problemas.</li>
</ul>

<h2>Configuración del Proyecto</h2>
<p>Este proyecto utiliza el plugin Lombok para reducir la verbosidad del código. Asegúrate de que tu entorno de desarrollo lo admita.</p>

<h2>Dependencias del Proyecto</h2>
<ul>
    <li><strong>Spring Boot 3.1.5</strong></li>
    <li><strong>Lombok 8.4</strong></li>
    <li><strong>Spring Boot Starter Validation</strong></li>
    <li><strong>Spring Boot Starter Web</strong></li>
    <li><strong>Spring Boot Starter Data JPA</strong></li>
    <li><strong>MySQL Connector</strong></li>
    <li><strong>MapStruct 1.5.5.Final</strong></li>
    <li><strong>Springdoc OpenAPI Starter Webmvc UI 2.3.0</strong></li>
    <li><strong>Mockito Core 3.12.4</strong></li>
</ul>

<h2>Instrucciones de Ejecución</h2>
<ol>
    <li>Clona el repositorio.</li>
    <li>Configura tu base de datos MySQL y actualiza la configuración en application.properties.</li>
    <li>Ejecuta la aplicación usando tu IDE o mediante el comando <code>./gradlew bootRun</code>.</li>
    <li>Accede a la documentación de la API generada automáticamente en <a href="http://localhost:8080/swagger-ui.html">http://localhost:8080/swagger-ui.html</a>.</li>
</ol>
    

