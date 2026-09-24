# 🗄️ Banco de Dados - Supabase & PostgreSQL

Este diretório contém todos os scripts de definição de dados (DDL), carga inicial (DML) e regras de segurança (RLS) para o banco de dados PostgreSQL integrado com o **Supabase**.

---

## 📁 Estrutura de Arquivos

| Arquivo | Descrição |
|---|---|
| [`schema.sql`](schema.sql) | Criação das tabelas (`usuarios`, `profissionais`, `obras`, `etapas_obra`), chaves primárias, relacionamentos, índices e gatilhos de `updated_at`. |
| [`seed.sql`](seed.sql) | Carga de dados iniciais realistas para o ecossistema de construção civil (engenheiros, arquitetos, obras residenciais/comerciais e etapas). |
| [`rls-policies.sql`](rls-policies.sql) | Políticas de **Row Level Security (RLS)** do Supabase para proteção de dados e permissões por usuário. |

---

## 🚀 Como Configurar no Supabase

### 1. Criar Projeto no Supabase
1. Acesse [https://supabase.com](https://supabase.com) e crie uma conta gratuita.
2. Crie um novo projeto, defina a senha do banco PostgreSQL e selecione a região mais próxima (ex: `sa-east-1` - São Paulo).

### 2. Executar os Scripts SQL
1. No menu lateral do dashboard do Supabase, clique em **SQL Editor**.
2. Abra o arquivo [`schema.sql`](schema.sql), cole o conteúdo e clique em **RUN**.
3. Em seguida, cole o conteúdo de [`seed.sql`](seed.sql) e clique em **RUN**.
4. Por fim, para habilitar a segurança por linha, cole o conteúdo de [`rls-policies.sql`](rls-policies.sql) e execute.

### 3. Conectar a Aplicação Spring Boot ao Supabase
1. No Supabase, vá em **Project Settings** > **Database**.
2. Copie a **Connection String** no formato **URI** ou **JDBC**.
   - Tipo recomendado: **Transaction Pooler** (porta `6543`) ou **Session Pooler / Direct** (porta `5432`).
3. Formato da URL JDBC para o Spring Boot:
   ```properties
   SPRING_DATASOURCE_URL=jdbc:postgresql://<SEU-HOST-SUPABASE>:5432/postgres?sslmode=require
   SPRING_DATASOURCE_USERNAME=postgres.<SEU-PROJECT-REF>
   SPRING_DATASOURCE_PASSWORD=<SUA-SENHA-SUPABASE>
   ```

### 4. Executando Localmente com H2 (Fallback Automático)
Caso nenhuma variável de ambiente do Supabase seja configurada, a aplicação Spring Boot inicia automaticamente com banco em memória **H2 Database**, populando os dados padrão através da classe `DataInitializer.java`.
