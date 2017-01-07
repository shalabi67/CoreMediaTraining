echo off
set PSQL_BIN="%POSTGRESQL_HOME%\bin\psql"
set THIS_DIR=%~dp0
echo === CREATE DATABASE ===
%PSQL_BIN% --username=postgres -f %THIS_DIR%create-database.sql


