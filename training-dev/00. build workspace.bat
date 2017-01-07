set THIS_DIR=%~dp0
:: === Build Workspace ===
cd %THIS_DIR%workspace
call mvn clean install -T4C
pause
