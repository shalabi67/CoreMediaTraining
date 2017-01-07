echo off
set PSQL_BIN="%POSTGRESQL_HOME%\bin\psql"
set THIS_DIR=%~dp0
echo === DROP SCHEMAS ===
%PSQL_BIN% --username=postgres --dbname=coredining -f %THIS_DIR%drop-schemas.sql


