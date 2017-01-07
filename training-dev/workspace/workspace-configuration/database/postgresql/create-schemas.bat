echo off
set PSQL_BIN="%POSTGRESQL_HOME%\bin\psql"
set THIS_DIR=%~dp0
echo === CREATE SCHEMAS ===
%PSQL_BIN% --username=postgres --dbname=coredining -f %THIS_DIR%create-schemas.sql

