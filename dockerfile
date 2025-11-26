# Base
FROM eclipse-temurin:21-jdk-alpine

# Workdir
WORKDIR /app

# Copiar archivos
COPY . .

# Dar permiso de ejecución a gradlew
RUN chmod +x gradlew || true

# Construir el proyecto
RUN ./gradlew bootJar -x test

# Ejecutar cualquier jar que se genere
CMD ["java", "-jar", "build/libs/app.jar"]

