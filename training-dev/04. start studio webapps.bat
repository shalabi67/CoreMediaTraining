set THIS_DIR=%~dp0

:: === Solr Webapp ===
cd %THIS_DIR%\workspace\modules\search\solr-webapp
call run.bat

:: === Content Feeder Webapp ===
cd %THIS_DIR%\workspace\modules\search\content-feeder-webapp
call run.bat

:: === Studio Webapp ===
cd %THIS_DIR%\workspace\modules\studio\studio-webapp
call run.bat

:: ===
cd %THIS_DIR%
::pause
