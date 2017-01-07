set THIS_DIR=%~dp0
:: === Content Management Server ===
%THIS_DIR%\workspace\modules\cmd-tools\cms-tools-application\target\cms-tools\bin\cm64 unlockcontentserver
cd %THIS_DIR%\workspace\modules\server\content-management-server-webapp
@start "content-management-server-webapp" mvn tomcat7:run-war

::  === Master Live Server === 
::  %THIS_DIR%\workspace\modules\cmd-tools\mls-tools-application\target\mls-tools\bin\cm64 unlockcontentserver
::  cd %THIS_DIR%\workspace\modules\server\master-live-server-webapp
::  @start "master-live-server-webapp" mvn tomcat7:run-war

::  === Replication Live Server ===
::  %THIS_DIR%\workspace\modules\cmd-tools\rls-tools-application\target\rls-tools\bin\cm64 unlockcontentserver
::  cd %THIS_DIR%\workspace\modules\server\replication-live-server-webapp
::  @start "replication-live-server-webapp" mvn tomcat7:run-war

::  === Workflow Server ===
::  cd %THIS_DIR%\workspace\modules\server\workflow-server-webapp
::  @start "workflow-server-webapp" mvn tomcat7:run-war

::  === User Changes Webapp ===
::  cd %THIS_DIR%\workspace\modules\server\user-changes-webapp
::  @start "user-changes-webapp" mvn tomcat7:run-war
::  ===

cd %THIS_DIR%
::  pause
