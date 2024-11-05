# Use uma imagem base do JDK 17
FROM openjdk:17-jdk-slim

# Diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo JAR gerado para dentro do contêiner
COPY target/dummyjson-client-1.0-SNAPSHOT.jar app.jar

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
