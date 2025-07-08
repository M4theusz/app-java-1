# app-java-1

# Aplicação Java Spring Boot com Redis Cache

## Visão Geral
Esta aplicação Java utiliza Spring Boot e roda na porta 8081 no contexto `/app-java-1`. Ela expõe vários endpoints e utiliza Redis para cache.

## Pré-requisitos
- Java 21
- Maven 3.9.9

## Docker
- Docker (Dockerfile disponivel para uso)
- Docker Compose (docker-compose.yml disponivel para execução com Redis)

## Endpoints Disponíveis

1. **Hora atual (com cache de 10 segundos)**
   - `GET /app-java-1/hora`
   - Retorna a hora atual do servidor com cache de 10 segundos

2. **Mensagem**
   - `GET /app-java-1/mensagem`
   - Retorna uma mensagem fixa ('============Desafio DevOps para Globo===============')

3. **Health Check**
   - `GET /app-java-1/actuator/health`
   - Endpoint de verificação de saúde da aplicação

4. **Métricas Prometheus**
   - `GET /app-java-1/actuator/prometheus`
   - Endpoint de métricas para monitoramento


