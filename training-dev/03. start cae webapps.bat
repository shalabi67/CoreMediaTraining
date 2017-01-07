set THIS_DIR=%~dp0

:: === Start CAE Preview Web Application ===
cd %THIS_DIR%workspace\modules\cae\cae-preview-webapp
@start "cae-preview-webapp" mvn tomcat7:run

:: === Start CAE Live Web Application ===
::  cd %THIS_DIR%workspace\modules\cae\cae-live-webapp
::  @start "cae-live-webapp" mvn tomcat7:run

:: ===
cd %THIS_DIR%
:: pause
