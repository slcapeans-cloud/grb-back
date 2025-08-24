# Imagen base con JDK 17 (puedes cambiar la versión)
FROM eclipse-temurin:17-jdk AS builder

# Crear carpeta para la app
WORKDIR /app

COPY . .

RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

# Exponer el puerto de Spring Boot (por defecto 8080)
ENV PORT=8080
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]

#docker run -it --rm -p 8081:8081 spring-boot-docker
#docker build -t spring-boot-docker .

#google CLOUD
#docker tag spring-boot-docker gcr.io/springgpc-468621/spring-boot-docker
#docker push gcr.io/springgpc-468621/spring-boot-docker