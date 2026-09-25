#!/usr/bin/env bash
# ==============================================================================
# CIVIL CONNECTION - STARTUP SCRIPT (Linux / macOS / Git Bash)
# ==============================================================================

echo "=============================================================================="
echo "                     CIVIL CONNECTION - STARTUP"
echo "               Conectando ideias, construindo o futuro"
echo "=============================================================================="
echo ""

if ! command -v java &> /dev/null; then
    echo "[ERRO] Java JDK 17 ou superior nao encontrado no PATH."
    exit 1
fi

echo "Iniciando backend Spring Boot (porta 8080)..."
echo "Acesse http://localhost:8080 no seu navegador."
echo "Pressione Ctrl+C para encerrar."
echo ""

cd backend
chmod +x ./gradlew
./gradlew bootRun
cd ..
