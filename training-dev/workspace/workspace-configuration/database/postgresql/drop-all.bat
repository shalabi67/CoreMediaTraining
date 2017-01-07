echo off
set THIS_DIR=%~dp0
call %THIS_DIR%drop-schemas.bat
call %THIS_DIR%drop-database.bat
call %THIS_DIR%drop-users.bat
pause

