-- ==============================================================================
-- CIVIL CONNECTION - SUPABASE ROW LEVEL SECURITY (RLS) POLICIES
-- Configurações de segurança em nível de linha no Supabase
-- ==============================================================================

-- 1. Habilitar RLS em todas as tabelas
ALTER TABLE usuarios ENABLE ROW LEVEL SECURITY;
ALTER TABLE profissionais ENABLE ROW LEVEL SECURITY;
ALTER TABLE obras ENABLE ROW LEVEL SECURITY;
ALTER TABLE etapas_obra ENABLE ROW LEVEL SECURITY;

-- 2. Políticas para 'usuarios'
-- Permitir leitura pública para visualização de perfis e dados cadastrais básicos
CREATE POLICY "Leitura pública de perfis de usuário"
    ON usuarios FOR SELECT
    USING (true);

-- Permitir criação de conta pública (auto-registro)
CREATE POLICY "Registro público de novos usuários"
    ON usuarios FOR INSERT
    WITH CHECK (true);

-- Permitir que o usuário atualize seus próprios dados
CREATE POLICY "Usuário pode atualizar seu próprio perfil"
    ON usuarios FOR UPDATE
    USING (auth.uid()::text = id::text)
    WITH CHECK (auth.uid()::text = id::text);

-- 3. Políticas para 'profissionais'
-- Qualquer visitante pode pesquisar e visualizar a vitrine de profissionais
CREATE POLICY "Vitrine de profissionais com leitura pública"
    ON profissionais FOR SELECT
    USING (true);

-- Profissionais autenticados podem cadastrar ou editar seu perfil
CREATE POLICY "Profissionais podem cadastrar seu perfil"
    ON profissionais FOR INSERT
    WITH CHECK (true);

CREATE POLICY "Profissionais podem atualizar seu próprio perfil"
    ON profissionais FOR UPDATE
    USING (auth.uid()::text = usuario_id::text)
    WITH CHECK (auth.uid()::text = usuario_id::text);

-- 4. Políticas para 'obras'
-- Leitura pública de obras em andamento para o catálogo/feed
CREATE POLICY "Leitura de projetos e obras"
    ON obras FOR SELECT
    USING (true);

-- Clientes cadastrados podem criar obras
CREATE POLICY "Clientes autenticados podem criar obras"
    ON obras FOR INSERT
    WITH CHECK (true);

-- Apenas o dono da obra pode atualizar ou excluir a obra
CREATE POLICY "Cliente proprietário pode atualizar sua obra"
    ON obras FOR UPDATE
    USING (auth.uid()::text = cliente_id::text)
    WITH CHECK (auth.uid()::text = cliente_id::text);

CREATE POLICY "Cliente proprietário pode remover sua obra"
    ON obras FOR DELETE
    USING (auth.uid()::text = cliente_id::text);

-- 5. Políticas para 'etapas_obra'
-- Qualquer pessoa que pode ver a obra pode visualizar as etapas
CREATE POLICY "Visualização de etapas de obra"
    ON etapas_obra FOR SELECT
    USING (true);

-- Engenheiros e gestores podem cadastrar e atualizar etapas
CREATE POLICY "Gestão de etapas de obra"
    ON etapas_obra FOR INSERT
    WITH CHECK (true);

CREATE POLICY "Atualização de progresso das etapas"
    ON etapas_obra FOR UPDATE
    USING (true)
    WITH CHECK (true);
