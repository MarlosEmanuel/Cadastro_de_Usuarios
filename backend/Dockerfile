# Usa uma imagem do OpenJDK 17
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR gerado para dentro do container
COPY target/Cadastro_de_Usuarios_backend-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta 8080 para acesso externo
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]
