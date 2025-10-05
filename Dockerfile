# Usar imagen base de Java
FROM eclipse-temurin:17-jdk-alpine

# Crear directorio de trabajo
WORKDIR /app

# Copiar el jar generado
COPY target/tutoria-api-0.0.1-SNAPSHOT.jar app.jar

# Exponer puerto de la aplicación
EXPOSE 8080

# Comando para correr la app
ENTRYPOINT ["java", "-jar", "app.jar"]
