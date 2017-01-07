set THIS_DIR=%~dp0
:: === Content Management Server ===
cd %THIS_DIR%..\..\cmd-tools\rls-tools-application\target\rls-tools\bin
call cm64 unlockcontentserver
cd %THIS_DIR%
pause