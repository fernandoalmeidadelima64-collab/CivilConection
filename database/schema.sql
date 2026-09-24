-- ==============================================================================
-- CIVIL CONNECTION - SUPABASE / POSTGRESQL DATABASE SCHEMA
-- Projeto Acadêmico Etec - Construção Civil
-- ==============================================================================

-- Habilita extensão pgcrypto caso seja necessária para funções criptográficas
CREATE EXTENSION IF NOT EXISTS pgcrypto;

-- 1. Tabela: usuarios
CREATE TABLE IF NOT EXISTS usuarios (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    tipo VARCHAR(50) NOT NULL DEFAULT 'CLIENTE', -- 'CLIENTE', 'PROFISSIONAL', 'ADMIN'
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Índices para otimização de busca de usuários
CREATE INDEX IF NOT EXISTS idx_usuarios_email ON usuarios(email);
CREATE INDEX IF NOT EXISTS idx_usuarios_tipo ON usuarios(tipo);

-- 2. Tabela: profissionais
CREATE TABLE IF NOT EXISTS profissionais (
    id BIGSERIAL PRIMARY KEY,
    usuario_id BIGINT NOT NULL REFERENCES usuarios(id) ON DELETE CASCADE,
    profissao VARCHAR(255) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    descricao TEXT,
    avaliacao NUMERIC(3, 2) DEFAULT 5.00 CHECK (avaliacao >= 0 AND avaliacao <= 5.00),
    especialidades VARCHAR(500),
    contato VARCHAR(255),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Índices para buscas rápidas na vitrine de profissionais
CREATE INDEX IF NOT EXISTS idx_profissionais_usuario ON profissionais(usuario_id);
CREATE INDEX IF NOT EXISTS idx_profissionais_cidade ON profissionais(cidade);
CREATE INDEX IF NOT EXISTS idx_profissionais_profissao ON profissionais(profissao);

-- 3. Tabela: obras
CREATE TABLE IF NOT EXISTS obras (
    id BIGSERIAL PRIMARY KEY,
    cliente_id BIGINT NOT NULL REFERENCES usuarios(id) ON DELETE CASCADE,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    cidade VARCHAR(255),
    status VARCHAR(50) DEFAULT 'EM_ANDAMENTO', -- 'PLANEJAMENTO', 'EM_ANDAMENTO', 'CONCLUIDA'
    categoria VARCHAR(50) DEFAULT 'RESIDENCIAL', -- 'RESIDENCIAL', 'COMERCIAL', 'INFRAESTRUTURA'
    progresso INTEGER DEFAULT 0 CHECK (progresso >= 0 AND progresso <= 100),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Índices para consultas de obras
CREATE INDEX IF NOT EXISTS idx_obras_cliente ON obras(cliente_id);
CREATE INDEX IF NOT EXISTS idx_obras_status ON obras(status);
CREATE INDEX IF NOT EXISTS idx_obras_categoria ON obras(categoria);
CREATE INDEX IF NOT EXISTS idx_obras_cidade ON obras(cidade);

-- 4. Tabela: etapas_obra
CREATE TABLE IF NOT EXISTS etapas_obra (
    id BIGSERIAL PRIMARY KEY,
    obra_id BIGINT NOT NULL REFERENCES obras(id) ON DELETE CASCADE,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    status VARCHAR(50) DEFAULT 'PENDENTE', -- 'PENDENTE', 'EM_ANDAMENTO', 'CONCLUIDO'
    progresso INTEGER DEFAULT 0 CHECK (progresso >= 0 AND progresso <= 100),
    ordem INTEGER DEFAULT 1,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Índices para etapas da obra
CREATE INDEX IF NOT EXISTS idx_etapas_obra_id ON etapas_obra(obra_id);
CREATE INDEX IF NOT EXISTS idx_etapas_ordem ON etapas_obra(obra_id, ordem);

-- 5. Função e Triggers para atualização automática de updated_at
CREATE OR REPLACE FUNCTION update_updated_at_column()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ language 'plpgsql';

DROP TRIGGER IF EXISTS trg_usuarios_updated_at ON usuarios;
CREATE TRIGGER trg_usuarios_updated_at
    BEFORE UPDATE ON usuarios
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_at_column();

DROP TRIGGER IF EXISTS trg_profissionais_updated_at ON profissionais;
CREATE TRIGGER trg_profissionais_updated_at
    BEFORE UPDATE ON profissionais
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_at_column();

DROP TRIGGER IF EXISTS trg_obras_updated_at ON obras;
CREATE TRIGGER trg_obras_updated_at
    BEFORE UPDATE ON obras
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_at_column();

DROP TRIGGER IF EXISTS trg_etapas_obra_updated_at ON etapas_obra;
CREATE TRIGGER trg_etapas_obra_updated_at
    BEFORE UPDATE ON etapas_obra
    FOR EACH ROW
    EXECUTE FUNCTION update_updated_at_column();
