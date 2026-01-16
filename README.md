# API REST - Gestión de Alumnos

API REST desarrollada con Spring Boot para gestionar alumnos, materias y notas de un sistema educativo.

## Tecnologías

- **Java 17**
- **Spring Boot 3.5.4**
- **Spring Data JPA**
- **PostgreSQL 16**
- **Maven**
- **Docker**

## Requisitos Previos

- Java JDK 17 o superior
- Docker y Docker Compose
- Maven 3.6+ (opcional, incluido wrapper)

## Ejecución del Proyecto

### 1. Levantar la base de datos
```bash
docker compose up -d
```

### 2. Compilar el proyecto
Para compilar el proyecto, se puede usar el siguiente comando:

En un entorno Linux:
```bash
./mvnw clean install
```
En un entorno Windows:
```bash
.\mvnw clean install
```

### 3. Ejecutar la aplicación
Para ejecutar el proyecto, se puede usar el siguiente comando:

En un entorno Linux:
```bash
./mvnw spring-boot:run
```

En un entorno Windows:
```bash
.\mvnw spring-boot:run
```

La API estará disponible en: `http://localhost:8080`

## Endpoints Disponibles

### Alumnos (`/api/alumnos`)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/api/alumnos` | Crear un nuevo alumno |
| GET | `/api/alumnos` | Listar todos los alumnos |
| GET | `/api/alumnos/{id}` | Consultar alumno por ID |
| PUT | `/api/alumnos/{id}` | Actualizar un alumno |
| DELETE | `/api/alumnos/{id}` | Eliminar un alumno |

**Ejemplo de creación:**
```json
{
  "nombre": "Juan",
  "apellido": "Pérez",
  "email": "juan.perez16@email.com",
  "fechaNacimiento": "2000-05-15"
}
```

**Ejemplo de actualización:**
> **Nota:** No es necesario incluir todos los campos, solo aquellos que desea modificar.

```json
{
  "email": "juan.nuevo@email.com"
}
```

O actualizar múltiples campos (estos son todos los campos disponibles para modificar):
```json
{
  "nombre": "Juan Carlos",
  "apellido": "Pérez García",
  "email": "jc.perez@email.com",
  "fechaNacimiento": "2000-08-20"
}
```

### Materias (`/api/materias`)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/api/materias` | Crear una nueva materia |
| GET | `/api/materias` | Listar todas las materias |
| GET | `/api/materias/{id}` | Consultar materia por ID |
| PUT | `/api/materias/{id}` | Actualizar una materia |
| DELETE | `/api/materias/{id}` | Eliminar una materia |

**Ejemplo de creación:**
```json
{
  "nombre": "Matemáticas",
  "codigo": "MAT101",
  "creditos": 4
}
```

**Ejemplo de actualización:**
> **Nota:** No es necesario incluir todos los campos, solo aquellos que desea modificar.

```json
{
  "creditos": 5
}
```

O actualizar múltiples campos (estos son todos los campos disponibles para modificar):
```json
{
  "nombre": "Matemáticas Avanzadas",
  "codigo": "MAT102",
  "creditos": 5
}
```

### Notas (`/api/notas`)

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/api/notas` | Registrar una nota |
| GET | `/api/notas/alumno/{alumnoId}` | Listar notas de un alumno |
| GET | `/api/notas/alumno/{alumnoId}/materia/{materiaId}` | Notas de alumno en materia específica |

**Ejemplo de registro:**
```json
{
  "alumnoId": 1,
  "materiaId": 1,
  "valor": 4.5
}
```

## Datos de Prueba

A continuación se presentan datos de prueba listos para usar en cada endpoint:

### Crear Alumnos (POST `/api/alumnos`)

**Alumno 1:**
```json
{
  "nombre": "María",
  "apellido": "González",
  "email": "maria.gonzalez@universidad.edu",
  "fechaNacimiento": "2001-03-15"
}
```

**Alumno 2:**
```json
{
  "nombre": "Carlos",
  "apellido": "Rodríguez",
  "email": "carlos.rodriguez@universidad.edu",
  "fechaNacimiento": "2000-07-22"
}
```

**Alumno 3:**
```json
{
  "nombre": "Ana",
  "apellido": "Martínez",
  "email": "ana.martinez@universidad.edu",
  "fechaNacimiento": "2002-11-08"
}
```

### Crear Materias (POST `/api/materias`)

**Materia 1:**
```json
{
  "nombre": "Programación I",
  "codigo": "PROG101",
  "creditos": 4
}
```

**Materia 2:**
```json
{
  "nombre": "Bases de Datos",
  "codigo": "BD201",
  "creditos": 5
}
```

**Materia 3:**
```json
{
  "nombre": "Estructuras de Datos",
  "codigo": "ED102",
  "creditos": 4
}
```

### Registrar Notas (POST `/api/notas`)

> **Nota:** Primero debes crear los alumnos y materias. Los IDs se generan automáticamente.

**Nota 1:** (Alumno ID 1 en Materia ID 1)
```json
{
  "alumnoId": 1,
  "materiaId": 1,
  "valor": 4.5
}
```

**Nota 2:** (Alumno ID 1 en Materia ID 2)
```json
{
  "alumnoId": 1,
  "materiaId": 2,
  "valor": 4.8
}
```

**Nota 3:** (Alumno ID 2 en Materia ID 1)
```json
{
  "alumnoId": 2,
  "materiaId": 1,
  "valor": 3.9
}
```

**Nota 4:** (Alumno ID 3 en Materia ID 3)
```json
{
  "alumnoId": 3,
  "materiaId": 3,
  "valor": 5.0
}
```

### Actualizar Datos

**Actualizar email de un alumno (PUT `/api/alumnos/1`):**
```json
{
  "email": "maria.g.nueva@universidad.edu"
}
```

**Actualizar créditos de una materia (PUT `/api/materias/1`):**
```json
{
  "creditos": 5
}
```

### Consultas

- **Listar todos los alumnos:** GET `http://localhost:8080/api/alumnos`
- **Obtener alumno por ID:** GET `http://localhost:8080/api/alumnos/1`
- **Listar notas de un alumno:** GET `http://localhost:8080/api/notas/alumno/1`
- **Listar notas de alumno en materia:** GET `http://localhost:8080/api/notas/alumno/1/materia/1`

## Base de Datos

La aplicación utiliza PostgreSQL. La configuración se encuentra en `compose.yml`:

- **Base de datos:** `gestion_alumnos`
- **Usuario:** `postgres`
- **Contraseña:** `postgres`
- **Puerto:** `5432`

### Restaurar Datos de Prueba

El proyecto incluye un dump de la base de datos con datos de prueba en `db/gestion_alumnos.dump`.

**Para restaurar el dump:**

1. Hay que asegurarse de que el contenedor de PostgreSQL esté ejecutándose:
```bash
docker compose up -d
```

2. A continuación, se restaura el dump en la base de datos con el siguiente comando:
```bash
docker exec -i gestion-alumnos-db pg_restore -U postgres -d gestion_alumnos -c < db/gestion_alumnos.dump
```

> **Nota:** La opción `-c` elimina los objetos existentes antes de restaurar, asegurando una restauración limpia.

**Verificar la restauración:**
- Inicia la aplicación y consulta: `http://localhost:8080/api/alumnos`
- Debería ver los datos de prueba cargados al usar cualquier método de "listado"

## Arquitectura

El proyecto sigue una arquitectura en capas:

```
com.jokerp515.gestionalumnos
├── controller/      # Endpoints REST
├── service/         # Lógica de negocio
│   └── impl/        # Implementaciones
├── repository/      # Acceso a datos (JPA)
├── model/           # Entidades JPA
├── dto/             # Data Transfer Objects
└── exception/       # Manejo de excepciones
```

## Configuración

Las variables de entorno pueden configurarse en `application.yaml`:

- `DB_URI`: URL de conexión (default: `jdbc:postgresql://localhost:5432/gestion_alumnos`)
- `DB_USER`: Usuario de BD (default: `postgres`)
- `DB_PASSWORD`: Contraseña (default: `postgres`)
- `DB_DRIVER`: Driver JDBC (default: `org.postgresql.Driver`)

### Variables de Entorno (Opcional)

Si desea ejecutar el programa sin depender de las valores de las variables de entorno por defecto o configurar valores diferentes a los predeterminados, puede configurar las variables de entorno antes de ejecutar la aplicación:

**En Windows (PowerShell):**
```powershell
$env:DB_URI="jdbc:postgresql://localhost:5432/gestion_alumnos"
$env:DB_USER="postgres"
$env:DB_PASSWORD="postgres"
$env:DB_DRIVER="org.postgresql.Driver"
.\mvnw spring-boot:run
```

**En Linux/Mac (Bash):**
```bash
export DB_URI="jdbc:postgresql://localhost:5432/gestion_alumnos"
export DB_USER="postgres"
export DB_PASSWORD="postgres"
export DB_DRIVER="org.postgresql.Driver"
./mvnw spring-boot:run
```

> **Nota:** Estas variables son temporales y solo estarán disponibles en la sesión actual del terminal. Los valores por defecto funcionan correctamente con la configuración de Docker incluida en el proyecto.

## Modelos

### Alumno
- `id`: Long (generado automáticamente)
- `nombre`: String (obligatorio)
- `apellido`: String (obligatorio)
- `email`: String (único, obligatorio, validado)
- `fechaNacimiento`: LocalDate

### Materia
- `id`: Long (generado automáticamente)
- `nombre`: String (obligatorio)
- `codigo`: String (único, obligatorio)
- `creditos`: Integer (obligatorio, > 0)

### Nota
- `id`: Long (generado automáticamente)
- `valor`: Double (0-5, obligatorio)
- `fechaRegistro`: LocalDate (automático)
- `alumno`: Alumno (relación Many-to-One)
- `materia`: Materia (relación Many-to-One)

## Detener la Aplicación

```bash
docker compose down
```