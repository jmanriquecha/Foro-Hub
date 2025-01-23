# Foro Hub

Foro Hub es una API Rest construida con Java y Spring Boot, diseñada para gestionar un foro con funcionalidades modernas y robustas. Este proyecto es parte del desafío propuesto en el curso **"Practicando Spring Framework: Challenge Foro Hub"** por Alura Latam y Oracle dentro del programa **ONE (Oracle Next Education)**.

## Características

- **Framework:** Spring Boot (v3.4.1)
- **Gestor de dependencias:** Maven
- **Base de datos:** MySQL
- **Control de migraciones:** Flyway
- **Seguridad:** Spring Security con implementación de tokens JWT
- **Validación:** Spring Boot Starter Validation
- **Configuración de entorno:** dotenv-java

## Estructura de Archivos

```
Foro-Hub
├── src/main/java/com/forohub/api
│   ├── controller
│   ├── domain
│   │   ├── curso
│   │   ├── perfil
│   │   ├── respuesta
│   │   ├── topico
│   │   ├── usuario
│   └── infra
├── src/main/resources
│   ├── db
│   ├── application.properties
│   └── migration
```

## Configuración del Proyecto

### Pre-requisitos

- Java 21
- Maven
- MySQL

### Configuración del Entorno

Renombrar el archivo `.env-example` a `.env` y completar los valores correspondientes:

```
# Datos de configuración de base de datos
DB_HOST=host
DB_NAME=db_name
DB_USER=user
DB_PASSWORD=pass

# Token JWT
JWT_SECRET=my_token_secret
```

### Instalación

1. Clona este repositorio:
   ```bash
   git clone https://github.com/jmanriquecha/Foro-Hub.git
   ```
2. Accede al directorio del proyecto:
   ```bash
   cd Foro-Hub
   ```
3. Instala las dependencias con Maven:
   ```bash
   mvn clean install
   ```
4. Configura la base de datos y el archivo `.env` según lo indicado.

### Ejecución

Inicia la aplicación ejecutando:
```bash
mvn spring-boot:run
```

La API estará disponible en: `http://localhost:8080`

## Endpoints Principales

| Método | Endpoint         | Descripción                     |
|--------|------------------|---------------------------------|
| GET    | `/topicos`       | Lista todos los tópicos         |
| GET    | `/topicos/{id}`  | Lista un tópico específico      |
| POST   | `/topicos`       | Crea un nuevo tópico            |
| PUT    | `/topicos/{id}`  | Actualiza un tópico existente   |
| DELETE | `/topicos/{id}`  | Elimina un tópico               |

## Dependencias Principales

- **Spring Boot Starter Web**: Desarrollo de aplicaciones web y REST
- **Spring Boot Starter Data JPA**: Acceso y persistencia de datos
- **Spring Boot Starter Security**: Implementación de seguridad
- **Flyway**: Gestión de migraciones de base de datos
- **dotenv-java**: Configuración de entornos
- **Java JWT**: Implementación de autenticación mediante tokens JWT

## Licencia

Este proyecto está licenciado bajo los términos de la licencia MIT. Consulta el archivo `LICENSE` para más detalles.

## Autor

**Jorge Manrique**

- [LinkedIn](https://www.linkedin.com/in/jmanriquecha/)
- [GitHub](https://github.com/jmanriquecha/)
