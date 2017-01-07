set THIS_DIR=%~dp0
:: === Content Management Server ===
cd %THIS_DIR%..\..\cmd-tools\cms-tools-application\target\cms-tools\bin
call cm64 unlockcontentserver
cd %THIS_DIR%
pause