set THIS_DIR=%~dp0
cd %THIS_DIR%workspace\modules\cmd-tools\cms-tools-application\target\cms-tools
:: === Import Content ===
call bin\cm64 serverimport -u admin -p admin -r %THIS_DIR%workspace\test-data\content
:: === Import Users ===
call bin\cm64 restoreusers -u admin -p admin -f %THIS_DIR%workspace\test-data\users\users.xml
:: ===
cd %THIS_DIR%
pause
