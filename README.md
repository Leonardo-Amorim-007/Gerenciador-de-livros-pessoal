# 📚 Gerenciador de Livros Pessoal

Um sistema desenvolvido em **Java** para gerenciamento de uma biblioteca pessoal diretamente pelo terminal.

O objetivo do projeto é permitir o cadastro, consulta, alteração e remoção de livros, mantendo todas as informações armazenadas localmente em arquivos, sem a necessidade de um banco de dados.

Além de ser um sistema funcional, este projeto também foi criado com foco em boas práticas de desenvolvimento, organização em camadas e tratamento adequado de exceções.

---

## ✨ Funcionalidades

* 📖 Cadastro de livros
* 🔍 Pesquisa de livros
* ✏️ Alteração de informações
* 🗑️ Remoção de livros
* 💾 Persistência dos dados em arquivos
* ✔️ Validação de entradas do usuário
* ⚠️ Tratamento de erros e exceções

---

## 🛠 Tecnologias

* Java
* Java NIO (`Files`)
* JSON para armazenamento dos dados
* Programação Orientada a Objetos (POO)

---

## 📂 Estrutura do Projeto

```text
src/
├── model/          # Classes de domínio
├── repository/     # Leitura e escrita dos arquivos
├── service/        # Regras de negócio
├── view/           # Interface via terminal
└── Main.java
```

Cada camada possui uma responsabilidade específica:

* **View:** interação com o usuário.
* **Service:** regras de negócio e validações.
* **Repository:** persistência dos dados.
* **Model:** representação das entidades do sistema.

---

## 💾 Armazenamento

Os dados são armazenados localmente em arquivos JSON, permitindo que as informações permaneçam salvas entre diferentes execuções do programa.

---

## ▶️ Como executar

1. Clone o repositório

```bash
git clone https://github.com/SEU-USUARIO/Gerenciador-de-livros-pessoal.git
```

2. Entre na pasta

```bash
cd Gerenciador-de-livros-pessoal
```

3. Compile o projeto

```bash
javac -d bin src/main.java
```

4. Execute

```bash
java -cp bin Main
```

> Caso utilize uma IDE como IntelliJ IDEA ou Eclipse, basta importar o projeto e executar a classe `Main`.

---

## 📌 Objetivos do Projeto

Este projeto foi desenvolvido para praticar conceitos como:

* Programação Orientada a Objetos
* Organização em camadas
* Manipulação de arquivos
* Tratamento de exceções
* Boas práticas de programação
* Estruturas de dados da linguagem Java

---

## 📄 Licença

Este projeto é disponibilizado para fins de estudo e aprendizado.
