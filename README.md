# Algalog API

## Introdução

A Algalog API é uma aplicação Spring Boot destinada ao gerenciamento de entregas, elaborada em Bootcamp da Algaworks. A API permite que os usuários controlem a jornada de uma entrega, desde a criação até a atualização do status, passando pela gestão de ocorrências.

A arquitetura da aplicação segue o padrão MVC, incluindo camadas de Modelo, Repositório, Serviço e Controlador, além de manipuladores de exceções personalizados para fornecer respostas de erro mais úteis e informativas.

## Funcionalidades

- Gestão de Clientes
- Gestão de Destinatários
- Criação e rastreamento de Entregas
- Registro de Ocorrências
- Atualização de status de Entrega

## Tecnologias Utilizadas

- Spring Boot
- MySQL
- FlywayDB
- ModelMapper
- JPA
- Spring Boot Starter Validation
- Spring Boot DevTools
- Lombok

## Como Executar o Projeto

### Pré-requisitos

- Java 11
- MySQL
- FlywayDB
- Postman (ou outra ferramenta similar de teste de API)

### Instruções

Clone o repositório e importe o projeto em sua IDE favorita.

Certifique-se de ter o MySQL executando e configure as credenciais de banco de dados corretamente no arquivo application.properties.

Execute o projeto. O Spring Boot irá cuidar das migrações do banco de dados usando o FlywayDB.

Abra o Postman ou a ferramenta de sua escolha para testar APIs.
