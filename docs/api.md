# 📡 Referência da API REST - Civil Connection

Documentação completa dos endpoints HTTP fornecidos pelo backend Spring Boot.

**Base URL**: `http://localhost:8080/api`  
**Content-Type**: `application/json`

---

## 1. Estatísticas do Painel (`/api/stats`)

### `GET /api/stats`
Retorna os contadores globais e métricas da plataforma para exibição na Hero Section e nos cards de métricas.

**Resposta de Sucesso (`200 OK`)**:
```json
{
  "totalObras": 240,
  "obrasConcluidas": 180,
  "totalProfissionais": 1250,
  "taxaSatisfacao": 99.4
}
```

---

## 2. Usuários (`/api/usuarios`)

### `GET /api/usuarios`
Lista todos os usuários cadastrados.

### `GET /api/usuarios/{id}`
Obtém os detalhes de um usuário específico por ID.

### `POST /api/usuarios`
Cadastra um novo usuário no sistema.

**Corpo da Requisição**:
```json
{
  "nome": "Eng. Roberto Vasconcelos",
  "email": "roberto.vasconcelos@eng.br",
  "senha": "SenhaForte@123",
  "tipo": "PROFISSIONAL"
}
```

**Resposta de Sucesso (`201 Created`)**:
```json
{
  "id": 8,
  "nome": "Eng. Roberto Vasconcelos",
  "email": "roberto.vasconcelos@eng.br",
  "tipo": "PROFISSIONAL"
}
```

---

## 3. Profissionais (`/api/profissionais`)

### `GET /api/profissionais`
Lista todos os profissionais cadastrados na vitrine. Suporta filtro por termo de busca via query parameter:
- `GET /api/profissionais?termo=estrutural`

### `GET /api/profissionais/{id}`
Busca um profissional específico por ID.

### `POST /api/profissionais`
Cadastra ou atualiza o perfil profissional de um usuário.

**Corpo da Requisição**:
```json
{
  "usuarioId": 8,
  "profissao": "Engenheiro Geotécnico",
  "cidade": "São Paulo, SP",
  "descricao": "Especialista em fundações e contenções de encostas.",
  "avaliacao": 5.0,
  "especialidades": "Muros de Arrimo, Sondagem SPT, Estabilidade de Taludes",
  "contato": "(11) 97766-5544"
}
```

---

## 4. Obras & Projetos (`/api/obras`)

### `GET /api/obras`
Lista todas as obras cadastradas com suas respectivas etapas. Suporta filtros:
- `GET /api/obras?termo=Splendor`
- `GET /api/obras?categoria=RESIDENCIAL`

### `GET /api/obras/{id}`
Obtém uma obra completa com a lista detalhada de etapas de execução.

### `POST /api/obras`
Cadastra uma nova obra vinculada a um cliente.

**Corpo da Requisição**:
```json
{
  "clienteId": 5,
  "nome": "Condomínio Residencial Bougainville",
  "descricao": "Implantação de condomínio fechado com 60 lotes e infraestrutura completa.",
  "cidade": "Ribeirão Preto, SP",
  "status": "PLANEJAMENTO",
  "categoria": "RESIDENCIAL",
  "progresso": 0
}
```

---

## 5. Etapas de Obra (`/api/etapas`)

### `GET /api/etapas/obra/{obraId}`
Lista todas as etapas cronológicas de uma determinada obra.

### `POST /api/etapas`
Adiciona uma nova etapa a uma obra existente.

**Corpo da Requisição**:
```json
{
  "obraId": 1,
  "nome": "Instalação dos Elevadores",
  "descricao": "Montagem das guias e cabines dos elevadores de alta velocidade.",
  "status": "PENDENTE",
  "progresso": 0,
  "ordem": 6
}
```

### `PUT /api/etapas/{id}/status`
Atualiza o status e progresso de uma etapa de execução.

**Query Parameters / Corpo**:
- `status`: `PENDENTE` | `EM_ANDAMENTO` | `CONCLUIDO`
- `progresso`: `0` a `100`
