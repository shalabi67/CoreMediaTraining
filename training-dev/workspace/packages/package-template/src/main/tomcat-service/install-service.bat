@ECHO OFF
SETLOCAL ENABLEEXTENSIONS
IF ERRORLEVEL 1 ECHO Unable to enable extensions

SET MY_DIR=%~dp0

REM Must NOT contain whitespaces, must NOT be enclosed in ""
SET SERVICE_NAME=@APPLICATION_NAME@

REM Must be enclosed in ""
SET DisplayName="CoreMedia @APPLICATION_NAME@"

REM By convention CATALINA_HOME is set to %MY_DIR%\..\cm7-tomcat-installation. Must NOT be enclosed in ""
SET CATALINA_HOME=%MY_DIR%\..\@APPLICATION_PREFIX@-tomcat-installation
ECHO CATALINA_HOME is set to %CATALINA_HOME%

REM By convention CATALINA_BASE is the parent folder of this script's folder (assuming this script is in INSTALL). Must NOT be enclosed in ""

REM Crazy way of getting the parent dir. Unfortunately, Tomcat7 wont start if CATALINA_BASE contains relative-up-path (\..)
REM remember current dir, switch to parent dir of INSTALL, set var, switch back to current dir
SET CATALINA_BASE=%~dp0
ECHO CATALINA_BASE is set to %CATALINA_BASE%.

REM required for jvm options
SET JAVA_RMI_SERVER_HOSTNAME=@TOMCAT_JMX_PUBLIC_SERVER_HOSTNAME@

REM additional JVM options. MUST be enclosed in "". Options are separated by ; or by #
SET JVM_OPTIONS="-Xrs;-Djava.rmi.server.hostname=%JAVA_RMI_SERVER_HOSTNAME%;-Dcom.sun.management.jmxremote.ssl=false;-Dcom.sun.management.jmxremote.authenticate=false;-Dcom.sun.management.jmxremote.password.file=%CATALINA_BASE%\conf\jmx-password.txt;-Dcom.sun.management.jmxremote.access.file=%CATALINA_BASE%\conf\jmx-access.txt;-XX:MaxPermSize=@TOMCAT_PERM@;-XX:PermSize=@TOMCAT_PERM@"
ECHO JVM_OPTIONS %JVM_OPTIONS%

REM service.bat is pedantic about JAVA_HOME pointing to a JRE
IF NOT EXIST "%JAVA_HOME%\jre" (
  SET JRE_HOME=%JAVA_HOME%
  SET JAVA_HOME=
)

REM 1. Create the service
CALL %CATALINA_HOME%\bin\service.bat install %SERVICE_NAME%

REM 2. Update the Service -
REM 2a. StartMode and StopMode MUST be set to Java.
REM 2b. All JVM properties MUST be set again (will replace values set by service.bat install)
REM 2c. Set -Xms and -Xmx values
%CATALINA_HOME%\bin\tomcat7.exe //US//%SERVICE_NAME% --DisplayName=%DisplayName% --Description="" --JvmMs=@TOMCAT_HEAP@ --JvmMx=@TOMCAT_HEAP@ --Jvm=auto --StartMode=Java --StopMode=Java ++JvmOptions=%JVM_OPTIONS%

ENDLOCAL
