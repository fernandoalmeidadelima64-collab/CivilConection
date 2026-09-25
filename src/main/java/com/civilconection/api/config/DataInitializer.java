package com.civilconection.api.config;

import com.civilconection.api.dto.EtapaObraDTO;
import com.civilconection.api.dto.ObraDTO;
import com.civilconection.api.dto.ProfissionalDTO;
import com.civilconection.api.dto.UsuarioCreateDTO;
import com.civilconection.api.dto.UsuarioDTO;
import com.civilconection.api.repository.UsuarioRepository;
import com.civilconection.api.service.EtapaObraService;
import com.civilconection.api.service.ObraService;
import com.civilconection.api.service.ProfissionalService;
import com.civilconection.api.service.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioService usuarioService;
    private final ProfissionalService profissionalService;
    private final ObraService obraService;
    private final EtapaObraService etapaObraService;

    public DataInitializer(
            UsuarioRepository usuarioRepository,
            UsuarioService usuarioService,
            ProfissionalService profissionalService,
            ObraService obraService,
            EtapaObraService etapaObraService) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioService = usuarioService;
        this.profissionalService = profissionalService;
        this.obraService = obraService;
        this.etapaObraService = etapaObraService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (usuarioRepository.count() > 0) {
            return; // Data already exists
        }

        // 1. Create Users
        UsuarioDTO userCarlos = usuarioService.criar(new UsuarioCreateDTO(
                "Eng. Carlos Eduardo Medeiros",
                "carlos.medeiros@civilconection.com.br",
                "Senha@123",
                "PROFISSIONAL"
        ));

        UsuarioDTO userBeatriz = usuarioService.criar(new UsuarioCreateDTO(
                "Arq. Beatriz Lima",
                "beatriz.lima@civilconection.com.br",
                "Senha@123",
                "PROFISSIONAL"
        ));

        UsuarioDTO userRicardo = usuarioService.criar(new UsuarioCreateDTO(
                "Mestre Ricardo Souza",
                "ricardo.souza@civilconection.com.br",
                "Senha@123",
                "PROFISSIONAL"
        ));

        UsuarioDTO userCliente1 = usuarioService.criar(new UsuarioCreateDTO(
                "Construtora Alfa Ltda",
                "contato@construtoraalfa.com.br",
                "Senha@123",
                "CLIENTE"
        ));

        UsuarioDTO userCliente2 = usuarioService.criar(new UsuarioCreateDTO(
                "Mariana Oliveira",
                "mariana.oliveira@gmail.com",
                "Senha@123",
                "CLIENTE"
        ));

        // 2. Create Professionals
        profissionalService.salvarOuAtualizar(new ProfissionalDTO(
                null,
                userCarlos.getId(),
                userCarlos.getNome(),
                userCarlos.getEmail(),
                "Engenheiro Civil Structural Senior",
                "São Paulo, SP",
                "Especialista em cálculo estrutural, sondagem de solo SPT e laudos técnicos com emissão de ART CREA-SP.",
                4.9,
                "Cálculo Estrutural, Vistorias, Laudos ABNT",
                "(11) 98765-4321"
        ));

        profissionalService.salvarOuAtualizar(new ProfissionalDTO(
                null,
                userBeatriz.getId(),
                userBeatriz.getNome(),
                userBeatriz.getEmail(),
                "Arquiteta e Urbanista",
                "Campinas, SP",
                "Projetos arquitetônicos residenciais de alto padrão, modelagem BIM 3D e design de interiores integrados.",
                5.0,
                "Modelagem BIM, Projetos Residenciais, Design Interiores",
                "(19) 99887-6655"
        ));

        profissionalService.salvarOuAtualizar(new ProfissionalDTO(
                null,
                userRicardo.getId(),
                userRicardo.getNome(),
                userRicardo.getEmail(),
                "Mestre de Obras / Técnico em Edificações",
                "São Bernardo do Campo, SP",
                "Gestão de canteiro de obras, supervisão de equipes de alvenaria e instalações elétricas/hidráulicas.",
                4.8,
                "Alvenaria Estrutural, Gestão de Canteiro, NR-18",
                "(11) 97654-3210"
        ));

        // 3. Create Obras
        ObraDTO obra1 = obraService.criarOuAtualizar(new ObraDTO(
                null,
                userCliente1.getId(),
                userCliente1.getNome(),
                "Construção de Galpão Industrial 850m²",
                "Estrutura metálica moderna com piso usinado e instalações completas.",
                "Guarulhos, SP",
                "EM_ANDAMENTO",
                "COMERCIAL",
                65,
                null
        ));

        ObraDTO obra2 = obraService.criarOuAtualizar(new ObraDTO(
                null,
                userCliente2.getId(),
                userCliente2.getNome(),
                "Reforma Completa de Residência Duplex",
                "Reforma de acabamentos, instalações elétricas e paisagismo exterior.",
                "São Paulo, SP",
                "EM_ANDAMENTO",
                "RESIDENCIAL",
                40,
                null
        ));

        ObraDTO obra3 = obraService.criarOuAtualizar(new ObraDTO(
                null,
                userCliente1.getId(),
                userCliente1.getNome(),
                "Pavimentação e Drenagem Pluvial Subterrânea",
                "Obras de infraestrutura urbana em condomínio residencial fecho.",
                "Sorocaba, SP",
                "CONCLUIDA",
                "INFRAESTRUTURA",
                100,
                null
        ));

        // 4. Create Etapas for Obra 1
        etapaObraService.criarOuAtualizar(new EtapaObraDTO(null, obra1.getId(), "Planejamento & Sondagem", "Estudo geotécnico e sondagem SPT do terreno", "CONCLUIDO", 100, 1));
        etapaObraService.criarOuAtualizar(new EtapaObraDTO(null, obra1.getId(), "Fundação & Estacas", "Perfuração e concretagem de estacas hélice contínua", "CONCLUIDO", 100, 2));
        etapaObraService.criarOuAtualizar(new EtapaObraDTO(null, obra1.getId(), "Montagem de Estrutura Metálica", "Içamento e fixação de pilares e tesouras de aço", "EM_ANDAMENTO", 60, 3));
        etapaObraService.criarOuAtualizar(new EtapaObraDTO(null, obra1.getId(), "InstalaçõesElétricas & Hidráulicas", "Passagem de eletrocalhas e tubulação industrial", "PENDENTE", 0, 4));

        // 4. Create Etapas for Obra 2
        etapaObraService.criarOuAtualizar(new EtapaObraDTO(null, obra2.getId(), "Demolição e Preparação", "Remoção de revestimentos antigos e entulho", "CONCLUIDO", 100, 1));
        etapaObraService.criarOuAtualizar(new EtapaObraDTO(null, obra2.getId(), "Instalações Elétricas Renovadas", "Substituição do quadro de disjuntores e fiação", "EM_ANDAMENTO", 50, 2));
        etapaObraService.criarOuAtualizar(new EtapaObraDTO(null, obra2.getId(), "Acabamento & Pintura", "Aplicação de gesso, porcelanato e pintura", "PENDENTE", 0, 3));
    }
}
