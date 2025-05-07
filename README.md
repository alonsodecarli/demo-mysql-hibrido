# TechTalk - Réplicas de Leitura no MySQL

## Sobre o Projeto

Este é um projeto demonstrativo em Spring Boot com foco na utilização de **réplicas de leitura no MySQL** para melhorar a performance e escalabilidade de aplicações modernas.

O projeto foi desenvolvido como parte de uma apresentação técnica no evento **TechTalks Viasoft 2025**.

### Linha de Pesquisa

- ✅ Explorando estratégias para melhorar performance e escalabilidade em bancos de dados MySQL;
- ✅ Explorando soluções de banco de dados para aplicações modernas.

## Tecnologias Utilizadas

- Java 17+
- Spring Boot
- MySQL (Master + Read Replicas)
- Maven

## Como Executar

1. Clone o repositório:
   ```bash
   git clone <URL-do-repositório>
   cd demo-mysql-hibrido



2. Configure o arquivo `application.properties` com as credenciais do banco de dados MySQL:
   ```properties

    # Fonte de dados de principal/primaria (write)
    spring.datasource.master.url=jdbc:mysql://127.0.0.1:3307/db2?useSSL=false&serverTimezone=UTC
    spring.datasource.master.username=usuario
    spring.datasource.master.password=senha
    spring.datasource.master.driver-class-name=com.mysql.cj.jdbc.Driver
    
    # Fonte de dados da replica de leitura (read)
    spring.datasource.replica.url=jdbc:mysql://127.0.0.1:3308/db2?useSSL=false&serverTimezone=UTC
    spring.datasource.replica.username=usuario
    spring.datasource.replica.password=senha
    spring.datasource.replica.driver-class-name=com.mysql.cj.jdbc.Driver
   ```

3. Execute o projeto:
   ```bash
   mvn spring-boot:run
   ```

## Acesse o link da apresentação:  
   👉 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)


## Acesse o vídeo da apresentação:
   👉 Confluenece: [Tech Talks - Diretoria de Produtos](https://nimitz.atlassian.net/wiki/spaces/TD/pages/4356112398/Tech+talks+-+Diretoria+de+produtos)

