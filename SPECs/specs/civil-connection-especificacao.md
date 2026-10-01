# Civil Conection — Especificação do Sistema

## 1. Cenário

O **Civil Conection** é uma plataforma web acadêmica desenvolvida para o setor da construção civil. O sistema tem como objetivo aproximar clientes, profissionais e obras, centralizando informações que normalmente ficam distribuídas em diferentes meios de comunicação.

A plataforma permite consultar profissionais, cadastrar e acompanhar obras, visualizar o progresso de projetos, organizar etapas da construção e facilitar o acesso a informações de contato e localização relacionadas às obras e profissionais.

O sistema será desenvolvido como projeto acadêmico da **ETEC**, com foco em uma aplicação web funcional, organizada e adequada para demonstração.

## 2. Problema a ser resolvido

1. Dificuldade para encontrar profissionais da construção civil de acordo com especialidade e localização.
2. Falta de centralização das informações de obras e profissionais.
3. Dificuldade para acompanhar o andamento de uma obra.
4. Falta de organização das etapas e do progresso dos projetos.
5. Dificuldade de acesso a informações de contato dos profissionais.
6. Necessidade de aproximar clientes, profissionais e projetos de construção civil.
7. Informações de obras podem ficar espalhadas em conversas, anotações e diferentes sistemas.

## 3. Escopo

Criar um sistema web chamado **Civil Conection** para conectar clientes, profissionais e obras do setor da construção civil.

O sistema deverá permitir:

- Cadastro e consulta de usuários;
- Cadastro e consulta de profissionais;
- Busca e filtragem de profissionais;
- Cadastro e consulta de obras;
- Acompanhamento do progresso das obras;
- Organização das etapas de uma obra;
- Consulta de localização;
- Consulta de contatos;
- Visualização de informações resumidas e detalhadas das obras;
- Integração entre frontend, backend e banco de dados.

O sistema é um **projeto acadêmico da ETEC** e deverá priorizar clareza, organização e funcionamento das principais funcionalidades.

## 4. Glossário do domínio

| Termo | Definição |
|---|---|
| **Cliente** | Usuário que utiliza a plataforma para procurar profissionais ou acompanhar obras relacionadas a ele. |
| **Profissional** | Pessoa cadastrada que presta serviços relacionados à construção civil. |
| **Obra** | Projeto de construção cadastrado no sistema e acompanhado durante sua execução. |
| **Etapa da Obra** | Fase específica do processo de construção, com nome, descrição, status e progresso. |
| **Progresso** | Percentual que representa o andamento de uma obra ou etapa. |
| **Status da Obra** | Estado atual de uma obra, como planejamento, em andamento, pausada ou concluída. |
| **Especialidade** | Área de atuação de um profissional, como pedreiro, eletricista, encanador, engenheiro ou arquiteto. |
| **Avaliação** | Nota associada a um profissional para representar avaliações cadastradas na plataforma. |
| **Localização** | Cidade ou local relacionado a uma obra ou profissional. |
| **Demanda** | Necessidade ou atividade relacionada a uma obra que pode exigir a participação de um profissional. |

## 5. Requisitos Funcionais

### 5.1 Sistema de Acesso e Usuários

O sistema deve permitir cadastro e identificação dos usuários.

Cada usuário deverá possuir:

- ID;
- Nome;
- E-mail;
- Senha;
- Tipo de usuário.

Tipos previstos:

- Cliente;
- Profissional;
- Administrador.

O sistema deverá validar os dados enviados e impedir e-mails duplicados. Senhas não devem ser retornadas nas respostas da API.

### 5.2 Cadastro e Gestão de Profissionais

O sistema deve permitir cadastrar e consultar profissionais.

Cada profissional deverá possuir, no mínimo:

- ID;
- Usuário relacionado;
- Profissão/especialidade;
- Cidade;
- Descrição;
- Avaliação.

Deve permitir:

- Cadastrar;
- Consultar;
- Consultar individualmente;
- Editar;
- Remover;
- Pesquisar;
- Filtrar por especialidade;
- Filtrar por cidade;
- Exibir informações de contato quando apropriado.

### 5.3 Cadastro e Gestão de Obras

Cada obra deverá possuir:

- ID;
- Cliente responsável;
- Nome;
- Descrição;
- Cidade/localização;
- Status;
- Progresso.

Deve permitir cadastrar, consultar, editar, remover, pesquisar, filtrar e visualizar detalhes e progresso.

### 5.4 Etapas da Obra

Cada obra poderá possuir várias etapas.

Exemplos:

- Planejamento;
- Fundação;
- Estrutura;
- Alvenaria;
- Instalações;
- Acabamento;
- Finalização.

Cada etapa deverá possuir ID, obra relacionada, nome, descrição, status e progresso.

### 5.5 Acompanhamento do Processo da Obra

O sistema deverá apresentar:

- Nome da obra;
- Status atual;
- Percentual de progresso;
- Etapas;
- Status de cada etapa;
- Localização básica;
- Responsável.

Sempre que possível, o progresso deve vir do banco de dados em vez de valores fixos.

### 5.6 Pesquisa de Profissionais

A pesquisa poderá utilizar nome, profissão/especialidade e cidade. Os resultados devem utilizar os componentes visuais definidos pelo frontend.

### 5.7 Pesquisa de Obras

A pesquisa poderá considerar nome da obra, cidade e status.

### 5.8 Dashboard e Indicadores

A página inicial poderá apresentar indicadores gerais utilizando dados reais quando disponíveis, como:

- Obras cadastradas;
- Profissionais cadastrados;
- Obras em andamento;
- Obras concluídas.

### 5.9 Serviços

A plataforma deverá apresentar serviços como:

- Busca de profissionais;
- Acompanhamento de obras;
- Organização de etapas;
- Gerenciamento de demandas;
- Consulta de informações;
- Conexão entre clientes e profissionais.

### 5.10 Localização e Contatos

Para profissionais: cidade, profissão e informações de contato disponíveis.

Para obras: cidade/localização, cliente responsável e informações relacionadas ao projeto.

O sistema não precisa implementar rastreamento GPS em tempo real.

## 6. Arquitetura do Sistema

```text
Frontend
HTML + CSS + JavaScript
        |
        | HTTP / REST API
        v
Backend
Java + Spring Boot
        |
        | JPA / Hibernate
        v
Banco de Dados
PostgreSQL / Supabase
```

O **Git/GitHub** será utilizado para versionamento e armazenamento do código-fonte. Git/GitHub não é uma camada de banco de dados nem uma conexão direta com o Supabase.

## 7. Backend

Tecnologias:

- Java;
- Spring Boot;
- Spring Web;
- Spring Data JPA;
- Hibernate;
- PostgreSQL Driver;
- Gradle, mantendo a configuração existente.

Estrutura recomendada:

```text
src/main/java/com/civilconection/api/

controller/
model/
repository/
service/
dto/
exception/
```

## 8. API REST

### Usuários

```text
GET    /api/usuarios
GET    /api/usuarios/{id}
POST   /api/usuarios
PUT    /api/usuarios/{id}
DELETE /api/usuarios/{id}
```

### Profissionais

```text
GET    /api/profissionais
GET    /api/profissionais/{id}
POST   /api/profissionais
PUT    /api/profissionais/{id}
DELETE /api/profissionais/{id}
```

### Obras

```text
GET    /api/obras
GET    /api/obras/{id}
POST   /api/obras
PUT    /api/obras/{id}
DELETE /api/obras/{id}
```

### Etapas

```text
GET    /api/etapas
GET    /api/etapas/{id}
POST   /api/etapas
PUT    /api/etapas/{id}
DELETE /api/etapas/{id}
```

Os endpoints deverão utilizar códigos HTTP apropriados e respostas JSON consistentes.

## 9. Banco de Dados

O banco será **PostgreSQL hospedado no Supabase**.

Entidades principais:

```text
Usuario
Profissional
Obra
EtapaObra
```

Relacionamentos:

```text
Usuario 1 ---- 1 Profissional
Usuario 1 ---- N Obras
Obra 1 ---- N EtapaObra
```

Regras:

- Não utilizar MySQL;
- Não criar segundo banco;
- Não apagar tabelas existentes;
- Não usar DROP ou TRUNCATE na inicialização normal;
- Preservar dados existentes;
- Seeders devem ser idempotentes;
- Não inserir registros duplicados a cada inicialização.

## 10. Frontend

O frontend deverá utilizar HTML, CSS e JavaScript.

As telas e o design visual serão desenvolvidos utilizando **Figma/Google Stitch** como referência visual.

O design existente deverá ser preservado. Não substituir a interface por um template genérico.

O frontend deverá consumir a API REST por JavaScript, principalmente por `fetch()`.

```javascript
fetch('/api/profissionais')
```

Os dados retornados deverão preencher os componentes da interface.

## 11. Idioma

Todo conteúdo apresentado ao usuário deverá estar em **Português do Brasil (PT-BR)**, incluindo menus, botões, formulários, mensagens, erros, status, títulos, placeholders, notificações e informações de obras e profissionais.

Nomes técnicos de classes, métodos, pacotes e endpoints podem seguir convenções de código.

## 12. Validação

Validar dados recebidos.

**Usuário:** nome, e-mail válido e único, senha e tipo.

**Profissional:** profissão obrigatória e cidade válida quando informada.

**Obra:** nome obrigatório, cliente existente e status válido.

**Etapa:** obra existente, nome obrigatório e progresso válido.

## 13. Tratamento de Erros

Tratar:

- Usuário inexistente;
- Profissional inexistente;
- Obra inexistente;
- Etapa inexistente;
- E-mail duplicado;
- Dados inválidos;
- Falha de conexão com o banco.

Mensagens ao usuário devem estar em português. Stack traces e informações sensíveis não devem ser expostos.

## 14. Segurança

Não expor senhas, senhas do banco, Service Role Keys, secrets ou credenciais privadas.

Credenciais secretas do Supabase devem utilizar variáveis de ambiente.

Chaves públicas utilizadas no frontend devem respeitar as políticas de segurança/RLS configuradas no Supabase.

## 15. Regras de Negócio

1. Um usuário deve possuir e-mail único.
2. Um profissional deve estar relacionado a um usuário.
3. Uma obra deve possuir cliente responsável.
4. Uma obra pode possuir várias etapas.
5. Uma etapa deve pertencer a uma obra existente.
6. O progresso deve ser um valor entre 0% e 100%.
7. O status da obra deve utilizar valores definidos pelo sistema.
8. O sistema deve preservar os dados existentes no Supabase.
9. Dados de demonstração não podem ser duplicados a cada inicialização.
10. O frontend deve consumir dados reais fornecidos pela API quando a funcionalidade estiver implementada.
11. O sistema não deve depender permanentemente de dados mockados quando houver entidade correspondente no banco.
12. Alterações no backend não devem destruir o design do frontend.
13. Informações apresentadas ao usuário devem estar em PT-BR.

## 16. Não-Requisitos

1. Não é necessário aplicativo mobile nativo.
2. Não é necessário rastreamento GPS em tempo real.
3. Não é necessário sistema financeiro completo.
4. Não é necessário chat em tempo real.
5. Não é necessário substituir ferramentas profissionais de gerenciamento de obras.
6. Não é necessário uma rede social completa.
7. Não é necessário utilizar IA para gerenciar obras.
8. Não utilizar MySQL.
9. Não criar banco separado do Supabase.
10. O Figma será ferramenta de design/prototipação, não banco de dados.

## 17. Integração do Sistema

```text
Usuário
   |
   v
Frontend (HTML/CSS/JS)
   |
   | HTTP
   v
Spring Boot REST API
   |
   | JPA/Hibernate
   v
Supabase PostgreSQL
```

Versionamento:

```text
Desenvolvimento
      |
      v
Git
      |
      v
GitHub
```

## 18. Artefatos de Modelagem

1. **Diagrama de Casos de Uso (UML)** — Cliente, Profissional e Administrador e suas interações.
2. **Diagrama de Classes (UML)** — Usuario, Profissional, Obra, EtapaObra e relacionamentos.
3. **Diagrama de Arquitetura** — Frontend, API Spring Boot, JPA/Hibernate e Supabase PostgreSQL.
4. **Diagrama de Fluxo da Obra** — Cadastro, Planejamento, Execução, Acompanhamento e Conclusão.
5. **Protótipos de Tela** — Página inicial, cadastro/login, profissionais, detalhes do profissional, obras, detalhes da obra, progresso, etapas e cadastro de obra.

## 19. Testes

### Backend

- Inicialização do Spring Boot;
- Compilação Gradle;
- Conexão com Supabase;
- CRUD de usuários;
- CRUD de profissionais;
- CRUD de obras;
- CRUD de etapas;
- Validações;
- Tratamento de erros.

### Frontend

- Navegação;
- Formulários;
- Pesquisa;
- Filtros;
- Exibição de profissionais;
- Exibição de obras;
- Exibição do progresso;
- Comunicação com a API;
- Responsividade.

### Integração

```text
Frontend
    ↓
REST API
    ↓
Spring Boot
    ↓
JPA/Hibernate
    ↓
Supabase PostgreSQL
```

## 20. Requisitos do MVP

### Usuários

- Cadastro;
- Consulta;
- Tipos de usuário.

### Profissionais

- Cadastro;
- Listagem;
- Pesquisa;
- Filtros;
- Especialidade;
- Cidade;
- Avaliação.

### Obras

- Cadastro;
- Listagem;
- Pesquisa;
- Filtros;
- Detalhes;
- Status;
- Progresso.

### Etapas

- Cadastro;
- Listagem;
- Status;
- Progresso;
- Associação com obra.

### Integração

- Frontend funcional;
- Backend Spring Boot funcional;
- API REST;
- PostgreSQL/Supabase;
- Git/GitHub;
- Comunicação frontend → backend → banco.

## 21. Diretrizes de Desenvolvimento

O Civil Conection é um projeto acadêmico da ETEC.

O código deve ser organizado, legível, manutenível e fácil de explicar em uma apresentação. Deve evitar complexidade desnecessária e preservar as tecnologias já utilizadas pelo projeto.

A implementação deve priorizar:

**Funcionalidade + organização + integração + preservação do design + facilidade de manutenção.**

## 22. Critérios de Conclusão

O sistema será considerado funcional quando:

1. O frontend estiver implementado conforme o design definido no Figma/Google Stitch.
2. O Spring Boot iniciar sem erros.
3. O Gradle realizar build e testes com sucesso.
4. O backend acessar o Supabase.
5. Os principais CRUDs funcionarem.
6. O frontend consumir a API REST.
7. Profissionais forem carregados do banco.
8. Obras forem carregadas do banco.
9. Etapas forem associadas às respectivas obras.
10. Pesquisa e filtros funcionarem.
11. O progresso das obras puder ser visualizado.
12. O sistema estiver em Português do Brasil.
13. Os dados existentes do Supabase forem preservados.
14. O código estiver versionado no Git/GitHub.
15. O projeto puder ser executado para demonstração acadêmica.
