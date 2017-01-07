echo off
set THIS_DIR=%~dp0
call %THIS_DIR%create-users.bat
call %THIS_DIR%create-database.bat
call %THIS_DIR%create-schemas.bat
pause

