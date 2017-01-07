echo off
set PSQL_BIN="%POSTGRESQL_HOME%\bin\psql"
set THIS_DIR=%~dp0
echo === DROP LOGIN ROLES ===
%PSQL_BIN% --username=postgres -f %THIS_DIR%drop-users.sql

