# 📋 Lista de Tarefas - API REST

Este projeto é uma API RESTful desenvolvida com **Spring Boot** para gerenciamento de tarefas.  
Foi criado com o objetivo de praticar e consolidar conhecimentos em **Spring Boot**, **Spring Data JPA**, **Swagger** e tecnologias relacionadas.

## 🚀 Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- Swagger
- Lombok
- Banco de dados: H2 para testes
- Banco de dados: MySQL
- Docker Compose
- Maven

## 🎯 Funcionalidades

- [ ] Criar uma nova tarefa
- [ ] Listar todas as tarefas
- [ ] Atualizar informações de uma tarefa
- [ ] Marcar tarefa como concluída
- [ ] Excluir tarefa
- [ ] Documentação automática da API com Swagger

### - Clone o repositório
```bash
git clone https://github.com/rodrigoaraujoferreira/to-do-list.git
```
### - Acesse o diretório do projeto
```bash
cd to-do-list
```

### - Banco de Dados
O projeto utiliza MySQL rodando via Docker Compose.

### - Subir o banco de dados:
```bash
docker-compose up -d
```
### - Parar o banco de dados:
```bash
docker-compose down
```
### - Compile o projeto
```bash
./mvnw clean install
```
### - Rode a aplicação
```bash
./mvnw spring-boot:run
```
### - Documentação Swagger
```bash
http://localhost:8080/swagger-ui.html
```