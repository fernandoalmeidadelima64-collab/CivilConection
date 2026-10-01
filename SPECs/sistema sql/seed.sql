-- Dados iniciais de demonstração
INSERT INTO usuarios (nome, email, senha, tipo)
VALUES
    ('Maria Cliente', 'maria@civilconnection.com', '123456', 'CLIENTE'),
    ('João Engenheiro', 'joao@civilconnection.com', '123456', 'PROFISSIONAL'),
    ('Ana Construtora', 'ana@civilconnection.com', '123456', 'ADMIN')
ON CONFLICT (email) DO NOTHING;

INSERT INTO profissionais (usuario_id, profissao, cidade, descricao, avaliacao, especialidades, contato)
VALUES
    (2, 'Engenheiro Civil', 'São Paulo', 'Especialista em estruturas e projetos residenciais.', 4.90, 'Estruturas, Reforma, Execução', '(11) 99999-0001')
ON CONFLICT DO NOTHING;

INSERT INTO obras (cliente_id, nome, descricao, cidade, status, categoria, progresso)
VALUES
    (1, 'Residência Villa Verde', 'Construção residencial em dois pavimentos.', 'São Paulo', 'EM_ANDAMENTO', 'RESIDENCIAL', 42)
ON CONFLICT DO NOTHING;

INSERT INTO etapas_obra (obra_id, nome, descricao, status, progresso, ordem)
VALUES
    (1, 'Fundação', 'Execução de base e estrutura.', 'CONCLUIDO', 100, 1),
    (1, 'Alvenaria', 'Parede estrutural e fechamento.', 'EM_ANDAMENTO', 70, 2),
    (1, 'Acabamento', 'Pintura e detalhes finais.', 'PENDENTE', 5, 3);
