@echo off
title Civil Connection - Ambiente de Desenvolvimento
echo ==============================================================================
echo                      CIVIL CONNECTION - STARTUP
echo                Conectando ideias, construindo o futuro
echo ==============================================================================
echo.
echo Verificando instalacao do Java...
java -version
if %errorlevel% neq 0 (
    echo [ERRO] Java JDK 17 ou superior nao encontrado no PATH do sistema.
    pause
    exit /b %errorlevel%
)

echo.
echo Iniciando backend Spring Boot (porta 8080)...
echo Pressione Ctrl+C a qualquer momento para encerrar o servidor.
echo.
cd backend
call .\gradlew.bat bootRun
cd ..
pause
