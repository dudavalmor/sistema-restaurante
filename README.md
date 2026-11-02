# Sistema de Restaurante

## Sobre o projeto

Sistema de gerenciamento de restaurante desenvolvido em Java 17 com Maven.

O projeto permite registrar, listar, modificar e cancelar pedidos, personalizar lanches, adicionar complementos, registrar pagamentos e gorjetas e realizar o fechamento financeiro do restaurante.

## Funcionalidades

- Cadastro e gerenciamento de pedidos.
- Cardápio com diferentes tipos de lanches.
- Personalização dos ingredientes.
- Adicionais de cheddar e bacon extra.
- Cálculo automático dos pedidos.
- Cancelamento e modificação de pedidos.
- Registro de pagamentos e gorjetas.
- Relatório de fechamento financeiro.
- Identificação de combinações diferentes de lanches.

## Tecnologias utilizadas

- Java 17
- Maven
- JUnit 5
- IntelliJ IDEA

## Conceitos e padrões aplicados

- Programação orientada a objetos.
- Interfaces.
- Encapsulamento.
- Collections: HashMap, HashSet e ArrayList.
- Factory.
- Decorator.
- Singleton.
- Testes automatizados.

## Organização do projeto

- `app`: fluxo principal, menu e fachada.
- `cardapio`: lanches, fábrica e adicionais.
- `pedido`: gerenciamento dos pedidos.
- `financeiro`: caixa e transações.

## Como executar

É necessário ter Java instalado.

Execute o comando no terminal, na pasta do projeto:

    java -jar target/sistema-restaurante-1.0-SNAPSHOT.jar

## Testes

Os testes automatizados foram desenvolvidos com JUnit 5.

Para executar os testes, utilize:

    mvn test

## Demonstração em vídeo

[ASSISTIR AO VÍDEO](https://drive.google.com/drive/folders/1Mg-lw1xgPxU7F6JXS-vDp6CxCTmfXZpd)

## Autoria

Projeto desenvolvido como atividade prática de programação Java.