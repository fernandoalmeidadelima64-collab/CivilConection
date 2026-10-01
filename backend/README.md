# ☕ Backend API - Civil Connection

API RESTful robusta desenvolvida em **Java 17** com **Spring Boot 3**, persistência via **Spring Data JPA** e integração nativa com o **Supabase (PostgreSQL)**.

---

## 📁 Estrutura de Pacotes

A estrutura segue o padrão de arquitetura em camadas corporativo:

```
backend/
├── src/
│   ├── main/
│   │   ├── java/com/civilconection/api/
│   │   │   ├── CivilConectionApplication.java   # Classe principal Spring Boot
│   │   │   ├── config/                          # Configurações (CORS, DataInitializer)
│   │   │   ├── controller/                      # Endpoints REST (@RestController)
│   │   │   ├── dto/                             # Data Transfer Objects (Request/Response)
│   │   │   ├── exception/                       # Global Exception Handler
│   │   │   ├── model/                           # Entidades JPA (@Entity)
│   │   │   ├── repository/                      # Interfaces Spring Data JPA
│   │   │   └── service/                         # Regras de Negócio e Serviços
│   │   └── resources/
│   │       ├── application.properties           # Configuração de Datasource e JPA
│   │       └── static/                          # Arquivos frontend servidos em produção
│   └── test/java/com/civilconection/api/        # Testes de Integração e Unidade
├── build.gradle                                 # Dependências e build script
├── gradlew & gradlew.bat                        # Wrapper do Gradle
└── settings.gradle                              # Definição do projeto
```

---

## ⚙️ Pré-requisitos

- **Java JDK 17** instalado e configurado no `PATH` (`java -version`).
- Conexão de rede (para download inicial de dependências do Maven Central).

---

## 🚀 Como Executar

### 1. Execução com Supabase (PostgreSQL)
Defina as variáveis de ambiente antes de rodar:

**No Windows (PowerShell):**
```powershell
$env:SPRING_DATASOURCE_URL="jdbc:postgresql://<HOST-SUPABASE>:5432/postgres?sslmode=require"
$env:SPRING_DATASOURCE_USERNAME="postgres.<PROJECT-REF>"
$env:SPRING_DATASOURCE_PASSWORD="<SUA-SENHA>"
.\gradlew.bat bootRun
```

**No Linux / macOS:**
```bash
export SPRING_DATASOURCE_URL="jdbc:postgresql://<HOST-SUPABASE>:5432/postgres?sslmode=require"
export SPRING_DATASOURCE_USERNAME="postgres.<PROJECT-REF>"
export SPRING_DATASOURCE_PASSWORD="<SUA-SENHA>"
./gradlew bootRun
```

### 2. Execução dos Testes Automatizados
```bash
./gradlew test
```
