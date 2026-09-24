-- ==============================================================================
-- CIVIL CONNECTION - SUPABASE INITIAL SEED DATA
-- Carga de dados realistas para testes, demonstração e homologação
-- ==============================================================================

-- Limpeza prévia segura (em ordem reversa das foreign keys)
DELETE FROM etapas_obra;
DELETE FROM obras;
DELETE FROM profissionais;
DELETE FROM usuarios;

-- 1. Inserção de Usuários (senhas hasheadas em BCrypt ou padrão de desenvolvimento)
-- Obs: 'Senha@123' em BCrypt costuma ser '$2a$10$w...'. O backend re-hasheia se necessário.
INSERT INTO usuarios (id, nome, email, senha, tipo) VALUES
(1, 'Eng. Carlos Eduardo Medeiros', 'carlos.medeiros@civilconection.com.br', '$2a$10$e7Q8uKkE30p8J9y9zN4NeeZomH9e08r72kZzG6/e9FfW9vVd1q0O.', 'PROFISSIONAL'),
(2, 'Arq. Beatriz Lima', 'beatriz.lima@civilconection.com.br', '$2a$10$e7Q8uKkE30p8J9y9zN4NeeZomH9e08r72kZzG6/e9FfW9vVd1q0O.', 'PROFISSIONAL'),
(3, 'Mestre Ricardo Souza', 'ricardo.souza@civilconection.com.br', '$2a$10$e7Q8uKkE30p8J9y9zN4NeeZomH9e08r72kZzG6/e9FfW9vVd1q0O.', 'PROFISSIONAL'),
(4, 'Eng. Juliana Albuquerque', 'juliana.albuquerque@civilconection.com.br', '$2a$10$e7Q8uKkE30p8J9y9zN4NeeZomH9e08r72kZzG6/e9FfW9vVd1q0O.', 'PROFISSIONAL'),
(5, 'Construtora Alfa Ltda', 'contato@construtoraalfa.com.br', '$2a$10$e7Q8uKkE30p8J9y9zN4NeeZomH9e08r72kZzG6/e9FfW9vVd1q0O.', 'CLIENTE'),
(6, 'Mariana Oliveira', 'mariana.oliveira@gmail.com', '$2a$10$e7Q8uKkE30p8J9y9zN4NeeZomH9e08r72kZzG6/e9FfW9vVd1q0O.', 'CLIENTE'),
(7, 'Incorporadora Horizonte Real', 'projetos@horizontes.com.br', '$2a$10$e7Q8uKkE30p8J9y9zN4NeeZomH9e08r72kZzG6/e9FfW9vVd1q0O.', 'CLIENTE');

-- Ajusta sequência de IDs de usuários
SELECT setval('usuarios_id_seq', (SELECT MAX(id) FROM usuarios));

-- 2. Inserção de Profissionais
INSERT INTO profissionais (id, usuario_id, profissao, cidade, descricao, avaliacao, especialidades, contato) VALUES
(1, 1, 'Engenheiro Civil Structural Senior', 'São Paulo, SP', 'Especialista em cálculo estrutural, fundações profundas, contenções e laudos técnicos com emissão de ART CREA-SP. Mais de 15 anos de experiência.', 4.95, 'Cálculo Estrutural, Vistorias, Laudos ABNT, Fundações', '(11) 98765-4321'),
(2, 2, 'Arquiteta e Urbanista', 'Campinas, SP', 'Projetos arquitetônicos residenciais e comerciais sustentáveis, compatibilização BIM e aprovação ágil em prefeituras e órgãos ambientais.', 4.88, 'Projetos BIM, Interiores, Aprovações, Urbanismo', '(19) 97123-4567'),
(3, 3, 'Mestre de Obras Especialista', 'São Bernardo do Campo, SP', 'Coordenação de equipes de campo, controle rigoroso de canteiro, execução de alvenaria estrutural e acabamentos de alto padrão.', 4.75, 'Gestão de Canteiro, Alvenaria, Concretagem, Acabamentos', '(11) 96543-2109'),
(4, 4, 'Engenheira Eletricista e Automação', 'São Paulo, SP', 'Projetos elétricos industriais e prediais, subestações, cabeamento estruturado e conformidade integral com NR-10 e NBR 5410.', 4.92, 'Projetos Elétricos, Automação Predial, SPDA, NR-10', '(11) 99887-1122');

SELECT setval('profissionais_id_seq', (SELECT MAX(id) FROM profissionais));

-- 3. Inserção de Obras
INSERT INTO obras (id, cliente_id, nome, descricao, cidade, status, categoria, progresso) VALUES
(1, 5, 'Edifício Residencial Splendor Towers', 'Construção de torre residencial de alto padrão com 24 pavimentos, subsolos para garagens e área de lazer suspensa.', 'São Paulo, SP', 'EM_ANDAMENTO', 'RESIDENCIAL', 42),
(2, 6, 'Residência Villa Verde', 'Construção de casa unifamiliar contemporânea em condomínio fechado com placas fotovoltaicas e reaproveitamento de águas pluviais.', 'Campinas, SP', 'EM_ANDAMENTO', 'RESIDENCIAL', 68),
(3, 7, 'Centro Logístico Anhanguera Hub', 'Complexo logístico com 35.000m² de galpões industriais com piso de alta resistência e docas automatizadas.', 'Jundiaí, SP', 'PLANEJAMENTO', 'INFRAESTRUTURA', 15),
(4, 5, 'Retrofit Centro Corporativo Paulista', 'Modernização de fachada com pele de vidro e renovação completa do sistema de ar-condicionado central VRF.', 'São Paulo, SP', 'CONCLUIDA', 'COMERCIAL', 100);

SELECT setval('obras_id_seq', (SELECT MAX(id) FROM obras));

-- 4. Inserção de Etapas de Obra
INSERT INTO etapas_obra (id, obra_id, nome, descricao, status, progresso, ordem) VALUES
-- Etapas para Residencial Splendor Towers (Obra 1)
(1, 1, 'Sondagem do Solo e Movimentação de Terra', 'Escavação dos subsolos e testes de sondagem a percussão SPT.', 'CONCLUIDO', 100, 1),
(2, 1, 'Fundações Profundas e Contenções', 'Estacas hélice contínua e cortina de contenção atirantada.', 'CONCLUIDO', 100, 2),
(3, 1, 'Estrutura de Concreto Armado', 'Concretagem de lajes protendidas e pilares até o 12º pavimento.', 'EM_ANDAMENTO', 55, 3),
(4, 1, 'Instalações Hidrossanitárias e Elétricas', 'Passagem de prumadas e tubulações técnicas.', 'PENDENTE', 10, 4),
(5, 1, 'Acabamentos e Fachada', 'Instalação de esquadrias de alumínio, revestimentos cerâmicos e pintura.', 'PENDENTE', 0, 5),

-- Etapas para Residência Villa Verde (Obra 2)
(6, 2, 'Terraplanagem e Fundação', 'Baldrames e impermeabilização asfáltica.', 'CONCLUIDO', 100, 1),
(7, 2, 'Alvenaria Estrutural e Cobertura', 'Levantamento de paredes e telhado térmico.', 'CONCLUIDO', 100, 2),
(8, 2, 'Instalações e Revestimentos', 'Colocação de pisos porcelanatos e bancadas de quartzo.', 'EM_ANDAMENTO', 75, 3),
(9, 2, 'Pintura e Paisagismo Final', 'Pintura acrílica interna/externa e plantio do jardim.', 'PENDENTE', 0, 4);

SELECT setval('etapas_obra_id_seq', (SELECT MAX(id) FROM etapas_obra));
