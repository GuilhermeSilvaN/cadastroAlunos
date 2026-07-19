# Cadastro de Alunos

Sistema de cadastro de alunos desenvolvido em Java, utilizando JDBC para realizar a comunicação direta com o banco de dados.

O projeto foi desenvolvido com o objetivo de praticar conceitos fundamentais de desenvolvimento de aplicações Java, persistência de dados e operações CRUD (Create, Read, Update e Delete).

## Sobre o projeto

O Cadastro de Alunos é uma aplicação voltada para o gerenciamento de informações acadêmicas. O sistema permite realizar operações de cadastro, consulta, atualização e exclusão de alunos armazenados em um banco de dados relacional.

A aplicação utiliza o JDBC (Java Database Connectivity) para estabelecer a comunicação entre o sistema Java e o banco de dados, permitindo a execução de comandos SQL diretamente na aplicação.

## Funcionalidades

* Cadastro de novos alunos;
* Consulta de alunos cadastrados;
* Atualização de informações de alunos;
* Exclusão de alunos;
* Persistência dos dados em banco de dados relacional;
* Comunicação com o banco de dados utilizando JDBC.

## Tecnologias utilizadas

* Java;
* JDBC;
* SQL;
* Banco de dados relacional;
* IntelliJ IDEA;
* Git e GitHub.

## Arquitetura do projeto

A aplicação foi organizada de forma a separar as responsabilidades entre as diferentes partes do sistema.

```text
cadastroAlunos/
│
├── lib/
│
├── src/
│   └── ...
│
├── .gitignore
├── AlunoCadastro.iml
└── README.md
```

A pasta `src` contém o código-fonte principal da aplicação, enquanto a pasta `lib` contém bibliotecas utilizadas pelo projeto.

## Funcionamento da aplicação

O fluxo principal da aplicação pode ser representado da seguinte forma:

```text
Usuário
   │
   ▼
Aplicação Java
   │
   ▼
JDBC
   │
   ▼
Banco de Dados
```

Quando uma operação é realizada, a aplicação Java utiliza o JDBC para criar uma conexão com o banco de dados e executar os comandos SQL necessários.

### Exemplo do fluxo de cadastro

```text
1. Usuário informa os dados do aluno
          ↓
2. Aplicação recebe os dados
          ↓
3. JDBC estabelece conexão com o banco
          ↓
4. Comando INSERT é executado
          ↓
5. Aluno é persistido no banco de dados
```

## Operações CRUD

O sistema trabalha com as principais operações de persistência de dados.

### Create

Responsável por inserir um novo aluno no banco de dados.

```sql
INSERT INTO aluno (...)
VALUES (...);
```

### Read

Responsável por consultar os alunos cadastrados.

```sql
SELECT * FROM aluno;
```

### Update

Responsável por atualizar as informações de um aluno existente.

```sql
UPDATE aluno
SET nome = ?
WHERE id = ?;
```

### Delete

Responsável por remover um aluno do banco de dados.

```sql
DELETE FROM aluno
WHERE id = ?;
```

## JDBC

O JDBC é utilizado como camada de comunicação entre a aplicação Java e o banco de dados.

O processo normalmente envolve:

```text
Driver JDBC
    ↓
Connection
    ↓
PreparedStatement
    ↓
ResultSet
```

### Connection

Responsável por estabelecer a conexão com o banco de dados.

### PreparedStatement

Responsável por preparar e executar comandos SQL de forma parametrizada.

### ResultSet

Responsável por armazenar e percorrer os resultados retornados por uma consulta SQL.

## Boas práticas utilizadas

O projeto utiliza comandos SQL parametrizados por meio do `PreparedStatement`, evitando a concatenação direta de valores dentro das consultas SQL.

Exemplo:

```java
String sql = "SELECT * FROM aluno WHERE id = ?";

PreparedStatement statement =
        connection.prepareStatement(sql);

statement.setInt(1, id);
```

Essa abordagem permite separar os comandos SQL dos valores recebidos pela aplicação.

## Como executar o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/GuilhermeSilvaN/cadastroAlunos.git
```

### 2. Abra o projeto

Abra o projeto utilizando uma IDE compatível com Java, como o IntelliJ IDEA.

### 3. Configure o banco de dados

Configure o banco de dados de acordo com as informações utilizadas na aplicação.

Verifique:

* URL de conexão;
* Usuário;
* Senha;
* Driver JDBC;
* Estrutura das tabelas.

### 4. Execute a aplicação

Após configurar o ambiente, execute a classe principal da aplicação pela sua IDE.

## Objetivo de aprendizagem

Este projeto foi desenvolvido com o objetivo de consolidar conhecimentos relacionados a:

* Programação Orientada a Objetos;
* Java;
* JDBC;
* SQL;
* Bancos de dados relacionais;
* Operações CRUD;
* Conexão entre aplicações e bancos de dados;
* Organização de projetos Java.

Este projeto foi desenvolvido para fins de estudo e prática de desenvolvimento de software.

