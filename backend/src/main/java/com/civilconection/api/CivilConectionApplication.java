package com.civilconection.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@SpringBootApplication
public class CivilConectionApplication {

    public static void main(String[] args) {
        loadDotEnv();
        SpringApplication.run(CivilConectionApplication.class, args);
    }

    /**
     * Carrega automaticamente o arquivo .env da raiz do projeto ou da pasta atual
     * para propriedades do sistema, permitindo conexao facil com o Supabase sem necessidade
     * de configuracao manual de variaveis de ambiente no sistema operacional.
     */
    private static void loadDotEnv() {
        File[] candidates = {
                new File(".env"),
                new File("../.env")
        };

        for (File file : candidates) {
            if (file.exists() && file.isFile()) {
                try {
                    List<String> lines = Files.readAllLines(file.toPath());
                    for (String line : lines) {
                        line = line.trim();
                        if (line.isEmpty() || line.startsWith("#")) {
                            continue;
                        }
                        int eqIdx = line.indexOf('=');
                        if (eqIdx > 0) {
                            String key = line.substring(0, eqIdx).trim();
                            String value = line.substring(eqIdx + 1).trim();

                            // Ignora placeholders padrao para permitir fallback seguro ao H2
                            if (value.contains("SEU_PROJETO_AQUI") || value.contains("SUA_SENHA_AQUI") || value.isEmpty()) {
                                continue;
                            }

                            if (System.getProperty(key) == null && System.getenv(key) == null) {
                                System.setProperty(key, value);
                            }
                        }
                    }
                    System.out.println("[INFO] Configuracoes do arquivo .env carregadas com sucesso a partir de: " + file.getAbsolutePath());
                    break;
                } catch (IOException e) {
                    System.err.println("[AVISO] Nao foi possivel carregar o arquivo .env: " + e.getMessage());
                }
            }
        }
    }
}
