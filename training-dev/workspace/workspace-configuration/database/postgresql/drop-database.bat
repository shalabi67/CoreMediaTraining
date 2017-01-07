echo off
set PSQL_BIN="%POSTGRESQL_HOME%\bin\psql"
set THIS_DIR=%~dp0
echo === DROP DATABASE ===
%PSQL_BIN% --username=postgres -f %THIS_DIR%drop-database.sql


