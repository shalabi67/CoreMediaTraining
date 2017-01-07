@echo off

@echo === Check Installation ========
@echo.
@echo === JAVA ======================
@echo.
@echo JAVA_HOME = %JAVA_HOME%
@echo.
@call java -version

@echo.   
@echo === Maven =====================
@echo.
@echo M2_HOME = %M2_HOME%
@echo MAVEN_OPTS = %MAVEN_OPTS%
@echo CATALINA_OPTS = %CATALINA_OPTS%
@echo.
@call mvn --version
@echo.    
REM @echo === PhantomJS =================
REM @echo.
REM @echo PHANTOMJS_HOME = %PHANTOMJS_HOME%
REM @echo.
REM @call phantomjs --version
REM @echo.
REM @echo === Vagrant ===================
REM @echo.
REM @echo VAGRANT_HOME = %VAGRANT_HOME%
REM @echo.
REM @call vagrant --version
REM @echo.
REM @call vagrant plugin list
REM @echo.
REM @echo === Oracle Virtual Box ========
REM @echo.
REM @echo VBOX_INSTALL_PATH = %VBOX_INSTALL_PATH%
REM @echo.
REM @call vboxmanage --version
REM @echo.
REM @echo === ChefDK ====================
REM @echo.
REM @echo CHEFDK_HOME = %CHEFDK_HOME%
REM @echo.
REM @call chef --version
REM @echo.
@echo === DONE ======================
pause